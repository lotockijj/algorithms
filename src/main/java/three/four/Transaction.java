package three.four;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final String who;
    private final Date when;
    private final double amount;
    private int cacheHash;
    private static int countOfHashCodeAccess = 0;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public int hashCode(){
        //if(getCacheHash() != 0) return cacheHash;
        int hash = 1;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + when.hashCode();
        hash = 31 * hash + ((Double)amount).hashCode();
        cacheHash = hash;
        countOfHashCodeAccess++;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(who, that.who) &&
                Objects.equals(when, that.when);
    }

    public String getWho() {
        return who;
    }

    public Date getWhen() {
        return when;
    }

    public double getAmount() {
        return amount;
    }

    public int getCacheHash() {
        return cacheHash;
    }

    public static int getCountOfHashCodeAccess() {
        return countOfHashCodeAccess;
    }
}
