
package projects.MaxNum;
public class Max {
    public static void main(String[] args) {
        int nums[] = {3, 7, 2, 8, 4};
        int max = nums[0];

        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        System.out.print("biggest number among: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\nis: " + max);
    }
}
