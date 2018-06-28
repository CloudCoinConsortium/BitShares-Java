package com.cloudcoin.bitshares.bitsharejava.ecc;

import org.springframework.lang.NonNull;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import static org.apache.commons.codec.digest.DigestUtils.sha512;

public class AES {

    /**
     * @arg {string} seed - secret seed may be used to encrypt or decrypt.
     */
    public static Cipher fromSeed(@NonNull byte[] seed) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException {
        String hashSHA = new String(sha512(seed), StandardCharsets.UTF_8);

        IvParameterSpec iv = new IvParameterSpec(DatatypeConverter.parseHexBinary(hashSHA.substring(64, 96)));
        SecretKeySpec keySpec = new SecretKeySpec(DatatypeConverter.parseHexBinary(hashSHA.substring(0, 64)), "AES");
        SecretKey key = SecretKeyFactory.getInstance("AES").generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        // System.out.println("... fromSeed ", + hash);
        return cipher;
    }
}
