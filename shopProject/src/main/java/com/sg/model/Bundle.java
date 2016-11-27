/**
 * 
 */
package com.sg.model;

/**
 * @author pparthas
 *
 */
public class Bundle {
  
  private int bundleCount = 0;
  private double bundlePrice = 0.0; // cost per bundle
  private double bundleDiscountedPrice = 0.0; // Discounted cost per bundle
  
  public int getBundleCount() {
    return bundleCount;
  }
  public void setBundleCount(int bundleCount) {
    this.bundleCount = bundleCount;
  }
  public double getBundlePrice() {
    return bundlePrice;
  }
  public void setBundlePrice(double bundlePrice) {
    this.bundlePrice = bundlePrice;
  }
  public double getBundleDiscountedPrice() {
    return bundleDiscountedPrice;
  }
  public void setBundleDiscountedPrice(double bundleDiscountedPrice) {
    this.bundleDiscountedPrice = bundleDiscountedPrice;
  }
  
}
