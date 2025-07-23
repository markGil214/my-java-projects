

package projects.Indexing;
public class TargetNum {
    public static void main(String[] args) {
        int nums[] = {12, 5, 6, 20, 50};
        int target = 4;
        int resultIndex = -1;

        int index = 0;
        for(int num : nums) {
            if(num == target) {
                resultIndex = index;
                break;
            }
            index++;
        }

        System.out.println("Output: " + resultIndex);
    }
}

