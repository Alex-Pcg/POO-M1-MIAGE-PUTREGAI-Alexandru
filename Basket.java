package fr.ubordeaux.miage.s7.poo.td1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Basket {
    //LES VARIABLES
    private final int id;
    private Map<Product, Integer> produits;
    private Customer customer;

    private static int prochainBasket = 0;

    //CONSTRUCTEUR
    public Basket(final Customer customer) {
        this.id = prochainBasket++;
        produits = new HashMap<>();
        this.customer = customer;
    }

    //LES METHODES
    public void ajouterProduit(final int produitId, int quantite) {
        Catalog catalog = Catalog.getInstance();
        Product produitAjoute = catalog.getProductById(produitId);
        int quantiteProduite = catalog.quantiteProduit(produitAjoute);
        if (produitAjoute != null & quantiteProduite > quantite) {
            produits.put(produitAjoute, produits.getOrDefault(produitAjoute, 0) + quantite);
            catalog.setProductById(produitAjoute, quantite);
        } else {
            System.err.println("Produit est en rupture de stock");
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    //LES OVERRIDES
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id && Objects.equals(produits, basket.produits) && Objects.equals(customer, basket.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produits, customer);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", produits=" + produits +
                '}';
    }
}
