# Problem
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is **23**. The path is denoted by numbers in bold.
```
   3
  7 4
 2 4 6
8 5 9 3
```
 
 
 

That is
```
3 + 7 + 4 + 9 = 23
```

Find the maximum total from top to bottom of the triangle given in input.


# Solution
The solution to this problem is not to use brute force by applying recursion to find the path with the max sum but to make the following considerations:

* the triangle is a tree in which the parent node shares a child node with his sibling ( the node with value 2 has two childen 8 and 5 but 5 is also a child of node with value 4)
* the problem asks for the maximum sum but it does not require the path traversed to obtain that sum

Taking in account the previous considerations we can archieve the solution in the following way:
* traverse the tree from bottom to top
* for each row take the elements two by two and find the maximum between them 
* add the maximum to the value of the parent
* get the final value in root that will be the maximum sum

This solution applies both to problem 18 and 67
