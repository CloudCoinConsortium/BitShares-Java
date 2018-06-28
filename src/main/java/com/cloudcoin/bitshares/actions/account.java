package com.cloudcoin.bitshares.actions;

/*import { PrivateKey, key, Aes } from 'bitsharesjs';
import * as types from '../mutations';
// import { getAccountIdByOwnerPubkey, getAccount } from '../services/wallet.js';
import API from '../services/api';
import PersistentStorage from '../services/persistent-storage';*/

import com.cloudcoin.bitshares.bitsharejava.ecc.AES;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import com.cloudcoin.bitshares.bitsharejava.ecc.BrainKey;
import org.apache.commons.codec.binary.Hex;

public class account {

    // does not belong here
    class Balance {

    }

    final int OWNER_KEY_INDEX = 1;
    final int ACTIVE_KEY_INDEX = 0;


    /**
     * Function to convert array of balances to object with keys as assets ids
     * @param {Array} balancesArr - array of balance objects
     */
    public Balance[] balancesToObject(Balance[] balancesArr) {
        Balance[] obj = new Balance[balancesArr.length];
        for (Balance item : balancesArr) {
            obj[item.hashCode()] = item;
        }
        return obj;
    };

    /**
     * helper func
     */
    public void createWallet(String brainkey, String password) throws NoSuchPaddingException,
            NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException,
            InvalidAlgorithmParameterException, InvalidKeySpecException, InvalidKeyException {
        Cipher passwordAes = AES.fromSeed(password.getBytes(StandardCharsets.UTF_8));
        byte[] encryptionBuffer = SecureRandom.getInstance("AES").generateSeed(16);
        Cipher aesPrivate = AES.fromSeed(encryptionBuffer);

        byte[] normalizedBrainkey = BrainKey.normalize(brainkey).getBytes(StandardCharsets.UTF_8);
        String encryptedBrainkey = Hex.encodeHexString(aesPrivate.doFinal(normalizedBrainkey));
        /*const passwordPrivate = PrivateKey.fromSeed(password);
        const passwordPubkey = passwordPrivate.toPublicKey().toPublicKeyString();

        const result = {
            passwordPubkey,
            encryptionKey,
            encryptedBrainkey,
            aesPrivate,
        };

        return result;*/
    }
}
