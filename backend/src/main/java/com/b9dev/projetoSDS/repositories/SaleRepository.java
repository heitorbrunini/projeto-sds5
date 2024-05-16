package com.b9dev.projetoSDS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.b9dev.projetoSDS.dto.SaleSuccessSumDTO;
import com.b9dev.projetoSDS.dto.SaleSumDTO;
import com.b9dev.projetoSDS.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query ("SELECT new com.b9dev.projetoSDS.dto.SaleSumDTO (obj.seller, SUM (obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGruoupedBySeller();
	
	@Query ("SELECT new com.b9dev.projetoSDS.dto.SaleSuccessSumDTO (obj.seller, SUM (obj.visited), SUM (obj.deals))"
			+" FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessSumDTO> SuccessGruoupedBySeller();
}
