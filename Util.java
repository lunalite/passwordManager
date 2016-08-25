/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author HD
 */
public class Util {

    /**
     * Static Scanner that simplifies taking in of input
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * The List of keys of Account Information that would be mapped later
     */
    public static List<String> AccountStoringFormatKey = new ArrayList();

    /**
     * Iterator that lists the keys of Account Information that would be further mapped
     */
    public static Iterator<String> AccountStoringFormatKeyItr;
    
    /**
     * Resets the iterator so that the cursor points back to the first key
     */
    public static void AccountStoringFormatKeyResetItr() {
        AccountStoringFormatKeyItr = AccountStoringFormatKey.iterator();
    }

    static {
        AccountStoringFormatKey.add("service");
        AccountStoringFormatKey.add("userName");
        AccountStoringFormatKey.add("password");
        AccountStoringFormatKey.add("email");
        AccountStoringFormatKey.add("misc");
    }
}
