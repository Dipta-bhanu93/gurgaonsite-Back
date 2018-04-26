package com.dipta.project.utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
 * This program shows how AES encryption and decryption can be done in Java.
 * SecretKey is generated first time and store in to the server which are used for next time for encryption and decryption process.
 * @author Shrikant kushwaha
 */
public class AESEncryption {
 
    /**
     * 1. Generate a plain text for encryption
     * 2. Get a secret key (printed in hexadecimal form). In actual use this must 
     * by encrypted and kept safe. The same key is required for decryption.
     * 3. 
     */
	public static final String SECURE_KEY_PATH="/cdiondemand/api.ser";
       
    public static String encryptText(String plainText) throws Exception{
    	SecretKey secKey=getSavedSecreatKey();
    	byte[] cipherText = encryptText(plainText, secKey);
    	return DatatypeConverter.printBase64Binary(cipherText);
    }
    public static String decryptText(String encyptText) throws Exception{
    	SecretKey secKey=getSavedSecreatKey();
    	String decryptedText = decryptText(DatatypeConverter.parseBase64Binary(encyptText), secKey);
    	return decryptedText;
    }
    
    
    
    public static SecretKey createSecurityKey() throws Exception{
    	SecretKey secKey = getSecretEncryptionKey();
    	FileOutputStream fout = new FileOutputStream(SECURE_KEY_PATH);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(secKey);
        return secKey;
    }
    
    
    public static SecretKey getSavedSecreatKey() throws Exception{
    	SecretKey secKey;
		try {
			FileInputStream fin = new FileInputStream(SECURE_KEY_PATH);
			ObjectInputStream ois = new ObjectInputStream(fin);
			secKey = (SecretKey) ois.readObject();
		} catch (FileNotFoundException e) {
			return createSecurityKey();
		}
        return secKey;
    }
    
    /**
     * gets the AES encryption key. In your actual programs, this should be safely
     * stored.
     * @return
     * @throws Exception 
     */
    public static SecretKey getSecretEncryptionKey() throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
        SecretKey secKey = generator.generateKey();
        return secKey;
    }
    
    /**
     * Encrypts plainText in AES using the secret key
     * @param plainText
     * @param secKey
     * @return
     * @throws Exception 
     */
    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return byteCipherText;
    }
    
    /**
     * Decrypts encrypted byte array using the key used for encryption.
     * @param byteCipherText
     * @param secKey
     * @return
     * @throws Exception 
     */
    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }
    
    /**
     * Convert a binary byte array into readable hex form
     * @param hash
     * @return 
     */
    private static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }
}