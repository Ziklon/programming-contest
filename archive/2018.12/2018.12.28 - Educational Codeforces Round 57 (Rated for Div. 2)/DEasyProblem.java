package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class DEasyProblem {

  char[] s;
  int[] seq;
  final String hard = "hard";
  long[][] dp;

  long go(int idx, int pos) {
    if (idx >= hard.length()) return 1L << 45;
    if (pos >= s.length) return 0;

    if (dp[idx][pos] == -1) {

      long ans = 1L << 45;
      if (s[pos] != hard.charAt(idx)) ans =  go(idx, pos + 1);
      else {
        ans = Math.min(go(idx + 1, pos + 1), go(idx, pos + 1) + seq[pos]);
      }
      dp[idx][pos] = ans;
      return ans;
    }
    return dp[idx][pos];
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    s = in.readString().toCharArray();
    seq = new int[n];
    dp = new long[4][n];
    ArrayUtils.fill(dp, -1);
    for (int i = 0; i < n; ++i) seq[i] = in.readInt();

    out.printLine(go(0, 0));
  }
}
