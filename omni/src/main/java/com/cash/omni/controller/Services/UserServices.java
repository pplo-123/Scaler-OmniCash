package com.cash.omni.controller.Services;




import com.cash.omni.exceptions.UserNotExistException;
import com.cash.omni.model.*;
import com.cash.omni.repository.FeedbackRepository;
import com.cash.omni.repository.TransactionRepository;
import com.cash.omni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    private Object NullPointerException;

    public Customer saveUser(@RequestBody Customer user) {

        return userRepository.save(user);

    }

    /*public  Customer loginUser(@Valid @RequestBody Customer customer){
        //login for user validation



    }

    public List<Outlet> getNearestOutlets(){
        //logic to get nearest outlets;
    }

    public Customer editProfile(@PathVariable(name = "id") long id){

        Optional<Customer> customer = userRepository.findById(id);

        if (customer!=null){

            //

        }

    }

     */

    public Feedback saveFeedback(@RequestBody Feedback feedback) {


        return feedbackRepository.save(feedback);
    }

    public List<Transaction> getTransactionHistory(@PathVariable long id) throws Throwable {

        Optional<Customer> customer = userRepository.findById(id);

        if (customer!=null){
            return transactionRepository.findByCustomer(customer);
        }
        else{
            throw (Throwable) NullPointerException;
        }


    }

    public Customer editProfile(@Valid @RequestBody Customer customer){
        return userRepository.save(customer);
    }


}
