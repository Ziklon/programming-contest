package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D1EqualizingByDivisionEasyVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), k = in.readInt();
        int[] seq = in.readIntArray(n);

        List<Integer>[] counter = new List[1 << 20];

        for (int i = 0; i < counter.length; ++i) counter[i] = new ArrayList<>();


        for (int e : seq) {
            int t = 0;
            while (e > 0) {
                counter[e].add(t);
                e /= 2;
                t++;
            }
            counter[0].add(t);
        }
        int ans = Integer.MAX_VALUE;
        for (List<Integer> items : counter) {
            if (items.size() >= k) {
                Collections.sort(items);
                int sum = 0;
                for (int i = 0; i < k; ++i) sum += items.get(i);
                ans = Math.min(ans, sum);
            }
        }
        out.printLine(ans);

    }

}
