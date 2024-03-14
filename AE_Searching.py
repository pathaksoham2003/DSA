## Time Complexity :- O(N)
arr = [1,2,3,4,5,6,7,8,9]
def linear(arr,target):
    for i in range(0,len(arr)):
        if(arr[i]==target):
            return i
    return -1
## Time Complexity :- O(logN)
def binary(arr,target):
    start = 0
    end = len(arr) - 1
    while(start <= end):
        mid = (start + end) // 2
        if(arr[mid] > target):
            start = mid + 1
        elif(arr[mid] < target):
            end = mid - 1
        else:
            return mid
    return -1
print(linear([1,2,3,4,5,6,7],5))
print(binary([1,2,3,4,5,6,7],6))