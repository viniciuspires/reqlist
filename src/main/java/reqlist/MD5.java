/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqlist;

import java.security.*;
import java.math.*;

/**
 *
 * @author Vinicius
 */
public class MD5 {
    public static String digest(String s){
        String retorno = "";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(),0,s.length());
            retorno = new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(MD5.class.getName()+": "+ex);
        }
        
        return retorno;
    }
}