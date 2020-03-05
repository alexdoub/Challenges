package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

class PhoneNumberCombos {
    companion object {
        fun letterCombinations(digits: String): List<String> {

            var stringBuilders = ArrayList<StringBuilder>()

            //Make helper string to init, but only run on valid input
            fun handleEmpty() {
                if (stringBuilders.isEmpty()) {
                    stringBuilders.add(StringBuilder())
                }
            }

            //Enumerate digits & diverge
            digits.forEach { d ->
                when (d) {
                    '1' -> {
                        handleEmpty()
                    }
                    '2' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('a') })
                            newSBs.add(StringBuilder(it).apply { append('b') })
                            newSBs.add(StringBuilder(it).apply { append('c') })
                        }
                        stringBuilders = newSBs
                    }
                    '3' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('d') })
                            newSBs.add(StringBuilder(it).apply { append('e') })
                            newSBs.add(StringBuilder(it).apply { append('f') })
                        }
                        stringBuilders = newSBs
                    }
                    '4' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('g') })
                            newSBs.add(StringBuilder(it).apply { append('h') })
                            newSBs.add(StringBuilder(it).apply { append('i') })
                        }
                        stringBuilders = newSBs
                    }
                    '5' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('j') })
                            newSBs.add(StringBuilder(it).apply { append('k') })
                            newSBs.add(StringBuilder(it).apply { append('l') })
                        }
                        stringBuilders = newSBs
                    }
                    '6' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('m') })
                            newSBs.add(StringBuilder(it).apply { append('n') })
                            newSBs.add(StringBuilder(it).apply { append('o') })
                        }
                        stringBuilders = newSBs
                    }
                    '7' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('p') })
                            newSBs.add(StringBuilder(it).apply { append('q') })
                            newSBs.add(StringBuilder(it).apply { append('r') })
                            newSBs.add(StringBuilder(it).apply { append('s') })
                        }
                        stringBuilders = newSBs
                    }
                    '8' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('t') })
                            newSBs.add(StringBuilder(it).apply { append('u') })
                            newSBs.add(StringBuilder(it).apply { append('v') })
                        }
                        stringBuilders = newSBs
                    }
                    '9' -> {
                        handleEmpty()
                        val newSBs = ArrayList<StringBuilder>()
                        stringBuilders.forEach {
                            newSBs.add(StringBuilder(it).apply { append('w') })
                            newSBs.add(StringBuilder(it).apply { append('x') })
                            newSBs.add(StringBuilder(it).apply { append('y') })
                            newSBs.add(StringBuilder(it).apply { append('z') })
                        }
                        stringBuilders = newSBs
                    }
                    '0' -> {
                        handleEmpty()
                        stringBuilders.forEach {
                            it.append(" ")
                        }
                    }
                }
            }
            return stringBuilders.map { it.toString() }
        }
    }
}