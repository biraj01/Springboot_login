package com.biraj.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biraj.login.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
