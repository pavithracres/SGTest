/**
 * 
 */
package com.sg.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sg.model.Bill;
import com.sg.model.Item;
import com.sg.model.ShoppingCart;
import com.sg.model.discount.DiscountRule;
import com.sg.shopping.logic.ShoppingCartEvaluator;
import com.sg.util.Constants.DiscountType;

import static org.junit.Assert.assertEquals;

/**
 * @author pparthas
 *
 */
public class TestGroupPercentageDiscountRule {
  
  ShoppingCartEvaluator eval = new ShoppingCartEvaluator();   
  
  /*
   * Book 1 - 2 copies
   * Book 2 - 2 copies
   * Book 3 - 2 copies
   * Book 4 - 1 copies
   * Book 5 - 1 copies
   * 1 copy - 0%
   * 2 copies - 5%
   * 3 copies - 10%
   * 4 copies - 20%
   * 5 copies - 25%
   */
  @Test
  public void testGroupPercentageDiscountRuleFiveItems(){
    ShoppingCart sc = new ShoppingCart(); 
    
    Item item1 = new Item();
    item1.name = "Harry Potter Book 1";
    item1.itemGroup = "HP";
    item1.count = 2;
    item1.cost = 8;
    Item item2 = new Item();
    item1.name = "Harry Potter Book 2";
    item2.itemGroup = "HP";
    item2.count = 2;
    item2.cost = 8;
    Item item3 = new Item();
    item1.name = "Harry Potter Book 3";
    item3.itemGroup = "HP";
    item3.count = 2 ;
    item3.cost = 8;
    Item item4 = new Item();
    item1.name = "Harry Potter Book 4";
    item4.itemGroup = "HP";
    item4.count = 1;
    item4.cost = 8;
    Item item5 = new Item();
    item1.name = "Harry Potter Book 5";
    item5.itemGroup = "HP";
    item5.count = 1;
    item5.cost = 8;
    
    DiscountRule percentageRuleOneItem = new DiscountRule();
    DiscountRule percentageRuleTwoItems = new DiscountRule();
    DiscountRule percentageRuleThreeItems = new DiscountRule();
    DiscountRule percentageRuleFourItems = new DiscountRule();
    DiscountRule percentageRuleFiveItems = new DiscountRule();
    
    percentageRuleOneItem.setNumberOfItems(1);
    percentageRuleOneItem.setApplyForItemGroup("HP");
    percentageRuleOneItem.setDiscountValue(0);
    percentageRuleOneItem.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleTwoItems.setNumberOfItems(2);
    percentageRuleTwoItems.setApplyForItemGroup("HP");
    percentageRuleTwoItems.setDiscountValue(5);
    percentageRuleTwoItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleThreeItems.setNumberOfItems(3);
    percentageRuleThreeItems.setApplyForItemGroup("HP");
    percentageRuleThreeItems.setDiscountValue(10);
    percentageRuleThreeItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFourItems.setNumberOfItems(4);
    percentageRuleFourItems.setApplyForItemGroup("HP");
    percentageRuleFourItems.setDiscountValue(20);
    percentageRuleFourItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFiveItems.setNumberOfItems(5);
    percentageRuleFiveItems.setApplyForItemGroup("HP");
    percentageRuleFiveItems.setDiscountValue(25);
    percentageRuleFiveItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    List<Item> items = new ArrayList<Item>();
    
    items.add(item1);
    items.add(item2);
    items.add(item3);
    items.add(item4);
    items.add(item5);
    
    List<DiscountRule> activeDiscounts = new ArrayList<DiscountRule>();
    
    activeDiscounts.add(percentageRuleOneItem);
    activeDiscounts.add(percentageRuleTwoItems);
    activeDiscounts.add(percentageRuleThreeItems);
    activeDiscounts.add(percentageRuleFourItems);
    activeDiscounts.add(percentageRuleFiveItems);
    
    sc.setItems(items);
    
    Bill bill = eval.evaluate(sc,activeDiscounts);
    assertEquals(bill.getTotalCost(),64.0,0.0);
    assertEquals(bill.getTotalDiscountedCost(),51.6,0.0);
  }
  
  /*
   * Book 1 - 2 copies - 0%
   * Book 2 - 2 copies
   * Book 4 - 1 copies
   * Book 5 - 1 copies - 25%
   * 1 copy - 0%
   * 2 copies - 5%
   * 3 copies - 10%
   * 4 copies - 20%
   * 5 copies - 25%
   */
  @Test
  public void testGroupPercentageDiscountRuleFourItems(){
    ShoppingCart sc = new ShoppingCart(); 
    
    Item item1 = new Item();
    item1.itemGroup = "HP";
    item1.count = 2;
    item1.cost = 8;
    Item item2 = new Item();
    item2.itemGroup = "HP";
    item2.count = 2;
    item2.cost = 8;
    Item item4 = new Item();
    item4.itemGroup = "HP";
    item4.count = 1;
    item4.cost = 8;
    Item item5 = new Item();
    item5.itemGroup = "HP";
    item5.count = 1;
    item5.cost = 8;
    
    DiscountRule percentageRuleOneItem = new DiscountRule();
    DiscountRule percentageRuleTwoItems = new DiscountRule();
    DiscountRule percentageRuleThreeItems = new DiscountRule();
    DiscountRule percentageRuleFourItems = new DiscountRule();
    DiscountRule percentageRuleFiveItems = new DiscountRule();
    
    percentageRuleOneItem.setNumberOfItems(1);
    percentageRuleOneItem.setDiscountValue(0);
    percentageRuleOneItem.setApplyForItemGroup("HP");
    percentageRuleOneItem.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleTwoItems.setNumberOfItems(2);
    percentageRuleTwoItems.setDiscountValue(5);
    percentageRuleTwoItems.setApplyForItemGroup("HP");
    percentageRuleTwoItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleThreeItems.setNumberOfItems(3);
    percentageRuleThreeItems.setDiscountValue(10);
    percentageRuleThreeItems.setApplyForItemGroup("HP");
    percentageRuleThreeItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFourItems.setNumberOfItems(4);
    percentageRuleFourItems.setDiscountValue(20);
    percentageRuleFourItems.setApplyForItemGroup("HP");
    percentageRuleFourItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFiveItems.setNumberOfItems(5);
    percentageRuleFiveItems.setDiscountValue(25);
    percentageRuleFiveItems.setApplyForItemGroup("HP");
    percentageRuleFiveItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    List<Item> items = new ArrayList<Item>();
    
    items.add(item1);
    items.add(item2);
    items.add(item4);
    items.add(item5);
    
    List<DiscountRule> activeDiscounts = new ArrayList<DiscountRule>();
    
    activeDiscounts.add(percentageRuleOneItem);
    activeDiscounts.add(percentageRuleTwoItems);
    activeDiscounts.add(percentageRuleThreeItems);
    activeDiscounts.add(percentageRuleFourItems);
    activeDiscounts.add(percentageRuleFiveItems);
    
    sc.setItems(items);
    
    Bill bill = eval.evaluate(sc,activeDiscounts);
    assertEquals(bill.getTotalCost(),48.0,0.0);
    assertEquals(bill.getTotalDiscountedCost(),40.8,0.0);
  }
    
  /*
   * Book 2 - 4 copies
   * Book 3 - 4 copies
   * Book 4 - 6 copies
   * 1 copy - 0%
   * 2 copies - 5%
   * 3 copies - 10%
   * 4 copies - 20%
   * 5 copies - 25% 
   */
  @Test
  public void testGroupPercentageDiscountRuleThreeItems(){
    ShoppingCart sc = new ShoppingCart(); 
    
    Item item2 = new Item();
    item2.itemGroup = "HP";
    item2.count = 4;
    item2.cost = 8;
    Item item3 = new Item();
    item3.itemGroup = "HP";
    item3.count = 4 ;
    item3.cost = 8;
    Item item4 = new Item();
    item4.itemGroup = "HP";
    item4.count = 6;
    item4.cost = 8;
    
    DiscountRule percentageRuleOneItem = new DiscountRule();
    DiscountRule percentageRuleTwoItems = new DiscountRule();
    DiscountRule percentageRuleThreeItems = new DiscountRule();
    DiscountRule percentageRuleFourItems = new DiscountRule();
    DiscountRule percentageRuleFiveItems = new DiscountRule();
    
    percentageRuleOneItem.setNumberOfItems(1);
    percentageRuleOneItem.setDiscountValue(0);
    percentageRuleOneItem.setApplyForItemGroup("HP");
    percentageRuleOneItem.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleTwoItems.setNumberOfItems(2);
    percentageRuleTwoItems.setDiscountValue(5);
    percentageRuleTwoItems.setApplyForItemGroup("HP");
    percentageRuleTwoItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleThreeItems.setNumberOfItems(3);
    percentageRuleThreeItems.setDiscountValue(10);
    percentageRuleThreeItems.setApplyForItemGroup("HP");
    percentageRuleThreeItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFourItems.setNumberOfItems(4);
    percentageRuleFourItems.setDiscountValue(20);
    percentageRuleFourItems.setApplyForItemGroup("HP");
    percentageRuleFourItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFiveItems.setNumberOfItems(5);
    percentageRuleFiveItems.setDiscountValue(25);
    percentageRuleFiveItems.setApplyForItemGroup("HP");
    percentageRuleFiveItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    List<Item> items = new ArrayList<Item>();

    items.add(item2);
    items.add(item3);
    items.add(item4);
    
    List<DiscountRule> activeDiscounts = new ArrayList<DiscountRule>();
    
    activeDiscounts.add(percentageRuleOneItem);
    activeDiscounts.add(percentageRuleTwoItems);
    activeDiscounts.add(percentageRuleThreeItems);
    activeDiscounts.add(percentageRuleFourItems);
    activeDiscounts.add(percentageRuleFiveItems);
    
    sc.setItems(items);
    
    Bill bill = eval.evaluate(sc,activeDiscounts);
    assertEquals(bill.getTotalCost(),112.0,0.0);
    assertEquals(bill.getTotalDiscountedCost(),102.4,0.0);
  }
  
  /*
   * Book 2 - 8 copies
   * Book 3 - 8 copies
   * 1 copy - 0%
   * 2 copies - 5%
   * 3 copies - 10%
   * 4 copies - 20%
   * 5 copies - 25%
   */
  @Test
  public void testGroupPercentageDiscountRuleTwoItem(){
    ShoppingCart sc = new ShoppingCart(); 
    
    Item item1 = new Item();
    item1.itemGroup = "HP";
    item1.count = 0;
    item1.cost = 8;
    Item item2 = new Item();
    item2.itemGroup = "HP";
    item2.count = 10;
    item2.cost = 8;
    Item item3 = new Item();
    item3.itemGroup = "HP"; 
    item3.count = 10;
    item3.cost = 8;
    Item item4 = new Item();
    item4.itemGroup = "HP";
    item4.count = 0;
    item4.cost = 8;
    Item item5 = new Item();
    item5.itemGroup = "HP";
    item5.count = 0;
    item5.cost = 8;
    
    DiscountRule percentageRuleOneItem = new DiscountRule();
    DiscountRule percentageRuleTwoItems = new DiscountRule();
    DiscountRule percentageRuleThreeItems = new DiscountRule();
    DiscountRule percentageRuleFourItems = new DiscountRule();
    DiscountRule percentageRuleFiveItems = new DiscountRule();
    
    percentageRuleOneItem.setNumberOfItems(1);
    percentageRuleOneItem.setDiscountValue(0);
    percentageRuleOneItem.setApplyForItemGroup("HP");
    percentageRuleOneItem.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleTwoItems.setNumberOfItems(2);
    percentageRuleTwoItems.setDiscountValue(5);
    percentageRuleTwoItems.setApplyForItemGroup("HP");
    percentageRuleTwoItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleThreeItems.setNumberOfItems(3);
    percentageRuleThreeItems.setDiscountValue(10);
    percentageRuleThreeItems.setApplyForItemGroup("HP");
    percentageRuleThreeItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFourItems.setNumberOfItems(4);
    percentageRuleFourItems.setDiscountValue(20);
    percentageRuleFourItems.setApplyForItemGroup("HP");
    percentageRuleFourItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFiveItems.setNumberOfItems(5);
    percentageRuleFiveItems.setDiscountValue(25);
    percentageRuleFiveItems.setApplyForItemGroup("HP");
    percentageRuleFiveItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    List<Item> items = new ArrayList<Item>();
    
    items.add(item1);
    items.add(item2);
    items.add(item3);
    items.add(item4);
    items.add(item5);
    
    List<DiscountRule> activeDiscounts = new ArrayList<DiscountRule>();
    
    activeDiscounts.add(percentageRuleOneItem);
    activeDiscounts.add(percentageRuleTwoItems);
    activeDiscounts.add(percentageRuleThreeItems);
    activeDiscounts.add(percentageRuleFourItems);
    
    sc.setItems(items);
    
    Bill bill = eval.evaluate(sc,activeDiscounts);
    assertEquals(bill.getTotalCost(),160.0,0.0);
    assertEquals(bill.getTotalDiscountedCost(),152.0,0.0);
  }
  
  /*
   * Book 1 - 0 copies  -- To test item with 0 items
   * Book 5 - 10 copies 
   * 1 copy - 0%
   * 2 copies - 5%
   * 3 copies - 10%
   * 4 copies - 20%
   * 5 copies - 25%
   */
  @Test
  public void testGroupPercentageDiscountRuleOneItem(){
    ShoppingCart sc = new ShoppingCart(); 
    
    Item item1 = new Item();
    item1.itemGroup = "HP";
    item1.count = 0;
    item1.cost = 8;
    Item item5 = new Item();
    item5.itemGroup = "HP";
    item5.count = 10;
    item5.cost = 8;
    
    DiscountRule percentageRuleOneItem = new DiscountRule();
    DiscountRule percentageRuleTwoItems = new DiscountRule();
    DiscountRule percentageRuleThreeItems = new DiscountRule();
    DiscountRule percentageRuleFourItems = new DiscountRule();
    DiscountRule percentageRuleFiveItems = new DiscountRule();
    
    percentageRuleOneItem.setNumberOfItems(1);
    percentageRuleOneItem.setDiscountValue(0);
    percentageRuleOneItem.setApplyForItemGroup("HP");
    percentageRuleOneItem.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleTwoItems.setNumberOfItems(2);
    percentageRuleTwoItems.setDiscountValue(5);
    percentageRuleTwoItems.setApplyForItemGroup("HP");
    percentageRuleTwoItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleThreeItems.setNumberOfItems(3);
    percentageRuleThreeItems.setDiscountValue(10);
    percentageRuleThreeItems.setApplyForItemGroup("HP");
    percentageRuleThreeItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFourItems.setNumberOfItems(4);
    percentageRuleFourItems.setDiscountValue(20);
    percentageRuleFourItems.setApplyForItemGroup("HP");
    percentageRuleFourItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFiveItems.setNumberOfItems(5);
    percentageRuleFiveItems.setDiscountValue(25);
    percentageRuleFiveItems.setApplyForItemGroup("HP");
    percentageRuleFiveItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    List<Item> items = new ArrayList<Item>();
    
    items.add(item1);
    items.add(item5);
    
    List<DiscountRule> activeDiscounts = new ArrayList<DiscountRule>();
    
    activeDiscounts.add(percentageRuleOneItem);
    activeDiscounts.add(percentageRuleTwoItems);
    activeDiscounts.add(percentageRuleThreeItems);
    activeDiscounts.add(percentageRuleFourItems);
    
    sc.setItems(items);
    
    Bill bill = eval.evaluate(sc,activeDiscounts);
    assertEquals(bill.getTotalCost(),80.0,0.0);
    assertEquals(bill.getTotalDiscountedCost(),80.0,0.0);
  }
  
  /*
   * Book 5 - 10 copies 
   * 1 copy - 2.5% -- Different percentage from requirement - Only to test
   * 2 copies - 5%
   * 3 copies - 10%
   * 4 copies - 20%
   * 5 copies - 25%
   */
  @Test
  public void testGroupPercentageDiscountRuleOneItemDifferentPercentage(){
    ShoppingCart sc = new ShoppingCart(); 

    Item item5 = new Item();
    item5.itemGroup = "HP";
    item5.count = 10;
    item5.cost = 8;
    
    DiscountRule percentageRuleOneItem = new DiscountRule();
    DiscountRule percentageRuleTwoItems = new DiscountRule();
    DiscountRule percentageRuleThreeItems = new DiscountRule();
    DiscountRule percentageRuleFourItems = new DiscountRule();
    DiscountRule percentageRuleFiveItems = new DiscountRule();
    
    percentageRuleOneItem.setNumberOfItems(1);
    percentageRuleOneItem.setDiscountValue(2.5);
    percentageRuleOneItem.setApplyForItemGroup("HP");
    percentageRuleOneItem.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleTwoItems.setNumberOfItems(2);
    percentageRuleTwoItems.setDiscountValue(5);
    percentageRuleTwoItems.setApplyForItemGroup("HP");
    percentageRuleTwoItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleThreeItems.setNumberOfItems(3);
    percentageRuleThreeItems.setDiscountValue(10);
    percentageRuleThreeItems.setApplyForItemGroup("HP");
    percentageRuleThreeItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFourItems.setNumberOfItems(4);
    percentageRuleFourItems.setDiscountValue(20);
    percentageRuleFourItems.setApplyForItemGroup("HP");
    percentageRuleFourItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    percentageRuleFiveItems.setNumberOfItems(5);
    percentageRuleFiveItems.setDiscountValue(25);
    percentageRuleFiveItems.setApplyForItemGroup("HP");
    percentageRuleFiveItems.setRuleType(DiscountType.ITEM_GROUP_PERCENTAGE_DISCOUNT);
    
    List<Item> items = new ArrayList<Item>();

    items.add(item5);
    
    List<DiscountRule> activeDiscounts = new ArrayList<DiscountRule>();
    
    activeDiscounts.add(percentageRuleOneItem);
    activeDiscounts.add(percentageRuleTwoItems);
    activeDiscounts.add(percentageRuleThreeItems);
    activeDiscounts.add(percentageRuleFourItems);
    
    sc.setItems(items);
    
    Bill bill = eval.evaluate(sc,activeDiscounts);
    assertEquals(bill.getTotalCost(),80.0,0.0);
    assertEquals(bill.getTotalDiscountedCost(),78.0,0.0);
  }
 }


