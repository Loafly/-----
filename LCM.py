N = int(input())

def GCD(a, b):
    while(b):
        a, b = b, a % b
    return a

def LCM(a, b):
    # max_value = max(a, b)

    # for i in range(max_value, (a * b) + 1, 1 ):
        # if i % a == 0 and i % b == 0:            
            # return i
    return (a *b) // GCD(a, b)
        



for i in range(N):
    a, b = map(int, input().split())
    print(LCM(a, b))
