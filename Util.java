/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager;

import basicpwmanager.models.ACC_TYPE;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author HD
 */
public class Util {

    /* Please set the following variables*/
    
    public static File File = new File("secretFile");
    
    /* End of configuration*/
    
    public static Scanner sc = new Scanner(System.in);
    public static GsonBuilder Builder = new GsonBuilder();
    public static Gson Gson = Util.Builder.create();

    /**
     * The List of keys of Account Information that would be mapped later.
     */
    public static List<ACC_TYPE> AccountStoringFormatKey = new ArrayList();

    /**
     * Iterator that lists the keys of Account Information that would be further
     * mapped.
     */
    public static Iterator<ACC_TYPE> AccountStoringFormatKeyItr;

    /**
     * Resets the iterator so that the cursor points back to the first key.
     */
    public static void AccountStoringFormatKeyResetItr() {
        AccountStoringFormatKeyItr = AccountStoringFormatKey.iterator();
    }

    static {
        AccountStoringFormatKey.add(ACC_TYPE.SERVICE);
        AccountStoringFormatKey.add(ACC_TYPE.USERNAME);
        AccountStoringFormatKey.add(ACC_TYPE.PASSWORD);
        AccountStoringFormatKey.add(ACC_TYPE.EMAIL);
        AccountStoringFormatKey.add(ACC_TYPE.MISC);
    }
}
