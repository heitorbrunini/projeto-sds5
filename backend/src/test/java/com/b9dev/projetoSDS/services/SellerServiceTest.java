package com.b9dev.projetoSDS.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.b9dev.projetoSDS.dto.SellerDTO;
import com.b9dev.projetoSDS.entities.Seller;
import com.b9dev.projetoSDS.repositories.SellerRepository;

class SellerServiceTest {

	@Mock
	private SellerRepository sellerRepository;

	@InjectMocks
	private SellerService service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		Seller seller = new Seller(1L, "Hyuki");
		Seller seller2 = new Seller(2L, "Light");

		List<Seller> sellerList = Arrays.asList(seller, seller2);

		when(sellerRepository.findAll()).thenReturn(sellerList);

		List<SellerDTO> result = service.findAll();

		assertEquals(2, result.size());
		verify(sellerRepository).findAll();
	}

}
