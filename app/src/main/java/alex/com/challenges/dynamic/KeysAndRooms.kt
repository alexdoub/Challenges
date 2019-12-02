package alex.com.challenges.dynamic


/**
 * Created by Alex Doub on 11/26/2019.
 * https://leetcode.com/problems/keys-and-rooms/
 */

class KeysAndRooms {
    companion object {

        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
            val dfs = canVisitAllRooms_DFS(rooms)
            val bfs = canVisitAllRooms_BFS(rooms)
            assert(dfs == bfs)
            return dfs
        }

        //DFS - stack follows keys as it gets them, then backs out to get remaining
        fun canVisitAllRooms_DFS(rooms: List<List<Int>>): Boolean {
            val accessibleRooms = BooleanArray(rooms.size)

            fun checkRoom(room: Int) {
                accessibleRooms[room] = true
                rooms[room].forEach { key ->
                    if (!accessibleRooms[key]) {
                        checkRoom(key)
                    }
                }
            }
            checkRoom(0)

            return accessibleRooms.all { accessible -> accessible }
        }

        fun canVisitAllRooms_BFS(rooms: List<List<Int>>): Boolean {

            val accessibleMap = HashMap<Int, Boolean>()
            val keyStack = ArrayList<Int>()

            keyStack.add(0)
            accessibleMap[0] = true

            while (keyStack.isNotEmpty()) {
                val key = keyStack.removeAt(0)
                accessibleMap[key] = true
                val newKeys = rooms[key]

                newKeys.forEach { newKey ->
                    if (accessibleMap[newKey] == null) {
                        accessibleMap[newKey] = true
                        val foundKeys = rooms[newKey]
                        keyStack.addAll(foundKeys)
                    }
                }
            }

            return accessibleMap.size == rooms.size
        }
    }
}