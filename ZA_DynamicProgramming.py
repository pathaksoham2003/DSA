ans = [0,0,1]
def tribo(n): 
    if n <= 1:
        return 0
    if n <= 2:
        return 1
    nthtribo = tribo(n-1) + tribo(n-2) + tribo(n-3)
    ans.append(nthtribo)
    return nthtribo
tribo(4)
print(ans)
