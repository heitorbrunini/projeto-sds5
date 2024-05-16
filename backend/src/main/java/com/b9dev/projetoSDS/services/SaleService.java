package com.b9dev.projetoSDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b9dev.projetoSDS.dto.SaleDTO;
import com.b9dev.projetoSDS.dto.SaleSuccessSumDTO;
import com.b9dev.projetoSDS.dto.SaleSumDTO;
import com.b9dev.projetoSDS.entities.Sale;
import com.b9dev.projetoSDS.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGruoupedBySeller(){
		return repository.amountGruoupedBySeller();
	};
	
	@Transactional(readOnly = true)
	public List<SaleSuccessSumDTO> SuccessGruoupedBySeller(){
		return repository.SuccessGruoupedBySeller();
	};
}
