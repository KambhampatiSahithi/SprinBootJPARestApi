package com.example.SprinBootHello.service;

import com.example.SprinBootHello.entity.Account;
import com.example.SprinBootHello.entity.Transaction;
import com.example.SprinBootHello.repository.AccountRepository;
import com.example.SprinBootHello.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionService
{
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AccountRepository accrepository;

    //Post for send data to transaction and update account balance
    public Transaction saveTransaction(Transaction transaction)
    {
        transaction.setAccnum(transaction.getAccnum());
        transaction.setAmount(transaction.getAmount());
        transaction.setTrtype(transaction.getTrtype());
        Account acc = accrepository.getDataByAccnum(transaction.getAccnum());
        if(Objects.equals(transaction.getTrtype(),"deposit")){
            acc.setBalance((int) (acc.getBalance()+transaction.getAmount()));
            transaction.setStatus("Success");
        }
        else if(Objects.equals(transaction.getTrtype(),"withdraw")){
            if(acc.getBalance()>transaction.getAmount()) {
                acc.setBalance((int) (acc.getBalance() - transaction.getAmount()));
                transaction.setStatus("Success");
            }
            else{
                transaction.setStatus("Failure");
            }
        }
        else{
            transaction.setStatus("Failure");
        }
        Date  date = new Date();
        transaction.setTrdate(date);
        transaction.setCreated(date);
        transaction.setUpdated(date);
        return repository.save(transaction);
    }


    //Get for getting data from transaction
    public List<Transaction> getTransactions()
    {
        return repository.findAll();
    }
    public Transaction getTransactionByAccNum(long accnum)
    {
        return repository.findByAccnum(accnum);
    }

    //PUT for update transaction
    public Transaction updateTransaction(Transaction transaction)
    {
        Transaction existProd = repository.findByAccnum(transaction.getAccnum());
        existProd.setStatus(transaction.getStatus());
        return repository.save(existProd);
    }

    //get transactions done on account based on account number from creation of account
    public List<Transaction> getstatement(long accnum) {
        Date to = new Date();
        Account a =accrepository.getDataByAccnum(accnum);
        Date from = a.getCreated();
       return repository.transactionByAccnum(accnum,from,to);
    }
}
