package com.sg.shopping.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sg.model.Bill;
import com.sg.model.Item;
import com.sg.model.ShoppingCart;
import com.sg.model.discount.ApplyGroupPercentageDiscountRule;
import com.sg.model.discount.Discount;
import com.sg.model.discount.DiscountRule;
import com.sg.util.Constants.DiscountType;;

public class ShoppingCartEvaluator {

  public Bill evaluate(ShoppingCart cart, List<DiscountRule> activeDiscounts) {
    Bill bill = new Bill();
    Collections.sort(activeDiscounts);
    List<Item> listOfItems = cart.getItems();
    List<Item> listOfItemsCopy = new ArrayList<Item>();
    List<Item> listOfItemsEligibleForDiscounts;
    for (Item item : listOfItems) {
      try {
        listOfItemsCopy.add((Item) item.clone());
      }
      catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }

    for (DiscountRule discountRule : activeDiscounts) {
      listOfItemsEligibleForDiscounts = new ArrayList<Item>();
      for (Item item : listOfItemsCopy) {
        if (item.getItemGroup().equals(discountRule.getApplyForItemGroup())) {
          listOfItemsEligibleForDiscounts.add(item);
        }
      }
      Discount discount = getDiscountRuleProcessor(discountRule);
      discount.applyDiscountsAndUpdateBill(listOfItemsEligibleForDiscounts, bill);
    }

    for (Item item : listOfItems) {
      bill.setTotalCost(bill.getTotalCost() + (item.getCount() * item.getCost()));
    }

    return bill;
  }

  public Discount getDiscountRuleProcessor(DiscountRule discountRule) {

    if (discountRule.getRuleType() == DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT) {
      return new ApplyGroupPercentageDiscountRule(discountRule);
    }

    else
      return null;

  }

}
