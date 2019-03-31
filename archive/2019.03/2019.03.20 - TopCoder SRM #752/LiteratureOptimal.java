package com.darkbit.problems;

public class LiteratureOptimal {
  public int minTurns(int N, int[] Teja, int[] history) {
    int[] sure = new int[3 * N + 1];
    for (int i = 0; i < history.length; ++i) {
      if (i % 3 != 0) sure[history[i]] = i % 3;
    }
    for (int e : Teja) sure[e] = 0;
    int x = N, y = N;
    for (int e : sure) {
      if (e == 1) x--;
      else if (e == 2) y--;
    }
    int round = history.length;

    while (Math.min(x, y) > 0) {
      if (round % 3 == 1) x--;
      else if (round % 3 == 2) y--;
      round++;
    }

    return round - history.length;
  }
}
