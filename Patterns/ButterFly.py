n = 4

for i in range(0,5):
    for j in range(0,5):
        if j == 0 or j == n:
            print("*",end="")
        elif i == j:
            print("*",end="")
        elif i + j == n:
            print("*",end="")
        else:
            print(" ",end="")
    print("\n")
