package com.cloudcoin.bitshares.bitsharejava.ecc;

public class BrainKey {

    public static String normalize(String brainKey) {
        return String.join(" ", brainKey.trim().split("/(/t|/n|/v|/f|/r )+/"));
    }
}
