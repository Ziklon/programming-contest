package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DWalkingRobot {

  int ai;
  int b;

  void useBattery(int val, int a) {
    if (val == 1 && ai < a) ai = Math.min(ai + 1, a);
    b--;
  }

  void useAccum() {
    ai--;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    this.b = in.readInt();

    int a = in.readInt();

    int[] seq = in.readIntArray(n);

    int ans = 0;

    this.ai = a;

    for (int i = 0; i < n; ++i) {
      if (Math.max(this.b, ai) == 0) break;
      ans++;
      if (ai == 0) useBattery(seq[i], a);
      else if (this.b == 0) {
        useAccum();
      } else {
        if (seq[i] == 1 && ai < a) useBattery(seq[i], a);
        else useAccum();
      }
    }

    out.printLine(ans);
  }
}
