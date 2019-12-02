package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/25/2019.
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Lessons learned: When doing a DP of this, an extra row/column were necessary
 * to safely mark a base case and have successive states propagate off of it
 */

class WildcardMatching {
    companion object {
        private fun debugPrint(string: String) {
            if (false) println(string)
        }

        fun isMatch(s: String, p: String): Boolean {
            return isMatch_DP(s, p)
        }

        fun isMatch_DP(s: String, p: String): Boolean {

            //Create 2d boolean array. s+1 wide, p+1 tall
            // A boolean at some row & column indicates that there is a match up to here
            // 0th row is empty pattern, 0th col is empty string!
            // 0,0 is the base case, build out from there
            val matches = Array(p.length + 1) {
                BooleanArray(s.length + 1) { false }
            }

            matches[0][0] = true

            // Enumerate vertically and fill rows
            (0..p.length).forEach { row ->

                // Enumerate horizontally & pull values
                (0..s.length).forEach { col ->

                    val inputChar = if (col == 0) null else s[col - 1]
                    val patternChar = if (row == 0) null else p[row - 1]

                    // Single match, propagate ahead
                    if (inputChar == patternChar || patternChar == '?') {

                        // On single match, propagate DIAGONALLY, from top left -> this
                        val topLeftMatches = row != 0 && col != 0 && matches[row - 1][col - 1]
                        if (topLeftMatches) {
                            matches[row][col] = true
                            debugPrint("Marked a match at $row,$col")
                        } else {
                            debugPrint("SKIPPED single match at $row,$col")
                        }

                    } else if (patternChar == '*') {
                        // On star, propagate DOWN OR RIGHT
                        val aboveMatches = if (row == 0) false else matches[row - 1][col]
                        val leftMatches = if (col == 0) false else matches[row][col - 1]
                        if (aboveMatches || leftMatches) {
                            matches[row][col] = true
                            debugPrint("Star match at $row,$col")
                        } else {
                            debugPrint("SKIPPED star match at $row,$col")
                        }
                    }
                }

                debugPrint("Finished filling out row #$row. ${matches[row].joinToString()}}")
                println()
            }

            // Base case testing
            // If input is empty string, only return true if pattern is wildcards
            if (s.length == 0 && p.replace("*", "").length == 0) {
                return true
            }

            return matches[p.length][s.length]
        }

        fun isMatch_SEARCH(s: String, p: String): Boolean {
            var pattern = p
            while (pattern.indexOf("**") >= 0) {
                pattern = pattern.replace("**", "*")
            }

            fun matchesFrom(initialInputPosition: Int, initialPatternPosition: Int): Boolean {

                debugPrint(
                    "Checking if matches from. InputPos:$initialInputPosition, PatternPos:$initialPatternPosition"
                )

                var patternPos = initialPatternPosition
                (initialInputPosition until s.length).forEach { position ->

                    debugPrint(
                        "...checking position:$position with patternPos:$patternPos"
                    )

                    if (patternPos == pattern.length) {
                        debugPrint(
                            "... ran out of pattern to match so obviously its not this"
                        )
                        return@matchesFrom false
                    }

                    // Single char match
                    if ((s[position] == pattern[patternPos] || pattern[patternPos] == '?')) {
                        debugPrint(
                            "Single char match at $position, $patternPos"
                        )
                        patternPos += 1
                    } else if (pattern[patternPos] == '*') {

                        debugPrint(
                            "Wildcard match at $position, $patternPos... seeing if substring matches"
                        )

                        //Loop substring matches
                        (position..s.length).reversed().forEach {
                            val remainingSubstringPasses = matchesFrom(it, patternPos + 1)
                            if (remainingSubstringPasses) {
                                return@matchesFrom true
                            }
                        }
                    } else {
                        debugPrint(
                            "Single char MISmatch at $position, $patternPos"
                        )
                        return@matchesFrom false
                    }
                }

                //If you reach the end of the input, verify remaining pattern is wildcards
                val remainingPattern = pattern.substring(patternPos)
                return remainingPattern.replace("*", "").length == 0
            }

            // Base case testing
            // If input is empty string, only return true if pattern is wildcards
            if (s.length == 0 && pattern.replace("*", "").length == 0) {
                return true
            }

            return matchesFrom(0, 0)
        }
    }
}