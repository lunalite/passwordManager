/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import java.util.Scanner;

/**
 *
 * @author HD
 */
public class MainApp {

    private static final String secret = "1";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("====================="
                + " Luna Password Manager "
                + "===================\n");

        System.out.print("Please input master password: ");
        int counter = 3;
        
        do {
            String masterPass = Util.sc.next();
            if (masterPass.equals(secret)) {
                System.out.println("\nYou have successfully logged in...");
                System.out.println("Welcome back!");
                //TODO implement last time you were here
                break;
            } else {
                counter--;
            }
        } while (counter > 0);
        
        if (counter == 0) {
            System.out.println("You have entered the incorrect password far too many times.");
        } else {
            // TODO call for security manager, initialise it, and decode the dictionary for faster search
            
            RetrievalManager retrievalManager = new RetrievalManager();
            MenuManager.printMenu(retrievalManager);
        }
    }

}
