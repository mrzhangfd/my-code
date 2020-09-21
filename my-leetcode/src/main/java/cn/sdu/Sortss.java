package cn.sdu;

/**
 * 排序第二遍
 *
 * @author icatzfd
 * Created on 2020/9/15 13:36.
 */
public class Sortss {

    //快排
    public static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void quickSortHelper(int[] nums, int left, int right) {
        if (left < right) {
            int idv = partation1(nums, left, right);
            quickSortHelper(nums, left, idv - 1);
            quickSortHelper(nums, idv + 1, right);
        }

       /* if (left < right) {
            int idv = partation2(nums, left, right);
            quickSortHelper(nums, left, idv - 1);
            quickSortHelper(nums, idv + 1, right);
        }*/

    }

    private static int partation1(int[] nums, int left, int right) {

        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];

        }
        nums[left] = pivot;
        return left;

    }

    private static int partation2(int[] nums, int left, int right) {
        int pivot = left;
        //idx指向第一个比枢纽(nums[pivot])大的数的下标
        int idx = left + 1;
        for (int i = idx; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, idx - 1, pivot);
        return idx - 1;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    //冒泡排序优化一
    public void bubbleSort(int[] nums) {
        boolean flag = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }

    //冒泡排序优化二
    //border就是无序数列的边界。每一轮排序过程中，border之后的元素就完全不需要比较了，肯定是有序的。
    public void bubbleSort1(int[] nums) {
        boolean flag = false;
        int n = nums.length;
        //记录最后一次交换的位置
        int lastIdx = 0;

        //无序数组的边界，每次比较只需要比较到这里为止
        int border = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < border; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                    lastIdx = j;
                }
            }
            border = lastIdx;
            if (!flag) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 3, 2, 5, 6, 1};
        quickSort(nums);

    }


}
