package com.scalar.producrservice25.Controllers;

import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.exceptions.ProductNotFoundException;
import com.scalar.producrservice25.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(@Qualifier("selfproductservice") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productService.getSingleProduct(id);

        return new ResponseEntity<>(
                product,
                HttpStatus.OK //.FOUND//.NOT_FOUND //.ACCEPTED
        );

//        ResponseEntity<Product> responseEntity = null;
//        try{
//            Product product = productService.getSingleProduct(id);
//            responseEntity = new  ResponseEntity<>(
//                    product,
//                    HttpStatus.OK
//            );
//        }
//        catch(ProductNotFoundException e){
//            System.out.println(e.getMessage());
//            responseEntity = new  ResponseEntity<>(
//                    null,
//                    HttpStatus.BAD_REQUEST//.NOT_FOUND
//            );
//        }
//        return responseEntity;
//        throw new RuntimeException("Something went Wrong!!");
    }

    @GetMapping("")
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
        return productService.getAllProducts(pageNumber, pageSize);
    }
    // the url in postman looks like this -> localhost:8484/products?pageNumber=0&pageSize=2
    //Here ? -> is Query Parameter.

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product)
            throws ProductNotFoundException {
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        productService.deleteProduct(id);

        //to get the output as product -> deleted product
        //output type of this method should be Product
        //return productService.deleteProduct(id);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException pe){
        return new ResponseEntity<>(
                pe.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
}
