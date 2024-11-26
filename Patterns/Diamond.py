#     Diamond star pattern
#     output like:
#     *
#    ***
#   *****
#  *******
# *********
#  *******
#   *****
#    ***
#     *

n=5
for i in range(n):
  for j in range(n-i-1):
    print(" ",end="")
  for j in range((2*i)+1):
    print("*",end="")
  print("")
for k in range(1,n):
  for l in range(0,k):
    print(" ",end="")
  for l in range(2*(n-k)-1):
    print("*",end="")
  print("")
    

