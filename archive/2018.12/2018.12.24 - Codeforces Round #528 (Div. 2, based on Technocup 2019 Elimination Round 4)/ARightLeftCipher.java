package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ARightLeftCipher {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readString();
    StringBuilder sb = new StringBuilder();

    if (s.length() % 2 == 1) {
      s = s + "$";
    }

    int low = 0, hih = s.length() - 1;

    while (hih > low) {
      sb.append(s.charAt(hih--));
      sb.append(s.charAt(low++));
    }
    s = sb.reverse().toString();
    for (char c : s.toCharArray()) if (c != '$') out.print(c);
  }
}
