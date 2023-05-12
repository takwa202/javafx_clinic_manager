/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lenovo
 */
public class ShaUtils {
    
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
        // String algorithm = "SHA3-256";

       // String pText = "Hello World";
      //  System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
       // System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));
       
    /**
     *
     * @param text
     * @return
     */
    public String sha_256encryption(String text){
    String result = null;
     String algorithm = "SHA-256";
      byte[] shaInBytes = ShaUtils.digest(text.getBytes(UTF_8), algorithm);
    result =bytesToHex(shaInBytes);
    
    return result;
    }
       
       
    
}
    
    
    

