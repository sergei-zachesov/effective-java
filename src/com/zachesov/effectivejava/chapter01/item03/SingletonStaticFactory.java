package com.zachesov.effectivejava.chapter01.item03;

/**
 * @author Zachesov Sergei
 * @since 8/20/2022
 */
public class SingletonStaticFactory {

  private static final SingletonStaticFactory INSTANCE = new SingletonStaticFactory();

  private SingletonStaticFactory() {}

  public static SingletonStaticFactory getInstance() {
    return INSTANCE;
  }

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  // This code would normally appear outside the class!
  public static void main(String[] args) {
    SingletonStaticFactory singletonStaticFactory = SingletonStaticFactory.getInstance();
    singletonStaticFactory.leaveTheBuilding();
  }
}
