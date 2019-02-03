package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CBrutality {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    int[] damages = in.readIntArray(n);
    String s = in.readString() + "$";
    long ans = 0;
    List<Integer> list = new ArrayList<>();
    char prev = '$';

    for (int i = 0; i < n + 1; ++i) {
      if (s.charAt(i) == prev) {
        list.add(damages[i]);
      } else {
        Collections.sort(list);
        Collections.reverse(list);
        for (int j = 0; j < Math.min(k, list.size()); ++j) ans += list.get(j);
        list.clear();
        if (i < damages.length) list.add(damages[i]);
        prev = s.charAt(i);
      }
    }

    out.printLine(ans);
  }
}
