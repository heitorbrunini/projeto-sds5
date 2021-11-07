package com.b9dev.projetoSDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b9dev.projetoSDS.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
}
