package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class RepeatedString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readString();
    long n = in.readLong();
    int m = s.length();
    long ans = 0;

    int[] counter = new int[s.length() + 1];
    for (int i = 0; i < s.length(); ++i) {
      counter[i + 1] = counter[i];
      if (s.charAt(i) == 'a') counter[i + 1] += 1;
    }

    long times = n / m;
    ans += counter[s.length()] * times;

    ans += (counter[(int) (n % m)]);

    out.printLine(ans);
  }
}
