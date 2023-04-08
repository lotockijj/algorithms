package three.four;

/*
Hash cache. Modify Transaction on page 462 to maintain an instance variable hash,
so that hashCode() can save the hash value the first time it is called for each object
and does not have to recompute it on subsequent calls. Note : This idea works only for immutable types.
 */

import java.util.*;

public class Exercise_3_4_25 {

    public static void main(String[] args) {
        Transaction transaction1 = new Transaction("Roman", new Date(), 5.0);
        Transaction transaction2 = new Transaction("Volodya", new Date(), 3.0);
        Transaction transaction3 = new Transaction("Sergiy", new Date(), 1.0);
        Set<Transaction> transactions1 = new HashSet<>();
        transactions1.addAll(Arrays.asList(transaction1, transaction2, transaction3));
        System.out.println(Transaction.getCountOfHashCodeAccess());
        Set<Transaction> transactions2 = new HashSet<>();
        transactions2.addAll(Arrays.asList(transaction1, transaction2, transaction3));
        System.out.println(Transaction.getCountOfHashCodeAccess());
    }
}
