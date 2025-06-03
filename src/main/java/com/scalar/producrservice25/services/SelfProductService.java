package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Category;
import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.Repositories.CategoryRepository;
import com.scalar.producrservice25.Repositories.ProductRepository;
import com.scalar.producrservice25.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with given id -> " + id + " is not found");
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        Sort sort = Sort.by("price").descending().and(Sort.by("title").ascending());
        return productRepository.findAll(
//                PageRequest.of(pageNumber, pageSize, Sort.by("price").descending())
                PageRequest.of(pageNumber, pageSize, sort)
        );
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        //Before Saving the Product to DB, we should first check
        // -> If category is already present in the DB or not.
        //If present -> then good.
        //else -> we'll have to save the category first in the DB.
        Category category = product.getCategory();

        Optional<Category> optionalcategory = categoryRepository.findByName(category.getName());
        if(optionalcategory.isEmpty()){
            //save the category
            category = categoryRepository.save(category);

        }
        else{
            //If categoryName is present -> get the complete category (id,name,...)
            category = optionalcategory.get(); //getting the id of the category from Catagory (categories) table
        }

        product.setCategory(category); //setting the cat attributes ->along with the id of new category
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException{
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Hey Dude, Product with id -> " + id +" doesn't exist!");
        }
        Product productfromDB = optionalProduct.get();
        productfromDB.setTitle(product.getTitle());
        productfromDB.setDescription(product.getDescription());
        productfromDB.setPrice(product.getPrice());
        productfromDB.setImageUrl(product.getImageUrl());

        Category category = product.getCategory();
        Optional<Category> optionalcategory = categoryRepository.findByName(category.getName());
        if(optionalcategory.isEmpty()){
            //Save the category first in the DB
            category = categoryRepository.save(category);
        }
        else{
            category = optionalcategory.get();
        }
        productfromDB.setCategory(category);
        return productRepository.save(productfromDB);
    }

    @Override
    public void deleteProduct(Long id)  throws ProductNotFoundException{
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            //Product Not Found
            throw new ProductNotFoundException("Hey Dude, Product with id -> " + id +" doesn't exist!");
        }

        //if we need to return the product to be deleted
        //The return type of this method -> should be Product
        //Product prod = optionalProduct.get();
        productRepository.delete(optionalProduct.get());
        //return prod;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalproduct = productRepository.findById(id);
        if(optionalproduct.isEmpty()){
            throw new ProductNotFoundException("Hey Dude, Product with id -> " + id +
                    " doesn't exist!");
        }

        Product productfromDB = optionalproduct.get();
        //lets change/modify only the description.
        productfromDB.setDescription(product.getDescription());
        productfromDB.setPrice(product.getPrice());
        return productRepository.save(productfromDB);
    }
}
