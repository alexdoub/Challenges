A collection of solutions to various programming challenges I found online.

# Challenges
**Maze** - Simple maze navigation problem. Shortest solution wins  
**BoxMaze** - A twist on maze, where you push a box around a maze. Shortest solution wins. Similar to the game Sokoban  
**SimilarWords** - Find similar words in a sentence. A word is similar if they both contain the same set of letters  
**LightsOut** - Find a solution to the lights out problem. NP-Hard  
**LinkedListAdder** - https://leetcode.com/problems/add-two-numbers/  
**IntegerDivision** - https://leetcode.com/problems/divide-two-integers/  
**IsNumber** - https://leetcode.com/problems/valid-number/  
**BinaryTreeMaxPath** - https://leetcode.com/problems/binary-tree-maximum-path-sum/  
**MaxPointsOnALine** - https://leetcode.com/problems/max-points-on-a-line/  
**LongestSubstringWithoutRepeatingCharacters** - https://leetcode.com/problems/longest-substring-without-repeating-characters/  
**AssignCookies** - https://leetcode.com/problems/assign-cookies/  
**BinaryMatrix** - https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/  
**MinimumSwaps** - https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/  
**ValidParenthesis** - https://leetcode.com/problems/valid-parentheses/  
**MinCostClimbingStairs** - https://leetcode.com/problems/min-cost-climbing-stairs/  
**MinFallingPathSum** - https://leetcode.com/problems/minimum-falling-path-sum/  
**KnightDialer** - https://leetcode.com/problems/knight-dialer/  
**DivisorGame** - https://leetcode.com/problems/divisor-game/  
**DiceRollsWithTargetSum** - https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/  
**ValidParenthesisString** - https://leetcode.com/problems/valid-parenthesis-string/  
**WildcardMatching** - https://leetcode.com/problems/wildcard-matching/  
**SmallestSpanningRange** - https://www.careercup.com/question?id=16759664  
**KeysAndRooms** - https://leetcode.com/problems/keys-and-rooms/  
**FindEventualSafeStates** - https://leetcode.com/problems/find-eventual-safe-states/  
**MinWindowSubstring** - https://leetcode.com/problems/minimum-window-substring/  
	"Given an input string and a target string, return the smallest substring that contains all the letters in the target string"  
	Loop + Hashmap tracking indexes.  Similar to StringIncludesPermutation. Make hashmap that maps chars to counts. Make 2nd hashmap that maps chars to index locations. Loop input and tally up characters. If over-tallyd, pop off last. Store solutions when tallys are full.  
**StringIncludesPermutation** - https://leetcode.com/problems/permutation-in-string/  
	"Given an input string and a target string, return T/F if the input string contains a permutation of the target string in it"  
	Loop + Hashmap tracking indexes. Similar to MinWindowSubstring. Make hashmap of char -> count of the target string. Loop over input string and tally characters as they match. Prune indexes when they get too far. Check for solution each step  
**RepeatedSubstringPattern** - https://leetcode.com/problems/repeated-substring-pattern/  
	"Given a string, return T/F if its just a repeat of a single substring"  
	Tricky math. Get all divisors of input string. For each divisor, enumerate input string in chunks and see if its a full match.  
**LongPressedName** - https://leetcode.com/problems/long-pressed-name/  
	"Given an input string and a target string, return T/F if the input string is the target string with repeated characters (sticky keys)"  
	Single loop. Loop over input char with a pointer along the target string. Try to advance target string first OR check for sticky letter repeat (In that order).  
**MixedWordsConcatenated** - https://leetcode.com/problems/substring-with-concatenation-of-all-words/  
	"Given a string and a list of words, return ALL the starting indexes of substrings that contain all the listed words."  
	Loop + Map + Lookahead. Prepare map that maps words to counts. Loop over characters, from start to logical last index. On each char, see if there is a substring match & keep searching for matches along that pattern. If its successful, add to results list.  
**ShortestDistanceToChar** - https://leetcode.com/problems/shortest-distance-to-a-character/  
	"Given a string and a char, return an IntArray represnting how far away each digit is from a target letter"  
	1) Simple loop x2. Loop & build list of indexes for target char. Loop again and compare each char to the 2 lowest indexes from the index list. If the 2nd index is closer, pop the first from the arraylist.  
	2) DP 2-way sweep.  Loop from LtR then RtL and build off previous solution. Only first iteration has base case that checks original string & sets 0  
**CandyDistribution** - https://leetcode.com/problems/candy/  
	"Given an IntArray of children priorities, return the minimum amount of candy to satisfy them all"  
	DP 2-way sweep. Make IntArray solution and fill out by sweeping LtR then RtL, making sure priorities are satisfied.  
**PerfectRectangle** - https://leetcode.com/problems/perfect-rectangle/  
	"Given a list of rectangles, return T/F if the area perfectly makes a single rectangle with no gaps or overlaps."  
	Loop + Hashmap. Enumerate rects and build a hashmap to count points. Also track min/max X/Y & sum up area. Check 1 = the total area must equal the expected area. Check 2 = enumerate hashmap and verify theres 1 point in the corners, 2 points on the side, and either 2 or 4 points in the inner area.  
**WordBreakII** - https://leetcode.com/problems/word-break-ii/  
	"Given a sentence string and a list of words, return all combinations of the sentence such that the words are from the word list with spaces inbetween"  
	DP Graph construction. Enumerate chars in sentence & see if this char starts off any words from the word list. Build a graph, starting from initial node, and place new nodes at index of DP array. DP Array contains arraylist of nodes that are valid up to that character. Nodes point back to previous nodes. Early terminate if too far past last node. After enumeration, recursively (DFS) enumerate from final nodes to build sentences.  
**MinimumPath4DSum** - https://leetcode.com/problems/minimum-path-sum/ (Including modified solution)  
	"Given a matrix of numbers, find the minimum path sum from the top left to the bottom right. You can only move down or right."  
	1-way sweep + DP. 2D-loop in order and fill out solution graph. Return bottom right value.  
**LargestIsland** - Find largest island in a boolean grid of land & sea (interview question) 
	"Given a boolean matrix, find the largest island"  
	Simple loop + recursive (BFS). On every cell in the matrix, use BFS to find the total area. Then zero it out to prevent re-computing the same island.  
**PalindromeSubstring** - https://leetcode.com/problems/longest-palindromic-substring/  
	"Given a string, find the longest palindrome within it"  
	Simple loop. Loop over string and on each character, try to 'expand outwards' to find the longest palindome from this char. Also account for even length palindromes. Store & return the best one.  
**CountRectangles** - https://www.youtube.com/watch?v=EuPSibuIKIg  (first half)  
	"Given a list of points, count how many rectangles can be made"  
	Double loop over points, record only forward lines on the same Y axis. In a hashmap with the key as the start-end X coords, increment your count and add to sum.  
	Explaination: This reduces our search space by not counting duplicate rects (inverted, rotated, etc). Adding a matching line below a rect creates a 2nd rect. Adding another one adds 2 more rects, etc.  
**ZigZagConverter** - https://leetcode.com/problems/zigzag-conversion/  
	"Given a string & an int, produce a zigzag pattern of that string"  
	Simple loop. Maintain list of stringbuilders for each row. Loop over chars & put in the right row. Extra variables for going up/down.  
**ContainerWithMostWater** - https://leetcode.com/problems/container-with-most-water/  
	"Given an array of heights, find which indexes produce the most area"  
	Sliding window. Calculate area & close in the side with the smaller number  
**IntToRoman** - https://leetcode.com/problems/integer-to-roman/  
	"Given an int, convert it to roman numerals"  
	Simple loop + big map. Loop over number greedily subtracting the biggest value possible.  
**RomanToInt** - https://leetcode.com/problems/roman-to-integer/  
	"Given a roman numeral, convert it to an integer"  
	Simple loop + big map. Do loop and check next 1 or 2 chars. Advance sum & ptr accordingly.  
**TwoSum** - https://leetcode.com/problems/two-sum/  
	"Given a list of ints & a target, return 2 indexes whos associated values sum up to the target. Return exactly 1 solution & don't use same element twice"  
	Simple loop. Make hashmap that maps values to an array list of positions. On loop,  See if counterpart exists & is not the same index  
**3Sum** - https://leetcode.com/problems/3sum/  
	"Given an array of integers, return all solutions such that a + b + c = 0"  
	Simple Loop + Sliding Window.  
	Sort then loop array. On each number, try to find the compliment pair by using sliding window on remaining data. Sliding window starts at edge-to-edge then smartly closes in.  
**3SumClosest** - https://leetcode.com/problems/3sum-closest/  
	"Given an array of integers, return the sum of 3 ints that is closest to the target."  
	Simple Loop + sliding window.  
	Sort then loop array. Use sliding window on remaining data to find the closest sum.  
**4Sum** - https://leetcode.com/problems/4sum/  
	"Given an array of integers, return a complete solution set of all the unique quadruplets that sum to the target"  
	Simple loop + existing solution. Implement 3-sum. Loop over values and call 3-sum trying to find the counterparts.  
**PhoneNumberCombos** - https://leetcode.com/problems/letter-combinations-of-a-phone-number/  
	"Given a phone number string, return all letter combinations possible"  
	Simple loop. Maintain list of StringBuilders starting with a single empty one. On each digit, copy existing SBs and append 1 single letter.  
**RemoveNthNodeFromEnd** - https://leetcode.com/problems/remove-nth-node-from-end-of-list/  
	"Given a linked list, remove the Nth node from the end. Hardmode: only enumerate once"  
	Enumerate once, maintaining a pointer of the Nth node behind. Once you reach the end, use the N-behind node & advance its 'next'. If the end is less than N, advance head once.  
**CombinationSum** - https://leetcode.com/problems/combination-sum/  
	"(Modified Subset Sum Problem) - Given a set of numbers and a target, return all combinations that sum up to target. You can re-use numbers."
	Do tricky recursive DFS. Limit scope & reduce duplicate combinations by having sub-searches only account for new possibilties in the array PAST the last used value's index.  
**GenerateParenthesis** - https://leetcode.com/problems/generate-parentheses/  
	"Given an int N, list all permutations of VALID parentheses"  
	Simple recursive (DFS) loop. Base case adds the valid option to the options list  
**InvertBinaryTree** - https://leetcode.com/problems/invert-binary-tree/  
	"Invert a binary tree"
	Inverting a tree just means reversing it. 
	Do SIMPLE recursive loop where you swap L and R. Initially call on head.  
**FindNumRange** - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/  
	"In a sorted array, find the range (start/end index) of a specific int"  
	Do two slightly different sliding window approaches. One to find the first occurrence, one to find the last. Early return if no first occurrence.  
**MathPow** - https://leetcode.com/problems/powx-n/  
	"Implement Math.pow, where a double is put to the power of an int"  
	Keep track of isNegative. If it was negative you do a final flip at the end, 1.0/sum. Loop and subtract from power & add to base. If even, double base & divide power by 2. If odd, subtract 1 & add base to sum.  
**JumpGame** - https://leetcode.com/problems/jump-game/  
	"Given an IntArray, start at the 0th index. Hop UP TO as many times as the value you're on. Return T/F if you can hop to the end"  
	Make BoolArray representing reachable states. Enumerate BoolArr filling out reachability from known reachable states (push ahead). Maintain int variable of 'furthest reachable' and early terminate if you go past.  
**Permutations** - https://leetcode.com/problems/permutations/  
	"Given an IntArray, find all possible permutations"  
	Inner Recursive (DFS) loop to fill out options list. Pass in used & remaining items thru parameters.  
**PermutationsII** - https://leetcode.com/problems/permutations-ii/submissions/  
	"Same as above, but only show distinct options"  
	Same as above, but only propagate distinct options from 'remaining' list.  
**SearchInRotatedArray** - https://leetcode.com/problems/search-in-rotated-sorted-array/  
	"Given a rotated sorted array, find the target or return -1"  
	Use sliding window + tricky checks to determine where to search  
**IsValidBST** - https://leetcode.com/problems/validate-binary-search-tree/  
	"Given a binary tree, determine if it is a valid binary search tree (BST)."  
	Recurisvely enumerate nodes (DFS) with greater/less than parameters passed down.  
	Gotcha: Use nullable lt/gt parameters  
**FindGrasshopper** - https://leetcode.com/discuss/interview-question/494186/google-onsite-grasshopper-position  
	"Given a graph and an int N, determine the probability that you will be in each node if you did hops at random"  
	Recursively (DFS) get list of nodes after N hops. Evenly distribute probabilities accounting for duplicate nodes.  
**CourseSchedule** - https://leetcode.com/problems/course-schedule/  
	"Given a dependency map representing college courses, return T/F if you can take them all"  
	Return false if any circular dependencies  
	Transform inputs into dependency & accessibility maps. Make BoolArr for taken courses. Do recursive (DFS) search and fill out BoolArr.  
**CourseScheduleII** - https://leetcode.com/problems/course-schedule-ii/  
	"Given a dependency map representing college courses, print the order in which you take them all & satisfy prerequisites"  
	Similar to previous, but also print the progress.  
**StringMultiply** - https://leetcode.com/problems/multiply-strings/  
	"Given two strings representing integers, multiply them"  
	Oldschool multiply, digit by digit. Store partial sums in IntArray  
	Finally, loop over IntArray & fill out string  
**NumIslands** - https://leetcode.com/problems/number-of-islands/  
	"Given a 2d binary matrix of islands, count the total amount of islands."  
	Loop matrix, BFS to zero out found islands  
**DistanceFromZeroes** - https://leetcode.com/problems/01-matrix/  
	"Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell"  
	2-way matrix sweep  
**SortPartiallySortedArray** - https://leetcode.com/discuss/interview-question/378774/  
	"Given an array of positive integers (possibly with duplicates) such that the numbers have been sorted only by 28 most significant bits. Sort the array completely"  
	Bucket Sort  

# Strategies

## Graph
**Single loop** - RemoveNthNodeFromEnd  
**Recursive DFS** - CourseSchedule, NumIslands, CourseSchedule, KeysAndRooms, FindGrasshopper, IsValidBST, WordBreakII(pt2)  
**Recursive** - InvertBinaryTree  
**DP Array** - MinFallingPathSum  

## Matrix
**1-way sweep DP matrix** - MinimumPath4DSum  
**2-way sweep DP matrix** - DistanceFromZeroes  
**Recursive (BFS)** - FindLargestIsland  
**Loop (BFS)** - MinimumPath4DSum(modified)  

## Points
**Loop + Hashmap** - CountRectangles, PerfectRectangle  

## Arrays
**Single Loop** - PhoneNumberCombos, TwoSums, RomanToInt, ZigZagConverter, PalindromeSubstring, ShortestDistanceToChar(mediocre), MixedWordsConcatenated  
**Recursive DFS** -  Permutations, GenerateParentheses, CombinationSum  
**Sliding Window** - SearchInRotatedArray, FindNumInRange, 3-Sum, 3-SumClosests, ContainerWithMostWater  
**Partial Sums** - StringMultiply  
**Partial Sort** - SortPartiallySortedArray  
**DP Array** - JumpGame  
**DP Graph** - WordBreakII(pt1)  
**2 Way Sweep** - CandyDistribution, ShortestDistanceToChar  
**Tricky Math** - RepeatedSubstringPattern  
**Loop + Hashmap** - StringIncludesPermutation, MinWindowSubstring  