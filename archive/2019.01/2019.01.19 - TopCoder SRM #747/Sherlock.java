package com.darkbit.problems;

public class Sherlock {
  final String FN = "BENEDICT";
  final String LN = "CUMBERBATCH";

  public String isItHim(String firstName, String lastName) {

    if (Math.min(firstName.length(), lastName.length()) <= 6) return "It is someone else";

    if (!firstName.startsWith("B") || !lastName.startsWith("C")) return "It is someone else";

    if (count(firstName, FN) < 3 || count(lastName, LN) < 5) return "It is someone else";
    return "It is him";
  }

  int count(String s, String t) {
    int ans = 0;
    for (char c : s.toCharArray()) if (t.contains(c + "")) ans++;
    return ans;
  }
}
