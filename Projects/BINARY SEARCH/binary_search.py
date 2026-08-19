nums = []
print("Enter 10 Numbers (in ascending order):")
for i in range(10):
    nums.insert(i, int(input()))
print("Enter a Number to Search:")
search = int(input())
first = 0
last = 9
middle = (first+last)/2
middle = int(middle)
while first <= last:
    if nums[middle]<search:
        first = middle+1
    elif nums[middle]==search:
        print("The Number Found at Position:")
        print(middle+1)
        break
    else:
        last = middle-1
    middle = (first+last)/2
    middle = int(middle)
if first>last:
    print("The Number is not Found in the List")