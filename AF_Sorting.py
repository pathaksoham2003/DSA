arr = [16,23,45,9,55]
def bubble(arr):
    for i in range(0,len(arr)):
        for j in range(0,len(arr)-1):
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
bubble(arr)
print(arr)
arr = [16,23,45,9,55]
def selection(arr):
    for i in range(0,len(arr)):
        for j in range(0,len(arr)-i-1):
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
selection(arr)
print(arr)
arr = [16,23,45,9,55]
def swap(arr,first,second):
    temp = arr[first]
    arr[first] = arr[second]
    arr[second] = temp
def findMax(arr,start,end):
    max = -1
    for i in range(start,end):
        if max < arr[i]:
            max = i
    return max
def insertion(arr):
    for i in range(0,len(arr)):
        maxEleIndex = findMax(arr,0,len(arr)-i-1)
        swap(arr,maxEleIndex,len(arr)-1-i)
insertion(arr)
print(arr)
arr = [4,5,1,2,3,7,6]
def cyclic(arr):
    i = 0
    while(i<len(arr)):
        correct = arr[i] - 1
        if arr[correct] != arr[i]:
           swap(arr,correct,i)
        else:
            i = i + 1
cyclic(arr)
print(arr)
    