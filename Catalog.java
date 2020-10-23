package fr.ubordeaux.miage.s7.poo.td1;

import java.util.*;

public class Catalog {
    //LES VARIABLES
    private static Catalog INSTANCE = new Catalog();
    private final Map<Product, Integer> products;

    //CONSTRUCTEURS
    private Catalog() {
        products = new HashMap<>();
    }

    //LES GETTERS
    public static Catalog getInstance() {return INSTANCE;}
    public int quantiteProduit(final Product produit){
        return products.getOrDefault(produit, 0);
    }
    public Product getProductById(final int id) {
        for(Product p : products.keySet()){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    //LES SETTERS
    public void setProductById(final Product produit, final int quantite){
        products.put(produit, quantiteProduit(produit)-quantite);
    }

    public void ajouterProduit(final String nom, final float prix, final int quantite) {
        products.put(new Product(prix, nom), quantite);
    }

    //LES OVERRIDES
    @Override
    public String toString() {
        return "Catalog{" +
                "produits=" + products +
                '}';
    }
}
