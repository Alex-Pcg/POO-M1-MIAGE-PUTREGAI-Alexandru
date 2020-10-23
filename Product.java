package fr.ubordeaux.miage.s7.poo.td1;

import java.util.Objects;

public class Product {
    //LES VARIABLES
    private final int id;
    private final float prix;
    private final String nom;
    private static int prochainProduit = 0;

    //CONSTRUCTEUR
    public Product(float prix, String nom) {
        this.id = prochainProduit++;
        this.prix = prix;
        this.nom = nom;
    }

    //GETTERS
    public int getId() {return id;}
    public float getPrix() {return prix;}
    public String getNom() {return nom;}

    //OVERRIDES
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.prix, prix) == 0 && Objects.equals(nom, product.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prix, nom);
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", prix=" + prix +
                ", nom='" + nom + '\'' +
                '}';
    }
}
