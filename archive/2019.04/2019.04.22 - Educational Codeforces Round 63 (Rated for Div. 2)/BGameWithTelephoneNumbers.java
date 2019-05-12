package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BGameWithTelephoneNumbers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    char[] s = in.readString().toCharArray();

    int remainder = n - 11;
    int cnt = 0;
    for (int i = 0; i + 11 <= n; ++i) {
      if (s[i] == '8') cnt++;
    }

    //System.out.println(cnt);
    out.printLine(cnt * 2 > remainder ? "YES" : "NO");
  }
}
