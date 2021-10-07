package com.example.SprinBootHello.service;

import com.example.SprinBootHello.entity.Account;
import com.example.SprinBootHello.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService
{
    @Autowired
    private AccountRepository repository;

    //Post for send data to server
    public Account saveAccount(Account account)
    {
        return repository.save(account);
    }
    public List<Account> saveAccounts(List<Account> accounts)
    {
        return repository.saveAll(accounts);
    }

    //Get for getting data
    public List<Account> getAccounts()
    {
        return repository.findAll();
    }
    public Account getAccountById(int id)
    {
        return repository.findById(id).orElse(null);
    }

    //PUT for update
    public Account updateAccount(Account account)
    {
        Account existProd = repository.findById(account.getId()).orElse(null);
        existProd.setAccnum(account.getAccnum());
        existProd.setAccname(account.getAccname());
        existProd.setBalance(account.getBalance());
        existProd.setDob(account.getDob());
        existProd.setActype(account.getActype());
        existProd.setFee(account.getFee());
        return repository.save(existProd);
    }
}
