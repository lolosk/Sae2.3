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
public class ClassementComplet {
    private int place;
    private String prenom;
    private String nom;
    private String nationalite;
    private int naissance;
    private String nomBateau;
    private String architecte;
    private int misealeau;

    public ClassementComplet(int place, String prenom, String nom, String nationalite, int naissance, String nomBateau, String architecte, int misealeau) {
        this.place = place;
        this.prenom = prenom;
        this.nom = nom;
        this.nationalite = nationalite;
        this.naissance = naissance;
        this.nomBateau = nomBateau;
        this.architecte = architecte;
        this.misealeau = misealeau;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getNomBateau() {
        return nomBateau;
    }

    public void setNomBateau(String nomBateau) {
        this.nomBateau = nomBateau;
    }

    public String getArchitecte() {
        return architecte;
    }

    public void setArchitecte(String architecte) {
        this.architecte = architecte;
    }

    public int getMisealeau() {
        return misealeau;
    }

    public void setMisealeau(int misealeau) {
        this.misealeau = misealeau;
    }

    
}

