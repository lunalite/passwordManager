/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import basicpwmanager.models.ACC_TYPE;
import basicpwmanager.models.Account;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Writer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author HD
 */
//TODO retrieve after searching through dictionary. 
//TODO Storing of sensitive information 
public class RetrievalManager {

    private List<Map<ACC_TYPE, String>> storageAccMap;

    /**
     * Constructor that instantiates the storageAcc storing the list of
     * AccountDetails mapping.
     */
    public RetrievalManager() {
        storageAccMap = new ArrayList();
        List<Account> tempAccountDetailsList = loadAccountDetails();
        if (tempAccountDetailsList != null) {
            this.storageAccToMap(tempAccountDetailsList);
        }
    }

    /**
     * Converts account details from storageAcc to storageAccMap
     */
    private void storageAccToMap(List<Account> storageAcc) {
        Iterator<Account> storageAccItr = storageAcc.iterator();
        while (storageAccItr.hasNext()) {
            storageAccMap.add(storageAccItr.next().getMap());
        }
        storageAcc = new ArrayList();
    }

    /**
     * Storing AccountDetails into the private List of Map<String, String>
     * storageAcc.
     *
     * @param accountDetails
     */
    public void storeLocalAccountDetails(List<String> accountDetails) {
        //TODO call for searchManager and check if its present, else add
        /*
        if (present) {
            do nothing
        } else {*/
        Map<ACC_TYPE, String> tempAccountMap = new HashMap<>();

        Util.AccountStoringFormatKeyResetItr();
        while (Util.AccountStoringFormatKeyItr.hasNext()) {
            tempAccountMap.put(Util.AccountStoringFormatKeyItr.next(), accountDetails.remove(0));
        }

        storageAccMap.add(tempAccountMap);
        /*for (String key : tempAccountMap.keySet()) {
            System.out.println(key + ": " + tempAccountMap.get(key));
        }*/
        //}
    }

    /**
     * Saving accountDetails into hard-coded file for use next time
     */
    public void saveAccountDetails() {
        try (Writer writer = new FileWriter(Util.File)) {
            if (!Util.File.exists()) {
                Util.File.createNewFile();
            }
            Util.Gson.toJson(storageAccMap, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loading of account details from file at Util.File
     *
     * @return
     */
    public List<Account> loadAccountDetails() {
        try (BufferedReader bReader = new BufferedReader(new FileReader(Util.File))) {
            Account[] accountArr = Util.Gson.fromJson(bReader, Account[].class);
            if (accountArr.length != 0) {
                List<Account> tempAccountDetailsList = Arrays.asList(accountArr);
                return tempAccountDetailsList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * storageAccMap getter
     *
     * @return private variable storageAccMap that stores all HashMaps of
     * storage Account Details
     */
    public List<Map<ACC_TYPE, String>> getStorageAccMap() {
        return storageAccMap;
    }

    /**
     * Printing of all account details mapped.
     */
    public void printStorageAccMap() {
        Iterator storageAccMapItr = storageAccMap.iterator();
        while (storageAccMapItr.hasNext()) {
            System.out.println(storageAccMapItr.next().toString());
        }
    }
}
