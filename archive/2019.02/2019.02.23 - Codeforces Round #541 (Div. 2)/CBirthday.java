package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.LinkedList;

public class CBirthday {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int seq[] = in.readIntArray(n);
    seq = ArrayUtils.radixSort(seq);

    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
      int next = seq[n - i - 1];
      if ((i & 1) == 1) list.addFirst(next);
      else list.addLast(next);
    }

    out.printLine(list.toArray());
  }
}
