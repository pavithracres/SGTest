package com.sg.model;

public class Bill {

  ShoppingCart cart;

  Double totalCost = 0.0;
  Double totalDiscountedCost = 0.0;

  public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }

  public Double getTotalDiscountedCost() {
    return totalDiscountedCost;
  }

  public void setTotalDiscountedCost(Double totalDiscountedCost) {
    this.totalDiscountedCost = totalDiscountedCost;
  }

  public ShoppingCart getCart() {
    return cart;
  }

  public void setCart(ShoppingCart cart) {
    this.cart = cart;
  }

}
