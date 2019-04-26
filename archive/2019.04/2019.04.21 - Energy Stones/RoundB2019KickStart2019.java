package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class RoundB2019KickStart2019 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), q = in.readInt();

    char[] s = in.readString().toCharArray();

    int[][] counter = new int[n + 1][26];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < 26; ++j) {
        counter[i + 1][j] = counter[i][j];
        if (s[i] - 'A' == j) counter[i + 1][j] = counter[i][j] + 1;
      }
    }

    int ans = 0;
    for (int i = 0; i < q; ++i) {
      int x = in.readInt(), y = in.readInt();

      int odd = 0;
      for (int j = 0; j < 26; ++j) {
        int diff = counter[y][j] - counter[x - 1][j];
        if (diff % 2 == 1) odd++;
      }
      if (odd <= 1) ans++;
    }
    out.printLine(String.format("Case #%d: %d", testNumber, ans));
  }
}
