/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

/**
 *
 * @author HD
 */
public class SearchManager {
    //TODO incorporate a search method that allows for regex to be used.

    public static void searchCall() {
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

            switch (response) {
                case "-1":
                    return;
                case "1":
                    ""
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                default:
                    break;
            }
        } while (true);

    
    }
}
