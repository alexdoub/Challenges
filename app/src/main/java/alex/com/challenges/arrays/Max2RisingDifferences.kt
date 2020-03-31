package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/30/2020.
 */

object Max2RisingDifferences {



    // This FAILS because valleys could be combined
    // Loop and count valleys, keep top 2
    fun maxProfit_BAD(prices: IntArray): Int {
        val profits = ArrayList<Int>()

        var lowest = if (prices.isNotEmpty()) prices[0] else 0
        var last = lowest
        for (p in prices) {
            if (p < last) {
                val prof = last - lowest
                println("found decline at $p - saving profit $prof")
                profits.add(prof)
                lowest = p
            }
            last = p
        }

        //last iteration
        if (last > lowest) {
            val prof = last - lowest
            println("(extra) - saving profit $prof")
            profits.add(prof)
        }

        //2x o(n) loop to find the maxes
        var sum = 0
        profits.max()?.let {
            sum += it
            profits.remove(it)
        }
        profits.max()?.let {
            sum += it
            profits.remove(it)
        }
        return sum
    }
}