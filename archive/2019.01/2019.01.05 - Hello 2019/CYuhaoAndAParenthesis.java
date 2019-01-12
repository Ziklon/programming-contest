package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CYuhaoAndAParenthesis {

  final int INF = 1 << 30;

  int counters(String s) {
    int needOpen = 0;
    int needClose = 0;
    for (int j = 0; j < s.length(); ++j) {
      if (s.charAt(j) == '(') {
        needClose++;
      } else {
        needClose--;
        if (needClose < 0) {
          needClose = 0;
          needOpen++;
        }
      }
    }
    if (needClose > 0 && needOpen > 0) return INF;
    if (needClose > 0) return needClose;
    return -1 * needOpen;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    Map<Integer, Integer> map = new HashMap<>();
    List<String> items = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      String s = in.readString();
      int counter = counters(s);
      if (counter != INF) {
        map.put(counter, map.getOrDefault(counter, 0) + 1);
      }
    }
    int ans = map.getOrDefault(0, 0) / 2;

    for (int key : map.keySet()) {
      if (key < 0) {
        ans += Math.min(map.getOrDefault(key, 0), map.getOrDefault(-key, 0));
      }
    }
    out.printLine(ans);
  }
}
