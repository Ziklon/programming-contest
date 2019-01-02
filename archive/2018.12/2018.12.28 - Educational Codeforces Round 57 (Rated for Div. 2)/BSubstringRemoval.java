package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BSubstringRemoval {
  final int MOD = 998244353;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    char[] s = (in.readString() + "$").toCharArray();
    long ans = 0;

    List<Integer> sets = new ArrayList<>();

    char last = s[0];
    int counter = 1;
    for (int i = 1; i < s.length; ++i) {
      if (s[i] == last) {
        counter++;
      } else {
        sets.add(counter);
        counter = 1;
        last = s[i];
      }
    }

    ans = (ans + sets.get(0))% MOD;
    ans = (ans + sets.get(sets.size() - 1)) % MOD;

    if (sets.size() >= 3 && s[0] == s[s.length - 2]) {
      ans += (sets.get(0) * 1L * sets.get(sets.size() - 1)) % MOD;
    }
    out.printLine((ans+1)%MOD);
  }
}
