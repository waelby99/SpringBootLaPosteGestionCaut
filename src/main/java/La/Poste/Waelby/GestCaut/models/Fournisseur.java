package La.Poste.Waelby.GestCaut.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fournisseurs")
public class Fournisseur {

    @Id
    private String id;
    @NotBlank
    @Size(max=20)
    private String nom;
    @NotBlank
    @Size(max=50)
    @Email
    private String mail;
    @NotBlank
    @Size(max=150)
    private String adresse;
    @NotNull
    private int tel;

    public Fournisseur() {
    }

    public Fournisseur(String id, String nom, String mail, String adresse, int tel) {
        this.id = id;
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Fournisseur(String nom, String mail, String adresse, int tel) {
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
