/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reqlist.util;

import java.security.*;
import java.math.*;

/**
 *
 * @author Vinicius
 */
public class Hash {
    
    public static String md5(String string){
        String retorno = "";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(string.getBytes(),0,string.length());
            retorno = new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(Hash.class.getName()+": "+ex);
        }
        
        return retorno;
    }

    public static String sha1(String string) {
        String retorno = "";
        try {
            MessageDigest m = MessageDigest.getInstance("SHA1");
            m.update(string.getBytes(),0,string.length());
            retorno = new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(Hash.class.getName()+": "+ex);
        }
        
        return retorno;
    }
}