package com.b9dev.projetoSDS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b9dev.projetoSDS.dto.SaleDTO;
import com.b9dev.projetoSDS.dto.SaleSuccessSumDTO;
import com.b9dev.projetoSDS.dto.SaleSumDTO;
import com.b9dev.projetoSDS.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sum")
	public ResponseEntity<List<SaleSumDTO>> amountGruoupedBySeller(){
		List<SaleSumDTO> list = service.amountGruoupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sucess")
	public ResponseEntity<List<SaleSuccessSumDTO>> SuccessGruoupedBySeller(){
		List<SaleSuccessSumDTO> list = service.SuccessGruoupedBySeller();
		return ResponseEntity.ok(list);
	}
	
}
