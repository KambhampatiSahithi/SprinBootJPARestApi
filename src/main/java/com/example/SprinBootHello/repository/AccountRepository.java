package com.example.SprinBootHello.repository;

import com.example.SprinBootHello.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;

public interface AccountRepository extends JpaRepository<Account, Integer>
{
    @Query(value = "select * from account where accnum=?1",nativeQuery = true)
    Account getDataByAccnum(long accnum);
}
