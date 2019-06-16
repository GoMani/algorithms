# Insertion Sort
# complexity O(nSquare)
#
def insertionSort(arr,asc=True):
    if len(arr) <2 :
        return arr
    for j in range(1, len(arr)):
        current= arr[j]
        i= j-1
        while i>=0 and comparator(arr[i],current,asc) :
            arr[i+1]= arr[i]
            i=i-1
        arr[i+1] =current
    return arr

def comparator(i,j,asc):
    if asc :
        return i > j
    return j > i

result= insertionSort( [4,2,5,1,3])
for i in result:
    print i
result= insertionSort( [4,2,5,1,3],False)
for i in result:
    print i