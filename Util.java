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

    public static Scanner sc = new Scanner(System.in);
    public static List<String> AccountStoringFormatKey = new ArrayList();
    public static Iterator<String> AccountStoringFormatKeyItr;
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
