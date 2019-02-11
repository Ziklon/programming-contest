package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class ATomRiddlesDiary {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();

    Set<String> hs = new HashSet<>();

    for (int i = 0; i < n; ++i) {
      String s = in.readString();
      if (hs.contains(s)) out.printLine("YES");
      else out.printLine("NO");
      hs.add(s);
    }
  }
}
