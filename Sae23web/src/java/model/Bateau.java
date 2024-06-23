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
public class Bateau {
    private int idb;
    private String architecte;
    private int misealeau;
    private String nomBateau;

    public Bateau(int idb, String architecte, int misealeau, String nomBateau) {
        this.idb = idb;
        this.architecte = architecte;
        this.misealeau = misealeau;
        this.nomBateau = nomBateau;
    }

    // Getters and setters for all attributes

    public int getIdb() {
        return idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
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

    public String getNomBateau() {
        return nomBateau;
    }

    public void setNomBateau(String nomBateau) {
        this.nomBateau = nomBateau;
    }
}