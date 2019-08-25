package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.string.StringUtils;

public class C2IncreasingSubsequenceHardVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int[] seq = in.readIntArray(n);

        int low = 0, hih = n - 1;

        StringBuilder sb = new StringBuilder();
        int current = 0;
        while (hih >= low) {
            int mini = Math.min(seq[low], seq[hih]);
            int max = Math.max(seq[low], seq[hih]);

            if (max <= current) break;
            if (low == hih) {
                sb.append("R");
                break;
            }
            int which = 0;

            if (max == mini) {
                int best1 = 0;
                int best2 = 0;
                int prev = current;

                for (int j = low; j <= hih; ++j) {
                    if (seq[j] <= prev) break;
                    prev = seq[j];
                    best1++;
                }
                prev = current;
                for (int j = hih; j >= low; --j) {
                    if (seq[j] <= prev) break;
                    prev = seq[j];
                    best2++;
                }
                if (best1 >= best2) {
                    sb.append(StringUtils.repeat('L', best1));
                } else {
                    sb.append(StringUtils.repeat('R', best2));
                }
                break;
            }
            if (current < mini) which = mini;
            else which = max;
            if (seq[low] == which) {
                sb.append("L");
                low++;
            } else {
                sb.append("R");
                hih--;
            }
            current = which;
        }

        out.printLine(sb.length());
        out.printLine(sb.toString());
    }
}
