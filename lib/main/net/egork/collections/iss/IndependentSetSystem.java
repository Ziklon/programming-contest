package net.egork.collections.iss;

/** @author Egor Kulikov (kulikov@devexperts.com) */
public interface IndependentSetSystem {
  boolean join(int first, int second);

  int get(int index);

  int getSetCount();

  void setListener(Listener listener);

  interface Listener {
    void joined(int joinedRoot, int root);
  }
}
