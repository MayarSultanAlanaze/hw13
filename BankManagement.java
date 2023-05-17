package com.example.demo.BankMangement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("api/v1/Bank")
public class BankManagement {

    public ArrayList<Bank> Banks = new ArrayList<>();


    @GetMapping("/create")
    public ArrayList<Bank> create() {
        return Banks;
    }

    @PostMapping("/add")
    public String addBank(@RequestBody Bank bank) {
        Banks.add(bank);
        return "bank add";
    }

    @PutMapping("/update/{index}")
    public String updateBank(@PathVariable int index, @RequestBody Bank bank) {
        Banks.set(index, bank);
        return "Bank update";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteBank(@PathVariable int index) {
        Banks.remove(index);
        return "bank delete";
    }


    @PutMapping("/deposite/{index}")
    public String deposit(@PathVariable int index, @RequestBody int amount) {

        Bank bank1 = Banks.get(index);
        bank1.setBalance(bank1.getBalance() + amount);
        Banks.set(index, bank1);
        return "banke balance";
    }

    @PutMapping("/withdram/{Balance}")
    public String withdrem(@PathVariable int balance, @RequestBody Bank bank, int amount) {
        if (amount > balance) {
            Bank bank2 = Banks.get(balance);
            bank2.setBalance(bank2.getBalance() - amount);
            Banks.set(balance, bank2);}
            return "banke balance";

        }
        }



