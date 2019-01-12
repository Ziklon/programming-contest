package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CPostcard {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    char s[] = in.readString().toCharArray();
    int k = in.readInt();
    int type[] = new int[500];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length; ++i) {
      if (s[i] == '?') type[sb.length() - 1] = 1;
      else if (s[i] == '*') type[sb.length()-1] = 2;
      else sb.append(s[i]);
    }
    String ss = sb.toString();
    if (sb.length() == k) {
      out.printLine(sb);
    } else if (ss.length() < k) {
      sb.setLength(0);
      boolean found = false;
      for (int i = 0; i < ss.length(); ++i) {
        if (type[i] == 2 && !found) {
          sb.append(ss.charAt(i));
          found = true;
          for (int j = 0; j < (k- ss.length()); ++j)sb.append(ss.charAt(i));
        }else sb.append(ss.charAt(i));
      }
      out.printLine(sb.length() != k ? "Impossible" : sb.toString());
    } else {
      int needToRemove = ss.length() - k;
      sb.setLength(0);
      for (int i = 0; i < ss.length(); ++i) {
        if (needToRemove > 0 && type[i] != 0) {
          needToRemove--;
        } else sb.append(ss.charAt(i));
      }
      out.printLine(sb.length() != k ? "Impossible" : sb.toString());
    }
  }
}
