package com.jbariel.example.jpaswapping.respository;

import java.util.UUID;

import com.jbariel.example.jpaswapping.model.Hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, UUID> {

}