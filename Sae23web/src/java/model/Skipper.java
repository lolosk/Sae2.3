/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author robert
 */
public class Skipper {
    private int ids;
    private String nom;
    private String prenom;
    private String nationalite;
    private int naissance;

    public Skipper(int ids, String nom, String prenom, String nationalite, int naissance) {
        this.ids = ids;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.naissance = naissance;
    }

    // Getters and setters

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getNaissance() {
        return naissance;
    }

    public void setNaissance(int naissance) {
        this.naissance = naissance;
    }
}