package alex.com.challenges

/**
 * Created by Alex Doub on 3/12/20.
 *
 * https://old.reddit.com/r/dailyprogrammer/comments/ffxabb/20200309_challenge_383_easy_necklace_matching/
 */

object StringIsOffset {

    fun solve(a: String, b: String): Boolean {
        return a.length == b.length && (a+a).contains(b)
    }
}