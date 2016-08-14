/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import static java.lang.Integer.parseInt;

/**
 *
 * @author HD
 */
public class MenuManager {

    /**
     * printMenu() method for printing out the possible options
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
                    break;
                case "2":
                    System.out.println("Calling AccountManager...");
                    AccountManager.setAccountDetails();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Please input the right option.");
            }
        } while (selection != "3");
    }
}