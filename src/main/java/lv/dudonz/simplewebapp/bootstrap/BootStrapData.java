package lv.dudonz.simplewebapp.bootstrap;

import lv.dudonz.simplewebapp.domain.Customer;
import lv.dudonz.simplewebapp.domain.Product;
import lv.dudonz.simplewebapp.repositories.CustomerRepository;
import lv.dudonz.simplewebapp.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public BootStrapData(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
    }
}
