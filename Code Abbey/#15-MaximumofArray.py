def maxx(input):
    lister = input.split()
    lister = [int(num) for num in lister]
    maxx = lister[0]
    minn = lister[0]
    answer = ''
    for i in range(0, len(lister)):
        if lister[i] > maxx:
            maxx = lister[i]
        
        if lister[i] < minn:
            minn = lister[i]
    
    answer = str(maxx) + ' ' + str(minn)
    return answer
