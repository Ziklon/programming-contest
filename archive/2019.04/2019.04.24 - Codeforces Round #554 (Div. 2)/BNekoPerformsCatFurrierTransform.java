package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BNekoPerformsCatFurrierTransform {

  boolean isFinish(int n) {
    int bc = Integer.bitCount(n);
    return n == (1 << bc) - 1;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int x = in.readInt();

    int who = 1;
    int steps = 0;
    List<Integer> list = new ArrayList<>();
    while (!isFinish(x)) {
      if (who == 1) {
        for (int i = 0; i <= 30; ++i) {
          if ((x & (1 << i)) > 0) {
            list.add(i);
            x = x ^ ((1 << i) - 1);
            break;
          }
        }
      } else x = x + 1;
      who ^= 1;
      steps++;
    }
    out.printLine(steps);
    out.printLine(list.toArray());
  }
}
