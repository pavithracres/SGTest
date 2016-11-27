/**
 * 
 */
package com.sg.model.discount;

import java.util.List;

import com.sg.model.Bill;
import com.sg.model.Item;

/**
 * @author pparthas
 *
 */
public interface Discount {

  public void applyDiscountsAndUpdateBill(List<Item> listOfItems, Bill bill);
  
}
