package com.cash.omni.controller.Services;

import com.cash.omni.model.Feedback;
import com.cash.omni.model.Outlet;
import com.cash.omni.model.OutletOwner;
import com.cash.omni.model.Transaction;
import com.cash.omni.repository.OutletOwnerRepository;
import com.cash.omni.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class OutletOwnerService
{
    @Autowired
    List<Outlet> outletList;
    List<Transaction> transactionList;
    Outlet outlet;
    OutletOwner outletOwner;
    OutletOwnerRepository outletOwnerRepository;
    OutletRepository outletRepository;

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
        return outletOwnerRepository.save(outletOwner);
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
        outletRepository.findFeedbacks(outletId);
    }
}
