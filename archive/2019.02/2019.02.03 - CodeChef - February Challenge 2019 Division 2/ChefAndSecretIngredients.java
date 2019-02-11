package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ChefAndSecretIngredients {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int i = 0; i < t; ++i) {
      int n = in.readInt();
      int[] count = new int[26];
      for (int j = 0; j < n; ++j) {
        char[] s = in.readString().toCharArray();
        int[] tmp = new int[26];
        for (char c : s) tmp[c - 'a']++;

        for (int k = 0; k < tmp.length; ++k) if (tmp[k] > 0) count[k]++;
      }
      int ans = 0;
      for (int c : count) if (c == n) ans++;
      out.printLine(ans);
    }
  }
}
