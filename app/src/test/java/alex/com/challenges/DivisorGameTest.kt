package alex.com.challenges

import alex.com.challenges.dynamic.DivisorGame
import org.junit.Test

/**
 * Created by Alex Doub on 11/22/2019.
 */

class DivisorGameTest {
    //1 - F
    //2 -  T
    //3 - F
    //4 -  T
    //5 - F

    @Test
    fun test1() {
        //From question
        assert(DivisorGame.divisorGame(1) == false)
    }

    @Test
    fun test2() {
        //From question
        assert(DivisorGame.divisorGame(2) == true)
    }

    @Test
    fun test3() {
        //From question
        // you take 1, he takes 1, you left with 1
        assert(DivisorGame.divisorGame(3) == false)
    }

    @Test
    fun test4() {
        //From question
        //You pick 1, they pick 3 or 1 which are loss states
        assert(DivisorGame.divisorGame(4) == true)
    }

    @Test
    fun test5() {
        //5 -> you pick 1
        // they pick 1 or 2
        // 1-> they get 4
        assert(DivisorGame.divisorGame(5) == false)
    }

    @Test
    fun test6() {
        assert(DivisorGame.divisorGame(99) == false)
    }
}