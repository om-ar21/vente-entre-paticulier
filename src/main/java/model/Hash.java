package model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.*;

public class Hash {
public String sha1(String input) {
		
	    String sha1 = input;
	    
	    try {
	        MessageDigest msdDigest = MessageDigest.getInstance("SHA-256");
	        				msdDigest = MessageDigest.getInstance("MD5");
	        msdDigest.update(input.getBytes("UTF-8"), 0, input.length());	        
	        		//sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
	        //sha1 = new String(msdDigest.digest(), StandardCharsets.UTF_8);
	        sha1 = Base64.getEncoder().encodeToString(msdDigest.digest());
	        System.out.println("From hashMe: " + sha1);
	        
	        
	    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
	        Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, e);
	    }
	    return sha1;
	    
	}
/**
 * Hash le password en SHA-256
 * 
 * @param chaine le password
 * @return le password crypté
 */
public String hashPwd(String chaine) {
    MessageDigest md = null;
    try {
        md = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    md.update(chaine.getBytes());
    byte byteData[] = md.digest();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
}
}
