package com.darkbit.problems;

public class PokerRound {
  public int amount(int T) {

    for (int x = 0; x <= 10000; x++) {
      int y = 10000 - x;
      int a = x, b = y;
      for (int i = 0; i < 3; ++i) {
        int mini = Math.min(a, b);
        a += mini;
        b -= mini;
      }
      if (b == T) return y;
    }

    return -1;
  }
}
