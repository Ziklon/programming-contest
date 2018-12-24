package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; ++i) {
      int sock = in.readInt();
      map.put(sock, map.getOrDefault(sock, 0) + 1);
    }

    int ans = 0;
    for (int value : map.values()) ans += value / 2;
    out.printLine(ans);
  }
}
