package com.zensar.aa_pmo.repository;

import org.springframework.data.repository.CrudRepository;

import com.zensar.aa_pmo.model.Employee;

public interface RestRepository extends CrudRepository<Employee, Integer> {

}
