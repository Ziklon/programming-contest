package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;
import net.egork.numbers.IntegerUtils;

public class NewYearChaos {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int u = 0; u < t; ++u) {
      int n = in.readInt();
      int seq[] = new int[n];
      for (int i = 0; i < n; ++i) seq[i] = in.readInt();

      int sum = 0;
      boolean isThereSol = true;
      for (int i = n-1; i >=0; --i) {
        if (seq[i] != i + 1) {

            if(i -1 >=0 && seq[i-1] == i+1){
                sum++;
                
            }

        }
      }

      if (!isThereSol) {
        out.printLine("Too chaotic");
      } else {
        out.printLine(3);
      }
    }
  }
}
