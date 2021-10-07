package com.example.SprinBootHello.repository;

import com.example.SprinBootHello.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findByAccnum(long accnum);

    @Query(value = "select t from Transaction t where t.accnum=?1 and t.trdate between ?2 and ?3")
    List<Transaction> transactionByAccnum(long accnum, Date from, Date to);

}
