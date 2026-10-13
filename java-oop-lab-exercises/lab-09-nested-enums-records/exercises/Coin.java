// Assignment 9 (Lab 9) - Exercise 5 (Challenge): enum with fields and a greedy coin method
import java.util.EnumMap;
import java.util.Map;

public enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int cents;

    Coin(int cents) { this.cents = cents; }

    public int getCents() { return cents; }

    // Fewest coins for the amount: greedy from the largest coin (optimal for this coin system)
    public static Map<Coin, Integer> fewestCoins(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        Map<Coin, Integer> result = new EnumMap<>(Coin.class);
        Coin[] coins = values();
        for (int i = coins.length - 1; i >= 0; i--) {
            int count = amount / coins[i].cents;
            if (count > 0) {
                result.put(coins[i], count);
                amount %= coins[i].cents;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] amounts = {67, 41, 99, 5, 0};
        for (int a : amounts) {
            Map<Coin, Integer> r = fewestCoins(a);
            int total = r.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println(a + " cents -> " + r + " (" + total + " coins)");
        }
    }
}
