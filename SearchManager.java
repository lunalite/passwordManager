/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import basicpwmanager.models.ACC_TYPE;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author HD
 */
public class SearchManager {
    //TODO incorporate a search method that allows for regex to be used.

    public static void searchCall(RetrievalManager retrievalManager) {
        int counter = 1;
        String response;

        System.out.println("Please input type of detail to be searched:");
        Util.AccountStoringFormatKeyResetItr();
        while (Util.AccountStoringFormatKeyItr.hasNext()) {
            System.out.println(counter++ + ")" + Util.AccountStoringFormatKeyItr.next());
        }
        //TODO to implement a regex searching system that is efficient
        System.out.println(counter++ + ")Regex");
        do {
            response = Util.sc.next();
            String searchQuery;
            switch (response) {
                case "-1":
                    return;
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    int selector = Integer.parseInt(response) - 1;
                    System.out.println(ACC_TYPE.values()[selector].toQuery());
                    searchQuery = Util.sc.next();
                    if ("-1".equals(searchQuery)) {
                        break;
                    } else {
                        SearchManager.searchThroughMap(retrievalManager, ACC_TYPE.values()[selector], searchQuery);
                    }
                    break;
                    
                case "6":
                    break;

                default:
                    break;
            }
        } while (true);

    }

    private static Map<ACC_TYPE, String> searchThroughMap(RetrievalManager retrievalManager, ACC_TYPE dataType, String searchQuery) {
        Iterator<Map<ACC_TYPE, String>> storageAccMapItr = retrievalManager.getStorageAccMap().iterator();
        int counter = 0;
        while (storageAccMapItr.hasNext()) {
            if (storageAccMapItr.next().get(dataType).toLowerCase().contains(
                    searchQuery.toLowerCase())) {
                System.out.println(retrievalManager.getStorageAccMap().get(counter));
            }
            counter++;
        }

        return null;
    }
}
