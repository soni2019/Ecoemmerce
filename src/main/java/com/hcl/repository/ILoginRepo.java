package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.entity.Login;


@Repository
public interface ILoginRepo extends JpaRepository<Login, Long>{

	public Login findByUserName(String userName);
}
