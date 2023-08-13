package La.Poste.Waelby.GestCaut.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection="cautions")
public class Caution {

    @Id
    private String id;


    private int code;

    private Date datecaut;

    private String reference;

    private float montant;

    private Date dateleve;

    private Date daterest;


    private String remarque;

    private Etat etat;
    @DBRef
    private Set<Ordonnateur> ordonnateurs = new HashSet<>();

    @DBRef
    private Set<Banque> banques = new HashSet<>();

    @DBRef
    private Set<Fournisseur> fournisseurs = new HashSet<>();


    public Set<Banque> getBanques() {
        return banques;
    }

    public void setBanques(Set<Banque> banques) {
        this.banques = banques;
    }

    public Set<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(Set<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public Set<Ordonnateur> getOrdonnateurs() {
        return ordonnateurs;
    }

    public void setOrdonnateurs(Set<Ordonnateur> ordonnateurs) {
        this.ordonnateurs = ordonnateurs;
    }


    public enum Etat {
        encours,
        leve,
        restitution,
        saisie
    }



    public Caution() {
    }

    public Caution(int code, Date datecaut, String reference, float montant, Date dateleve, Date daterest, String remarque, Etat etat) {
        this.code = code;
        this.datecaut = datecaut;
        this.reference = reference;
        this.montant = montant;
        this.dateleve = dateleve;
        this.daterest = daterest;
        this.remarque = remarque;
        this.etat = etat;
    }

    public Caution(String id, int code, Date datecaut, String reference, float montant, Date dateleve, Date daterest, String remarque, Etat etat) {
        this.id = id;
        this.code = code;
        this.datecaut = datecaut;
        this.reference = reference;
        this.montant = montant;
        this.dateleve = dateleve;
        this.daterest = daterest;
        this.remarque = remarque;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDatecaut() {
        return datecaut;
    }

    public void setDatecaut(Date datecaut) {
        this.datecaut = datecaut;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDateleve() {
        return dateleve;
    }

    public void setDateleve(Date dateleve) {
        this.dateleve = dateleve;
    }

    public Date getDaterest() {
        return daterest;
    }

    public void setDaterest(Date daterest) {
        this.daterest = daterest;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
