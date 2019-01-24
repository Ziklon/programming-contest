package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class FancyQuotes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = Integer.parseInt(in.readLine());

    for (int i = 0; i < t; ++i) {
      String[] words = in.readLine().toLowerCase().split(" ");
      boolean found = false;
      for (String word : words) {
        if (word.equals("not")) found = true;
      }
      out.printLine(found ? "Real Fancy" : "regularly fancy");
    }
  }
}
