package com.example.jpaIntern.Controllers;

import com.example.jpaIntern.DTO.APIResponse;
import com.example.jpaIntern.Models.InternOrder;
import com.example.jpaIntern.Models.Product;
import com.example.jpaIntern.Models.User;
import com.example.jpaIntern.Repositories.IUserRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    IUserRepo userRepo;
    @GetMapping(value = "user/getAll")
    public APIResponse<Page<User>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size){
        Page<User> allUser = userRepo.findAll(PageRequest.of(page, size));
        return new APIResponse<>(allUser.getNumberOfElements(), allUser);
    }
    @PostMapping(value = "user/addNewUser")
    public String addNewUser(@RequestBody String user){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        User newUser = gson.fromJson(user, User.class);
        userRepo.save(newUser);
        return "thanh cong";
    }
    @PutMapping(value = "user/fixUser")
    public String fixUser(@RequestBody String user){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        User newUser = gson.fromJson(user, User.class);
        User user1 = userRepo.findById(newUser.getUserID()).get();
        user1.setUserName(newUser.getUserName());
        user1.setPhone(newUser.getPhone());
        user1.setEmail(newUser.getEmail());
        user1.setAddress(newUser.getAddress());
        user1.setCreateAt(newUser.getCreateAt());
        user1.setUpdateAt(newUser.getUpdateAt());
        userRepo.save(user1);
        return "thanh cong";
    }
    @DeleteMapping(value = "user/deleteUser")
    public String delUser(@RequestParam int userID){
        userRepo.deleteById(userID);
        return "Thanh cong";
    }
}
