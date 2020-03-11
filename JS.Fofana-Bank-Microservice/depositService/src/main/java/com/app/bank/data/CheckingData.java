package com.app.bank.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.model.Checking;

@Repository
public interface CheckingData extends JpaRepository<Checking, Integer> {

}
