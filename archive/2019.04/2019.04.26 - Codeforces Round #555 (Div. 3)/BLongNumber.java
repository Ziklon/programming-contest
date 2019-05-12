package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BLongNumber {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    char[] s = in.readString().toCharArray();

    int f[] = in.readIntArray(9);
    boolean found = false;
    for (int i = 0; i < n && !found; ++i) {
      int d = s[i] - '0';
      int di = f[d - 1];
      if (di > d) {
        found = true;
        s[i] = (char) (di + '0');
        for (int j = i + 1; j < n; ++j) {
          int x = s[j] - '0';
          if (x <= f[x - 1]) {
            s[j] = (char) ('0' + f[x - 1]);
          } else break;
        }
      }
    }
    out.printLine(new String(s));
  }
}
