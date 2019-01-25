package net.egork.concurrency;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

/** @author egor@egork.net */
public interface Task {
  void read(InputReader in);

  void solve();

  void write(OutputWriter out, int testNumber);
}
