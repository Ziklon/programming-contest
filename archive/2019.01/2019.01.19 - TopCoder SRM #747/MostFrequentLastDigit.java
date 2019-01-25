package com.darkbit.problems;

public class MostFrequentLastDigit {
  public int[] generate(int n, int d) {

    int[] ans = new int[n];
    for (int x = 1; x < 10; ++x) {
      for (int y = x + 1; y < 10; ++y) {
        if ((x + y) % 10 == d ) {
          for (int i = 0; i < n; ++i)
            ans[i] = i * 10 + (i % 2 == 1 ? x : y);
        }
      }
    }
    return ans;
  }
}
