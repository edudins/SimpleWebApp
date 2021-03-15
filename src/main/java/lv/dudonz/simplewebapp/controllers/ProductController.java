package lv.dudonz.simplewebapp.controllers;

import lv.dudonz.simplewebapp.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    // Injecting
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/products")
    public String getProducts(Model model) {
        // Get a list of products
        model.addAttribute("products", productRepository.findAll());

        return "products";
    }

}
