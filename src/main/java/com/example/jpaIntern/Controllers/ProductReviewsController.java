package com.example.jpaIntern.Controllers;

import com.example.jpaIntern.DTO.APIResponse;
import com.example.jpaIntern.Models.Product;
import com.example.jpaIntern.Models.Product_Reviews;
import com.example.jpaIntern.Models.Product_Types;
import com.example.jpaIntern.Repositories.IProductReviewsRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ProductReviewsController {
    @Autowired
    IProductReviewsRepo productReviewsRepo;
    @GetMapping(value = "productReviews/getAll")
    public APIResponse<Page<Product_Reviews>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                   @RequestParam(value = "size", defaultValue = "10") Integer size){
        Page<Product_Reviews> allProductReviews = productReviewsRepo.findAll(PageRequest.of(page, size));
        return new APIResponse<>(allProductReviews.getNumberOfElements(), allProductReviews);
    }
    @PostMapping(value = "productReviews/addNew")
    public String addNewProductReviews(@RequestBody String productReview){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Product_Reviews newProdReviews = gson.fromJson(productReview, Product_Reviews.class);
        productReviewsRepo.save(newProdReviews);
        return "thanh cong";
    }
    @PutMapping(value = "productReviews/fixProductReviews")
    public String fixProductReviews(@RequestBody String productReview){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Product_Reviews newProdReviews = gson.fromJson(productReview, Product_Reviews.class);
        Product_Reviews productReviews = productReviewsRepo.findById(newProdReviews.getProductReviewID()).get();
        productReviews.setContentRated(newProdReviews.getContentRated());
        productReviews.setPointEvaluation(newProdReviews.getPointEvaluation());
        productReviews.setContentSeen(newProdReviews.getContentSeen());
        productReviews.setStatus(newProdReviews.getStatus());
        productReviews.setCreateAt(newProdReviews.getCreateAt());
        productReviews.setUpdateAt(newProdReviews.getUpdateAt());
        productReviewsRepo.save(productReviews);
        return "thanh cong";
    }
    @DeleteMapping(value = "productReviews/deleteProductReviews")
    public String delProductReviews(@RequestParam int productReviewsID){
        productReviewsRepo.deleteById(productReviewsID);
        return "Thanh cong";
    }
}
