package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.MiscUtils;

import java.util.*;

public class ETwoTeams {

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), k = in.readInt();

    int[] seq = in.readIntArray(n);
    MiscUtils.decreaseByOne(seq);

    int[] index = new int[n];
    for (int i = 0; i < n; ++i) index[seq[i]] = i;

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; ++i) queue.add(index[n - i - 1]);

    TreeSet<Integer> heap = new TreeSet<>();
    for (int i = 0; i < n; ++i) heap.add(i);

    char[] ans = new char[n];
    Arrays.fill(ans, '0');

    int who = 0;
    while (!heap.isEmpty()) {

      while (!heap.contains(queue.peek())) queue.poll();

      int at = queue.poll();

      List<Integer> add = new ArrayList<>();
      add.add(at);
      Integer next = at;
      for (int i = 0; i < k; ++i) {
        next = heap.higher(next);
        if (next == null) break;
        add.add(next);
      }
      Integer prev = at;
      for (int i = 0; i < k; ++i) {
        prev = heap.lower(prev);
        if (prev == null) break;
        add.add(prev);
      }

      for (Integer id : add) {
        ans[id] = (char) ('1' + who);
        heap.remove(id);
      }

      who ^= 1;
    }
    out.printLine(new String(ans));
  }
}
