package com.darkbit.problems;

import net.egork.collections.map.TreeCounter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int[] seq = in.readIntArray(n);

        TreeCounter<Integer> counter = new TreeCounter<>();
        for (int e : seq) counter.add(e);


        long x = 1;

        for (Integer key : counter.keySet()) {
            x = IntegerUtils.lcm(x, IntegerUtils.lcm(key, counter.get(key)));
        }
        for (; ; ++x) {
            boolean found = true;
            for (Integer key : counter.keySet()) {
                long val = counter.get(key) * x;
                if (val % key != 0) {
                    found = false;
                    break;
                }
            }
            if (found) break;
        }
        long sum = 0;
        long many = 0;
        for (Integer key : counter.keySet()) {
            sum += counter.get(key) * x;
            many += (counter.get(key) * x) / key;
        }
        long gcd = IntegerUtils.gcd(sum, many);

        sum /= gcd;
        many /= gcd;
        out.printLine(String.format("Case #%d: %d/%d", testNumber, sum, many));
    }
}
