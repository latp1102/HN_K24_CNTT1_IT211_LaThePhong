package re.edu.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import re.edu.hackathon.dto.request.CreateProductDTO;
import re.edu.hackathon.dto.request.UpdateProductDTO;
import re.edu.hackathon.entity.Product;
import re.edu.hackathon.exception.NotFoundException;
import re.edu.hackathon.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public ResponseEntity<?> getAll(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return ResponseEntity.ok(product);

    }
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("sản phẩm không tồn tại"));
    }
    public ResponseEntity<?> addProduct(CreateProductDTO createProductDTO) {
        Product product = Product.builder()
                .code(createProductDTO.getCode())
                .name(createProductDTO.getName())
                .sku(createProductDTO.getSku())
                .description(createProductDTO.getDescription())
                .stockQuantity(createProductDTO.getStockQuantity())
                .price(createProductDTO.getPrice())
                .category(createProductDTO.getCategory())
                .weight(createProductDTO.getWeight())
                .build();
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateProduct(UpdateProductDTO updateProductDTO, Long id){
        Product product = findById(id);
        product.setCode(updateProductDTO.getCode());
        product.setName(updateProductDTO.getName());
        product.setSku(updateProductDTO.getSku());
        product.setDescription(updateProductDTO.getDescription());
        product.setStockQuantity(updateProductDTO.getStockQuantity());
        product.setPrice(updateProductDTO.getPrice());
        product.setCategory(updateProductDTO.getCategory());
        product.setWeight(updateProductDTO.getWeight());
        product.setStatus(updateProductDTO.getStatus());
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }
    public ResponseEntity<?> updateProductById(Long id, UpdateProductDTO updateProductDTO){
        Product product = findById(id);
        if(updateProductDTO.getName() != null){
            updateProductDTO.setName(updateProductDTO.getName());
        }
        if(updateProductDTO.getCode() != null){
            updateProductDTO.setCode(updateProductDTO.getCode());
        }
        if(updateProductDTO.getCategory() != null){
            updateProductDTO.setCategory(updateProductDTO.getCategory());
        }
        if(updateProductDTO.getDescription() != null){
            updateProductDTO.setDescription(updateProductDTO.getDescription());
        }
        if(updateProductDTO.getSku() != null){
            updateProductDTO.setSku(updateProductDTO.getSku());
        }
        if(updateProductDTO.getPrice() != null){
            updateProductDTO.setPrice(updateProductDTO.getPrice());
        }
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }
    public ResponseEntity<?> deleteProduct(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
