package com.cloudcoin.bitshares.actions;

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

import static org.apache.commons.codec.digest.DigestUtils.sha512;

public class account {

    final int OWNER_KEY_INDEX = 1;
    final int ACTIVE_KEY_INDEX = 0;


    /**
     * Function to convert array of balances to object with keys as assets ids
     *
     * @param {Array} balancesArr - array of balance objects
     */
    public void /*Object[]*/ balancesToObject(Object[] balancesArr) {
        /*Balance[] obj = new Balance[balancesArr.length];
        for (Balance item : balancesArr) {
            obj[item.hashCode()] = item;
        }
        return obj;*/
    }

    /**
     * helper func
     */
    public void createWallet(String brainkey, String password) throws NoSuchPaddingException,
            NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException,
            InvalidAlgorithmParameterException, InvalidKeySpecException, InvalidKeyException {
        /*Cipher passwordAes = AES.fromSeed(password.getBytes(StandardCharsets.UTF_8));
        byte[] encryptionBuffer = SecureRandom.getInstance("AES").generateSeed(16);
        String encryptionKey = new String(encryptionBuffer, StandardCharsets.UTF_8);
        Cipher aesPrivate = AES.fromSeed(encryptionBuffer);

        byte[] normalizedBrainkey = BrainKey.normalize(brainkey).getBytes(StandardCharsets.UTF_8);
        String encryptedBrainkey = Hex.encodeHexString(aesPrivate.doFinal(normalizedBrainkey));
        const passwordPrivate = PrivateKey.fromSeed(password);
        const passwordPubkey = passwordPrivate.toPublicKey().toPublicKeyString();

        const result = {
            passwordPubkey,
            encryptionKey,
            encryptedBrainkey,
            aesPrivate,
        };

        return result;*/
    }

    /**
     * Unlocks user's wallet via provided password
     *
     * @param {string} password - user password
     */
    public void unlockWallet(Object commit, Object state, String password) throws InvalidKeySpecException,
            InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        /*Cipher passwordAes = AES.fromSeed(password.getBytes(StandardCharsets.UTF_8));
        byte[] encryptionPlainbuffer = passwordAes.decryptHexToBuffer(state.encryptionKey);
        const aesPrivate = Aes.fromSeed(encryptionPlainbuffer);
        commit(types.ACCOUNT_UNLOCK_WALLET, aesPrivate);*/
    }

    /**
     * Locks user's wallet
     */
    public void lockWallet(Object commit) {

    }

    /**
     * Creates account & wallet for user
     *
     * @param {string} name - user name
     * @param {string} password - user password
     * @param {string} dictionary - string to generate brainkey from
     */
    public void signup() {

    }

    //  write backup brainkey date to Cookie
    public void storeBackupDate() {//} (state, { date, userId }) => {

    }

    /**
     * Logs in & creates wallet
     *
     * @param {string} password - user password
     * @param {string} brainkey - user brainkey
     */
    public void login() {

    }

    /**
     * Log out
     */
    public void logout(Object commit) {

    }

    // clears current user data (balances, acount, etc)
    public void clearCurrentUserData(Object commit) {

    }

    /**
     * Gets user's data from storage and saves it
     */
    public void checkCachedUserData(Object commit) {

    }

    /**
     * Checks username for existance
     *
     * @param {string} username - name of user to fetch
     */
    public void checkIfUsernameFree() {

    }

    public void fetchCurrentUser() {

    }
}
