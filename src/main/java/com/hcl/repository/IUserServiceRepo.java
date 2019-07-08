package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Registration;

@Repository
public interface IUserServiceRepo  extends JpaRepository<Registration, Long>{

}
