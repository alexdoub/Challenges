A collection of solutions to various programming challenges I found online.   

# Challenges
**MazeMatrixMinPath** - Simple maze navigation problem. Shortest solution wins  
	Recurisve BFS. Don't go to the same location twice.  
**MazeMatrixMinPathPushingBox** - A twist on maze, where you push a box around a maze. Shortest solution wins. Similar to the game Sokoban.  
	BFS (naive).  
**SimilarWords** - Find similar words in a sentence. A word is similar if they both contain the same set of letters  
	Loop + Hashset. Transform input strings into hashSets of their characters. Keep only the matching sets. Filter duplicates by transforming wordList into a set.  
**LightsOut** - Find a solution to the lights out problem. NP-Hard  
	"Solve the lights out game in the minimum amount of turns. (Google the description)"  
	BFS. Loop over matrix and toggle each one, save that matrix to a state. Enumerate states, check if solved, and do the same thing. Don't toggle the same cell twice.  
**LinkedListAdder** - https://leetcode.com/problems/add-two-numbers/  
	"Given a linked list representing single digits to a number, where the head of the linked list is the low value, return a linked list of the same style containing the sum of both linked lists."  
	Simple Loop. Starting at both heads, add the values together and keep the sum. Create a new node & put the sum in there, %10. If sum was over 10 then set a carry bit, which will add +1 to the next iteration.  
**IntegerDivision** - https://leetcode.com/problems/divide-two-integers/  
	"Given two integers, divide them without using the * or / operators."  
	Recursive + Bitshift. Do 4th grade style division but in binary -- Double divisor (and result) until its as large as it can be without being greater than the dividend. Subtract that from the dividend & recursively call divide on that, adding its result to our result. Also account for negatives & int_min/max edge cases.  
**ValidNumber** - https://leetcode.com/problems/valid-number/  
	"Given a string, return T if its a valid number that can be parsed directly"  
	TODO: Redo without BigDecimal lol  
**BinaryTreeMaxPathSum** - https://leetcode.com/problems/binary-tree-maximum-path-sum/  
	"Given a binary tree, find the max path sum. A path connects 2 nodes that are reachable from the starting node."  
	Double Recursive DFS. Tricky, but can be solved in a few lines. Define 2 recursive functions, one that finds the max sum with branching and one that does not. The branching function returns the max of a) the branching functions applied to either child or b) the non-branching function of both children + the value of this node.  The non-branching function has already branched, so an existing sum must be passed down.  
**MaxPointsOnALine** - https://leetcode.com/problems/max-points-on-a-line/  
	"Given a list of points, how many lie on a single line?"  
	Double loop + Hashmap. Double loop over all points to find lines and duplicates of this point. Dont do a full N^2 loop or else you get the reverse (duplicate) of each line. Calculate the slope of all those lines, adjusted for GCD, and store them in a hashmap representing with Key/Values <Slope, Count>. The maximum intersecting line for this point is the max from the hashmap + duplicates of this point. Function returns the highest max.  
**LongestSubstringWithoutRepeatingCharacters** - https://leetcode.com/problems/longest-substring-without-repeating-characters/  
	"Given a string, return the length of the longest substring without repeating characters"  
	Greedy loop + hashmap. Enumerate chars and store their positions in a hashmap. Upon seeing a duplicate, null out all the positions before it. On every loop, record the max length substring thus far.  
**AssignCookies** - https://leetcode.com/problems/assign-cookies/  
	"Given an IntArray of children who want cookies of at least a specific size and an IntArray representing cookies of some size, return how many children can be happy."  
	Greedy loop. Sort cookies and children in descending order. Enumerate children and try to give them the biggest cookie available or skip them.  
**BinaryMatrix** - https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/  
	"Reconstruct a matrix as follow: The matrix has 2 rows containing either 0s or 1s. You've given the sum of 1s on the top and bottom, and additionally given an array representing the sum of the column."  
	Greedy loop. Do not do DFS. Loop over sums and smartly put 1s or 0s according to the colsum. Keep track of remaining upper/lower 1s & evenly distribute them. If you go over the upper/lower limit, its impossible  
**MinimumSwaps** - https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/  
	"Given two strings containing any amount of X or Y, return an int representing the minimum number of swaps to make them equal. You can swap any element from string 1 with any element from string 2"
	Greedy loop. Do not do DFS or multi loops. Do not actually manipulate the strings.  
	Loop and count the Y/X and X/Y mismatches. Early return if they aren't the same oddity. Add half of each sum to the result and another 2 if they were both odd.  
**ValidParentheses** - https://leetcode.com/problems/valid-parentheses/  
	"Given a string with 3 kinds of parentheses, {}[](), return T if they are valid. Brackets must be closed in order"  
	Loop + Stack.  Loop over chars and add to the stack if open brackets. Attempt to remove from the stack on closed brackets. Fail on mismatch. Ignore other chars. Return T if stack is empty at end.  
**MinCostClimbingStairs** - https://leetcode.com/problems/min-cost-climbing-stairs/  
	"Given an IntArray of costs, find the minimum sum to get to the end of the array. You can step in increments of 1 or 2."  
	DP Array. Make IntArray representing 'min cost to get to here'. Fill out base case of 0 at index 0 & 1. Loop over every cost and fill out the next 1 & 2 steps, adding the cost and the previous sum. Only keep mins. Return cost in last cell.  
**MinFallingPathSum** - https://leetcode.com/problems/minimum-falling-path-sum/  
	"Given an X by Y DAG with values, find the minimum sum from top to bottom. When moving down, you can only go left or right at max once per step."  
	Simple DP Matrix. Fill out base case of values on the first row. For each additional row, fill out each cell by setting the min of the previous options + this cells value. Return min in last row.  
**KnightDialer** - https://leetcode.com/problems/knight-dialer/  
	"Imagine a knight from chess. Given 1 placement & N-1 hops, return the total number of possibilities of phone number strings that can be generated"  
	Simple DP Matrix. Build a hashmap represnting which numbers can be reached from where. Make IntArray representing options that end up on this index. Make base case of filling array with 1s. For each hop, make a new IntArray row that adds every value from the previous positions & set it on the new position. Most positions can jump 2 places so values will repeatedly double or triple. Mod the new sums or overflow. Lastly, sum up total.  
**DivisorGame** - https://leetcode.com/problems/divisor-game/  
	"Read the divisor game rules at the link (long). Assuming both players play perfectly, return T if a given number is a guaranteed win, F if its a loss."  
	DP Array OR recursive with memoization.  
	DP: Starting with the base case that 0 and 1 are losses, count up to N & fill out the solution array. This solution is a winner if it leaves the opponent with only losing options.  
	Memoized Recursion: This may check less total numbers, thus making it faster. Starting with N, see if any of your options are winners. Check options recursively and account for whos turn it is. Store result for each option after it has been calculated.  
**DiceRollsWithTargetSum** - https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/  
	"Given D dice with F faces, calculate how many different combinations of rolls results in a target sum T"  
	Simple DP Matrix. Make solution matrix with T columns and D rows. Fill out base case with 1s (1 to face). Loop over dice count and fill out next row. Set values that += the previous rows individual counts after accounting for this dice roll. Mod the stored values or they overflow. Note: Can be simplified to multiple DP-Arrays where the old solution is replaced every iteration.  
	3 Loops: Dice -> Previous array values -> Each dice roll.  
**ValidParenthesisString** - https://leetcode.com/problems/valid-parenthesis-string/  
	"Given a string of open & closed perenthesis & wildcards that can represent either or nothing, return T/F if the string has valid perenthesis."  
	Loop + Stack count + recursive branching (BFS). Loop and maintain stack. On wildcard, branch 3 ways with ||. Dont let stack go negative.  
**WildcardMatching** - https://leetcode.com/problems/wildcard-matching/  
	"Given an input string and a pattern that may contain an asterisk, return T/F if the input matches the pattern"  
	Simple DP Matrix. Make a 2D boolean matrix & fill out in order. Horizontal represents 'match so far' in input string and vertical represents how far in the pattern you are. On every row, smartly update the matrix by chaining from previous row. Asterisks fill the rest of the row. Return the last value in the matrix.  
**SmallestSpanningRange** - https://www.careercup.com/question?id=16759664  
	"Given an array of Int arrays, find the smallest range that spans all the int arrays."  
	2D - Sliding window. Starting at the 0th index of all the arrays, endlessly loop & push up the index of the minimum value. Compare & store best value. Finish when all indexes are at end.  
**KeysAndRooms** - https://leetcode.com/problems/keys-and-rooms/  
	"Given a flattened graph (array of Int arrays, representing nodes & paths to new nodes), return T/F if all the nodes can be visited."  
	Recursive DFS OR loop BFS. Simply start at node 0 and enumerate as far as possible. Return T if all nodes visited.  
**FindEventualSafeStates** - https://leetcode.com/problems/find-eventual-safe-states/  
	"Find all the terminal nodes in a graph. A terminal node will not lead to any loops"  
	Recursive DFS. Maintain list of states for each node. Loop over all nodes and explore them with DFS. Explore function recursively checks all next nodes & checks for loops according to the visited list that was passed in. If a visited node is seen again, then this path looped. If any child paths looped, they return false & it sets this node to unsafe.  
**!MinWindowSubstring** - https://leetcode.com/problems/minimum-window-substring/  
	"Given an input string and a target string, return the smallest substring that contains all the letters in the target string"  
	(Decent)Loop + Hashmap tracking indexes.  Similar to StringIncludesPermutation. Make hashmap that maps chars to counts. Make 2nd hashmap that maps chars to index locations. Loop input and tally up characters. If over-tallyd, pop off last. Store solutions when tallys are full.  
	(Better) Variable Sliding window. Maintain hashmap of ideal char counts & progress char counts. Have L & R pointers on the input string. Expand right when non-match, pull in left when matching. On each char, update the single char count & check if matching. Don't compare whole hashmaps, instead just check what changed. O(n).  
**!StringIncludesPermutation** - https://leetcode.com/problems/permutation-in-string/  
	"Given an input string and a target string, return T/F if the input string contains a permutation of the target string in it"  
	Loop + Hashmap tracking indexes. Similar to MinWindowSubstring. Make hashmap of char -> count of the target string. Loop over input string and tally characters as they match. Prune indexes when they get too far. Check for solution each step  
	(Better) Fixed sliding window. Make array of counts for full s2 & for s2.substring(s1.length). Loop from s1.length to end of s2. Every iteration, add the RHS to the s1 counts array and remove the LHS & check for win state.  Don't count full array on each iteration, instead have an int count & update it regarding each changed char. Similar to my solution but doesn't involve counting indexes & pruning them.  
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
**MinimumPath2DSum** - https://leetcode.com/problems/minimum-path-sum/   
	"Given a matrix of numbers, find the minimum path sum from the top left to the bottom right. You can only move down or right."  
	1-way sweep + DP. 2D-loop in order and fill out solution graph. Return bottom right value.  
**MinimumPath4DSum** - Similar to MinimumPath2DSum, but you can move in 4 directions. 
	BFS. Maintain an array of states. Start with a single state representing the top left cell. Loop over states and expand in the other directions, excluding cells you've been to. Return the first solution you find.  
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
**ZigzagConversion** - https://leetcode.com/problems/zigzag-conversion/  
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
**GenerateParentheses** - https://leetcode.com/problems/generate-parentheses/  
	"Given an int N, list all permutations of VALID parentheses"  
	Simple recursive (DFS) loop. Base case adds the valid option to the options list  
**InvertBinaryTree** - https://leetcode.com/problems/invert-binary-tree/  
	"Invert a binary tree"
	Inverting a tree just means reversing it. 
	Do SIMPLE recursive loop where you swap L and R. Initially call on head.  
**GetRangeOfNumInArray** - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/  
	"In a sorted array, find the range (start/end index) of a specific int"  
	Do two slightly different sliding window approaches. One to find the first occurrence, one to find the last. Early return if no first occurrence.  
**MathPow** - https://leetcode.com/problems/powx-n/  
	"Implement Math.pow, where a double is put to the power of an int"  
	Keep track of isNegative. If it was negative you do a final flip at the end, 1.0/sum. Loop and subtract from power & add to base. If even, double base & divide power by 2. If odd, subtract 1 & add base to sum.  
**JumpGame** - https://leetcode.com/problems/jump-game/  
	"Given an IntArray, start at the 0th index. Hop UP TO as many times as the value you're on. Return T/F if you can hop to the end"  
	Make BoolArray representing reachable states. Enumerate BoolArr filling out reachability from known reachable states (push ahead). Maintain int variable of 'furthest reachable' and early terminate if you go past.  
**PermutationsI** - https://leetcode.com/problems/permutations/  
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
**CourseScheduleI** - https://leetcode.com/problems/course-schedule/  
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
	2-way DP matrix sweep. Enumerate matrix forwards and backwards, setting values based on previous values. Base case in first sweep.   
**SortPartiallySortedArray** - https://leetcode.com/discuss/interview-question/378774/  
	"Given an array of positive integers (possibly with duplicates) such that the numbers have been sorted only by 28 most significant bits. Sort the array completely"  
	Bucket Sort. Loop and add values into bucket. On new bucket found, unroll last bucket. Finally unroll bucket again.  
**ReverseLinkedList** - https://leetcode.com/problems/reverse-linked-list/  
	"Reverse a linked list"  
	Simple Loop. Keep 3 pointers, prev/current/next. Advance next, swap current, then advance prev & current.  
**BinaryTreePathSumI** - https://leetcode.com/problems/path-sum/  
	"Given a binary tree, return T if there is a path from root to a leaf node that sums up to the target"  
	Recursive DFS.  
**BinaryTreePathSumIII** - https://leetcode.com/problems/path-sum-iii/  
	Double recursive DFS  
**BinaryTreePathSumII** - https://leetcode.com/problems/path-sum-ii  
	Recursive DFS. Pass down path traversed & only return when the correct conditions are met, else return empty list. Recursive function returns left + right lists joined.  
**BinaryTreeAllPaths** - https://leetcode.com/problems/binary-tree-paths  
	Recursive DFS. Same as BinaryTreePathSumII  
**BinaryTreeMinLexographicalPath** - https://leetcode.com/problems/smallest-string-starting-from-leaf/  
	Recursive DFS + Tricky filtering.  
	Get all valid paths via DFS. Find best path by iterating 1 index at a time and filtering early. Lastly, transform into string.  
**ReverseInt** - https://leetcode.com/problems/reverse-integer/  
	Tricky Math.  
	Mark if negative, re-apply it at the end. Parse last digit with %10. Multiply sum * 10 then add new digit. Repeat for each digit while dividing input by 10.  
**StringsAreInterleaved** - https://leetcode.com/problems/interleaving-string/  
	Recursive DFS.  Make recursive function with indexes as parameters. Try to advance left and right if possible. Do checks to make sure you don't push too far.  
**KMostFrequentInts**  
	"Given a list of integers and a single int K, print out the top K most occurring elements"  
	Hashmap + Sorting. Group inputs into a map by their values, where the value is the occurence count. Convert entries to sorted list descending by value. Print the first K entries (input int, occurence).  
	Linear time: Hashmap grouping + Buckets. Group values into map with key=number, value=count. Transform that into array of buckets, where index=count, value=list of numbers at that occurrence. Finally, reverse loop over buckets array and pop values.  
**CountSort** - O(Count + MaxIntValue) speed & size  
	Make flat IntArray of size 0. Loop inputs and increment each corresponding value in the flat array. Extend array on each new large input. Finally, loop over flat array and decrement values while putting the value (from index) into an arraylist. Return arraylist.  
**MergeTwoLinkedLists** - https://leetcode.com/problems/merge-two-sorted-lists/  
	"Given two sorted linked lists, merge them into a single one."
	Single Loop. Maintain pointers for head, tail, leftHead and rightHead. Early return if either input is empty. Handle both not null case - loop and pull best head+tail once else advance the best option. Handle 1 not null case - unroll that list. Advance tail after every push. Lastly, return head which was set previously.  
**MergedSortedArrayIntoPaddedSortedArray** - https://leetcode.com/problems/merge-sorted-array/  
	"Given an array with extra space and a 2nd array, merge the 2nd into the first and sort the values, excluding the padding."  
	Simple loop. Do not sort. Reverse iterate from m+n-1 and swap values into main array. Use pointers for each arrays' 'known end values'.  
**QuickSort & QuickSelect** - https://www.geeksforgeeks.org/quick-sort/  
	Make recursive sort function. If low < high, get adjusted partition index and call sort on the left & right sides. When getting adjusted partition index, choose a pivot (last element) and a smallIndex (start). Loop up to the pivot index, if any element was smaller than the pivot then swap it with the smallIndex & ++ it (this puts items smaller than the pivot to the left of the partition). Finally swap the pivot with the small index, making it separate the left & right sides.  
	To reiterate, partition splits the array according to the pivot and returns the index of the split.  
	Quickselect: Use exact same partition function but recursively call & narrow down the range. Return when pi == k.  
**IsIntPalindrome** - https://leetcode.com/problems/palindrome-number/submissions/  
	"Return true if the int is a palindrome (treated like a string). You cannot use strings"  
	Count how many digits the input is, by dividing by 10 and counting until the input is 0. Next, do the sliding window approach from end to end and compare digits. The compare function fetches specific digits by dividing by 10^digit (as int), then modding by 10.  
**InPlaceRemoveElements** - https://leetcode.com/problems/remove-element/  
	"Given an array and an integer, adjust the array so all the values except that integer are in the front, and return the final index of the array. (Remove all the elements but return the end index of the sub-array)"  
	Sliding window. Maintain start and end index. Loop over array, incremening startIndex until you find an instance of that value. Then, inner loop from the end index to find a non-match & swap them. Repeat until sliding window disappears, then return startIndex.  
	Edit: Single loop from anchor index is better! Full upgrade.  
**ComposeRanges** - https://app.codesignal.com/interview-practice/task/cHYqbQ9DiWmejAdeG  
	"Reduce an ascending intArray into a sequence of strings"  
	Arrays + Greedy loop. Loop over array until a sequence break is detected, then fill out that sequence. Finally fill out any existing sequences in progress.  
**RemoveDuplicatesFromLinkedList** - https://leetcode.com/problems/remove-duplicates-from-sorted-list  
	Greedy loop. Main loop advances tail, inner loop skips next nodes that are duplicates.  
**IntSquareRoot** - https://leetcode.com/problems/sqrtx/  
	BST Sliding window. Every iteration close it in by mid +- 1. Left is the source of truth. Undo last -1 before returning.  
**IsPerfectSquare** - https://leetcode.com/problems/valid-perfect-square/  
	Same as IntSquareRoot but verify that root square == num  
**IsSumOfSquares** - https://leetcode.com/problems/sum-of-square-numbers/  
	"Given a number, return T/F if its the sum of 2 other numbers squared  
	Linear Sliding Window, from 0 to sqrt of input.  
**!CountSubarraysWithSumTarget** - https://leetcode.com/problems/subarray-sum-equals-k/  
	"Given an array of integers, return the total number of continuous subsets that sum up to a target K"  
	Tricky Hashmap. Loop over values and maintain a rolling sum. Use a hashmap to mark counts of partial sums after each iteration, including a base case of 0->1. If ${rolling sum - target} exists in the hashmap then it means we had that many partial sub-arrays sum up to the target.  
**!MoveZeroes** - https://leetcode.com/problems/move-zeroes/  
	"Given an intArray with some 0s, in-place move all the 0s to the end)
	Simple loop. Set index = 0. Loop over numbers, if that value is NOT zero, swap it with index, then increment index.  
**ExclusiveTimeOfFunctions** - https://leetcode.com/problems/exclusive-time-of-functions/  
	Stack. On each function start, push the stack & tally the time of the last function. On each stop, pop the stack and tally the time. Return tallied time.  
**AddBinaryStrings** - https://leetcode.com/problems/add-binary/  
	Simple loop. Starting at the end of both strings, add them up and put the new binary sum in a stringbuilder. Loop until at the end of inputs & no carry bit left. Lastly prune extra 0s (but leave at least 1 character in the SB). Return reversed SB.  
**!CombinationSumII** - https://leetcode.com/problems/combination-sum-ii  
	DFS. O(2^(n-1)) speed & runtime. Similar to CombinationSumI except the index always moves forward each branch.  
	Sort input values & recursively search for a sum. On each search, only branch among unique values (prune early). Since values are searched in order & skipping duplicate branches, final solutions are guaranteed to be unique.  
	Notes: Sort values ascendingly so we can early-terminate search trees. Don't copy lists over and over, use a single arraylist & copy only when a solution is found. Don't use a hashset, its indicative of bad pruning. Don't make a custom datastructure, it just slows the algorithm down.  
**LongestCommonPrefix** - https://leetcode.com/problems/longest-common-prefix/  
	"Given a list of strings, find the longest common prefix"  
	Double loop. Take the first string and loop over its indices. Inner loop across remaining strings & search for a mismatch or end of string, then return the substring so far.  
**GroupedAnagrams** - https://leetcode.com/problems/group-anagrams  
	"Given an array of strings, group them by anagrams"  
	Group up input into a hashmap, where the key is the sorted string. Sort using countSort.  
	Runtime & Mem: O(NL) where N is the number of strings, L is the avg length. Or O(M) where M is the total amount of characters in the entire array.  
**SimplifyUnixPath** - https://leetcode.com/problems/simplify-path  
	Stacks. Loop over characters and either add to a temp path in progress OR end the stack if its a /. When ending stack, pop from pathstack on ".." or push it to the pathstack if its not "."  
**CountDecodePaths** - https://leetcode.com/problems/decode-ways/discuss/543987/Kotlin-O(n)-speed-O(1)-memory  
	Hopscotch DP. Maintain a variable for count & last count. Early terminate on impossible numbers. Split if 11-19 or 21-26. On split, add previous count to this count. On no-split, set previous count to this count.  
**EvenOddLinkedList** - https://leetcode.com/problems/odd-even-linked-list/  
	Single loop. Get heads for both sides & tails for both sides. Loop over main tail and alternate appending to each tail. Lastly null out the even tail and set the odd tail to the even head.  
**FindKthSmallestElementInBST** - https://leetcode.com/problems/kth-smallest-element-in-a-bst/  
	Recursive DFS. Define a variable for count & a recursive algorithm. Recursive algorithm searches left, increments count, checks if matches k, then searches right. If any search yeilded a result then propagate that up the callsite, else return null.  
**UniquePaths** - https://leetcode.com/problems/unique-paths/  
	"Given an X by Y board where you can only move down and right, how many unique paths exist from 0,0 to end,end?"  
	DP. This problem basically counts all the unique permutations of 2 values. For example, given 5 Ls and 1 R (5) or 5 Ls and 0 Rs (1). Build a matrix and enumerate cells. This value is equal to the value above it and left of it. Base case: edges are always 1. Simplification: dont store solution in a 2d matrix, instead replace rows as they are filled out.  
**RemoveDuplicatesFromSortedArray** - https://leetcode.com/problems/remove-duplicates-from-sorted-array/  
	Similar to MoveZeroes.  
	Simple loop. Skip first element. Maintain anchor starting at 1 and loop from 1 to end. In loop, if this value isn't the same as our last anchored value (anchor-1), swap it in (anchor) and increment anchor. Finally return anchor, as it represnts the end of our cleaned array.  
**ValidPalindromeWithSkips** - https://leetcode.com/problems/valid-palindrome-ii/  
	Sliding window. Two options here. You can do it recursively or with a single greedy loop. Recursive is recommended for several reasons, mainly scalability if you had to allow more skips.  
	Recursive: define recursive function that determines if its a valid palindrome between a Left and Right index. Loop & close in L/R each step except if its a mismatch. In that case, branch once for each side & count skips. If too many skipped, return false.  
**BSTIterator** - https://leetcode.com/problems/binary-search-tree-iterator/  
	Stack + Recursion. Maintain a stack representing the next lowest elements. On init, push the left-most path to the stack. On each next(), pop from the stack and push the left-most path of the right side. The iterator is finished when the stack is empty.  
**AddStringInts** - * https://leetcode.com/problems/add-strings/  
	Simple loop. Maintain pointers to both ends of the strings. Loop until indexes run off and no carry. Account for either one reaching 0. Subtract '0' from each to get int values, add together, append single digit, factor carry.  
**MaxSubArraySum** - https://leetcode.com/problems/maximum-subarray/  
	Simple loop. Keep rolling sum as you loop over values. If sum goes under 0, reset it. Account for negative max sums by having max initialize to Int.MIN.  
**TrieWithWildcards** - https://leetcode.com/problems/add-and-search-word-data-structure-design/  
	Trie. Define node class with isWord:Boolean and next:HashMap<Char, Node>. For add, loop through characters and build out trie graph & finally set isWord=true. For search, start with a list of root and loop over chars, mapping the list into a new list. Finally return nodes.any{ it.isWord }
**TrieWithoutWildcards** - https://leetcode.com/problems/implement-trie-prefix-tree  
	Trie. Same as above but also has startsWith() function. Same as search but also returns true if final node's next is not empty.  
**FindLargestRisingDifference** - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/  
	Simple Loop. Similar to MaxSubArraySum. We only care about max - min but we must find the min first. Loop and both set min & compare this difference compared to min. Return max difference.  
**SumOfRisingDifferences** - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/  
	Same as FindLargestRisingDifference but you keep a rolling sum. Increment sum with diff of this and last iff its positive.  
**IsSameBST** - https://leetcode.com/problems/same-tree/  
	Dirt simple recursive loop. If both null, return false. If both same, return recursive call on left && right. If not same, return false.  
**CombinationSumIII** - https://leetcode.com/problems/combination-sum-iii/  
	Recursive DFS. Define recursive function with WIP list & sum. Check base cases: if used too many or sum too high, cancel. Branch on remaining numbers in order from last used number.  
**!CombinationSumIV** - https://leetcode.com/problems/combination-sum-iv/  
	"Given an array of numbers, how many unique *permutations* sum up to a target?"
	DP. Order does matter. 1D array with base case of 0=1. Outer loop up to target from 1, inner loop over numbers propagating prev vals, like dp[dx] += dp[dx - coin].  
	Recursive solution is too damn slow.  
**!CoinChangeII** - https://leetcode.com/problems/coin-change-2/description/  
	"Given an array of numbers, how many unique *combinations* make a target sum?"  
	DP. Order doesn't matter. 1d array with base case of 0=1. Outer loop coins, inner loop up to target, like dp[dx] += dp[dx - coin]. 
	NOTES: In DP, always extend from previous cases, never do +=1. 
	Order matters, aka Permutation: outer loop target, inner loop values.
	Order does not matter aka Combination: outer loop values, inner loop target
**RobHouses** - https://leetcode.com/problems/house-robber/  
	Greedy loop. Store past 3 values. Loop over nums & set this sum as the value + max of two or three houses back.  
**LRUCache**  
	Hashmap & Linked List. Hashmap points to LL nodes. Linked list node holds key, value, prev & next. On put, push the tail off if new key, or replace existing node & move to front. On get, move node to front.  
**PossibleIPAddresses** - https://leetcode.com/problems/restore-ip-addresses/  
	Recursion. Make recursive function that takes in an index & a 'work in progress' list. Branch out 3 times, adding a 1-3 digit substring to the used list. Base case -- if theres 4 batches in the list then we are done. Be sure to verify that a batch is a valid number. Additional optimizations include: leave enough digits for remaining batches & make sure there arent too many digits remaining for remaining batches. Note: This algo runs in constant time regardless, as input can be at max 12 digits.  
**RotateLinkedList** - https://leetcode.com/problems/rotate-list/  
	Loop. Get length of head. Decide depth of new head, using mod to account for large rolls. Early terminate if no roll necessary.  Loop down and find new tail and new head. Null out new tail. Append original head to original tail, then return new head.  
**TotalTimeOfJobsWithCooldown** - FB TI  
	Simple loop. Use a hashmap to store when a job will be ready to run again. On loop, add remaining difference if exists, then increment total time.  
**ContainsDuplicatesIII** - https://leetcode.com/problems/contains-duplicate-iii/submissions/  
	Single loop with buckets. Use a map to store values in buckets, with size determined by T. Zero-normalize values so -1 doesn't offset buckets. After bucket calculated, check if bucket already exists. Check ahead and behind & do a fine compare. If buckets > k, remove last bucket  

## TODO:
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/  
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/  

Combo Sum Suite
Coin Change II
SubarraySum

# Strategy Categories

## Data Structures
**Trie** - TrieWithWildcards, TrieWithoutWildcards  

## Graph
**Recursive DFS** - CourseScheduleI, NumIslands, CourseScheduleII, KeysAndRooms, FindGrasshopper, IsValidBST, WordBreakII(pt2), FindEventualSafeStates, KeysAndRooms, InvertBinaryTree, BinaryTreePathSumI, BinaryTreePathSumII, BinaryTreeAllPaths, BinaryTreeMinLexographicalPath  
**Loop BFS** - KeysAndRooms  
**Double Recursive DFS** - BinaryTreeMaxPathSum, BinaryTreePathSumIII  
**DP Array** - MinFallingPathSum  
**Stack + Recursion** - BSTIterator  

## Linked List
**Single loop** - RemoveNthNodeFromEnd, LinkedListAdder, MergeTwoLinkedLists, ReverseLinkedList, RemoveDuplicatesFromLinkedList, EvenOddLinkedList, RotateLinkedList  
**Recursive** - RotateLinkedList  

## Matrix
**1-way sweep DP matrix** - MinimumPath2DSum  
**2-way sweep DP matrix** - DistanceFromZeroes  
**Recursive BFS** - FindLargestIsland  
**BFS** - MazeMatrixMinPath, MazeMatrixMinPathPushingBox, LightsOut, MinimumPath4DSum  

## Points
**Tricky Hashmap** - CountRectangles, PerfectRectangle, MaxPointsOnALine  

## Stacks
**Loop** - ValidParentheses, ExclusiveTimeOfFunctions, SimplifyUnixPath  
**Recursive DFS** - ValidParenthesesString, BSTIterator  

## Arrays
**Greedy Loop** - RomanToInt, ZigzagConversion, MinimumSwaps, BinaryMatrix, MergedSortedArrayIntoPaddedSortedArray, ComposeRanges, MaxSubArraySum, FindLargestRisingDifference, SumOfRisingDifferences, RobHouses  
**Loop + Hashmap** - TwoSums  
**Loop + Branch** - PhoneNumberCombos  
**Loop + Inner Loop** - PalindromeSubstring, MixedWordsConcatenated  
**Loop + Queues** - AssignCookies  
**Loop + Buckets** - ContainsDuplicatesIII  
**Recursive DFS** -  PermutationsI, PermutationsII, GenerateParentheses, CombinationSum, CombinationSumII, CombinationSumIII  
**Sliding Window** - SearchInRotatedArray, GetRangeOfNumInArray, 3-Sum, 3-SumClosests, ContainerWithMostWater  
**2D Sliding Window** - SmallestSpanningRange, InPlaceRemoveElements  
**Partial Sort** - SortPartiallySortedArray  
**Recursive + Memoization** - DivisorGame, Fibonacci  
**Tricky Math** - RepeatedSubstringPattern  
**Tricky Hashmap** - StringIncludesPermutation, MinWindowSubstring, LongestSubstringWithoutRepeatingCharacters, CountSubarraysWithSumTarget  

## Dynamic Programming  
**Single DP Array** - JumpGame, DivisorGame, KnightDialer, Fibonacci, MinCostClimbingStairs, StringMultiply, UniquePaths, CombinationSumIV, CoinChangeII  
**Simple DP Matrix** - WildcardMatching, DiceRollsWithTargetSum, MinFallingPathSum  
Note: Simple means that this can be optimized to replace each array after processing, saving memory.  
**DP Graph** - WordBreakII(pt1)  
**2 Way Sweep** - CandyDistribution, ShortestDistanceToChar  

## Numbers
**Recursive + Tricky Math** - IntegerDivision  
**Loop + Tricky Math** - ReverseInt, IsIntPalindrome  
**Binary Sliding Window** - IntSquareRoot, IsPerfectSquare  
**Linear Sliding Window** - IsSumOfSquares  
**Simple Loop** - MoveZeroes, AddBinaryStrings, RemoveDuplicatesFromSortedArray    

## Strings
**Simple Loop** - AddStringInts, TotalTimeOfJobsWithCooldown  
**Loop + Hashset** - SimilarWords  
**Double Loop** - LongestCommonPrefix  
**Loop + Countsort** - GroupedAnagrams  
**Hopscotch DP** - CountDecodePaths  
**Fixed Sliding Window** - StringIncludesPermutation  
**Variable Sliding Window** - MinWindowSubstring  
**Closing Sliding Window** - ValidPalindromeWithSkips  
**RecursiveDFS** - PossibleIPAddresses  


### DP Tricks

Usually there is a base case of 0=1  
Usually you do NOT add +1, you += a previous value  

Combinations: e.g. CoinChangeII  
	For each value, loop DP rows. (Enumerate rows)  

Permutations: e.g. CombinationSumIV  
	For each index, loop through values. (Enumerate columns)  

<img src="dp combination permutations.jpg"/>

Trick to remember: Think of how you draw a P. Top to bottom, come back up and go right a bit.   
