package socket.server.manager;

public class PrimeCalculationManager {
    public int findPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
