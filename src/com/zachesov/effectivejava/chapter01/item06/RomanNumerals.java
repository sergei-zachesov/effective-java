package com.zachesov.effectivejava.chapter01.item06;

import java.util.regex.Pattern;

/**
 * @author Zachesov Sergei
 * @since 8/21/2022
 */
public class RomanNumerals {

  // Performance can be greatly improved! (Page 22)
  static boolean isRomanNumeralSlow(String s) {
    return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
  }

  // Reusing expensive object for improved performance (Page 23)
  private static final Pattern ROMAN =
      Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

  static boolean isRomanNumeralFast(String s) {
    return ROMAN.matcher(s).matches();
  }

  public static void main(String[] args) {
    int numSets = Integer.parseInt(args[0]);
    int numReps = Integer.parseInt(args[1]);
    boolean b = false;

    for (int i = 0; i < numSets; i++) {
      long start = System.nanoTime();
      for (int j = 0; j < numReps; j++) {
        b ^= isRomanNumeralSlow("MCMLXXVI"); // Change Slow to Fast to see performance difference
      }
      long end = System.nanoTime();
      System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
    }

    // Prevents VM from optimizing away everything.
    if (!b) System.out.println();
  }
}
