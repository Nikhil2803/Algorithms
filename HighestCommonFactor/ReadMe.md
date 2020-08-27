# Highest Common Factor

Highest common factor (H.C.F) of two or more numbers is the greatest number which divides each of them exactly.

# Example
Factors of 6 = 1, 2, 3 and 6.
Factors of 9 = 1, 3 and 9.
Therefore, common factors of 6 and 9 = 1 and 3.
Highest common factor (H.C.F) of 6 and 9 = 3.

# Real Life Problems for HCF

There are four buckets of 14,28,35 and 49 ltr,and you have to use a container of the largest volume with which all the bucket's water could be measured exactly.
Ans: HCF of 14,28,35 and 49 i.e. 7

# Solution

>> 1. Iterate through all prime numbers and divide all the given numbers. The product of all the prime numbers that divided given numbers is HCF

>> 2. Take two number for which you have to find HCF. Keep on substracting the numbers from bigger to smaller. At the end either you would have two equal numbers that will result 0 is substration or you would have 1 as result of substraction. If we get equal numbers than that would be the HCF or else 1 would be the HCF

    Example:  18,15
            ->  18 - 15 = 3
            ->  15 - 3  = 12
            ->  12 - 3  = 9
            ->   9-  3  = 6
            ->   6 - 3 =  3
            ->   3 - 3  = 0      3 is the HCF of 18 & 15
            
>> 3. Similar to above method just in place of substraction we can use modulous operation that will reduce the number of itterations 

     Example:  18,15
            ->  18 % 15 = 3
            ->  15 % 3  = 0    3 is the HCF of 18 & 15
