from collections import deque

class Solution:
    def bfs(self, begin, target, alphabetDict, words, memo, wordDict):
        q = deque()
        q.append((begin, 1))
        memo.add(begin)

        while q:
            temp = len(q)

            for _ in range(temp):
                cur, count = q.popleft()
                if cur == target:
                    return count

                for j in range(len(cur)):
                    for v in alphabetDict[j+1]:
                        newW = cur[:j] + v + cur[j+1:]
                        if newW not in wordDict: continue
                        if newW in memo: continue
                        memo.add(newW)
                        q.append((newW, count+1))
        return 0
                    
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if endWord not in wordList:
            return 0
    
        alphabetDict = {}
        wordDict = {}
        for i in wordList:
            wordDict[i] = 1
        for i in range(len(wordList[0])):
            alphabetDict[i+1] = set()
            for j in wordList:
                alphabetDict[i+1].add(j[i:i+1])
                

        return self.bfs(beginWord, endWord, alphabetDict, wordList, set(), wordDict)