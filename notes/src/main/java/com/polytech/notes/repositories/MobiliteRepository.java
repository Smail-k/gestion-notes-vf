package com.polytech.notes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polytech.notes.models.Mobilite;
import com.polytech.notes.models.User;

@Repository
public interface MobiliteRepository extends JpaRepository<Mobilite, Long>{
}