package br.com.entra21java.dao;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author Crispim Paiano dos Santos
 */
public class ConverterSHA512 {

    public String transformarSenha(String senha){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-512");
	    digest.reset();
	    digest.update(senha.getBytes("utf8"));
	    return String.format("%040x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }
    
}
