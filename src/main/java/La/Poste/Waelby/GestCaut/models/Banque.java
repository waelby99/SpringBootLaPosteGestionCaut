package La.Poste.Waelby.GestCaut.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="banques")
public class Banque {

    @Id
    private String id;

    private String nom;

    private String mail;

    private String adresse;

    private int tel;

    public Banque() {
    }

    public Banque(String id, String nom, String mail, String adresse, int tel) {
        this.id = id;
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Banque(String nom, String mail, String adresse, int tel) {
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }



    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
