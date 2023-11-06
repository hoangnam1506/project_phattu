package com.example.jpaIntern.Controllers;

import com.example.jpaIntern.DTO.APIResponse;
import com.example.jpaIntern.Models.Product;
import com.example.jpaIntern.Repositories.*;
import com.example.jpaIntern.ResData.ResListData;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

@RestController
public class ProductController {
    @Autowired
    IProductRepo productRepo;
    @Autowired
    IProductImagesRepo productImagesRepo;
    @Autowired
    IOrderDetailRepo orderDetailRepo;
    @Autowired
    IProductReviewsRepo productReviewsRepo;
    @Autowired
    ICartsItemsRepo cartsItemsRepo;
    @GetMapping(value = "product/getAll")
    public APIResponse<Page<Product>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                             @RequestParam(value = "size", defaultValue = "10") Integer size){
        Page<Product> allProduct = productRepo.findAll(PageRequest.of(page, size));
        return new APIResponse<>(allProduct.getNumberOfElements(), allProduct);
    }
    @GetMapping(value = "product/findByNameProduct")
    public APIResponse<Page<Product>> findByNameProduct(@RequestParam(value = "page", defaultValue = "0") int page,
                                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                          @RequestParam String nameProduct){
        Page<Product> allProduct = productRepo.findByNameProduct(nameProduct, PageRequest.of(page, size));
        return new APIResponse<>(allProduct.getNumberOfElements(), allProduct);
    }
    @GetMapping(value = "product/findByTitle")
    public APIResponse<Page<Product>> findByTitle(@RequestParam(value = "page", defaultValue = "0") int page,
                                                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                          @RequestParam String title){
        Page<Product> allProduct = productRepo.findByNameProduct(title, PageRequest.of(page, size));
        return new APIResponse<>(allProduct.getNumberOfElements(), allProduct);
    }
    @PostMapping(value = "product/addNew")
    public String addNewProduct(@RequestBody String product) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Product newProduct = gson.fromJson(product, Product.class);
        productRepo.save(newProduct);
        return "thanh cong";
    }
    @PutMapping(value = "product/fixProduct")
    public String fixProduct(@RequestBody String product){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Product fixProduct = gson.fromJson(product, Product.class);
        Product product1 = productRepo.findById(fixProduct.getProductID()).get();
        product1.setNameProduct(fixProduct.getNameProduct());
        product1.setPrice(fixProduct.getPrice());
        product1.setAIProduct(fixProduct.getAIProduct());
        product1.setTitle(fixProduct.getTitle());
        product1.setDiscount(fixProduct.getDiscount());
        product1.setStatus(fixProduct.getStatus());
        product1.setNumOfViews(fixProduct.getNumOfViews());
        product1.setCreateAt(fixProduct.getCreateAt());
        product1.setUpdateAt(fixProduct.getUpdateAt());
        product1.setProductTypes(fixProduct.getProductTypes());
        productRepo.save(product1);
        return "thanh cong";
    }
    @GetMapping(value = "product/NumOfViews")
    public List<String> NumOfViews(){
        List<String> lst = new ArrayList<>();
        productRepo.findAll().forEach(x->{
            lst.add(x.getNameProduct() +" : "+ String.valueOf(x.getNumOfViews()));
        });
        return lst;
    }
    @DeleteMapping(value = "product/deleteProduct")
    public String delProduct(@RequestParam int productID){
        productRepo.findAll().forEach(y->{
            if(y.getProductID() == productID){
                productImagesRepo.findAll().forEach(x->{
                    if(x.getProduct().getProductID() == productID)
                        productImagesRepo.delete(x);
                });
                orderDetailRepo.findAll().forEach(x->{
                    if(x.getProduct().getProductID() == productID)
                        orderDetailRepo.delete(x);
                });
                productReviewsRepo.findAll().forEach(x->{
                    if(x.getProduct().getProductID() == productID)
                        productReviewsRepo.delete(x);
                });
                cartsItemsRepo.findAll().forEach(x->{
                    if(x.getProduct().getProductID() == productID)
                        cartsItemsRepo.delete(x);
                });
                productRepo.delete(y);
            }});
        return "Thanh cong";
    }
}
