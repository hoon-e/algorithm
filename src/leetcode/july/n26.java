package leetcode.july;

import java.util.*;

public class n26 {
    public int addDigits(int num) {
        return (num == 0) ? 0 : 1 + ((num-1) % 9);
    }
}
