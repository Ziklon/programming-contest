package com.darkbit.problems;

public class EllysAndXor {
  public int getMax(int[] numbers) {

    int ans = 0;
    int n = numbers.length;
    for (int mask = 0; mask < (1 << n); ++mask) {

      int ret = numbers[0];
      for (int i = 1; i < n; ++i) {
        if ((mask & (1 << i)) > 0) ret ^= numbers[i];
        else ret &= numbers[i];
      }
      ans = Math.max(ans, ret);
    }

    return ans;
  }
}
