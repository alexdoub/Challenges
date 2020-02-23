A collection of solutions to various programming challenges I found online.

# Challenges
Maze - Simple maze navigation problem. Shortest solution wins  
BoxMaze - A twist on maze, where you push a box around a maze. Shortest solution wins. Similar to the game Sokoban  
SimilarWords - Find similar words in a sentence. A word is similar if they both contain the same set of letters  
LightsOut - Find a solution to the lights out problem. NP-Hard  
LinkedListAdder - https://leetcode.com/problems/add-two-numbers/  
TwoSums - https://leetcode.com/problems/two-sum/  
IntegerDivision - https://leetcode.com/problems/divide-two-integers/  
IsNumber - https://leetcode.com/problems/valid-number/  
BinaryTreeMaxPath - https://leetcode.com/problems/binary-tree-maximum-path-sum/  
MaxPointsOnALine - https://leetcode.com/problems/max-points-on-a-line/  
LongestSubstringWithoutRepeatingCharacters - https://leetcode.com/problems/longest-substring-without-repeating-characters/  
AssignCookies - https://leetcode.com/problems/assign-cookies/  
BinaryMatrix - https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/  
MinimumSwaps - https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/  
ValidParenthesis - https://leetcode.com/problems/valid-parentheses/  
MinCostClimbingStairs - https://leetcode.com/problems/min-cost-climbing-stairs/  
MinFallingPathSum - https://leetcode.com/problems/minimum-falling-path-sum/  
KnightDialer - https://leetcode.com/problems/knight-dialer/  
DivisorGame - https://leetcode.com/problems/divisor-game/  
DiceRollsWithTargetSum - https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/  
ValidParenthesisString - https://leetcode.com/problems/valid-parenthesis-string/  
WildcardMatching - https://leetcode.com/problems/wildcard-matching/  
SmallestSpanningRange - https://www.careercup.com/question?id=16759664  
KeysAndRooms - https://leetcode.com/problems/keys-and-rooms/  
FindEventualSafeStates - https://leetcode.com/problems/find-eventual-safe-states/  
MinWindowSubstring - https://leetcode.com/problems/minimum-window-substring/  
StringIncludesPermutation - https://leetcode.com/problems/permutation-in-string/  
RepeatedSubstringPattern - https://leetcode.com/problems/repeated-substring-pattern/  
LongPressedName - https://leetcode.com/problems/long-pressed-name/  
MixedWordsConcatenated - https://leetcode.com/problems/substring-with-concatenation-of-all-words/  
ShortestDistanceToChar - https://leetcode.com/problems/shortest-distance-to-a-character/  
CandyDistribution - https://leetcode.com/problems/candy/  
PerfectRectangle - https://leetcode.com/problems/perfect-rectangle/  
WordBreakII - https://leetcode.com/problems/word-break-ii/  
MinimumPath4DSum - https://leetcode.com/problems/minimum-path-sum/ (Modified)  
LargestIsland - Find largest island in a boolean grid of land & sea (interview question)  
PalindromeSubstring - https://leetcode.com/problems/longest-palindromic-substring/  
RectCounter - https://www.youtube.com/watch?v=EuPSibuIKIg  (first half)  
ZigZagConverter - https://leetcode.com/problems/zigzag-conversion/  
ContainerWithMostWater - https://leetcode.com/problems/container-with-most-water/  
IntToRoman - https://leetcode.com/problems/integer-to-roman/  
RomanToInt - https://leetcode.com/problems/roman-to-integer/  
3Sum - https://leetcode.com/problems/3sum/  
3SumClosest - https://leetcode.com/problems/3sum-closest/  
PhoneNumberCombos - https://leetcode.com/problems/letter-combinations-of-a-phone-number/  
4Sum - https://leetcode.com/problems/4sum/  
RemoveNthNodeFromEnd - https://leetcode.com/problems/remove-nth-node-from-end-of-list/  
CombinationSum - https://leetcode.com/problems/combination-sum/  
GenerateParenthesis - https://leetcode.com/problems/generate-parentheses/  
InvertBinaryTree - https://leetcode.com/problems/invert-binary-tree/  
FindNumRange - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/  
MathPow - https://leetcode.com/problems/powx-n/  
JumpGame - https://leetcode.com/problems/jump-game/  
Permutations - https://leetcode.com/problems/permutations/  
PermutationsII - https://leetcode.com/problems/permutations-ii/submissions/  
SearchInRotatedArray - https://leetcode.com/problems/search-in-rotated-sorted-array/  
	"Given a rotated sorted array, find the target or return -1"  
	Use sliding window + tricky checks to determine where to search  
IsValidBST - https://leetcode.com/problems/validate-binary-search-tree/  
	"Given a binary tree, determine if it is a valid binary search tree (BST)."  
	Recurisvely enumerate nodes (DFS) with greater/less than parameters passed down.  
	Gotcha: Use nullable lt/gt parameters  
FindGrasshopper - https://leetcode.com/discuss/interview-question/494186/google-onsite-grasshopper-position  
	"Given a graph and an int N, determine the probability that you will be in each node if you did hops at random"  
	Recursively (DFS) get list of nodes after N hops. Evenly distribute probabilities accounting for duplicate nodes.   
CourseSchedule - https://leetcode.com/problems/course-schedule/  
	"Given a dependency map representing college courses, return T/F if you can take them all"  
	Return false if any circular dependencies  
	Transform inputs into dependency & accessibility maps. Make BoolArr for taken courses. Do recursive (DFS) search and fill out BoolArr.   
CourseScheduleII - https://leetcode.com/problems/course-schedule-ii/  
	"Given a dependency map representing college courses, print the order in which you take them all & satisfy prerequisites"  
	Similar to previous, but also print the progress.  
StringMultiply - https://leetcode.com/problems/multiply-strings/  
	"Given two strings representing integers, multiply them"  
	Oldschool multiply, digit by digit. Store partial sums in IntArray  
	Finally, loop over IntArray & fill out string  
NumIslands - https://leetcode.com/problems/number-of-islands/  
	"Given a 2d binary matrix of islands, count the total amount of islands."  
	Loop matrix, BFS to zero out found islands  
DistanceFromZeroes - https://leetcode.com/problems/01-matrix/  
	"Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell"  
	2-way matrix sweep  
SortPartiallySortedArray - https://leetcode.com/discuss/interview-question/378774/  
	"Given an array of positive integers (possibly with duplicates) such that the numbers have been sorted only by 28 most significant bits. Sort the array completely"  
	Bucket Sort  

#Strategies

##Graph
Recursive DFS - CourseSchedule, NumIslands, CourseSchedule, KeysAndRooms, FindGrasshopper, IsValidBST
Dynamic - MinFallingPathSum

##Matrix
2-way sweep - DistanceFromZeroes

##Points

##Arrays
Sliding Window - SearchInRotatedArray
Partial sums - StringMultiply
Partial sort - SortPartiallySortedArray
