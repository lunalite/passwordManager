/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager.models;

import basicpwmanager.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HD
 */
public class Account {

    private String service;
    private String username;
    private String password;
    private String email;
    private String misc;

    public Account(String service, String username, String password, String email, String misc) {
        this.service = service;
        this.username = username;
        this.password = password;
        this.email = email;
        this.misc = misc;
    }
    
    public String getService() {
        return service;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getMisc() {
        return misc;
    }

    public Map<ACC_TYPE, String> getMap() {
        Map<ACC_TYPE, String> tempAccountMap = new HashMap();

        Util.AccountStoringFormatKeyResetItr();
        tempAccountMap.put(Util.AccountStoringFormatKeyItr.next(), service);
        tempAccountMap.put(Util.AccountStoringFormatKeyItr.next(), username);
        tempAccountMap.put(Util.AccountStoringFormatKeyItr.next(), password);
        tempAccountMap.put(Util.AccountStoringFormatKeyItr.next(), email);
        tempAccountMap.put(Util.AccountStoringFormatKeyItr.next(), misc);       
        return tempAccountMap;
    }

}
