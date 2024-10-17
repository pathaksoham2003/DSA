## Half Diamond
# *
# **
# ***
# **
# *

n = int(input("Enter any number: "))
col = 1

for i in range(1, n * 2):
    for j in range(1, col):
        print("*", end="") 

    print("")  
    if i < n:
        col += 1
    else:
        col -= 1
        
    