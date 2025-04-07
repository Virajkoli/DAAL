import java.util.*;

class Item {
    int value, weight;
    float ratio;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (float) value / weight;
    }
}

public class FractionalKnapsack {

    public static float fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items, (a, b) -> Float.compare(b.ratio, a.ratio)); // descending order by ratio

        int remainingCapacity = capacity;
        float totalValue = 0.0f;

        for (Item item : items) {
            if (remainingCapacity == 0)
                break;

            if (item.weight <= remainingCapacity) {
                remainingCapacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((float) remainingCapacity / item.weight);
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();

        float maxValue = fractionalKnapsack(capacity, items);
        System.out.printf("The maximum value that can be obtained: %.2f\n", maxValue);

        sc.close();
    }
}
