/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.ArrayList;

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
            System.out.println("3) Exit");
            System.out.println("============================");

            selection = Util.sc.next();

            switch (selection) {
                case "1":
                    System.out.println("Searching...");
                    System.out.println("Please input detail to be searched:");
                    break;
                case "2":
                    System.out.println("Calling AccountManager...");
                    List<String> accDet = ListOfData.AccountDetails; //AccountManager.setAccountDetails();
                    if (null == accDet) {
                        break;
                    }
                    retrievalManager.storeLocalAccountDetails(accDet);
                    break;
                case "3":
                    System.out.println("Exiting...");
                    retrievalManager.saveAccountDetails();
                    return;
                default:
                    System.out.println("Please input the right option.");
            }
        } while (selection != "3");
    }
}
