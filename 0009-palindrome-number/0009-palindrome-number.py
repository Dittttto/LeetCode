class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            print(x)
            return False
        
        number = str(x)
        numberArr = list(number)
        numberArrReverse = numberArr[::-1]
        
        return  numberArr == numberArrReverse