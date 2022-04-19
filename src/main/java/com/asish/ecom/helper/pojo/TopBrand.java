package com.asish.ecom.helper.pojo;

public class TopBrand implements Comparable<TopBrand> {
	private String brandName;
	private int orderCount;
	private int orderQty;

	public TopBrand() {
		this.orderCount = 0;
		this.orderQty = 0;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	@Override
	public String toString() {
		return "TopBrand [brandName=" + brandName + ", orderCount=" + orderCount + ", orderQty=" + orderQty + "]";
	}

	@Override
	public int compareTo(TopBrand o) {
		if (orderCount == o.orderCount) {
			return 0;
		} else if (orderCount < o.orderCount) {
			return 1;
		}
		return -1;
	}

}
