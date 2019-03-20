package com.darkbit.problems;

import net.egork.geometry.Point;
import net.egork.geometry.Polygon;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BVasyaAndCornfield {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), d = in.readInt(), m = in.readInt();

    Polygon polygon =
        new Polygon(new Point(0, d), new Point(d, 0), new Point(n, n - d), new Point(n - d, n));

    for (int i = 0; i < m; ++i) {
      Point p = new Point(in.readInt(), in.readInt());
      out.printLine(polygon.contains(p) ? "YES" : "NO");
    }
  }
}
