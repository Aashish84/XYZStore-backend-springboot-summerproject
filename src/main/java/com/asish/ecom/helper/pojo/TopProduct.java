package com.asish.ecom.helper.pojo;

import org.springframework.stereotype.Component;

@Component
public class TopProduct implements Comparable<TopProduct> {
	private int productId;
	private String productName;
	private int productOrderCount;
	private int productQuantityCount;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductOrderCount() {
		return productOrderCount;
	}

	public void setProductOrderCount(int productOrderCount) {
		this.productOrderCount = productOrderCount;
	}

	public int getProductQuantityCount() {
		return productQuantityCount;
	}

	public void setProductQuantityCount(int productQuantityCount) {
		this.productQuantityCount = productQuantityCount;
	}

	@Override
	public int compareTo(TopProduct o) {
		if (productQuantityCount == o.productQuantityCount) {
			return 0;
		} else if (productQuantityCount < o.productQuantityCount) {
			return 1;
		}
		return -1;
	}

}
