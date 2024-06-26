package com.JBDL.RestDemoLibrary.repository;

import com.JBDL.RestDemoLibrary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
