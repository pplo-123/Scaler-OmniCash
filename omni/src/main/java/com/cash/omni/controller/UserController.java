package com.cash.omni.controller;


import com.cash.omni.controller.Services.UserServices;
import com.cash.omni.model.*;
import com.cash.omni.repository.UserRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PutMapping("/sign-up")
    public Customer saveUser(@RequestBody Customer customer){
        return userServices.saveUser(customer);
    }




    /* @PostMapping("/log-in")
    public Customer getUser(@RequestBody Customer customer){

    }





    @GetMapping("/get-outlets")
    public List<Outlet> getNearestOutlets(){

        return userServices.getNearestOutlets();


    }

    @PutMapping("edit-profile/{id}")
    public Customer editProfile(@PathVariable(name = "id") long id){

    }

     */


    @PostMapping("save-feedback")

    public Feedback saveFeedback( @RequestBody Feedback feedback){

        return userServices.saveFeedback(feedback);


    }

    @GetMapping("get-outlets")
    public String getNearestOutlets() throws IOException {

        URL response = new URL("https://api.ipdata.co/?api-key=28616745af5276150c5aa4ffe496d9f4f9126bbbe0cfe276bf40951a");

        URLConnection conn = response.openConnection();

        InputStream stream = conn.getInputStream();







    }




    @GetMapping("get_transaction-history/{id}")

    public List<Transaction> getTransactionHistory(@PathVariable long id) throws Throwable {

        return userServices.getTransactionHistory(id);

    }

    @PutMapping("edit-user-profile")
    public Customer updateUserProfile(Customer customer){
        return userServices.editProfile(customer);
    }








}
