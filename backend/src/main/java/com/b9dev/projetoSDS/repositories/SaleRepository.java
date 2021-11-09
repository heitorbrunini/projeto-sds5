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
	//Caused by: org.hibernate.hql.internal.ast.QuerySyntaxException: Unable to locate appropriate constructor on class [com.b9dev.projetoSDS.dto.SaleSuccessSumDTO]. 
	//Expected arguments are: com.b9dev.projetoSDS.entities.Seller, long, long [SELECT new com.b9dev.projetoSDS.dto.SaleSuccessSumDTO (obj.seller, SUM (obj.visited), SUM(obj.deals)) FROM com.b9dev.projetoSDS.entities.Sale AS obj GROUP BY obj.seller]
	@Query ("SELECT new com.b9dev.projetoSDS.dto.SaleSuccessSumDTO (obj.seller, SUM (obj.visited), SUM (obj.deals))"
			+" FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessSumDTO> SuccessGruoupedBySeller();
}
