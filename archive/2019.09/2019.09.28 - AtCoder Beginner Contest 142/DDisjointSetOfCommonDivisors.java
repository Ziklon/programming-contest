package com.darkbit.problems;

import net.egork.generated.collections.list.LongArrayList;
import net.egork.generated.collections.list.LongList;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.HashSet;
import java.util.TreeSet;

public class DDisjointSetOfCommonDivisors {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long a = in.readLong(), b = in.readLong();

        TreeSet<Long> divisors = new TreeSet<>();

        for (long e = 1; e * e <= Math.max(a, b); ++e) {
            if (a % e == 0 && b % e == 0) {
                divisors.add(e);
                long x = a / e;
                long y = b / e;
                if (b % x == 0) divisors.add(x);
                if (a % y == 0) divisors.add(y);
            } else if (a % e == 0) {
                long x = a / e;
                if (b % x == 0) divisors.add(x);
            } else if (b % e == 0) {
                long y = b / e;
                if (a % y == 0) divisors.add(y);
            }
        }

        LongList longList = new LongArrayList();
        for (long e : divisors) longList.add(e);

        boolean seen[] = new boolean[longList.size()];

        for (int i = 1; i < seen.length; ++i) {
            for (int j = i + 1; j < seen.length; ++j) {
                if (longList.get(j) % longList.get(i) == 0) {
                    seen[j] = true;
                }
            }
        }

        out.printLine(ArrayUtils.count(seen, false));

    }
}
