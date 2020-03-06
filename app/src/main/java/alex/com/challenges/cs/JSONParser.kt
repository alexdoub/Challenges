package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/5/2020.
 *
 * EDIT: TODO: Finish lolol
 */

object MyJSONParser {
    fun parseJson(string: String): Map<CharSequence, Any> {

        var string = string.replace("\t", "")
        string = string.replace("\n", "")
        string = string.replace(" ", "")
        println("Begin parse")

        // Parse entry strings for THIS LEVEL
        val entryStrings = ArrayList<CharSequence>()
        var start = 0
        while (start < string.length) {
            val entryString = getDenestedSubstring(string, start, ',')
            entryStrings.add(entryString)
            start += entryString.length
        }

        // do last iteration
        if (start < string.length) {
            entryStrings.add(string.subSequence(start, string.length))
        }

        // Convert to map
        val map = HashMap<CharSequence, Any>()
        val entries = entryStrings.map { stringEntryToMapEntry(it) }
        map.putAll(entries)
        return map
    }

    fun stringEntryToMapEntry(string: CharSequence): Pair<CharSequence, Any> {

        val left = getDenestedSubstring(string, 0, ':')
        val right = string.subSequence(left.length, string.length)
        println("Split an entry string")
        println("Left: $left")
        println("Right: $right")
        return Pair(left, right)
    }

    fun getDenestedSubstring(string: CharSequence, start: Int, split: Char): CharSequence {
        for (x in 0..string.length - 1) {
            //maintain stack, split by commas
            val stack = ArrayList<Char>()
            val char = string[x]
            if (char == '[' || char == '{') {
                stack.add(char)
            } else if (char == ']') {
                if (stack.last() == '[') {
                    stack.removeAt(stack.size-1)
                } else {
                    throw RuntimeException("Malformed JSON")
                }
            } else if (char == '}') {
                if (stack.last() == '{') {
                    stack.removeAt(stack.size-1)
                } else {
                    throw RuntimeException("Malformed JSON")
                }
            } else if (char == split && stack.isEmpty()) {
                //found end
                val entryString = string.subSequence(start, x-1)
                return entryString
            }
        }

        return string
//        throw RuntimeException("Couldn't find char in string!!")
    }
}