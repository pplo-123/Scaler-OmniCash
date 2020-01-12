package com.cash.omni.controller;



import com.cash.omni.model.*;
import com.cash.omni.repository.*;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


import java.net.URI;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private OutletOwnerRepository outletOwnerRepository;



    @Autowired
    private UserRepository userRepository;

    private Customer customer;

    @Autowired
    private OutletRepository outletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PutMapping("/sign-up")
    public Customer saveUser(@RequestBody Customer customer){
        return userRepository.save(customer);
    }

    int amt;
    Outlet outlet;


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
    @GetMapping("get-all-outlets")
    public List<Outlet> getAllOutlets(){
        return outletRepository.findAll();
    }

    @GetMapping("select-outlet/{id}")
    public Outlet selectOutlet(@PathVariable long id){
        return outletRepository.findById(id).orElseThrow();
    }


    @PostMapping("save-feedback")
    public Feedback saveFeedback( @RequestBody Feedback feedback){

        return feedbackRepository.save(feedback);


    }

    /*@GetMapping("get-outlets")
    public void getNearestOutlets() throws IOException, UnirestException, InterruptedException {



        String api = "https://api.ipdata.co/?api-key=28616745af5276150c5aa4ffe496d9f4f9126bbbe0cfe276bf40951a";

        HttpResponse<JsonNode> response = (HttpResponse<JsonNode>) Unirest.get(api).asJson();

        System.out.println(response);

    }

     */


    @GetMapping("get-transaction-history/{id}")

    public List<Transaction> getTransactionHistory(@PathVariable long id) throws Throwable {

        //Customer customer = userRepository.findById(id).orElseThrow();

        return transactionRepository.findAllByCustomerId(id);
    }


    @GetMapping("get-customer/{id}")
    public Customer getCustomer(@PathVariable long id){
        return userRepository.findById(id).orElseThrow();
    }

    @PutMapping("edit-user-profile")
    public Customer updateUserProfile(@RequestBody Customer customer){
        Customer oldCustomer = userRepository.findById(customer.getId()).orElseThrow();

        oldCustomer.setName(customer.getName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPassword(customer.getPassword());
        oldCustomer.setPhoneNumber(customer.getPhoneNumber());

        return userRepository.save(oldCustomer);

    }

    @PutMapping("create-transaction") // id = outlet_id
    public Transaction createTransaction(@RequestBody Transaction transaction)
    {
        amt = transaction.getAmount();
        outlet = transaction.getOutlet();
        outlet.setAvailableCash(outlet.getAvailableCash() - amt);
        outletRepository.save(outlet);
        customer = transaction.getCustomer();
        customer.setCashAvailable(customer.getCashAvailable() - amt);
        userRepository.save(customer);

        return transactionRepository.save(transaction);
    }







}