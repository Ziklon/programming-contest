package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.*;

public class BObtainingTheString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    String s = in.readString();
    String t = in.readString();

    char[] sc = s.toCharArray();
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < sc.length; ++i) {
      if (sc[i] != t.charAt(i)) {
        boolean found = false;
        for (int j = i + 1; j < sc.length; ++j) {
          if (sc[j] == t.charAt(i)) {
            for (int k = j - 1; k >= i; --k) {
              swap(sc, k, k + 1);
              ans.add(k + 1);
            }
            found = true;
            break;
          }
        }
        if (!found) {
          out.printLine(-1);
          return;
        }
      }
    }
    out.printLine(ans.size());
    out.printLine(ans.toArray());
  }

  private void swap(char[] sc, int k, int i) {
    char tmp = sc[k];
    sc[k] = sc[i];
    sc[i] = tmp;
  }

  private int[] countChars(String s) {
    int[] counter = new int[26];
    for (char c : s.toCharArray()) counter[c - 'a']++;
    return counter;
  }
}
