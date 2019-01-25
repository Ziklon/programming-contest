package net.egork.misc;

/** @author Egor Kulikov (kulikov@devexperts.com) */
public interface Operation<V> extends Factory<V> {
  V operation(V first, V second);
}
