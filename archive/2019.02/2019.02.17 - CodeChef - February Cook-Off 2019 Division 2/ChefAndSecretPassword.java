package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.List;

public class ChefAndSecretPassword {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();

    for (int i = 0; i < t; ++i) {
      int n = in.readInt();
      String s = in.readString();
      int[] counter = new int[26];
      for (char c : s.toCharArray()) counter[c - 'a']++;

      if (counter[s.charAt(0) - 'a'] == 1) {
        out.printLine(s);
      } else {
        char c = s.charAt(0);
        int[] pointers = new int[counter[c - 'a']];
        int idx = 0;
        for (int j = 0; j < n; ++j) if (s.charAt(j) == c) pointers[idx++] = j;

        int len = 1;
        for (int cur = 1; ; ++cur) {
          boolean isOk = true;
          for (int j = 0; j < pointers.length; ++j) {
            int xi = pointers[0] + cur;
            int yi = pointers[j] + cur;
            if (yi >= n || s.charAt(xi) != s.charAt(yi)) isOk = false;
          }
          if (!isOk) break;
          len++;
        }
        out.printLine(s.substring(0, len));
      }
    }
  }
}
