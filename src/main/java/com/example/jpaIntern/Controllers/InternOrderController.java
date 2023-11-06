package com.example.jpaIntern.Controllers;

import com.example.jpaIntern.DTO.APIResponse;
import com.example.jpaIntern.Models.InternOrder;
import com.example.jpaIntern.Models.Product;
import com.example.jpaIntern.Models.Product_Reviews;
import com.example.jpaIntern.Repositories.IInternOrderRepo;
import com.example.jpaIntern.Repositories.IOrderDetailRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class InternOrderController {
    @Autowired
    IInternOrderRepo internOrderRepo;
    @Autowired
    IOrderDetailRepo orderDetailRepo;
    @GetMapping(value = "order/getAll")
    public APIResponse<Page<InternOrder>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") Integer size){
        Page<InternOrder> allOrder = internOrderRepo.findAll(PageRequest.of(page, size));
        return new APIResponse<>(allOrder.getNumberOfElements(), allOrder);
    }
    @GetMapping(value = "order/getAllByFullName")
    public Page<InternOrder> getAllByFullName(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                                    @RequestParam String fullName){
        return internOrderRepo.findAllByFullName(fullName,PageRequest.of(page, size));
    }
    @PutMapping(value = "order/addNew")
    public String addNewOrder(@RequestBody String order){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        InternOrder newOrder = gson.fromJson(order, InternOrder.class);
        internOrderRepo.save(newOrder);
        return "thanh cong";
    }
    @PutMapping(value = "order/fixOrder")
    public String fixOrder(@RequestBody String order){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        InternOrder newOrder = gson.fromJson(order, InternOrder.class);
        InternOrder order1 = internOrderRepo.findById(newOrder.getOrderID()).get();
        order1.setOriginalPrice(newOrder.getOriginalPrice());
        order1.setActualPrice(newOrder.getActualPrice());
        order1.setFullName(newOrder.getFullName());
        order1.setEmail(newOrder.getEmail());
        order1.setPhone(newOrder.getPhone());
        order1.setAddress(newOrder.getAddress());
        order1.setCreateAt(newOrder.getCreateAt());
        order1.setUpdateAt(newOrder.getUpdateAt());
        internOrderRepo.save(order1);
        return "thanh cong";
    }
    @DeleteMapping(value = "order/deleteOrder")
    public String delOrder(@RequestParam int orderID){
        internOrderRepo.findAll().forEach(x->{
            if(x.getOrderID() == orderID){{
                orderDetailRepo.findAll().forEach(y->{
                    if(y.getOrders().getOrderID() == orderID) orderDetailRepo.delete(y);
                });
                internOrderRepo.delete(x);
            }}
        });
        return "Thanh cong";
    }

}
