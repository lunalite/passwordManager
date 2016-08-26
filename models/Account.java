/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpwmanager.models;

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
    
}