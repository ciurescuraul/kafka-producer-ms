package ro.cyberdev.products.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.cyberdev.products.service.ProductService;

@RestController
@RequestMapping("/products") // http://localhost:<port>/products
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRestModel product) {

        String productId = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}
