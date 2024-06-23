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
public class Classement {
    private int idb;
    private int ids;
    private int idc;
    private int place;
    private String nomBateau;
    private String prenom;
    private String nom;
    private String edition;

    public Classement(int idb, int ids, int idc, int place, String nomBateau) {
        this.idb = idb;
        this.ids = ids;
        this.idc = idc;
        this.place = place;
        this.nomBateau = nomBateau;
    }

    // Getters and Setters for all attributes

    public int getIdb() { return idb; }
    public void setIdb(int idb) { this.idb = idb; }

    public int getIds() { return ids; }
    public void setIds(int ids) { this.ids = ids; }

    public int getIdc() { return idc; }
    public void setIdc(int idc) { this.idc = idc; }

    public int getPlace() { return place; }
    public void setPlace(int place) { this.place = place; }

    public String getNomBateau() { return nomBateau; }
    public void setNomBateau(String nomBateau) { this.nomBateau = nomBateau; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }
}