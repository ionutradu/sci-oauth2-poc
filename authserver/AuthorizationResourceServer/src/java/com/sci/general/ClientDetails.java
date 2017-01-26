/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sci.general;

/**
 *
 * @author gabi
 */
public class ClientDetails {
    
    private String callback_uri;
    private String code;

    public ClientDetails() {
    }

    public String getCallback_uri() {
        return callback_uri;
    }

    public void setCallback_uri(String callback_uri) {
        this.callback_uri = callback_uri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
}
