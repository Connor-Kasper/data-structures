import java.util.Scanner;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        Set<Integer> primes = new TreeSet<>();

        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }
        for (int p = 2; p * p <= n; p++) {
            if (primes.contains(p)) {
                for (int i = p * 2; i <= n; i += p) {
                    primes.remove(i);
                }
            }
        }
        System.out.println("The prime numbers up to " + n + " are:");
        System.out.println(primes);
    }
}
