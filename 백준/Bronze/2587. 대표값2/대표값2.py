nums =[]
sum =0
for i in range(5):
    num = int(input())
    nums.append(num)
    sum +=int(num)

nums.sort()
avg = int(sum / len(nums))

print(avg)


if len(nums)%2 ==0:
    middle= nums[len(nums)//2]
    print(middle)
if len(nums)%2 ==1:
    middle = nums[len(nums)//2]
    print(middle)
