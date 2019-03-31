package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class BNirvana {
  long cal(String s) {
    long ans = 1;
    for (int i = 0; i < s.length(); ++i) {
      ans *= s.charAt(i) - '0';
    }
    return ans;
  }

  String newString(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) sb.append('9');
    return sb.toString();
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.readLong();

    String s = n + "";
    long ans = cal(s);
    for (int i = 0; i < s.length(); ++i) {
      int len = s.length() - i - 1;
      if (len < s.length()) ans = Math.max(ans, cal(newString(len)));

      if (s.charAt(i) >= '2') {
        char c = (char) (s.charAt(i) - 1);
        String sa = s.substring(0, i) + new String(new char[] {c}) + newString(len);
        ans = Math.max(ans, cal(sa));
      }
    }

    out.printLine(ans);
  }
}
