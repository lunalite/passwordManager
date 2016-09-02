/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import java.util.List;

/**
 *
 * @author HD
 */
public class MenuManager {

    /**
     * printMenu() method for printing out the possible options.
     *
     * @param retrievalManager
     */
    public static void printMenu(RetrievalManager retrievalManager) {

        String selection;

        do {
            System.out.println("============================");
            System.out.println("Please select the following:");
            System.out.println("1) Search");
            System.out.println("2) Store");
            System.out.println("3) Print");
            System.out.println("4) Exit");
            System.out.println("============================");

            selection = Util.sc.next();

            switch (selection) {
                case "1":
                    System.out.println("Searching...");
                    SearchManager.searchCall(retrievalManager);
                    break;
                case "2":
                    System.out.println("Calling AccountManager...");
                    List<String> accDet = AccountManager.setAccountDetails();
//                    List<String> accDet = ListOfData.AccountDetails;
                    if (null == accDet) {
                        break;
                    }
                    retrievalManager.storeLocalAccountDetails(accDet);
                    break;
                case "3":
                    System.out.println("Printing...");
                    retrievalManager.printStorageAccMap();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    retrievalManager.saveAccountDetails();
                    return;
                default:
                    System.out.println("Please input the right option.");
            }
        } while (!"4".equals(selection));
    }
}
