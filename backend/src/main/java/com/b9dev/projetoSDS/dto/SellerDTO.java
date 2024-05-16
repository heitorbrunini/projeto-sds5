package com.b9dev.projetoSDS.dto;

import com.b9dev.projetoSDS.entities.Seller;

public record SellerDTO(Long id, String name) {

	public SellerDTO(Seller entity) {
		
		this(
				entity.getId(),
				entity.getName()
		);
	}

}
