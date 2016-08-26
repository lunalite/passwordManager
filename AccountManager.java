/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import basicpwmanager.models.Account;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 *
 * @author HD
 */
public class AccountManager {

    private static List<String> AccountDetails;
    private static Account AccountObj;
    private static String[] AccountDetailsQuery = {
        "Please enter the type of service: ",
        "Please enter your username: ",
        "Please enter your current password: ",
        "Please enter the registered email: ",
        "Are there any other details required?: "
    };

    //TODO: Add frequently used user/pw/email

    /**
     * Calls for query from user input in order to get the account details.
     * 
     * @return AccountDetails from AccountManager.CheckAccountDetails() 
     */
    public static List<String> setAccountDetails() {
        AccountDetails = new ArrayList();
        for (String query : AccountDetailsQuery) {
            System.out.println(query);
            String input = Util.sc.next();
            if (input.equals("-1")) {
                return null;
            } else {
                AccountManager.AccountDetails.add(input);
            }
        }
        return AccountManager.CheckAccountDetails();
    }

    /**
     * Account Details checker which requires user to manually see if they have entered the right information.
     * 
     * @return AccountDetails
     */
    public static List<String> CheckAccountDetails() {
        System.out.println("Please check if the details are correct:");
        Iterator<String> accountItr = AccountDetails.iterator();
        Util.AccountStoringFormatKeyResetItr();
        while (accountItr.hasNext()) {
            System.out.println(Util.AccountStoringFormatKeyItr.next() + ": " + accountItr.next());
        }
        System.out.println("Are they correct? [Y]es [N]o");
        String option = Util.sc.next();
        boolean yesOption = Pattern.matches("([yY])|([yY][eE][sS])", option);
        boolean noOption = Pattern.matches("([nN])|([nN][oO])", option);
        if (yesOption) {
            System.out.println("Thank you.");
            return AccountDetails;
        } else if (noOption) {
            System.out.println("No? so sad.");
            AccountManager.setAccountDetails();
        } else {
            System.out.println("Please enter the right option.");
            AccountManager.CheckAccountDetails();
        }
        return null;
    }
}
