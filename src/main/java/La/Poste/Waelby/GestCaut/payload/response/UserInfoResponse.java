package La.Poste.Waelby.GestCaut.payload.response;

import java.util.List;

public class UserInfoResponse {
    private String id;
    private String username;
    private String email;
    private List<String> roles;
    private String nom;
    private String prenom;
    private String position;


    public UserInfoResponse(String id, String username, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public UserInfoResponse(String id, String username, String email, List<String> roles, String nom, String prenom, String position) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
