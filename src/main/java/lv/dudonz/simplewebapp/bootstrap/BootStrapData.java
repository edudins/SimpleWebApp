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

        for (int i=1; i<11; i++) {
            Product product = new Product("Product_" + i, "11111", "Lorem ipsum dolor sit amet", 900_00);
            productRepository.save(product);
        }

        System.out.println("Products in repository: " + productRepository.count());
    }
}
