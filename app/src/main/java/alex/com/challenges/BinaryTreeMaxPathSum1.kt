package alex.com.challenges

import alex.com.challenges.common.TreeNode
import kotlin.collections.HashMap

//https://leetcode.com/problems/binary-tree-maximum-path-sum/

@Deprecated("USE #3")
class BinaryTreeMaxPathSum1 {
    class NodeState(
        val treeNode: TreeNode,
        val chainValue: Int,
        val includeOrphans: Boolean,
        val alreadyBranched: Boolean
    ) {

        override fun hashCode(): Int {
            var result = treeNode.hashCode()
            result = 31 * result + chainValue
            result = 31 * result + includeOrphans.hashCode()
            result = 31 * result + alreadyBranched.hashCode()
            return result
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as NodeState

            if (treeNode != other.treeNode) return false
            if (chainValue != other.chainValue) return false
            if (includeOrphans != other.includeOrphans) return false
            if (alreadyBranched != other.alreadyBranched) return false

            return true
        }

    }

    //REDO this with top down approach. Parent passes value down, gets returned max possible value

    companion object {
        val hashmap = HashMap<NodeState, Int>()

        fun maxPathSum(root: TreeNode?): Int {
            return root?.getMaxValueOfThisNode(0, includeOrphans = true, alreadyBranched = false) ?: 0
        }

        private fun TreeNode.getMaxValueOfThisNode(
            chainValue: Int,
            includeOrphans: Boolean,
            alreadyBranched: Boolean
        ): Int {

            val nodeState = NodeState(this, chainValue, includeOrphans, alreadyBranched)
            hashmap[nodeState]?.let { return it }

            val onlyThis = `val` + chainValue

            // ONLY child paths (Used to exclude this node but propagate child path)
            val leftOrphanPath: Int? = left?.getMaxValueOfThisNode(0, true, alreadyBranched)
            val rightOrphanPath: Int? = right?.getMaxValueOfThisNode(0, true, alreadyBranched)

            // Child path + THIS
            val leftPathInclusive: Int? = left?.getMaxValueOfThisNode(onlyThis, false, alreadyBranched = true)
            val rightPathInclusive: Int? = right?.getMaxValueOfThisNode(onlyThis, includeOrphans = false, alreadyBranched = true)

            val options = arrayOf(
                onlyThis,
                leftPathInclusive,
                rightPathInclusive
            ).toMutableList()

            // Both child paths + this (subtract `val` to not double account)
            // Ignore if we already branched
            var bothPathsInclusive: Int?
            if (!alreadyBranched) {
                bothPathsInclusive =
                    if (leftPathInclusive != null && rightPathInclusive != null) {
                        leftPathInclusive + rightPathInclusive - onlyThis
                    } else null
                options.add(bothPathsInclusive)
            }
            if (includeOrphans) {
                options.add(leftOrphanPath)
                options.add(rightOrphanPath)
            }
            val maxValue = options.mapNotNull { it }.max()!!
            if ((this as? TreeNode)?.id == 2) {
                return maxValue
            }

            //Create hash table entry
            hashmap[nodeState] = maxValue
            return hashmap[nodeState]!!
        }
    }
}
