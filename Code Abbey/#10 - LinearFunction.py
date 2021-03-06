def lin(input):
    
    nums = input.split()
    nums = [int(num) for num in nums]
    answer = ''
    pairs = nums[0]
    nums.remove(nums[0])
    
	#basically calculate slope, then solve
	#for b, and cast as ints
    for i in range(0, len(nums), 4):
        x1, y1, x2, y2 = nums[i], nums[i+1], nums[i+2], nums[i+3]
        slope_a = int((y2-y1)/(x2-x1))
        b = int(y1 - (slope_a*x1))
        answer += "(" + str(slope_a) + " " + str(b) + ") "
        
    print(answer)
