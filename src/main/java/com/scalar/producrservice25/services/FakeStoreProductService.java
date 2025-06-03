package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Category;
import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.dtos.FakeStoreProductDto;
import com.scalar.producrservice25.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreproductservice")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    //To convert FakeStoreProductDto to Product
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category cat = new Category();
        cat.setName(fakeStoreProductDto.getCategory());
        product.setCategory(cat);

        //way2
//        product.setCategory(new Category());
//        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {

        //First check in the Redis (Cache) -> If the Product with given id is present or not.
//        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_"+id);
//        //cache HIT -> Found product info int the cache
//        if(product != null) {
//            return product;
//        }

        //Cache MISS -> The product info with given order=_id is not there in cache
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id: " + id + " doesn't exist!");
        }

        Product product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

        //Now store this product in cache before returning to FE(Client)
//        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_"+id, product);
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return new PageImpl<>(products);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }
}
