/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sci.general;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author gabi
 */
public class Constants {
    
    private final static String client_id = "app_20000300_1471874043775";

    public static Map<String, UserDetails> users = new HashMap<String, UserDetails>();
    public static Map<String, String> authorizationCodeUsername = new HashMap<String, String>();
    public static Map<String, ClientDetails> clients = new HashMap<String, ClientDetails>();
    static {
        ClientDetails clientDetails = new ClientDetails();
        clients.put(client_id, clientDetails);
        
        
        UserDetails user1 = new UserDetails("user1", "pass1", "https://pbs.twimg.com/profile_images/1184738582/D04_400x400.png");
        UserDetails user2 = new UserDetails("user2", "pass2", "https://pbs.twimg.com/profile_images/545192591952576512/5_sYRNp6.png");
        
        users.put(user1.getUsername(), user1);
        users.put(user2.getUsername(), user2);
    }
    
    private static final String characters = "qwertyuiopasdfghjklzxcvbnm1234567890";

    public static String generateRandom(int length) {
        Random random = new SecureRandom();
        if (length <= 0) {
            throw new IllegalArgumentException("String length must be a positive integer");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
    
    public static String generateAuthorizationCode(String client_id, String callback_uri, String username) {
        String authorizationCode = generateRandom(20);
        
        clients.get(client_id).setCode(authorizationCode);
        clients.get(client_id).setCallback_uri(callback_uri);
        
        authorizationCodeUsername.put(authorizationCode, username);
        
        return authorizationCode;
    }
    
    public static boolean checkUser(String username, String password) {
        
        if(users.containsKey(username)) {
            if(users.get(username).getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        
        return false;  
    }
}
