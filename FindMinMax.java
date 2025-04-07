import java.util.Scanner;

class MinMax {
    int min, max;

    MinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class FindMinMax {
    public static MinMax findMinMax(int[] arr, int low, int high) {
        if (low == high) {
            return new MinMax(arr[low], arr[low]);
        }
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                return new MinMax(arr[low], arr[high]);
            } else {
                return new MinMax(arr[high], arr[low]);
            }
        }
        int mid = (low + high) / 2;
        MinMax leftResult = findMinMax(arr, low, mid);
        MinMax rightResult = findMinMax(arr, mid + 1, high);
        int min = Math.min(leftResult.min, rightResult.min);
        int max = Math.max(leftResult.max, rightResult.max);
        return new MinMax(min, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MinMax result = findMinMax(arr, 0, n - 1);
        System.out.println("Minimum element: " + result.min);
        System.out.println("Maximum element: " + result.max);
        sc.close();
    }
}