package alex.com.challenges

import alex.com.challenges.dynamic.KeysAndRooms
import org.junit.Test

/**
 * Created by Alex Doub on 11/26/2019.
 */

class KeysAndRoomsTest {
    @Test
    fun test1() {
        val input = listOf(
            listOf(1),
            listOf(2),
            listOf(3),
            listOf())
        assert(KeysAndRooms.canVisitAllRooms(input))
    }

    @Test
    fun test2() {
        val input = listOf(
            listOf(1,3),
            listOf(3,0,1),
            listOf(2), //cant open door 2
            listOf(0))
        assert(KeysAndRooms.canVisitAllRooms(input) == false)
    }

    @Test
    fun test3() {
        val input = listOf(
            listOf(3),//0
            listOf(2),//1
            listOf(1),//2
            listOf())//3
        assert(KeysAndRooms.canVisitAllRooms(input) == false)
    }

    @Test
    fun test4() {
        val input = listOf(
            listOf(2),//0
            listOf(3),//1
            listOf(1),//2
            listOf())//3
        assert(KeysAndRooms.canVisitAllRooms(input) == true)
    }
}