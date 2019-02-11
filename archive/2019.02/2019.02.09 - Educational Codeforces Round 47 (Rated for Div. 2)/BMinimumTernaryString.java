package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BMinimumTernaryString {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    char[] s = in.readString().toCharArray();
    int as = ArrayUtils.count(s, '1');
    StringBuilder sb = new StringBuilder();
    for (char c : s) if (c != '1') sb.append(c);

    s = sb.toString().toCharArray();
    sb.setLength(0);

    int idx = 0;
    for (; idx < s.length && s[idx] == '0'; ++idx) sb.append(s[idx]);

    for (int i = 0; i < as; ++i) sb.append('1');
    for (; idx < s.length; ++idx) sb.append(s[idx]);

    out.printLine(sb);
  }
}
