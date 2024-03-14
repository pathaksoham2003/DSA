# Merge Sort
# Time : O(n.log(n))
# Space : O(log(n))
def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def merge(first, second):
    mix = []
    i = j = 0
    while i < len(first) and j < len(second):
        if first[i] < second[j]:
            mix.append(first[i])
            i += 1
        else:
            mix.append(second[j])
            j += 1
    mix.extend(first[i:])
    mix.extend(second[j:])
    return mix

arr = [100, 220, 990, 860, 750, 2004, 2003, 1203]
print(merge_sort(arr))

# Merge Sort
# Time : O(n.log(n))
# Space : O(log(n))
def merge_sort_in_place(arr, s, e):
    if e - s == 1:
        return
    mid = (s + e) // 2
    merge_sort_in_place(arr, s, mid)
    merge_sort_in_place(arr, mid, e)
    merge_in_place(arr, s, mid, e)

def merge_in_place(arr, s, m, e):
    mix = [0] * (e - s)

    i = s
    j = m
    k = 0

    while i < m and j < e:
        if arr[i] < arr[j]:
            mix[k] = arr[i]
            i += 1
        else:
            mix[k] = arr[j]
            j += 1
        k += 1

    # it may be possible that one of the arrays is not complete
    # copy the remaining elements
    while i < m:
        mix[k] = arr[i]
        i += 1
        k += 1

    while j < e:
        mix[k] = arr[j]
        j += 1
        k += 1

    for l in range(len(mix)):
        arr[s+l] = mix[l]

arr = [100,220,990,860,750,2004,2003,1203]
merge_sort_in_place(arr, 0, len(arr))
print(arr)

# Quick Sort : 
# Time:O(n.log(n)) 
# Space:O(log(n))
def quick(arr,low,high):
    if low>=high:
        return
    start = low
    end = high 
    mid  = start + (end - start)//2
    pivot = arr[mid]
    while(start<=end):
        while(arr[start] < pivot):
            start = start + 1
        while(arr[end]>pivot):
            end = end - 1
        if(start <= end):
            temp = arr[start]
            arr[start] = arr[end]
            arr[end] = temp
            start = start + 1
            end = end - 1
    quick(arr,low,end)
    quick(arr,start,high)
        
arr = [100,220,990,860,750,2004,2003,1203]
quick(arr,0,len(arr)-1)
print(arr)        
