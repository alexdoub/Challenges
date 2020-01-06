package alex.com.challenges

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

class RemoveNthFromEnd {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    companion object {

        //1 pass mode
        //Time: O(n)
        //Space: O(1)
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var h = head
            var nBehind: ListNode? = null
            var iterations = 0

            while (h != null) {
                println("Iteration: $iterations")
                h = h.next
                nBehind = nBehind?.next

                if (iterations == n) {
                    nBehind = head
                    println("did set nBehind")
                }
                iterations++
            }

            //got here, head points to nothing
            println("On nBehind hotswap. null: ${nBehind == null}")
            nBehind?.next = nBehind?.next?.next
            println("After nBehind hotswap. null: ${nBehind == null}")


            //Edge case
            println("Edge case check. Iterations:${iterations} n:${n}")
            return if (iterations <= n) {
                head?.next
            } else {
                head
            }
        }
    }
}