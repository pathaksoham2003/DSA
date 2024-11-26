# Inverted right angle + right angle 
#In these code 2 patterns are there one after one 
# expected output:

# *****
# ****
# ***
# **
# *
# *
# **
# ***
# ****
# *****

# *****
#  ****
#   ***
#    **
#     *
#     *
#    **
#   ***
#  ****
# *****


n=5
for i in range(n):
    for j in range (i,n):
        print("*",end="")
    print("")
for k in range(n):
    for l in range(k+1):
        print("*",end="")
    print("")
print("")

# Same pattern on opposite side

for i in range(n):
    for j in range(i):
        print(" ",end="")
    for k in range(i,n):
        print("*",end="")
    print("")
for i in range(1,n+1):
    for j in range(i,n):
        print(" ",end="")
    for k in range(i):
        print("*",end="")
    print("")