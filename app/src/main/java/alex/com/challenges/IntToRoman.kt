package alex.com.challenges

/**
 * Created by Alex Doub on 12/31/2019.
 * https://leetcode.com/problems/integer-to-roman/
 */

class IntToRoman {
    companion object {
        fun intToRoman(num: Int): String {

            val builder = StringBuilder()
            var mutableNum = num

            while (mutableNum > 0) {
                when {
                    mutableNum >= 1000 -> {
                        builder.append("M")
                        mutableNum -= 1000
                    }
                    mutableNum >= 900 -> {
                        builder.append("CM")
                        mutableNum -= 900
                    }
                    mutableNum >= 500 -> {
                        builder.append("D")
                        mutableNum -= 500
                    }
                    mutableNum >= 400 -> {
                        builder.append("CD")
                        mutableNum -= 400
                    }
                    mutableNum >= 100 -> {
                        builder.append("C")
                        mutableNum -= 100
                    }
                    mutableNum >= 90 -> {
                        builder.append("XC")
                        mutableNum -= 90
                    }
                    mutableNum >= 50 -> {
                        builder.append("L")
                        mutableNum -= 50
                    }
                    mutableNum >= 40 -> {
                        builder.append("XL")
                        mutableNum -= 40
                    }
                    mutableNum >= 10 -> {
                        builder.append("X")
                        mutableNum -= 10
                    }
                    mutableNum >= 9 -> {
                        builder.append("IX")
                        mutableNum -= 9
                    }
                    mutableNum >= 5 -> {
                        builder.append("V")
                        mutableNum -= 5
                    }
                    mutableNum >= 4 -> {
                        builder.append("IV")
                        mutableNum -= 4
                    }
                    mutableNum >= 1 -> {
                        builder.append("I")
                        mutableNum -= 1
                    }
                }
            }

            return builder.toString()
        }
    }
}