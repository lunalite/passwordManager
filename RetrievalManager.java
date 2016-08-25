/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

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
     * Constructor that instantiates the storageAcc storing the list of AccountDetails mapping
     */
    public RetrievalManager() {
        storageAcc = new ArrayList();
    }

    /**
     * Storing AccountDetails into the private List of Map<String, String> storageAcc
     * 
     * @param accountDetails
     */
    public void storeAccountDetail(List<String> accountDetails) {
        //TODO call for searchManager and check if its present, else add
        /*
        if (present) {
            do nothing
        } else {*/
        Map<String, String> tempAccountMap = new HashMap<String, String>();

        Util.AccountStoringFormatKeyResetItr();
        while (Util.AccountStoringFormatKeyItr.hasNext()) {
            tempAccountMap.put(Util.AccountStoringFormatKeyItr.next(), accountDetails.remove(0));
        }

        /*for (String key : tempAccountMap.keySet()) {
            System.out.println(key + ": " + tempAccountMap.get(key));
        }*/

        //}
    }

}
