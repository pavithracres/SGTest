package com.sg.model.discount;

import com.sg.util.Constants.DiscountType;

public class DiscountRule implements Comparable<DiscountRule>{

  private int numberOfItems;

  private double discountValue;
  
  private DiscountType ruleType;
  
  private String applyForItemGroup; // To Scale - Can be array of "item groups" or "item group ids" instead of only for one group - Here Harry Potter - HP 
  
  public int getNumberOfItems() {
    return numberOfItems;
  }
  public void setNumberOfItems(int numberOfItems) {
    this.numberOfItems = numberOfItems;
  }
  public double getDiscountValue() {
    return discountValue;
  }
  public void setDiscountValue(double discountValue) {
    this.discountValue = discountValue;
  }
  public DiscountType getRuleType() {
    return ruleType;
  }
  public void setRuleType(DiscountType ruleType) {
    this.ruleType = ruleType;
  }
  
  public int compareTo(DiscountRule discountRule) {
    // Sort descending
    if( discountRule == null ){
      return 0;
    }
    if( this.numberOfItems > discountRule.numberOfItems){
      return -1;
    }else if ( this.numberOfItems < discountRule.numberOfItems){
      return 1;
    }
    return 0;
  }
  public String getApplyForItemGroup() {
    return applyForItemGroup;
  }
  public void setApplyForItemGroup(String applyForItemGroup) {
    this.applyForItemGroup = applyForItemGroup;
  }
  
}
