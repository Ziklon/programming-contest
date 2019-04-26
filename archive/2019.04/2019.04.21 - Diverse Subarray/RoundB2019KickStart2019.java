package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundB2019KickStart2019 {

  static class Stone {
    int s, e, l;

    public Stone(int[] arr) {
      this.s = arr[0];
      this.e = arr[1];
      this.l = arr[2];
    }
  }

  List<Stone> stones;

  int[][] dp;

  int func(int idx, int time) {
    if (idx >= stones.size()) return 0;

    if (dp[idx][time] != -1) return dp[idx][time];

    int ans = func(idx + 1, time);

    Stone stone = stones.get(idx);

    int life = Math.max(0, stone.e - (stone.l * time));
    ans = Math.max(ans, func(idx + 1, time + stone.s) + life);
    dp[idx][time] = ans;
    return ans;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    stones = new ArrayList<>();

    for (int i = 0; i < n; ++i) stones.add(new Stone(in.readIntArray(3)));
    Collections.sort(stones, (p, q) -> {


      q.l - p.l
    });
    dp = new int[n][10005];

    ArrayUtils.fill(dp, -1);

    out.printLine(String.format("Case #%d: %d", testNumber, func(0, 0)));
  }
}
