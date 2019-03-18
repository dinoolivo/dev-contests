# Problem
Starting in the top left corner of a 2x2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a NxM grid? As number of ways can be very large, print it modulo (10<sup>9</sup>+7).



# Solution
This problem can be solved in two ways:
* with recursion (not efficient) in which for each iteration move right or down until matrix[maxRow][maxCol] is reached incrementing the count by one
* with lattice paths formula [Lattice Path wiki](https://en.wikipedia.org/wiki/Lattice_path) where n is the number of rows and k the number of columns

Both solutions are considered into the contest15.kt file
