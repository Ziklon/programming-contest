package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class FormingAMagicSquare {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] m = new int[9];
    int[] g = new int[9];
    for (int i = 0; i < 9; ++i) g[i] = in.readInt();
    for (int i = 0; i < 9; ++i) m[i] = i + 1;
    int ans = 1 << 20;
    do {

      if (check(m)) {
        int sum = 0;
        for (int i = 0; i < 9; ++i) sum += Math.abs(m[i] - g[i]);
        ans = Math.min(ans, sum);
      }
    } while (ArrayUtils.nextPermutation(m));

    out.printLine(ans);
  }

  int sum(int[] m, int from, int to, int inc) {
    int sum = 0;
    for (int i = from; i < to; i += inc) sum += m[i];
    return sum;
  }

  boolean check(int[] m) {
    int s1 = sum(m, 0, 3, 1);
    int s2 = sum(m, 3, 6, 1);
    int s3 = sum(m, 6, 9, 1);
    if (s1 != s2 || s3 != s1) return false;

    if (sum(m, 0, 9, 3) != sum(m, 1, 9, 3)) return false;
    if (sum(m, 0, 9, 3) != sum(m, 2, 9, 3)) return false;
    if (m[0] + m[8] != m[2] + m[6]) return false;

    return true;
  }
}
