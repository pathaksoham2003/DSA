# inverted pyramid star pattern
# if n=5
# * * * * * 
#  * * * *
#   * * *
#    * *
#     *

# n=5
n=int(input("Enter height :"))
for i in range(n):
    for j in range(i):
        print(" ",end="")
    for j in range (i,n):
        print("* ",end="")
    print("")

