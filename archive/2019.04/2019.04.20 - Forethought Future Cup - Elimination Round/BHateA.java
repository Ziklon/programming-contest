package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BHateA {

  boolean validate(String s1, String s2) {

    int a = 0;
    int b = 0;
    while (true) {
      if (a >= s1.length()) break;
      if (b >= s2.length()) break;

      if (s1.charAt(a) == 'a') {
        a++;
        continue;
      }
      if (s1.charAt(a) != s2.charAt(b)) return false;
      a++;
      b++;
    }
    return true;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    String s = in.readString();

    int[] counter = new int[26];

    for (char c : s.toCharArray()) counter[c - 'a']++;

    int[] counter2 = new int[26];

    for (int i = 0; i < s.length(); ++i) {
      counter2[s.charAt(i) - 'a']++;
      boolean ok = counter2[0] == counter[0];
      for (int j = 1; j < 26; ++j) if (counter2[j] * 2 != counter[j]) ok = false;

      if (ok) {
        String s1 = s.substring(0, i + 1);
        String s2 = s.substring(i + 1);

        if (!validate(s1, s2)) continue;

        out.printLine(s.substring(0, i + 1));
        return;
      }
    }
    out.printLine(":(");
  }
}
