package com.darkbit.problems;

import net.egork.numbers.IntegerUtils;

public class SeventhPowers {

  public String reconstructA(int B) {

    long[] powers = new long[10];
    for (int i = 0; i < powers.length; ++i) powers[i] = IntegerUtils.power(i, 7);

    StringBuilder sb = new StringBuilder();

    for (int i = 9; i >= 1 && B > 0; i--) {
      while (B >= powers[i]) {
        B -= powers[i];
        sb.append(i);
      }
    }

    return sb.toString();
  }
}
