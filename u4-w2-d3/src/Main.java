import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

//        PRODOTTI
        Supplier<Double> randomPrice = () -> {
            Random random = new Random();
            return random.nextDouble(1, 2000);

        };
        String[] categorie = {"Boys", "Baby", "Books", "Games", "Home"};
        Supplier<String> randomCategory = () -> {
            int index = new Random().nextInt(categorie.length);
            return categorie[index];
        };

        Supplier<Product> productSupplier = () -> new Product("Prodotto", randomCategory.get(), randomPrice.get());

        List<Product> prodotti = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            prodotti.add(productSupplier.get());
        }

        System.out.println(prodotti);
//        ESERCIZIO 1

        List<Product> books = prodotti.stream().filter(Product -> Product.getCategory().equals("Books") && Product.getPrice() > 100).toList();
        System.out.println("ESERCIZIO 1");
        System.out.println("Questi sono i libri che costano più di 100: " + books);


//        ESERCIZIO 3
        System.out.println("ESERCIZIO 3");
        List<Product> boys = (prodotti.stream().filter(Product -> Product.getCategory()
                .equals("Boys"))).toList();
        System.out.println("Tutti i prodotti con categoria Boys: " + boys);
        boys.forEach(Product -> Product.setPrice(Product.getPrice() - (Product.getPrice() * 10) / 100));
        System.out.println("Tutti i prodotti con categoria Boys con 10% sconto applicato " + boys);
//

//        CUSTOMERS

        Supplier<Integer> randomTier = () -> {
            Random random = new Random();
            return random.nextInt(1, 5);

        };

        Supplier<Customer> customerSupplier = () -> new Customer("Customer", randomTier.get());
        List<Customer> customer = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            customer.add(customerSupplier.get());
        }
        System.out.println(customer);


//      ORDINI

        Supplier<LocalDate> randomOrderDate = () -> {
            Random random = new Random();
            Random random1 = new Random();
            Random random2 = new Random();

            return LocalDate.of(random.nextInt(2020, 2023), random1.nextInt(1, 11), random2.nextInt(1, 28));


        };
        Supplier<LocalDate> randomDeliveryDate = () -> {
            Random random = new Random();
            Random random1 = new Random();
            Random random2 = new Random();

            return LocalDate.of(random.nextInt(2020, 2023), random1.nextInt(1, 11), random2.nextInt(1, 28));


        };


        Supplier<Order> orderSupplier = () -> new Order("Consegnato", randomOrderDate.get(), randomDeliveryDate.get(), prodotti, customer.get(1));
        List<Order> order = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            order.add(orderSupplier.get());

        }
        System.out.println(order);

//        ESERCIZIO 2

        List<Order> baby = order.stream().filter(Order -> ).toList();
        System.out.println(baby);


    }


}