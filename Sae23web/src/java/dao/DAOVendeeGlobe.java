/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author robert
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bateau;
import model.Classement;
import model.ClassementComplet;
import model.Skipper;

public class DAOVendeeGlobe {
    private static final Logger LOGGER = Logger.getLogger(DAOVendeeGlobe.class.getName());

    public static final String DB = "vglobe";
    public static final String ROLE = "admin";
    private static final String PWD = "m2104";
    
    private String serveurIP;
    private Integer serveurPort;
    
    public DAOVendeeGlobe(String ip, Integer port) {
        this.serveurIP = ip;
        this.serveurPort = port;
    }
    
    public DAOVendeeGlobe(String ip) {
        this(ip, 5432);
    }
    
    public DAOVendeeGlobe() {
        this("localhost");
    }

    public String getServeurURL() {
        return "jdbc:postgresql://" + serveurIP + ":" + serveurPort + "/" + DB; 
    }

    public List<Skipper> lireTousLesSkippers() {
        List<Skipper> skippers = new ArrayList<>();
        String query = "SELECT ids, nom, prenom, naissance, nationalite FROM skipper";
        LOGGER.log(Level.INFO, "Connecting to database at: {0}", getServeurURL());
        
        // Enregistrer le driver JDBC
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "PostgreSQL JDBC Driver not found", e);
            return skippers;
        }

        try (Connection con = DriverManager.getConnection(getServeurURL(), ROLE, PWD);
             PreparedStatement st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {
            LOGGER.log(Level.INFO, "Connected to database.");
            while (rs.next()) {
                int id = rs.getInt("ids");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String nationalite = rs.getString("nationalite");
                int naissance = rs.getInt("naissance");
                Skipper skipper = new Skipper(id, nom, prenom, nationalite, naissance);
                skippers.add(skipper);
                LOGGER.log(Level.INFO, "Added skipper: {0} {1}", new Object[]{prenom, nom});
            }
            LOGGER.log(Level.INFO, "Number of skippers found: {0}", skippers.size());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error", e);
        }
        return skippers;
    }
    
    
    
    public List<Bateau> lireBateaux() {
    List<Bateau> bateaux = new ArrayList<>();
    try (
        Connection con = DriverManager.getConnection(getServeurURL(), ROLE, PWD);
        PreparedStatement st = con.prepareStatement(
            "SELECT b.idb, b.architecte, b.misealeau, c.nombateau " +
            "FROM bateau b " +
            "JOIN classement c ON b.idb = c.idb;"
        );
        ResultSet rs = st.executeQuery()
    ) {
        while (rs.next()) {
            int idb = rs.getInt("idb");
            String architecte = rs.getString("architecte");
            int misealeau = rs.getInt("misealeau");
            String nomBateau = rs.getString("nombateau");
            Bateau bateau = new Bateau(idb, architecte, misealeau, nomBateau);
            bateaux.add(bateau);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bateaux;
    }

    
    
    public List<ClassementComplet> getClassementsByEdition(String edition) {
    List<ClassementComplet> classements = new ArrayList<>();
    try (
        Connection con = DriverManager.getConnection(getServeurURL(), ROLE, PWD);
        PreparedStatement st = con.prepareStatement(
            "SELECT c.place, s.prenom, s.nom, s.nationalite, s.naissance, c.nombateau, b.architecte, b.misealeau " +
            "FROM classement c " +
            "JOIN skipper s ON c.ids = s.ids " +
            "JOIN bateau b ON c.idb = b.idb " +
            "JOIN course co ON c.idc = co.idc " +
            "WHERE co.edition = ?"
        )
    ) {
        st.setString(1, edition);
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int place = rs.getInt("place");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String nationalite = rs.getString("nationalite");
                int naissance = rs.getInt("naissance");
                String nomBateau = rs.getString("nombateau");
                String architecte = rs.getString("architecte");
                int misealeau = rs.getInt("misealeau");

                ClassementComplet classement = new ClassementComplet(place, prenom, nom, nationalite, naissance, nomBateau, architecte, misealeau);
                classements.add(classement);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return classements;
}




    


    
}