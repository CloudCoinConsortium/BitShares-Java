package com.cloudcoin.bitshares.bitsharejava.ecc;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

import static org.apache.commons.codec.digest.DigestUtils.sha256;

public class PrivateKey {

    private static Cipher fromBuffer(byte[] buf) throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES");
        //return new PrivateKey(BigInteger.valueOf(buf));
    }

    /**
     * @arg {string} seed - any length string.  This is private, the same seed produces the same private key every time.
     */
    public static Cipher fromSeed(String seed) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return PrivateKey.fromBuffer(sha256(seed));
    }
}
