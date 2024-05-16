package com.b9dev.projetoSDS.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.b9dev.projetoSDS.dto.SaleSuccessSumDTO;
import com.b9dev.projetoSDS.dto.SaleSumDTO;
import com.b9dev.projetoSDS.entities.Sale;
import com.b9dev.projetoSDS.entities.Seller;
import com.b9dev.projetoSDS.repositories.SaleRepository;
import com.b9dev.projetoSDS.repositories.SellerRepository;

@DataJpaTest
@ActiveProfiles("test")
class SaleServiceTest {

	@Mock
	private SaleRepository repository;

	@Mock
	private SellerRepository sellerRepository;
	
	@InjectMocks
	private SaleService service;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		Seller seller = new Seller (1L,"Hyuki");
		
		Sale sale1 = new Sale(1L, 10, 20, 120.0,LocalDate.now(), seller );
		Sale sale2 = new Sale(1L, 10, 20, 120.0,LocalDate.now(), seller );
		
		List<Sale> salesList = Arrays.asList(sale1,sale2);
		
		when(repository.findAll()).thenReturn(salesList);
		
		List<Sale> result =repository.findAll();
		
		assert(result.equals(salesList));			
		verify(repository).findAll();
	}

	@Test
	void testAmountGruoupedBySeller() {
		Seller seller = new Seller (1L,"Hyuki");
		Seller seller2 = new Seller (2L,"Light");
		
		SaleSumDTO ssd1 = new SaleSumDTO(seller, 20.0);
		SaleSumDTO ssd2 = new SaleSumDTO(seller2, 20.0);
		
		List<SaleSumDTO> salesSumList = Arrays.asList(ssd1,ssd2);
		
		when(repository.amountGruoupedBySeller()).thenReturn(salesSumList);
		
		List<SaleSumDTO> result = service.amountGruoupedBySeller();
		
		assert(result.equals(salesSumList));			
		verify(repository,times(1)).amountGruoupedBySeller();
	}
	
	
	@Test
	void testSuccessGruoupedBySeller() {
		Seller seller = new Seller (1L,"Hyuki");
		Seller seller2 = new Seller (2L,"Light");
		
		SaleSuccessSumDTO ssd1 = new SaleSuccessSumDTO(seller,40L, 20L);
		SaleSuccessSumDTO ssd2 = new SaleSuccessSumDTO(seller2,40L, 20L);
		
		List<SaleSuccessSumDTO> saleSuccessSumDTOList = Arrays.asList(ssd1,ssd2);
		
		when(repository.SuccessGruoupedBySeller()).thenReturn(saleSuccessSumDTOList);
		
		List<SaleSuccessSumDTO> result = service.SuccessGruoupedBySeller();
		
		assert(result.equals(saleSuccessSumDTOList));			
		verify(repository,times(1)).SuccessGruoupedBySeller();
	}


}
