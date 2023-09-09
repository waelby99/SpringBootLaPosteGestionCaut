package La.Poste.Waelby.GestCaut.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ordannateurs")
public class Ordonnateur {
    @Id
    private String id;

    private String ref;

    private String nom;

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }

    // Getter for ref
    public String getRef() {
        return ref;
    }

    // Setter for ref
    public void setRef(String ref) {
        this.ref = ref;
    }

    // Getter for nom
    public String getNom() {
        return nom;
    }

    // Setter for nom
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Ordonnateur() {
    }

    public Ordonnateur(String id, String ref, String nom) {
        this.id = id;
        this.ref = ref;
        this.nom = nom;
    }

    public Ordonnateur(String ref, String nom) {
        this.ref = ref;
        this.nom = nom;
    }
}



