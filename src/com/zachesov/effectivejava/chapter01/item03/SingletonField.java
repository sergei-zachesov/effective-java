package com.zachesov.effectivejava.chapter01.item03;

/**
 * @author Zachesov Sergei
 * @since 8/20/2022
 */
public class SingletonField {

  public static final SingletonField INSTANCE = new SingletonField();

  private SingletonField() {}

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  // This code would normally appear outside the class!
  public static void main(String[] args) {
    SingletonField.INSTANCE.leaveTheBuilding();
  }
}
