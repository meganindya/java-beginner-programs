# Dynamic Programming

Total: **91**

## Patterns

### Minimum (Maximum) Path to Reach a Target

Total: **17**

**Statement:** Given a target find minimum (maximum) cost/path to reach the target.

**Approach:** Choose minimum (maximum) path among all possible paths before the current state, then add value for the current state.

```cpp
routes[i] = min(routes[i-1], routes[i-2], ... , routes[i-k]) + cost[i]
```

Generate optimal solutions for all values in the target and return the value for the target.

```cpp
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] = min(dp[i], dp[i - ways[j]] + cost / path / sum);
       }
   }
}

return dp[target];
```

- **`(E)`** [LeetCode 746 - Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)
- **`(E)`** [LeetCode 53 - Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- **`(M)`** [LeetCode 64 - Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
- **`(M)`** [LeetCode 322 - Coin Change](https://leetcode.com/problems/coin-change/)
- **`(M)`** [LeetCode 931 - Minimum Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/)
- **`(M)`** [LeetCode 983 - Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)
- **`(M)`** [LeetCode 650 - 2 Keys Keyboard](https://leetcode.com/problems/2-keys-keyboard/)
- **`(M)`** [LeetCode 279 - Perfect Squares](https://leetcode.com/problems/perfect-squares/)
- **`(M)`** [LeetCode 1049 - Last Weighed Stone II](https://leetcode.com/problems/last-stone-weight-ii/)
- **`(M)`** [LeetCode 120 - Traingle](https://leetcode.com/problems/triangle/)
- **`(M)`** [LeetCode 474 - Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/)
- **`(M)`** [LeetCode 221 - Maximal Squares](https://leetcode.com/problems/maximal-square/)
- **`(M)`** [LeetCode 152 - Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
- **`(H)`** [LeetCode 85 - Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)
- **`(H)`** [LeetCode 1240 - Tiling a Rectangle with the Fewest Squares](https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/)
- **`(H)`** [LeetCode 174 - Dungeon Game](https://leetcode.com/problems/dungeon-game/)
- **`(H)`** [LeetCode 871 - Minimum Number of Refuelling Stops](https://leetcode.com/problems/minimum-number-of-refueling-stops/)

### Distinct Ways

Total: **17**

**Statement:** Given a target find a number of distinct ways to reach the target.

**Approach:** Sum all possible ways to reach the current state.

```cpp
routes[i] = routes[i-1] + routes[i-2], ... , + routes[i-k]
```

Generate sum for all values in the target and return the value for the target.

```cpp
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] += dp[i - ways[j]];
       }
   }
}

return dp[target];
```

- **`(E)`** [LeetCode 70 - Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
- **`(M)`** [LeetCode 62 - Unique Paths](https://leetcode.com/problems/unique-paths/)
- **`(M)`** [LeetCode 1155 - Number of Dice Rolls With Target Sum](https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/)
- **`(M)`** [LeetCode 688 - Knight Probability in Chessboard](https://leetcode.com/problems/knight-probability-in-chessboard/)
- **`(M)`** [LeetCode 494 - Target Sum](https://leetcode.com/problems/target-sum/)
- **`(M)`** [LeetCode 377 - Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/)
- **`(M)`** [LeetCode 935 - Knight Dialer](https://leetcode.com/problems/knight-dialer/)
- **`(M)`** [LeetCode 416 - Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
- **`(M)`** [LeetCode 808 - Soup Servings](https://leetcode.com/problems/soup-servings/)
- **`(M)`** [LeetCode 790 - Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/)
- **`(M)`** [LeetCode 801 - Minimum Swaps To Make Sequences Increasing](https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/)
- **`(M)`** [LeetCode 673 - Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
- **`(M)`** [LeetCode 63 - Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)
- **`(M)`** [LeetCode 576 - Out of Boundary Paths](https://leetcode.com/problems/out-of-boundary-paths/)
- **`(H)`** [LeetCode 1269 - Number of Ways to Stay in the Same Place After Some Steps](https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/)
- **`(H)`** [LeetCode 1220 - Count Vowels Permutation](https://leetcode.com/problems/count-vowels-permutation/)
- **`(H)`** [LeetCode 1223 - Dice Roll Simulation](https://leetcode.com/problems/dice-roll-simulation/)

### Merging Intervals

Total: **7**

**Statement:** Given a set of numbers find an optimal solution for a problem considering the current number and the best you can get from the left and right sides.

**Approach:** Find all optimal solutions for every interval and return the best possible answer.

```cpp
// from i to j
dp[i][j] = dp[i][k] + result[k] + dp[k+1][j]
```

Get the best from the left and right sides and add a solution for the current position.

```cpp
for(int l = 1; l<n; l++) {
   for(int i = 0; i<n-l; i++) {
       int j = i+l;
       for(int k = i; k<j; k++) {
           dp[i][j] = max(dp[i][j], dp[i][k] + result[k] + dp[k+1][j]);
       }
   }
}
 
return dp[0][n-1];
```

- **`(M)`** [LeetCode 1130 - Minimum Cost Tree From Leaf Values](https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/)
- **`(M)`** [LeetCode 96 - Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)
- **`(M)`** [LeetCode 1039 - Minimum Score Triangulation of Polygon](https://leetcode.com/problems/minimum-score-triangulation-of-polygon/)
- **`(M)`** [LeetCode 375 - Guess Number Higher or Lower II](https://leetcode.com/problems/guess-number-higher-or-lower-ii/)
- **`(H)`** [LeetCode 546 - Remove Boxes](https://leetcode.com/problems/remove-boxes/)
- **`(H)`** [LeetCode 1000 - Minimum Cost to Merge Stones](https://leetcode.com/problems/minimum-cost-to-merge-stones/)
- **`(H)`** [LeetCode 312 - Burst Balloons](https://leetcode.com/problems/burst-balloons/)

### DP on Strings

Total: **13**

**Statement:** Given two strings where lengths of those strings are not big, return some result.

**Approach:** Most of the problems on this pattern requires a solution that can be accepted in O(n^2) complexity.

```cpp
// i - indexing string s1
// j - indexing string s2
for (int i = 1; i <= n; ++i) {
   for (int j = 1; j <= m; ++j) {
       if (s1[i-1] == s2[j-1]) {
           dp[i][j] = /*code*/;
       } else {
           dp[i][j] = /*code*/;
       }
   }
}
```

If you are given one string `s` the approach may vary a little.

```cpp
for (int l = 1; l < n; ++l) {
   for (int i = 0; i < n-l; ++i) {
       int j = i + l;
       if (s[i] == s[j]) {
           dp[i][j] = /*code*/;
       } else {
           dp[i][j] = /*code*/;
       }
   }
}
```

- **`(M)`** [LeetCode 1143 - Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
- **`(M)`** [LeetCode 647 - Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
- **`(M)`** [LeetCode 516 - Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
- **`(M)`** [LeetCode 712 - Minimum ASCII Delete Sum for Two Strings](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/)
- **`(M)`** [LeetCode 5 - Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
- **`(M)`** [LeetCode 131 - Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)
- **`(M)`** [LeetCode 300 - Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
- **`(M)`** [LeetCode 139 - Word Break](https://leetcode.com/problems/word-break/)
- **`(H)`** [LeetCode 1092 - Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/)
- **`(H)`** [LeetCode 32 - Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
- **`(H)`** [LeetCode 72 - Edit Distance](https://leetcode.com/problems/edit-distance/)
- **`(H)`** [LeetCode 115 - Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)
- **`(H)`** [LeetCode 140 - Word Break II](https://leetcode.com/problems/word-break-ii/)

### Decision Making

Total: **7**

**Statement:** Given a set of values find an answer with an option to choose or ignore the current value.

**Approach:** If you decide to choose the current value use the previous result where the value was ignored; vice-versa, if you decide to ignore the current value use previous result where value was used.

```cpp
// i - indexing a set of values
// j - options to ignore j values
for (int i = 1; i < n; ++i) {
   for (int j = 1; j <= k; ++j) {
       dp[i][j] = max({dp[i][j], dp[i-1][j] + arr[i], dp[i-1][j-1]});
       dp[i][j-1] = max({dp[i][j-1], dp[i-1][j-1] + arr[i], arr[i]});
   }
}
```

- **`(E)`** [LeetCode 121 - Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- **`(M)`** [LeetCode 198 - House Robber](https://leetcode.com/problems/house-robber/)
- **`(M)`** [LeetCode 337 - House Robber III](https://leetcode.com/problems/house-robber-iii/)
- **`(M)`** [LeetCode 714 - Best Time to Buy and Sell Stock with Transaction Fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
- **`(M)`** [LeetCode 309 - Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
- **`(H)`** [LeetCode 123 - Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
- **`(H)`** [LeetCode 188 - Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

### Miscellaneous

Total: **5**

- **`(M)`** [LeetCode 338 - Counting Bits](https://leetcode.com/problems/counting-bits/)
- **`(M)`** [LeetCode 91 - Decode Ways](https://leetcode.com/problems/decode-ways/)
- **`(H)`** [LeetCode 42 - Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
- **`(H)`** [LeetCode 10 - Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)
- **`(H)`** [LeetCode 44 - Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)

## Unclassified

Total: **25**

- **`(E)`** [GFG - Minimum cost to reach a point N from 0 with two different operations allowed](https://www.geeksforgeeks.org/minimum-cost-to-reach-a-point-n-from-0-with-two-different-operations-allowed/)
- **`(E)`** [GFG - Count number of ways to cover a distance](https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/)
- **`(M)`** [AlgoExpert - Max Subset Sum No Adjacent](https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/)
- **`(M)`** [AlgoExpert - Number of Ways to Make Change](https://leetcode.com/problems/coin-change-2/)
- **`(M)`** [AlgoExpert - Min Number of Ways for Change](https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/)
- **`(M)`** [AlgoExpert - Maximum Sum Increase Subsequence](https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/)
- **`(M)`** [AlgoExpert - Minimum Number of Jumps to Reach End](https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/)
- **`(M)`** [AlgoExpert - Water Area](https://leetcode.com/problems/container-with-most-water/)
- **`(M)`** [AlgoExpert - 0-1 Knapsack Problem](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
- **`(M)`** [AlgoExpert - Longest String Chain](https://leetcode.com/problems/longest-string-chain/)
- **`(M)`** [GFG - Maximum Length Chain of Pairs](https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/)
- **`(M)`** [GFG - Find the longest path in a matrix with given constraints](https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/)
- **`(M)`** [GFG - Count number of binary strings without consecutive 1’s](https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/)
- **`(M)`** [GFG - Maximum Tip Calculator](https://stackoverflow.com/questions/48245860/maximum-tip-calculator-naive-solution)
- **`(M)`** [GFG - Longest Bitonic Subsequence](https://leetcode.com/problems/wiggle-subsequence/)
- **`(H)`** [AlgoExpert - Disk Stacking](https://www.geeksforgeeks.org/box-stacking-problem-dp-22/)
- **`(H)`** [AlgoExpert - Numbers in Pi](https://leetcode.com/problems/numbers-at-most-n-given-digit-set/)
- **`(H)`** [AlgoExpert - Palindrome Partitioning Minimum Cuts](https://leetcode.com/problems/palindrome-partitioning-ii/)
- **`(H)`** [GFG - Partition a set into two subsets such that the difference of subset sums is minimum](https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/)
- **`(H)`** [GFG - Optimal Strategy for a Game](https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/)
- **`(H)`** [GFG - Find amount of water in a given glass](https://www.geeksforgeeks.org/find-water-in-a-glass/)
- **`(H)`** [GFG - Interleaving String](https://leetcode.com/problems/interleaving-string/)
- **`(H)`** [GFG - Matrix Chain Multiplication](https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/)
- **`(H)`** [GFG - 4 Keys Keyboard](https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/)
- **`(X)`** [GFG - Minimize operations required to obtain N](https://www.geeksforgeeks.org/minimize-operations-required-to-obtain-n/)
