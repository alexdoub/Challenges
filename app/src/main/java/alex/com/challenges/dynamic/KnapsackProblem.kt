package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 4/1/2020.
 * https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
 */

object KnapsackProblem {
    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    fun knapsack_recursive(maxWeight: Int, wt: IntArray, values: IntArray, n: Int): Int {
        // Base Case
        if (n == 0 || maxWeight == 0) return 0

        // If weight of the nth item is more
        // than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        return if (wt[n - 1] > maxWeight) knapsack_recursive(maxWeight, wt, values, n - 1)
        else Math.max(
            values[n - 1] + knapsack_recursive(maxWeight - wt[n - 1], wt, values, n - 1),
            knapsack_recursive(maxWeight, wt, values, n - 1)
        )
    }


    fun knapsack_dynamic(maxWeight: Int, weights: IntArray, values: IntArray, numberOfItems: Int): Int {
        val dp = Array(numberOfItems + 1) { IntArray(maxWeight + 1) }

        // Build table K[][] in bottom up manner
        for (i in 0..numberOfItems) {
            dp[i][0] = 0
            for (w in 1..maxWeight) {
                if (i == 0 || w == 0)
                else if (weights[i - 1] <= w) dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
                else dp[i][w] = dp[i - 1][w]
            }
        }
        return dp[numberOfItems][maxWeight]
    }

}