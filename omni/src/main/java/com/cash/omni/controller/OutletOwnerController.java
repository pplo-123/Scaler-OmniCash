package com.cash.omni.controller;

import com.cash.omni.model.*;
import com.cash.omni.repository.OutletOwnerRepository;
import com.cash.omni.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/outlet_owner")
public class OutletOwnerController
{

    List<Outlet> outletList;

    List<Transaction> transactionList;


    Outlet outlet;


    OutletOwner outletOwner;

    @Autowired
    OutletOwnerRepository outletOwnerRepository;

    @Autowired
    OutletRepository outletRepository;


    @PutMapping("/sign-up")
    public OutletOwner saveOutletOwner(@RequestBody  OutletOwner outletOwner){
        return outletOwnerRepository.save(outletOwner);
    }
    @PostMapping("/add_outlet")
    public Outlet addOutlet(@Valid @RequestBody Outlet outlet)
    {
        return outletRepository.save(outlet);
    }

    @GetMapping("/selectOutlets/{owner_id}")
    public List<Outlet> selectOutlets(@PathVariable(value = "owner_id") Long ownerId)
    {
        return outletOwnerRepository.findById(ownerId).orElseThrow().getOutletList();
    }

    @GetMapping("/selectOutlets/checkBalance/{outlet_id}")
    public int checkBalance(@PathVariable(value = "outlet_id") Long outletId)
    {
        outlet = outletRepository.findById(outletId).orElseThrow();

        return outlet.getAvailableCash();
    }

    @PostMapping("/selectOutlets/check")
    public Outlet editOutlet(@Valid @RequestBody Outlet outlet)
    {
        return outletRepository.save(outlet);
    }

    @GetMapping("/profileInfo/owner_id")
    public OutletOwner getProfileInfo(@PathVariable(value = "owner_id") Long ownerId)
    {
        return outletOwnerRepository.findById(ownerId).orElseThrow();
    }

    @PostMapping("/editProfile")
    public OutletOwner editProfileInfo(@RequestBody OutletOwner outletOwner)
    {
        OutletOwner oldOutletOwner = outletOwnerRepository.findById(outletOwner.getId()).orElseThrow();

        oldOutletOwner.setName(outletOwner.getName());
        oldOutletOwner.setEmail(outletOwner.getEmail());
        oldOutletOwner.setPassword(outletOwner.getPassword());
        oldOutletOwner.setPhoneNumber(outletOwner.getPhoneNumber());

        return outletOwnerRepository.save(oldOutletOwner);
    }

    @GetMapping("/getTransactions/{owner_id}")
    public List<Transaction> getTransactions(@PathVariable(value = "owner_id") Long ownerId)
    {
        return outletOwnerRepository.findTransactionByOutletOwner(ownerId);
    }

    @GetMapping("/addCash/{outlet_id}")
    public Outlet addCash(@PathVariable(value = "outlet_id") Long outletId, int add)
    {
        outlet = outletRepository.findById(outletId).orElseThrow();
        outlet.setAvailableCash(outlet.getAvailableCash() + add);

        return outlet;
    }

    @GetMapping("/check_reviews/{outlet_id}")
    public List<Feedback> getReviews(@PathVariable(value = "outlet_id") Long outletId)
    {
        return outletRepository.findFeedbacks(outletId);
    }
}