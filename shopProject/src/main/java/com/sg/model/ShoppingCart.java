package com.sg.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  List<Item> Items = new ArrayList<Item>();

  public List<Item> getItems() {
    return Items;
  }

  public void setItems(List<Item> items) {
    Items = items;
  }
  
}
