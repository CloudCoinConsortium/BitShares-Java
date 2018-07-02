package com.cloudcoin.bitshares.actions;

public class user {

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
     * Fetches users objects from bitsharesjs-ws
     *
     * @param {string} username - name of user to fetch
     */
    public void fetchUser() {

    }

    /**
     * Checks username for existance
     *
     * @param {string} username - name of user to fetch
     */
    public void checkUsername() {

    }
}
