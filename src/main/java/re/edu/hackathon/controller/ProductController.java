package re.edu.hackathon.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.hackathon.dto.request.CreateProductDTO;
import re.edu.hackathon.dto.request.UpdateProductDTO;
import re.edu.hackathon.entity.Product;
import re.edu.hackathon.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<Product> getAll(@PathVariable Long id) {
        return productService.getAll(id);
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody CreateProductDTO createProductDTO) {
        return productService.addProduct(createProductDTO);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody UpdateProductDTO updateProductDTO, @PathVariable Long id) {
        return productService.updateProduct(updateProductDTO, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
