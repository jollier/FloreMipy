package com.example.eaversenq.floremipyweb.model;

/**
 * Created by EAVERSENQ on 01/03/2016.
 */
public class Cnx {

    private Cnx() {}
    private String nom = "KETAMER";
    private String prenom = "Jenny";

    private static Cnx c;

    public static Cnx getInstance() {
        if (c == null) c = new Cnx();
        return c;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
