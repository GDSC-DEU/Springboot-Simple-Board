package com.gdscdeu.springboot.simpleboard.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    public static String SHA512(String input){
        try{
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            byte[] digest = sha512.digest(input.getBytes());
            String hash = new BigInteger(1, digest).toString(16);

            while (hash.length() < 32) {

                hash = "0" + hash;
            }
            return hash;
        }
        catch (NoSuchAlgorithmException error){
            throw new RuntimeException(error);
        }
    }
}
