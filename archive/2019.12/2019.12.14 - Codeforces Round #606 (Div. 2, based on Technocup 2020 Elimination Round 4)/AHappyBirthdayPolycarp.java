package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class AHappyBirthdayPolycarp {

    List<Long> years = new ArrayList<>();
    static int MAX = (int) (1e9 + 7);


    void dfs(long e, int d) {
        if (e >= MAX) return;
        years.add(e);
        dfs((e * 10) + d, d);
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        for (int i = 1; i < 10; ++i) dfs(i, i);

        int n = in.readInt();
        for (int i = 0; i < n; ++i) {

            int y = in.readInt();
            int ans = 0;
            for (long e : years) {
                if (e <= y) ans++;
            }
            out.printLine(ans);
        }
    }
}
