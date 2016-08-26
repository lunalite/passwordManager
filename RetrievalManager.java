/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

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

/**
 *
 * @author HD
 */
//TODO retrieve after searching through dictionary. 
//TODO Storing of sensitive information 
public class RetrievalManager {

    private List<Map<String, String>> storageAccMap;
    private List<Account> storageAcc;

    /**
     * Constructor that instantiates the storageAcc storing the list of
     * AccountDetails mapping.
     */
    public RetrievalManager() {
        storageAccMap = new ArrayList();
        List<Account> tempAccountDetailsList = loadAccountDetails();
        if (null == tempAccountDetailsList) {
            storageAcc = new ArrayList();
        } else {
            storageAcc = new ArrayList(tempAccountDetailsList);
        }
        for (Account details: storageAcc) {
            System.out.println(details.getUsername());
            System.out.println(details.getEmail());
            System.out.println(details.getMisc());
            System.out.println(details.getPassword());
            System.out.println(details.getService());
        }
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
        Map<String, String> tempAccountMap = new HashMap<>();

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

    public List<Account> loadAccountDetails() {

        try (BufferedReader bReader = new BufferedReader(new FileReader(Util.File))) {
            Account[] accountObj = Util.Gson.fromJson(bReader, Account[].class);
            List<Account> tempAccountDetailsList = Arrays.asList(accountObj);
            return tempAccountDetailsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
