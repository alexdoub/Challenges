package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 4/1/2020.
 * https://leetcode.com/problems/combination-sum-iii/
 */
object CombinationSumIII {

    // Blind Redo
    fun combinationSum3(k: Int, total: Int): List<List<Int>> {
        val sums = ArrayList<List<Int>>()

        fun buildSums(lastNum: Int, rem: Int, used: ArrayList<Int>) {

            if (rem == 0) {
                if (used.size == k) sums.add(used.toList())
                return
            }
            if (used.size == k) return

            for (n in lastNum+1..9) {

                // Dont branch past this, we're already over the limit
                if (rem-n < 0) break

                used.add(n)
                buildSums(n, rem-n, used)
                used.removeAt(used.lastIndex)
            }

        }
        buildSums(0, total, ArrayList())
        return sums
    }

    fun combinationSum3_simple(k: Int, total: Int): List<List<Int>> {
        val sums = ArrayList<List<Int>>()
        fun buildSums(lastNum: Int, rem: Int, used: List<Int>) {
            if (rem == 0 && used.size == k) sums.add(used)
            if (rem <= 0 || used.size >= k) return

            for (n in lastNum+1..9) {
                buildSums(n, rem-n, used+n)
            }
        }
        buildSums(0, total, emptyList())
        return sums
    }


//    //140ms, 32.5mb
//    //Optimizations:
//    //1 - prune early, stop branching if over sum
//    //2 - less list copies. use array list as 'in progress'
//    fun combinationSum3(numsAllowed: Int, targetSum: Int): List<List<Int>> {
//        val sums = ArrayList<List<Int>>()
//        fun getCombos(used: ArrayList<Int>, sum: Int) {
//
//            if (sum == targetSum && used.size == numsAllowed) sums.add(used.toList())
//            if (used.size >= numsAllowed) return
//
//            val lastUsed = if (used.isNotEmpty()) used.last() else 0
//            for (i in lastUsed+1..9) {
//                if ((sum + i) > targetSum) break    //early prune #1
//
//                used.add(i)
//                getCombos(used, sum + i)
//                used.removeAt(used.lastIndex)
//            }
//        }
//
//        getCombos(ArrayList(), 0)
//        return sums
//    }

//    //160ms 34.0mb
//    fun combinationSum3_simple(numsAllowed: Int, targetSum: Int): List<List<Int>> {
//        val sums = ArrayList<List<Int>>()
//        fun getCombos(used: List<Int>, sum: Int) {
//
//            if (sum == targetSum && used.size == numsAllowed) sums.add(used)
//            if (used.size > numsAllowed || sum >= targetSum) return
//
//            val lastUsed = if (used.isNotEmpty()) used.last() else 0
//            for (i in lastUsed+1..9) {
//                getCombos(used + i, sum + i)
//            }
//        }
//
//        getCombos(emptyList(), 0)
//        return sums
//    }
}