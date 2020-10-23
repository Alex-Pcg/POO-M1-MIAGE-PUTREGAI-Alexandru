package fr.ubordeaux.miage.s7.poo.td1;

import java.util.Objects;

public class Customer {
    //LES VARIABLES
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;

    private static int idCounter = 0;
    private final int id;

    //CONSTRUCTEUR
    public Customer(String nom, String prenom, String adresse, String email, String telephone) {
        this.id = idCounter++;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

        if(verifTelephone(telephone)==true){
            this.telephone = telephone;
        }else{
            System.out.println("Le numéro de téléhpone introduit n'est pas correct");
            System.exit(1);
        }

        if(verifEmail(email) ==true){
            this.email = email;
        }else{
            System.out.println("L'email introduit n'est pas correct");
            System.exit(1);
        }
    }

    /*  Formule Regex trouvé sur:
        https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
     */
    private static boolean verifEmail(final String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }
    /*
    https://www.developpez.net/forums/d1400873/java/general-java/expression-regex-valider-numero-telephone-france/
    */
    private static boolean verifTelephone(final String telephone){
        String regex = "(0|\\\\+33|0033)[1-9][0-9]{8}";
        return telephone.matches(regex);
    }

    //Les GETTERS
    public static int getProchainId() {return idCounter;}
    public int getId() {return id;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getAdresse() {return adresse;}
    public String getEmail() {return email;}
    public String getTelephone() {return telephone;}

    //Les SETTERS
    public static void setProchainId(int prochainId) {
        Customer.idCounter = prochainId;
    }
    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setAdresse(String adresse) {this.adresse = adresse;}
    public void setTelephone(String telephone) {this.telephone = telephone;}
    public void setEmail(String email) {
        if(verifEmail(email)){
            this.email = email;
        }else{
            System.err.println("L'email introduit n'est pas correct");
            System.exit(1);
        }
    }

    //LES OVERRIDES
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(nom, customer.prenom)
                && Objects.equals(prenom, customer.prenom)
                && Objects.equals(adresse, customer.adresse)
                && Objects.equals(email, customer.email)
                && Objects.equals(telephone, customer.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, adresse, email, telephone);
    }

    @Override
    public String toString() {
        return "Client{\n" +
                " id=" + id +
                ",\n Nom='" + nom + '\'' +
                ",\n Alexandru='" + prenom + '\'' +
                ",\n adresse='" + adresse + '\'' +
                ",\n email='" + email + '\'' +
                ",\n téléphone='" + telephone + '\'' +
                '}';
    }
}
