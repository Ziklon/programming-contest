package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CShawarmaTent {
    static int MAXP = (int) 1e9;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), sx = in.readInt(), sy = in.readInt();

        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < n; ++i) points.add(new int[]{in.readInt(), in.readInt()});

        int maxi = 0;
        int[] point = new int[]{0, 0};

        for (int xi = -1; xi <= 1; ++xi) {
            for (int yi = -1; yi <= 1; ++yi) {
                if (Math.abs(xi + yi) < 1 && Math.abs(xi - yi) >= 2) continue;

                int[] s = new int[]{sx + xi, sy + yi};

                for (int e : s) if (e < 0 || e > MAXP) continue;

                int cnt = 0;

                for (int[] p : points) {
                    int d1 = Math.abs(sx - p[0]) + Math.abs(sy - p[1]);
                    int d2 = Math.abs(s[0] - p[0]) + Math.abs(s[1] - p[1]);
                    if (d2 + 1 == d1) {
                        cnt++;
                    }
                }
                if (cnt >= maxi) {
                    point = s;
                    maxi = cnt;
                }
            }
        }
        out.printLine(maxi);
        out.printLine(point);


    }
}
