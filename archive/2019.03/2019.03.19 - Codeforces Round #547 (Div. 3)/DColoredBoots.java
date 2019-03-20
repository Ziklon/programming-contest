package com.darkbit.problems;

import net.egork.collections.Pair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.*;

public class DColoredBoots {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    char[] s = in.readString().toCharArray();
    char[] t = in.readString().toCharArray();

    Queue<Integer> left[] = new Queue[1200];
    Queue<Integer> right[] = new Queue[1200];

    for (int i = 0; i < left.length; ++i) {
      left[i] = new LinkedList<>();
      right[i] = new LinkedList<>();
    }
    for (int i = 0; i < s.length; ++i) left[s[i]].add(i);
    for (int i = 0; i < t.length; ++i) right[t[i]].add(i);

    List<Pair<Integer, Integer>> ans = new ArrayList<>();
    for (int i = 0; i < left.length; ++i) {
      if (i == '?') continue;
      while (!left[i].isEmpty() && !right[i].isEmpty()) {
        ans.add(Pair.makePair(left[i].poll(), right[i].poll()));
      }
    }
    // check Left
    if (!left['?'].isEmpty()) {
      for (char c = 'a'; c <= 'z'; c++) {
        while (!left['?'].isEmpty() && !right[c].isEmpty()) {
          ans.add(Pair.makePair(left['?'].poll(), right[c].poll()));
        }
      }
    }

    // check right
    if (!right['?'].isEmpty()) {
      for (char c = 'a'; c <= 'z'; c++) {
        while (!left[c].isEmpty() && !right['?'].isEmpty()) {
          ans.add(Pair.makePair(left[c].poll(), right['?'].poll()));
        }
      }
    }
    while (!left['?'].isEmpty() && !right['?'].isEmpty()) {
      ans.add(Pair.makePair(left['?'].poll(), right['?'].poll()));
    }
    out.printLine(ans.size());
    for (Pair<Integer, Integer> p : ans) {
      out.printLine(p.first + 1, p.second + 1);
    }
  }
}
