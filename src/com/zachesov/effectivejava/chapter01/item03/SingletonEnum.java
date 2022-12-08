package com.zachesov.effectivejava.chapter01.item03;

/**
 * @author Zachesov Sergei
 * @since 8/20/2022
 */
public enum SingletonEnum {
  INSTANCE;

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  // This code would normally appear outside the class!
  public static void main(String[] args) {
    SingletonEnum.INSTANCE.leaveTheBuilding();
  }
}
