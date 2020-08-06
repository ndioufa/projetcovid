package com.fa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entities.CasConfirme;
@Repository
public interface ICasConfirme extends JpaRepository<CasConfirme, Integer>{

}
