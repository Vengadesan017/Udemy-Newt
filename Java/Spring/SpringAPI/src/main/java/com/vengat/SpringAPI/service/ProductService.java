package com.vengat.SpringAPI.service;

import com.vengat.SpringAPI.model.Product;
import com.vengat.SpringAPI.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo pr;

    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    public Product getProductById(int id) {
        return pr.findById(id).orElse(new Product(-1));
    }
    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
//        product.setId(7);
//        System.out.println("===Serveice===>>"+product);
        System.out.println("===Serveice===>>");
        return pr.save(product);
    }


    public void deleteProduct(int id) {
        pr.deleteById(id);
    }


    public List<Product> searchProducts(String keyword) {
        return pr.searchProducts(keyword);
    }
}
