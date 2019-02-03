package com.darkbit.problems;

public class FightMonsterDiv2 {
  public long damageDealt(long attack, long level, long duration) {

    long ans = 0;
    long inc = (attack * level) / 100;
    for (int i = 0; i < duration; ++i) {
      ans += attack;
      attack += inc;
    }
    return ans;
  }
}
