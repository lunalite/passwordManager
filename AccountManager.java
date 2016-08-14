/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

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

    //TODO: Add frequently used user/pw/email
    public static void setAccountDetails() {
        AccountDetails = new ArrayList();
        
        System.out.print("Please enter the type of service: ");
        String serviceType = Util.sc.next();
        AccountManager.AccountDetails.add(serviceType);

        System.out.print("Please enter your username: ");
        String userName = Util.sc.next();
        AccountManager.AccountDetails.add(userName);

        //TODO: Add hidden pw field
        System.out.print("Please enter your current password: ");
        String password = Util.sc.next();
        AccountManager.AccountDetails.add(password);

        System.out.print("Please enter the registered email: ");
        String email = Util.sc.next();
        AccountManager.AccountDetails.add(email);

        System.out.print("Are there any other details required?: ");
        String misc = Util.sc.next();
        AccountManager.AccountDetails.add(misc);
        
        AccountManager.CheckAccountDetails();
    }

    public static void CheckAccountDetails() {
        System.out.println("Please check if the details are correct:");
        Iterator<String> accountItr = AccountDetails.iterator();
        while (accountItr.hasNext()) {
            System.out.println(accountItr.next());
        }
        System.out.println("[Y]es [N]o");
        String option = Util.sc.next();
        boolean yesOption = Pattern.matches("([yY])|([yY][eE][sS])", option);
        boolean noOption = Pattern.matches("([nN])|([nN][oO])", option);
        if (yesOption) {
            System.out.println("Thank you.");
        } else if (noOption) {
            System.out.println("No? so sad.");
            AccountManager.setAccountDetails();
        } else {
            System.out.println("Please enter the right option.");
            AccountManager.CheckAccountDetails();
        }

    }
}
