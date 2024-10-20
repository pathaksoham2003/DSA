#     Diamond star pattern
#     output like:

#     *
#    * *
#   * * *
#  * * * *
# * * * * *
#  * * * *
#   * * *
#    * *
#     *


n = 5
# n=int(input("Enter height :"))

for i in range(n):
    for j in range(n, i, -1):
        print(" ", end="")
    for k in range(i ):
        print("*", end="")
    print()

for i in range(n):
    for j in range(i):
        print(" ", end="")
    for k in range(n , i , -1):
        print("*", end="")
    print()
    

