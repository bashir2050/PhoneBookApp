package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

}
