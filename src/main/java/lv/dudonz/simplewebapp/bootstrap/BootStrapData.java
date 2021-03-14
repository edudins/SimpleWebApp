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
        System.out.println("Bootstrap started: ");

        // Initial Tests
        Customer leonardo = new Customer("Leonardo", "TMNT");
        Product swords = new Product("Ninja Sword", "1001010");
        leonardo.getProducts().add(swords);
        swords.getCustomers().add(leonardo);

        customerRepository.save(leonardo);
        productRepository.save(swords);

        Customer raphael = new Customer("Raphael", "TMNT");
        Product sai = new Product("Sai (Pair)", "2002020");
        raphael.getProducts().add(sai);
        sai.getCustomers().add(raphael);

        customerRepository.save(raphael);
        productRepository.save(sai);

        System.out.println("Number of Customers: " + customerRepository.count());
        System.out.println("Number of Products: " + productRepository.count());

        // Further Tests
        Store firstStore = new Store("Empire State Building",
                "W 34th St",
                "New York",
                "NY",
                "10001",
                "+1 212-736-3100",
                "info@esbnyc.com");
        storeRepository.save(firstStore);
        System.out.println("New store created: " + firstStore.toString());
        System.out.println("Store count: " + storeRepository.count());
    }
}
