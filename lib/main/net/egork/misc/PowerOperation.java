package net.egork.misc;

/** @author Egor Kulikov (kulikov@devexperts.com) */
public interface PowerOperation<V> extends Operation<V> {
  V power(V base, int exponent);
}
