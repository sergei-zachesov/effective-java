package com.zachesov.effectivejava.chapter01.item02.hierarchicalbuilder;

/**
 * @author Zachesov Sergei
 * @since 8/16/2022
 */
public class Calzone extends Pizza {

  private final boolean sauceInside;

  public static class Builder extends Pizza.Builder<Builder> {
    private boolean sauceInside = false; // Default

    public Builder sauceInside() {
      sauceInside = true;
      return this;
    }

    @Override
    public Calzone build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private Calzone(Builder builder) {
    super(builder);
    sauceInside = builder.sauceInside;
  }

  @Override
  public String toString() {
    return String.format(
        "Calzone with %s and sauce on the %s", toppings, sauceInside ? "inside" : "outside");
  }
}
