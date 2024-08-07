# Logical Coding Challenges

## Challenge 1: Find the most frequent integer in an array

Write a function that takes an array of integers and returns the most frequent integer in the array. 
If there are multiple integers that have the same highest frequency, return the integer that appears first in the array.

For example, given the array `[1, 3, 1, 3, 2, 1]`, the output should be `1`.

Another example, given the array `[1, 2, 3, 4, 5, 6, 7, 8, 9]` the output should be `1`.

```java
public int mostFrequent(int[] input) {
    // Your code here
}
```

## Challenge 2: Find the longest substring of unique characters

Write a function that takes a string and returns the longest substring of unique characters in that string.

For example, given the string `"abcabcbb"`, the output should be `"abc"`, as the longest substring of unique characters is `"abc"`.

Another example, given the string `"bbbbb"`, the output should be `"b"`, as the longest substring of unique characters is `"b"`.

```java
public String longestSubstring(String input) {
    // Your code here
}
```

## Challenge 3: Matrix: Search a 2D Matrix II

Write an efficient algorithm that searches for a value in an `m x n` matrix. This matrix has the following properties:
- Integers in each row are sorted in ascending order from left to right.
- Integers in each column are sorted in ascending order from top to bottom.

To solve this problem efficiently, we can use a search strategy starting from the top-right corner of the matrix. 
From there, we can make decisions to move either left or down based on the current element's comparison with the target. 
This approach ensures that we discard one row or one column in each step, leading to an average time complexity of
O(m+n) and a worst-case time complexity of O(m+n).

