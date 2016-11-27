/**
 * 
 */
package com.sg.model.discount;

import java.util.List;

import com.sg.model.Bill;
import com.sg.model.Bundle;
import com.sg.model.Item;
import com.sg.service.GroupPercentageDiscountService;

/**
 * @author pparthas
 *
 */
public class ApplyGroupPercentageDiscountRule implements Discount {

  private GroupPercentageDiscountService groupPercentageDiscountService;
  private Bundle bundle;

  public ApplyGroupPercentageDiscountRule(DiscountRule discountRule) {
    groupPercentageDiscountService = new GroupPercentageDiscountService(discountRule);
  }

  public void applyDiscountsAndUpdateBill(List<Item> listOfItems, Bill bill) {
    bundle = groupPercentageDiscountService.generateBundles(listOfItems);
    if(bundle!=null){
      bill.setTotalDiscountedCost(bill.getTotalDiscountedCost() + (bundle.getBundleCount() * bundle.getBundleDiscountedPrice()));
    }
  }

}
