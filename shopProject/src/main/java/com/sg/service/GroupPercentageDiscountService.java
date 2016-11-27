package com.sg.service;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sg.model.Bundle;
import com.sg.model.Item;
import com.sg.model.discount.DiscountRule;

public class GroupPercentageDiscountService {

  public int numberOfItems;
  public double discountPercentage;

  public GroupPercentageDiscountService(DiscountRule rule) {
    this.numberOfItems = rule.getNumberOfItems();
    this.discountPercentage = rule.getDiscountValue();
  }

  public Bundle generateBundles(List<Item> listOfItems) {
    Bundle bundle = new Bundle();
    int uniqueItems = 0;

    Iterator<Item> listIteratorToRemove = listOfItems.iterator();

    while (listIteratorToRemove.hasNext()) {
      Item itemForCount = listIteratorToRemove.next();
      if (itemForCount.count > 0) {
        uniqueItems++;
      }
      else {
        listIteratorToRemove.remove();
      }
    }
    
    /* Set price if at least one bundle is present */
    if (numberOfItems == uniqueItems) {
      this.setBundlePrice(bundle, listOfItems);
    }
    
    while (numberOfItems == uniqueItems) {
      
      ListIterator<Item> listIterator = listOfItems.listIterator();
      bundle.setBundleCount(bundle.getBundleCount() + 1);
      
      while (listIterator.hasNext()) {
        Item tempItem = listIterator.next();
        tempItem.count = tempItem.count - 1;
        listIterator.set(tempItem);
        if (tempItem.count == 0) {
          listIterator.remove();
          numberOfItems--;
        }
      }
      
    }

    return bundle;
  }

  public void setBundlePrice(Bundle bundle, List<Item> listOfItems) {
    double itemCostAfterApplicableDiscount = 0.0;
    for (Item item : listOfItems) {
      itemCostAfterApplicableDiscount = item.cost - (item.cost * (discountPercentage / 100));
      bundle.setBundlePrice(bundle.getBundlePrice() + item.cost);
      bundle.setBundleDiscountedPrice(bundle.getBundleDiscountedPrice() + itemCostAfterApplicableDiscount);
    }
  }
  
  
}
