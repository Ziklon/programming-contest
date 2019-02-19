package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class ArtOfBalance {

  int calculateCost(int[] count, int n, int sizeGroup) {
    int groups = n / sizeGroup;

    if (groups > 26) return Integer.MAX_VALUE;

    int sum = 0;
    for (int i = 0; i < count.length; ++i) sum += count[i];

    int add = 0;
    for (int i = 0; i < groups; ++i) add += Math.min(sizeGroup, count[count.length - i - 1]);

    return sum - add;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int k = 0; k < t; ++k) {
      char[] s = in.readString().toCharArray();

      int[] count = new int[26];
      int n = s.length;
      for (char c : s) count[c - 'A']++;

      int ans = Integer.MAX_VALUE;
      Arrays.sort(count);

      for (int i = 1; i * i <= n; ++i) {
        if (n % i == 0) {
          ans = Math.min(ans, calculateCost(count, n, i));
          ans = Math.min(ans, calculateCost(count, n, n / i));
        }
      }
      out.printLine(ans);
    }
  }
}
