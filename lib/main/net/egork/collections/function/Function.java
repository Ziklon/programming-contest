package net.egork.collections.function;

/** @author Egor Kulikov (kulikov@devexperts.com) */
public interface Function<A, V> {
  V value(A argument);
}
