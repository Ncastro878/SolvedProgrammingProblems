def check(input):
    
    lister = input.split()
    lister.remove(lister[0])
    lister = [int(num) for num in lister]
    
    summ = 0
    for num in lister:
        summ += num
    
        summ = summ*113
    
        summ = summ%10000007 
    
    print(summ)
