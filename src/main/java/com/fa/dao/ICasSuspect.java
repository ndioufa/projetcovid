package com.fa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entities.CasSuspect;
@Repository

public interface ICasSuspect extends JpaRepository<CasSuspect, Integer> {

}
