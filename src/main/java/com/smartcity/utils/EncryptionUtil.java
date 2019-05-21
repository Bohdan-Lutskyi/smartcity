package com.smartcity.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {

    private static Logger logger = LoggerFactory.getLogger(EncryptionUtil.class);

    public static String encryptionPassword(String plaintextPassword){
        if (plaintextPassword == null) return null;

        String algoritm = "SHA";
        byte[] plainText = plaintextPassword.getBytes();

        MessageDigest md;

        try {
            md = MessageDigest.getInstance(algoritm);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Password encrypt exception. Message: {}", e.getMessage());
            return null;
        }

        md.reset();
        md.update(plainText);
        byte[] encodedPassword = md.digest();
        StringBuilder encryptedPassword = new StringBuilder();

        for (byte b : encodedPassword) {
            if ((b & 0xff) < 0x10) encryptedPassword.append("0");

            encryptedPassword.append(Long.toString(b & 0xff, 16));
        }
        return encryptedPassword.toString();

    }
}
