package com.cloudcoin.bitshares.bitsharejava;

public class GrapheneAPI {

    ChainWebSocket ws_rpc;

    String api_name;
    String api_id;

    public GrapheneAPI(ChainWebSocket ws_rpc, String api_name) {
        this.ws_rpc = ws_rpc;
        this.api_name = api_name;
    }

    public GrapheneAPI init() {
        /*return this.ws_rpc.call([1, this.api_name, []]).then( response => {
                //console.log("[GrapheneApi.js:11] ----- GrapheneApi.init ----->", this.api_name, response);
                api_id = response;
        return this;
        });*/
        return this;
    }

    public void exec(Object method, Object params) {
        /*return this.ws_rpc.call([this.api_id, method, params]).catch(error => {
        // console.log("!!! GrapheneApi error: ", method, params, error, JSON.stringify(error));
        throw error;
        });*/
    }
}
