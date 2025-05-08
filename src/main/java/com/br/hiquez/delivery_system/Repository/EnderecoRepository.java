package com.br.hiquez.delivery_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.hiquez.delivery_system.Entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
    
}
