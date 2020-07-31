package leetcode.july;

import java.util.*;

public class n29 {
    // TODO: 대박이다... 어떻게 생각하지...
    public int maxProfit(int[] prices) {
        int len=prices.length;

        if(len <= 1)
            return 0;

        // len이 2일 때에는 이전것이 더 클때가 가장 클때다
        if(len == 2 && prices[1] > prices[0])
            return prices[1]-prices[0];
        else if(len == 2 && prices[0] > prices[1])
            return 0;

        int[][] dp = new int[len][2];

        // 사지 않았을 경우
        dp[0][0] = 0;
        // 샀을 경우
        dp[0][1] = -prices[0];

        // 사지 않았을 때 다음의 경우는 사지 않거나, 팔았을 경우의 최댓값
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        // 샀을 경우는, 쿨타임을 갖거나
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for(int i=2; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }

        return dp[len-1][0];
    }
}
