# Creating a bubble sort function 

def bubble_sort(array):  
    for i in range(0, len(array)-1):  
        for j in range(len(array)-1):  
            if(array[j] > array[j+1]):  
                tempList = array[j]  
                array[j] = array[j+1]  
                array[j+1] = tempList  
    return array  
  
  
unsortedList = [6, 4, 9, 7, 8, 3]  
print("The unsorted list is: ", unsortedList)  

# Calling the bubble sort function  
print("The sorted list is: ", bubble_sort(unsortedList)) 
