package alex.com.challenges

/**
 * Created by Alex Doub on 1/8/2020.
 * https://leetcode.com/problems/jump-game/
 */

class JumpGame {
    companion object {
        fun canJump(nums: IntArray): Boolean {

            val reachable = BooleanArray(nums.size)
            var lastReachable = 0
            reachable[0] = true
            reachable.forEachIndexed { index, x ->
                if (index > lastReachable) {
                    println("Past last reachable. index:$index lr:$lastReachable")
                    return false
                }

                if (x) {
                    val newIndex = nums[index] + index
                    reachable.fill(true, index, Math.min(newIndex + 1, reachable.size))
                    lastReachable = Math.max(newIndex, lastReachable)
                    println("Reached from $index to $newIndex")
                    println("Reachability: ${reachable.joinToString()}")
                } else {
                    println("Index $index isn't reachable. skipping")
                }
            }
            return true
        }
    }
}

//1) Fill is (value, start index inclusive, end index EXCLUSIVE)