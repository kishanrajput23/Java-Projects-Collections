def LinearSearch(input_list,element):
    list_len = len(input_list)
    for i in range(list_len):
        if input_list[i] == element: #checks arr[element] equal to given element
            return i #return index where the given element is present
    return -1 #if element is not present 

myList = [10, 2, 40, 12, 41, 50, 11, 20, 60, 32]
print("The given list is", myList)
position = LinearSearch(myList, 20)
print( "The given Element 20 is at position:", position)

#Time complexity -worst case -o(n) where n is number of elements in list
