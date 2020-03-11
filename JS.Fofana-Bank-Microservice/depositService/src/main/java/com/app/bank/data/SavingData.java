package com.app.bank.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.model.Saving;

@Repository
public interface SavingData extends JpaRepository<Saving, Integer> {

}
