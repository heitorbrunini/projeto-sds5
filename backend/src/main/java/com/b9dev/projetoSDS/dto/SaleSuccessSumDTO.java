package com.b9dev.projetoSDS.dto;

import java.io.Serializable;

import com.b9dev.projetoSDS.entities.Seller;

public class SaleSuccessSumDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Long visited;
	private Long deals;
	
	public SaleSuccessSumDTO() {
	}

	public SaleSuccessSumDTO(Seller seller , Long visited,Long Deals) {
		sellerName = seller.getName();
		this.visited = visited;
		deals = Deals;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getVisited() {
		return visited;
	}

	public void setVisited(Long visited) {
		this.visited = visited;
	}

	public Long getDeals() {
		return deals;
	}

	public void setDeals(Long deals) {
		this.deals = deals;
	}
	
}


