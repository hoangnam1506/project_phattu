package com.example.jpaIntern.Controllers;

import com.example.jpaIntern.DTO.APIResponse;
import com.example.jpaIntern.Models.Product;
import com.example.jpaIntern.Models.Product_Types;
import com.example.jpaIntern.Repositories.IProductTypesRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ProductTypesController {
    @Autowired
    IProductTypesRepo productTypesRepo;
    @GetMapping(value = "productType/getAll")
    public APIResponse<Page<Product_Types>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                             @RequestParam(value = "size", defaultValue = "10") int size){
        Page<Product_Types> allProductType = productTypesRepo.findAll(PageRequest.of(page, size));
        return new APIResponse<>(allProductType.getNumberOfElements(), allProductType);
    }
    @DeleteMapping(value = "productType/Delete")
    public String deleteProdType(@RequestParam int productTypeId){
        productTypesRepo.findAll().forEach(x->{
            if (x.getProductTypeID() == productTypeId)
                productTypesRepo.delete(x);
        });
        return "thanh cong";
    }
    @PutMapping(value = "product/fixProductType")
    public String fixProductType(@RequestBody String productType){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Product_Types fixProductType = gson.fromJson(productType, Product_Types.class);
        Product_Types productTypes1 = productTypesRepo.findById(fixProductType.getProductTypeID()).get();
        productTypes1.setNameProductType(fixProductType.getNameProductType());
        productTypes1.setImageTypeProduct(fixProductType.getImageTypeProduct());
        productTypes1.setCreateAt(fixProductType.getCreateAt());
        productTypes1.setUpdateAt(fixProductType.getUpdateAt());
        productTypes1.setProducts(fixProductType.getProducts());
        productTypesRepo.save(productTypes1);
        return "thanh cong";
    }
}
