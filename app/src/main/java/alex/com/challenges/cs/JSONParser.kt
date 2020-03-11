package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/5/2020.
 *
 * EDIT: TODO: Finish lolol
 */

object MyJSONParser {
    fun parseJson(string: String) : Map< String, Any> {
        val objectIndex = string.objectIndexPair()
        if (objectIndex != null) {
            return parseJsonObject(string.substring(objectIndex.first+1, objectIndex.second+1))
        }
        else return parseJsonObject(string)
    }

    fun parseJsonObject(string: String): Map<String, Any> {

        var string = string.replace("\t", "")
        string = string.replace("\n", "")
        string = string.replace(" ", "")
        println("Begin parse")

        // Parse entry strings for THIS LEVEL
        val entryStrings = ArrayList<String>()
        var start = 0
        while (start < string.length) {
            val entryString = getDenestedSubstring(string, start, ',')
            entryStrings.add(entryString)
            start += entryString.length
            start++
        }

        // do last iteration
        if (start < string.length) {
            entryStrings.add(string.substring(start, string.length))
        }

        // Convert to map
        val map = HashMap<String, Any>()
        val entries = entryStrings.map { stringEntryToMapEntry(it) }
        map.putAll(entries)
        return map
    }

    fun stringEntryToMapEntry(entryString: String): Pair<String, Any> {

        val left = getDenestedSubstring(entryString, 0, ':').removeOuterParentheses()
        val right = entryString.substring(left.length + 1, entryString.length)
        println("Split an entry string")
        println("Left: $left")
        println("Right: $right")

        // Handle whatever the entry's right side data type is
        val objectIndex = right.objectIndexPair()
        if (objectIndex != null) {
            val jsonObject = parseJsonObject(right.substring(objectIndex.first, objectIndex.second))
            return Pair(left, jsonObject)
        }
        val stringIndex = right.stringIndexPair()
        if (stringIndex != null) {
            val string = entryString.substring(stringIndex.first+1, stringIndex.second)
            return Pair(left, string)
        }
        val arrayIndex = right.arrayIndexPair()
        if (arrayIndex != null) {

        }
        if (right.isInteger()) {

        }
        if (right.isFloat()) {

        }

        return Pair(left, right)
    }

    private fun String.objectIndexPair(): Pair<Int, Int>? {
        return getMatchingPairIndex('{', '}')
    }

    private fun String.stringIndexPair(): Pair<Int, Int>? {
        return getMatchingPairIndex('"', '"')
    }

    private fun String.arrayIndexPair(): Pair<Int, Int>? {
        return getMatchingPairIndex('[', ']')
    }

    private fun String.getMatchingPairIndex(leftChar: Char, rightChar: Char): Pair<Int, Int>? {
        var start = 0
        var end = this.length - 1
        while (start < end) {
            val left = this[start]
            val right = this[end]
            if (left.toString().isBlank()) {
                start++
            } else if (right.toString().isBlank()) {
                end--
            } else {
                if (leftChar == left && rightChar == right)
                    return Pair(start, end)
                else
                    return null
            }
        }
        return null
    }

    fun String.removeOuterParentheses(): String {
        var left = 0
        var right = this.length
        var gotLeft = false
        var gotRight = false
        while (left < right) {
            if (gotLeft && gotRight) {
                break
            } else if (!gotLeft) {
                if (this[left] == '"') {
                    gotLeft = true
                } else {
                    left+=
                }
            } else if (!gotRight) {
                if (this[right] == '"') {
                    gotRight = true
                } else {
                    right++
                }
            }
        }
        return this.substring(left, right)
    }

    fun getDenestedSubstring(string: String, start: Int, split: Char): String {
        val stack = ArrayList<Char>()
        for (x in start..string.length - 1) {
            val char = string[x]
            if (char == '[' || char == '{') {
                stack.add(char)
            } else if (char == ']') {
                if (stack.last() == '[') {
                    stack.removeAt(stack.size - 1)
                } else {
                    throw RuntimeException("Malformed JSON")
                }
            } else if (char == '}') {
                if (stack.last() == '{') {
                    stack.removeAt(stack.size - 1)
                } else {
                    throw RuntimeException("Malformed JSON")
                }
            } else if (char == split && stack.isEmpty()) {
                //found end
                val entryString = string.substring(start, x)
                return entryString
            }
        }

        return string.substring(start)
    }
}