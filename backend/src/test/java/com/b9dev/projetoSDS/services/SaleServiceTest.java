package com.b9dev.projetoSDS.services;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.b9dev.projetoSDS.dto.SaleDTO;
import com.b9dev.projetoSDS.dto.SaleSuccessSumDTO;
import com.b9dev.projetoSDS.dto.SaleSumDTO;
import com.b9dev.projetoSDS.entities.Sale;
import com.b9dev.projetoSDS.entities.Seller;
import com.b9dev.projetoSDS.repositories.SaleRepository;

@DataJpaTest
@ActiveProfiles("test")
class SaleServiceTest {

	@Mock
	private SaleRepository repository;

	@InjectMocks
	private SaleService service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		Seller seller = new Seller(1L, "Hyuki");

		Sale sale1 = new Sale(1L, 10, 20, 120.0, LocalDate.now(), seller);
		Sale sale2 = new Sale(1L, 10, 20, 120.0, LocalDate.now(), seller);

		List<Sale> salesList = Arrays.asList(sale1, sale2);

		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		Page<Sale> salePage = new PageImpl<>(salesList, firstPageWithTwoElements, salesList.size());

		when(repository.findAll(firstPageWithTwoElements)).thenReturn(salePage);

		Page<SaleDTO> result = service.findAll(firstPageWithTwoElements);

		assertThat(result).isNotNull();
		
		assertThat(result.getContent().size()).isEqualTo(2);
		assertThat(result.getContent().get(0).getId()).isEqualTo(sale1.getId());
		assertThat(result.getContent().get(1).getId()).isEqualTo(sale2.getId());
		
		verify(repository).findAll(firstPageWithTwoElements);
	}

	@Test
	void testAmountGruoupedBySeller() {
		Seller seller = new Seller(1L, "Hyuki");
		Seller seller2 = new Seller(2L, "Light");

		SaleSumDTO ssd1 = new SaleSumDTO(seller, 20.0);
		SaleSumDTO ssd2 = new SaleSumDTO(seller2, 20.0);

		List<SaleSumDTO> salesSumList = Arrays.asList(ssd1, ssd2);

		when(repository.amountGruoupedBySeller()).thenReturn(salesSumList);

		List<SaleSumDTO> result = service.amountGruoupedBySeller();

		assert (result.equals(salesSumList));
		verify(repository, times(1)).amountGruoupedBySeller();
	}

	@Test
	void testSuccessGruoupedBySeller() {
		Seller seller = new Seller(1L, "Hyuki");
		Seller seller2 = new Seller(2L, "Light");

		SaleSuccessSumDTO ssd1 = new SaleSuccessSumDTO(seller, 40L, 20L);
		SaleSuccessSumDTO ssd2 = new SaleSuccessSumDTO(seller2, 40L, 20L);

		List<SaleSuccessSumDTO> saleSuccessSumDTOList = Arrays.asList(ssd1, ssd2);

		when(repository.SuccessGruoupedBySeller()).thenReturn(saleSuccessSumDTOList);

		List<SaleSuccessSumDTO> result = service.SuccessGruoupedBySeller();

		assert (result.equals(saleSuccessSumDTOList));
		verify(repository, times(1)).SuccessGruoupedBySeller();
	}

}
