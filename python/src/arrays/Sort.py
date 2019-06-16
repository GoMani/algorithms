# Insertion Sort
# complexity O(nSquare)
#
def insertionSort(arr,asc=True):
    if len(arr) <2 :
        return arr
    for j in range(1, len(arr)):
        current,i= arr[j],j-1
        while i>=0 and comparator(arr[i],current,asc) :
            arr[i+1],i= arr[i],i-1
        arr[i+1] =current
    return arr

def comparator(i,j,asc):
    if asc :
        return i > j
    return j > i

def selectionSort(array,asc=True):
    if len(array) <2 : 
        return array
    for j in range(0, len(array)-1):
        current, minOrMax,index,i=array[j],array[j],j,j+1
        while i < len(array):
            if comparator(minOrMax,array[i],asc) :
                minOrMax,index =array[i],i
            i = i+1
        array[j],array[index] =minOrMax,current
    return array



result= insertionSort( [4,2,5,1,3])
print ("insertionSort asc")
for i in result:
    print (i)
print ("insertionSort desc")
result= insertionSort( [4,2,5,1,3],False)
for i in result:
    print (i)

result= selectionSort( [4,2,5,1,3])
print ("selectionSort asc")
for i in result:
    print (i)

result= selectionSort( [4,2,5,1,3],False)
print ("selectionSort desc")
for i in result:
    print (i)