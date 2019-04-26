package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class QualificationRound2019GoogleCodeJam2019 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readString();

    StringBuilder sa = new StringBuilder();
    StringBuilder sb = new StringBuilder();

    int a = 0, b = 0;

    for(int i =0; i <s)

    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '4') {
        sa.append("3");
        sb.append("1");
      } else {
        sa.append(s.charAt(i));
        sb.append("0");
      }
    }
    s = sb.toString();
    sb.setLength(0);
    for (int i = 0; i < s.length(); ++i)
      if (s.charAt(i) != '0') {
        sb.append(s.substring(i));
        break;
      }

    if (sb.length() == 0) sb.append("0");
    out.printLine(String.format("Case #%d: %s %s", testNumber, sa.toString(), sb.toString()));
  }
}
