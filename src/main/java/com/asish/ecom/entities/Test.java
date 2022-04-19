package com.asish.ecom.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
	@Id
	private int oiId;
	private int count;
}