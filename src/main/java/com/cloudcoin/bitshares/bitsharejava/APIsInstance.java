package com.cloudcoin.bitshares.bitsharejava;

public class APIsInstance {

    ChainWebSocket ws_rpc;

    String url;
    String statusCb;

    Object autoReconnect;
    boolean closed;

    Object _db;
    Object _net;
    Object _hist;
    Object _crypt;
    Object _orders;

    public void connect(String cs, int connectTimeout) {
        connect(cs, connectTimeout, false, false);
    }

    /**
     * @arg {string} connection ..
     */
    public void connect(String cs, int connectTimeout, boolean enableCrypto, boolean enableOrders) {
        // console.log("INFO\tApiInstances\tconnect\t", cs);
        this.url = cs;
        String rpc_user = "";
        String rpc_password = "";

        if (this.ws_rpc != null) {
            this.ws_rpc.statusCb = null;
            this.ws_rpc.keepAliveCb = null;
            this.ws_rpc.on_close = null;
            this.ws_rpc.on_reconnect = null;
        }
        /*this.ws_rpc = new ChainWebSocket(cs, this.statusCb, connectTimeout, autoReconnect, (closed)=>{
        if(this._db && !closed) {
            this._db.exec('get_objects', [['2.1.0']])
                    .catch((e)=>{

            })
        }
        });
        this.init_promise = this.ws_rpc.login(rpc_user, rpc_password).then(() => {
                //console.log("Connected to API node:", cs);
                this._db = new GrapheneAPI(this.ws_rpc, "database");
        this._net = new GrapheneAPI(this.ws_rpc, "network_broadcast");
        this._hist = new GrapheneAPI(this.ws_rpc, "history");
        if (optionalApis.enableOrders) this._orders = new GrapheneAPI(this.ws_rpc, "orders");
        if (optionalApis.enableCrypto) this._crypt = new GrapheneAPI(this.ws_rpc, "crypto");
        var db_promise = this._db.init().then( ()=> {
        //https://github.com/cryptonomex/graphene/wiki/chain-locked-tx
        return this._db.exec("get_chain_id",[]).then( _chain_id => {
                this.chain_id = _chain_id
        return ChainConfig.setChainId( _chain_id )
        //DEBUG console.log("chain_id1",this.chain_id)
                });
            });
        this.ws_rpc.on_reconnect = () => {
            if (!this.ws_rpc) return;
            this.ws_rpc.login("", "").then(() => {
                    this._db.init().then(() => {
            if(this.statusCb)
                this.statusCb("reconnect");
                    });
            this._net.init();
            this._hist.init();
            if (optionalApis.enableOrders) this._orders.init();
            if (optionalApis.enableCrypto) this._crypt.init();
                });
        }
        this.ws_rpc.on_close = () => {
            this.close().then(() => {
            if (this.closeCb) this.closeCb();
                })
        }
        let initPromises = [
        db_promise,
                this._net.init(),
                this._hist.init(),
            ];

        if (optionalApis.enableOrders) initPromises.push(this._orders.init());
        if (optionalApis.enableCrypto) initPromises.push(this._crypt.init());
        return Promise.all(initPromises);
        }).catch(err => {
                console.error(cs, "Failed to initialize with error", err && err.message);
        return this.close().then(() => {
        throw err;
            });
        })*/
    }

    public void close() {
        /*if (this.ws_rpc && this.ws_rpc.ws.readyState === 1) {
            return this.ws_rpc.close()
                    .then(() => {
                    this.ws_rpc = null;
            });
        };
        this.ws_rpc = null;
        return Promise.resolve();*/
    }

    public Object db_api () {
        return this._db;
    }

    public Object network_api () {
        return this._net;
    }

    public Object history_api () {
        return this._hist;
    }

    public Object crypto_api () {
        return this._crypt;
    }

    public Object orders_api () {
        return this._orders;
    }

    public void setRpcConnectionStatusCallback(String callback) {
        this.statusCb = callback;
    }
}
