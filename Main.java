package fr.ubordeaux.miage.s7.poo.td1;
public class Main {

    public static void main(String[] args){

        Customer testingMyself = new Customer("PUTREGAI", "Alexandru",
                "351 Avenue de la Libération",
                "alexandru.putregai@gmail.com",
                "0667224080");

        System.out.println("\n");
        System.out.println(testingMyself.toString());
        System.out.println("\n");

        System.out.println("Le contenu avant l'achat du client:");

        Catalog catalog = Catalog.getInstance();

        catalog.ajouterProduit("maïs", 2.0f, 17);
        catalog.ajouterProduit("chaussure", 1.8f, 63);
        catalog.ajouterProduit("scooter", 1.0f, 7);
        System.out.println(catalog.toString());
        System.out.println("\n");

        Basket basket = new Basket(testingMyself);

        basket.ajouterProduit(0, 2);
        basket.ajouterProduit(1, 1);
        basket.ajouterProduit(2, 4);

        System.out.println("Le contenu du panier du client:");
        System.out.println(basket.toString());
        System.out.println("\n");
        System.out.println("Le contenu du catalog après l'achat:");
        System.out.println(catalog.toString());
        System.out.println("\n");

        System.out.println("Vérification de l'annulation en cas de rupture de stock");
        Customer testingYourself = new Customer("Dupond", "Ferland,",
                "31 Avenue de la Libération",
                "dupond.ferland@gmail.com",
                "0667224010");
        Basket basket2= new Basket(testingYourself);
        basket2.ajouterProduit(2,5);
        System.out.println(basket2.toString());
    }
}
