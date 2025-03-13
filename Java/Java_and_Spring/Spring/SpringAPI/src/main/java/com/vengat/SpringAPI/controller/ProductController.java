package com.vengat.SpringAPI.controller;

import com.vengat.SpringAPI.model.Product;
import com.vengat.SpringAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("/")
public class ProductController {

    @Autowired
    private ProductService ps;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        System.out.println("jgdfjjdf");
        return new ResponseEntity<>(ps.getAllProducts(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = ps.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/product/{productId}/image")
//    public ResponseEntity<byte[]> getProductImage(@PathVariable int productId) {
//        Product product = ps.getProductById(productId);
//        if (product.getId() > 0) {
//            return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product savedProduct = null;
        System.out.println("haiiiii");
        try {
            System.out.println("===COntrollerrr===>"+product);
            savedProduct = ps.addOrUpdateProduct(product, imageFile);
            System.out.println("===COntroller===>"+savedProduct);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product updatedProduct = null;
        try {
//            System.out.println("===COntrollerrr===>"+product);
            updatedProduct = ps.addOrUpdateProduct(product, imageFile);
//            System.out.println("===COntroller===>"+updatedProduct);
            System.out.println("===COntroller===>");
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = ps.getProductById(id);
        if (product != null) {
            ps.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = ps.searchProducts(keyword);
        System.out.println("searching with :" + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
