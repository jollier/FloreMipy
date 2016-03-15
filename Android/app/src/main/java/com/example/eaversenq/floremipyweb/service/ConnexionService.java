package com.example.eaversenq.floremipyweb.service;

import com.example.eaversenq.floremipyweb.model.Context;

public class ConnexionService {

    private Context ctx = new Context();
    private static ConnexionService c;

    private ConnexionService() {}

    public static ConnexionService getInstance() {
        if (c == null) c = new ConnexionService();
        return c;
    }

    public Context getCtx() {
        return ctx;
    }
}
