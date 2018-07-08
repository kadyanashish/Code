Check length of a string is equal to the number appended at its last
Given a string that (may) be appended with a number at last. You need to find whether the length of string excluding that number is equal to that number. For example for “helloworld10”, answer is True as helloworld consist of 10 letters. Length of String is less than 10,000.

Examples:

Input:  str = "geeks5"
Output:  Yes
Explanation : As geeks is of 5 length and at 
              last number is also 5.

Input:  str = "geeksforgeeks15"
Output:  No
Explanation: As geeksforgeeks is of 13 length and
             at last number is 15 i.e. not equal
Asked in: Codenation Interview

We strongly recommend that you click here and practice it, before moving on to the solution.

A Naive approach is to traverse from starting and retrieve the number from string and check if length of string – digits in the number = number or Not

An efficient method is to do following steps

Traverse string from end and find the number stored.
If the number is equal to length of string except that number’s digits then return true.
Else return false.
// C++ program to check if size of string is appended
// at the end or not.
#include<bits/stdc++.h>
using namespace std;
 
// Function to find if given number is equal to
// length or not
bool isequal(string str)
{
    int n = str.length();
 
    // Traverse string from end and find the number
    // stored at the end.
    // x is used to store power of 10.
    int num = 0, x = 1, i = n-1;
    for (i=n-1; i>=0; i--)
    {
        if ('0' <= str[i] &&  str[i]  <= '9')
        {
            num = (str[i] - '0')*x + num;
            x = x * 10;
        }
        else break;
    }
 
    // Check if number is equal to string length except
    // that number's digits
    return num == i+1;
}
 
// Drivers code
int main()
{
    // Your C++ Code
    string str = "geeksforgeeks13";
    isequal(str)? cout << "Yes" : cout << "No";
    return 0;
}