n=int(input("enter no\n"))
count=n
res=1
while count>0:
    res=res*count
    count-=1

print("factorial of ",n,"is",res)
