package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BNonCoprimePartition {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    long totalSum = (n * (n + 1L)) >> 1;

    if (n <= 2) out.printLine("No");
    else {

      List<Integer> ans = new ArrayList<>();
      int choosed = -1;
      for (int i = 1; i <= n; ++i) {

        if (i > 1 && choosed == -1 && (totalSum - i) % i == 0) {
          choosed = i;
        } else ans.add(i);
      }
      if (choosed == -1) out.printLine("No");
      else {
        out.printLine("Yes");
        out.printLine(1, choosed);
        out.print(ans.size() + " ");
        out.printLine(ans.toArray());
      }
    }
  }
}
