package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 12/31/2019.
 * https://leetcode.com/problems/container-with-most-water/
 */

class ContainerWithMostWater {
    companion object {
        fun maxArea_simple(height: IntArray): Int {

            //Try simple N^2 solution
            var max = 0
            height.forEachIndexed { i1, h1 ->
                height.forEachIndexed { i2, h2 ->
                    val thisMax = Math.abs(i1 - i2) * Math.min(h1, h2)
                    if (thisMax > max) {
                        max = thisMax
                    }
                }
            }
            return max
        }

        fun maxArea_slidingWindow(height: IntArray): Int {

            //Try sliding window
            //Still N^2 but better average cases
            var max = 0
            var left = 0
            var right = height.size - 1

            while (left < right) {
                val thisMax = (right - left) * Math.min(height[left], height[right])
                if (thisMax > max) {
                    max = thisMax
                }

                if (height[left] > height[right]) {
                    right -= 1
                } else {
                    left += 1
                }
            }

            return max
        }
    }
}