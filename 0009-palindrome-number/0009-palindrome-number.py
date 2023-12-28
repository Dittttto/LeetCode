class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            print(x)
            return False
        
        number = str(x)
        isPal = True
        for i in range(len(number)//2):
            if(number[i] != number[-1-i]):
                isPal = False
                break
        return  isPal