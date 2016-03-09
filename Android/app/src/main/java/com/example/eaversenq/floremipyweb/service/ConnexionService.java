package com.example.eaversenq.floremipyweb.service;

import com.example.eaversenq.floremipyweb.model.Connexion;

public class ConnexionService {

    private Connexion cnx = new Connexion();
    private static ConnexionService c;

    private ConnexionService() {}

    public static ConnexionService getInstance() {
        if (c == null) c = new ConnexionService();
        return c;
    }

    public Connexion getCnx() {
        return cnx;
    }
}
