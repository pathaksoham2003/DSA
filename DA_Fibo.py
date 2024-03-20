## Fibonacci using dynamic programming
def fibo(n):
    if n == 0 or n==1:
        return n
    return fibo(n-1) + fibo(n-2)

print(fibo(5))
## Memoization for fibo
def fiboMemo(n,fibos):
    if n == 0 or n == 1:
        return n
    if fibos[n] != 0:
        return fibos[n]
    else:
        fibos[n] =  fiboMemo(n-1,fibos) + fiboMemo(n-2,fibos)
        return fibos[n]
    
n = 6 
fibos = [0] * (n + 1)
print(fiboMemo(n,fibos))

def countStairs(n,dp):
    if n == 0:
        return 1
    if n < 0:
        return 0
    dp[n] = countStairs(n-1,dp) + countStairs(n-2,dp)
    print(dp)
    return dp[n]
n = 5
dp = [0] * (n+1)
countStairs(n,dp)
