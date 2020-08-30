class Prime {

    void checkPrime(int... intArr)
    {
        for(int a : intArr)
        {
            if(isPrime(a))
            {
                System.out.print(a + " ");
            }
        }
        System.out.println();
    }

    boolean isPrime(int num)
    {
        if(num == 2)
        {
            return true;
        }

        if(num < 2 || num % 2 == 0)
        {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(num); i++)
        {
            if(num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}