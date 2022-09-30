package com.example.dto;

import java.math.BigDecimal;

public class ResponseBookDTO<T> {
    
    private String title;

    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
}
