package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BDreamoonAndWiFi {

  int ways = 0, pos1, valid = 0;
  char[] s;

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    String s1 = in.readString(), s2 = in.readString();

    pos1 = calculate(s1.toCharArray());

    s = s2.toCharArray();
    backTrack(0);

    double ans = (valid * 1.0) / ways;
    out.printLine(ans);
  }

  int calculate(char[] s) {
    int ans = 0;
    for (char c : s) {
      if (c == '+') ans++;
      else ans--;
    }
    return ans;
  }

  private void backTrack(int idx) {
    if (idx >= s.length) {
      if (calculate(this.s) == pos1) valid++;
      ways++;
    } else {
      if (s[idx] == '?') {
        s[idx] = '+';
        backTrack(idx + 1);
        s[idx] = '-';
        backTrack(idx + 1);
        s[idx] = '?';
      } else backTrack(idx + 1);
    }
  }
}
