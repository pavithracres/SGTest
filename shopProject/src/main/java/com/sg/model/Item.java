package com.sg.model;

public class Item implements Cloneable {

  public Long itemId = (long) 0;
  public String name = null;
  public String itemGroup = null;
  public long cost = 0;
  public long count = 0;
  
  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getItemGroup() {
    return itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public long getCost() {
    return cost;
  }

  public void setCost(long cost) {
    this.cost = cost;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}
