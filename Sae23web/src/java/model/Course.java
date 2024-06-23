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
public class Course {
    private int idc;
    private String edition;

    // Getters et setters

    // Constructeur avec tous les champs
    public Course(int idc, String edition) {
        this.idc = idc;
        this.edition = edition;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}