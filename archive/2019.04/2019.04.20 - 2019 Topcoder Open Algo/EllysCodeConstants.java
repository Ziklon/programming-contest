package com.darkbit.problems;

import java.util.HashMap;
import java.util.Map;

public class EllysCodeConstants {

  String[] ends = {"ULL", "LLU", "LL", "UL", "LU", "L", "U"};

  boolean isValid(char c) {
    return c >= '0' && c <= '9' || c >= 'A' && c <= 'F';
  }

  public String getLiteral(String candidate) {

    Map<Character, Character> map =
        new HashMap<Character, Character>() {
          {
            put('O', '0');
            put('I', '1');
            put('Z', '2');
            put('S', '5');
            put('T', '7');
          }
        };

    int len = 0;
    for (int i = 0; i < ends.length; ++i) {
      if (candidate.endsWith(ends[i])) {
        len = ends[i].length();
        break;
      }
    }

    if (len == candidate.length()) return "";

    char[] t = candidate.toCharArray();

    for (int i = 0; i + len < t.length; ++i) {
      if (isValid(t[i])) continue;
      if (map.containsKey(t[i])) {
        t[i] = map.get(t[i]);
        continue;
      }
      return "";
    }

    return "0x" + new String(t);
  }
}
