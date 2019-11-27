package alex.com.challenges.dynamic

import android.util.SparseBooleanArray
import androidx.core.util.contains
import androidx.core.util.containsValue
import androidx.core.util.set

/**
 * Created by Alex Doub on 11/26/2019.
 * https://leetcode.com/problems/keys-and-rooms/
 */

class KeysAndRooms {
    companion object {
        private fun debugPrint(string: String) {
            if (false) println(string)
        }
        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {

            val accessibleMap = HashMap<Int, Boolean>()
            val keyStack = ArrayList<Int>()

            keyStack.add(0)
            accessibleMap[0] = true
            debugPrint("Opening door 0 with keys${rooms[0]}")

            while (keyStack.isNotEmpty()) {
                val key = keyStack.removeAt(0)
                accessibleMap[key] = true
                val newKeys = rooms[key]
                debugPrint("opened door ${key} and it has ${newKeys}")

                newKeys.forEach { newKey ->
                    if (accessibleMap[newKey] == null) {
                        debugPrint("opened door ${newKey} and got keys ${rooms[newKey]}")
                        accessibleMap[newKey] = true
                        val foundKeys = rooms[newKey]
                        keyStack.addAll(foundKeys)
                    } else {
                        debugPrint("skipping already opened door ${newKey}")
                    }
                }
            }
            debugPrint("no more keys")

            return accessibleMap.size == rooms.size
        }
    }
}