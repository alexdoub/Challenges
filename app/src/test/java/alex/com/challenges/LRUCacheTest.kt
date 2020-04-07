package alex.com.challenges

import alex.com.challenges.cs.LRUCache
import org.junit.Test
import java.lang.RuntimeException

/**
 * Created by Alex Doub on 4/3/2020.
 */

class LRUCacheTest {
    
    @Test
    fun test_size_2() {
        val cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        assert("step 1", 1, cache.get(1))       // returns 1
        cache.put(3, 3)    // evicts key 2
        assert("step 2", -1, cache.get(2))       // returns -1 (not found)
        cache.put(4, 4)    // evicts key 1
        assert("step 3", -1, cache.get(1))       // returns -1 (not found)
        assert("step 4", 3, cache.get(3))       // returns 3
        assert("step 5", 4, cache.get(4))       // returns 4
    }

    fun assert (desc: String, input: Int, other: Int) {
        if (input != other) {
            println("Fail at: $desc")
            throw RuntimeException("Fail at: $desc")
        }
    }
}