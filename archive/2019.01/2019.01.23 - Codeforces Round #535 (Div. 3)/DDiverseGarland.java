package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.List;

public class DDiverseGarland {

  char getChar(char a, char b) {
    String s = "RGB";
    String t = a + "" + b;
    for (char c : s.toCharArray()) if (t.indexOf(c) == -1) return c;
    return 'R';
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    char[] s = in.readLine().toCharArray();

    int ans = 0;
    for (int i = 1; i < n; ++i) {
      if (s[i] == s[i - 1]) {
        char next = i + 1 < n ? s[i + 1] : '$';
        s[i] = getChar(s[i], next);
        ans++;
      }
    }
    out.printLine(ans);
    out.printLine(new String(s));
  }
}
