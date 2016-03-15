package com.example.eaversenq.floremipyweb.model;

/**
 * Created by EAVERSENQ on 01/03/2016.
 */
public class Context {

    private String nom;
    private String prenom;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    private long productId;

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
