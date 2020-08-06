package com.fa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entities.Cas;
@Repository
public interface ICas extends JpaRepository<Cas, Integer> {

}