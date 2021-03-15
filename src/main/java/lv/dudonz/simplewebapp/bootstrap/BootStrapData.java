package lv.dudonz.simplewebapp.bootstrap;

import lv.dudonz.simplewebapp.domain.Customer;
import lv.dudonz.simplewebapp.domain.Product;
import lv.dudonz.simplewebapp.domain.Store;
import lv.dudonz.simplewebapp.repositories.CustomerRepository;
import lv.dudonz.simplewebapp.repositories.ProductRepository;
import lv.dudonz.simplewebapp.repositories.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public BootStrapData(CustomerRepository customerRepository, ProductRepository productRepository, StoreRepository storeRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap started... ");

        // Create the Store
        Store firstStore = new Store("Empire State Building",
                "W 34th St",
                "New York",
                "NY",
                "10001",
                "+1 212-736-3100",
                "info@esbnyc.com");
        storeRepository.save(firstStore);

        // Print for testing
        System.out.println("New store created: " + firstStore.toString());
        System.out.println("Store count: " + storeRepository.count());

        // Create Products
        Product swords = new Product("Ninja Sword", "1001010");
        Product sai = new Product("Sai (Pair)", "2002020");
        productRepository.save(swords);
        productRepository.save(sai);

        // Place both Products in Store
        swords.setStore(firstStore);
        firstStore.getProducts().add(swords);
        sai.setStore(firstStore);
        firstStore.getProducts().add(sai);

        storeRepository.save(firstStore);

        // Create Customers
        Customer leonardo = new Customer("Leonardo", "TMNT");
        Customer raphael = new Customer("Raphael", "TMNT");

        leonardo.getProducts().add(swords);
        swords.getCustomers().add(leonardo);

        raphael.getProducts().add(sai);
        sai.getCustomers().add(raphael);

        customerRepository.save(leonardo);
        customerRepository.save(raphael);

        System.out.println("Number of Customers: " + customerRepository.count());
        System.out.println("Number of Products: " + productRepository.count());

        System.out.println("Store number of products " + firstStore.getProducts().size());
    }
}
