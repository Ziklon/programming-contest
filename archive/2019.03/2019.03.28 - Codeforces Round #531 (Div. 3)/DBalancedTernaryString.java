package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.LinkedList;
import java.util.Queue;

public class DBalancedTernaryString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int counter[] = new int[3];
    int n = in.readInt();
    int at = n / 3;
    char[] s = in.readString().toCharArray();

    for (char c : s) counter[c - '0']++;

    int low = 0, hih = n - 1;

    while (true) {

      boolean hasFinish = true;
      for (int e : counter) if (e != at) hasFinish = false;
      if (hasFinish) break;
    }

    out.printLine(new String(s));
  }
}
