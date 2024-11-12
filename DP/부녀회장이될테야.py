k = int(input())

def solved(floor, ho, arrays):

    if ho == 1:
        arrays[floor][ho] = ho
        return
    
    if floor == 0:
        arrays[floor][ho] = ho
        return

    
    if arrays[floor - 1][ho] == 0:
        solved(floor - 1, ho, arrays)

    if arrays[floor][ho - 1] == 0:
        solved(floor, ho - 1, arrays)

    arrays[floor][ho] = arrays[floor - 1][ho] + arrays[floor][ho - 1]



for i in range(k):
    floor = int(input())
    ho = int(input())

    arrays = [[0 for col in range(ho + 1)] for row in range(floor + 1)]

    solved(floor, ho, arrays)
    print(arrays[floor][ho])
