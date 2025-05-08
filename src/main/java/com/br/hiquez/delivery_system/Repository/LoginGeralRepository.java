package com.br.hiquez.delivery_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.br.hiquez.delivery_system.Entity.LoginGeral;

@Repository
public interface LoginGeralRepository extends JpaRepository<LoginGeral,Long>{

    UserDetails findByEmail(String username);
    
}
