package net.egork.collections.filter;

/** @author Egor Kulikov (kulikov@devexperts.com) */
public interface Filter<T> {
  boolean accept(T value);
}
