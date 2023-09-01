package La.Poste.Waelby.GestCaut.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection="demandes")
public class Demande {

    @Id
    private String id;

    private String username;

    private String nom;
    private String position;

    private String prenom;

    private String email;

    private String password;

    private Date demandecreatedat;

    private Boolean etat;

    private Boolean archived;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDemandecreatedat() {
        return demandecreatedat;
    }

    public void setDemandecreatedat(Date demandecreatedat) {
        this.demandecreatedat = demandecreatedat;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Demande(String id, String username, String nom, String position, String prenom, String email, String password, Date demandecreatedat, Boolean etat,Boolean archived) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.position = position;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.demandecreatedat = demandecreatedat;
        this.etat = etat;
        this.archived = archived;
    }

    public Demande(String username, String nom, String position, String prenom, String email, String password, Date demandecreatedat, Boolean etat,Boolean archived) {
        this.username = username;
        this.nom = nom;
        this.position = position;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.demandecreatedat = demandecreatedat;
        this.etat = etat;
        this.archived = archived;
    }
}
