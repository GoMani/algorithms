def printFib(n):
    """Print a Fibonacci series up to n terms."""
    a,b,i=0,1,0
    while i<n:
        print b
        a,b=b,a+b
        i+=1

printFib(20)
