/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author HP
 */
public class Signature {
    //méthode qui permet générer la signature 
   public String hmacSign(byte[] data , String privateSecret) throws NoSuchAlgorithmException, InvalidKeyException{
      SecretKeySpec secretKeySpec ;
      //Hmac algorithme qui permet de générer une signature 
      secretKeySpec = new SecretKeySpec(privateSecret.getBytes(),"HmacSHA256");
      //instance 
      Mac mac = Mac.getInstance("HmacSHA256");
      //initialiser avec la clé 
      mac.init(secretKeySpec);
      byte [] signature = mac.doFinal(data); //tableau de byte qu'on va le stokcer 
      //return signature format texte 
      return Base64.getEncoder().encodeToString(signature);
           
   }
   
   
}