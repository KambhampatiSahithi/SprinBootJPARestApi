package com.example.SprinBootHello.controller;

import com.example.SprinBootHello.entity.Account;
import com.example.SprinBootHello.entity.Transaction;
import com.example.SprinBootHello.service.AccountService;
import com.example.SprinBootHello.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountController
{
    @Autowired
    private AccountService service;

    @Autowired
    private TransactionService trservice;

    @PostMapping("/addaccount")
    public Account addAccount(@RequestBody Account account)
    {
        account.setActype(account.getActype());
        double fee=0.0;
        if((account.getActype().equalsIgnoreCase("current"))){
            fee=fee+5.0;
        }
        account.setAccname(account.getAccname());
        account.setFee(fee);
        account.setAccnum(account.getAccnum());
        account.setDob(account.getDob());
        account.setBalance(account.getBalance());
        Date  date = new Date();
        account.setCreated(date);
        account.setUpdated(date);
        return service.saveAccount(account);
    }
    @PostMapping("/addaccounts")
    public List<Account> addAccounts(@RequestBody List<Account> accounts)
    {
        return service.saveAccounts(accounts);
    }

    @GetMapping("/accounts")
    public List<Account> findAllProducts()
    {
        return service.getAccounts();
    }
    @GetMapping("/account/{id}")
    public Account findProductById(@PathVariable int id)
    {
        return service.getAccountById(id);
    }

    @PutMapping("/updateAccount")
    public Account updateAccount(@RequestBody Account account)
    {
        return service.updateAccount(account);
    }



    //***********Transaction method
    @PostMapping("/createtransaction")
    public Transaction addTransaction(@RequestBody Transaction transaction)
    {
        return trservice.saveTransaction(transaction);
    }

    @GetMapping("/transactions")
    public List<Transaction> findAllTransactions() {return trservice.getTransactions();}
    @GetMapping("/transaction/{id}")
    public Transaction findTransactionByAccNum(@PathVariable long accnum)
    {
        return trservice.getTransactionByAccNum(accnum);
    }

    @PutMapping("/updateTransaction")
    public Transaction updateTransaction(@RequestBody Transaction transaction) {
        return trservice.updateTransaction(transaction);
    }

    @GetMapping("/stmt/{accnum}")
    public List<Transaction> getstatements(@PathVariable long accnum){
        return trservice.getstatement(accnum);
    }
}
