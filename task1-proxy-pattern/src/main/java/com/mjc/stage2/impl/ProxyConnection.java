package com.mjc.stage2.impl;

import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    private boolean isClosed;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
        this.isClosed = false;
    }

    public void reallyClose() {
        if (!isClosed && !realConnection.isClosed()) {
            realConnection.close();
            isClosed = true;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isClosed() {
        return isClosed || realConnection.isClosed();
    }
}
