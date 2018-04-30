package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
    public String name;

    public Product(String name){
        this.name = name;
    }

    public Product() {
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
