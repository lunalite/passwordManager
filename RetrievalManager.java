/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author HD
 */
//TODO retrieve after searching through dictionary. 
//TODO Storing of sensitive information 
public class RetrievalManager {

    private List<Map<String, String>> storageAcc;

    /**
     * Constructor that instantiates the storageAcc storing the list of
     * AccountDetails mapping.
     */
    public RetrievalManager() {
        storageAcc =  new ArrayList();
        //loadAccountDetails();
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

        storageAcc.add(tempAccountMap);
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
            
            Util.Gson.toJson(storageAcc, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAccountDetails() {
        
        try (FileInputStream fis = new FileInputStream(Util.File)) {
            
            System.out.println("Total file size to read (in bytes) : "+ fis.available());

            int content;
            
            while ((content=fis.read()) != -1) {
                System.out.println((char)content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
