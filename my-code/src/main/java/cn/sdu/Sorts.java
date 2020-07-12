package cn.sdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 张峰达
 * Created on 2020/5/2 16:52.
 */

public class Sorts {
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        //p0表示数字0的最右边界下标
        int p0 = 0;
        //p2表示数字2的最左边界下标
        int p2 = nums.length - 1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, p0, cur);
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
                //因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，而与p2交换的值，
                // curr未扫描，要停下来扫描一下，所以curr不用++
            } else {
                cur++;
            }
        }
        System.out.println("1");
    }


    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        //1 使用哈希表展示数组中的数字频率
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        //2 使用频率作为数组下标
        List<Integer>[] lists = new List[nums.length + 1];
        for (int key : hashMap.keySet()) {
            int i = hashMap.get(key);
            if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }
            lists[i].add(key);
        }

        // 3 根据数组下标，倒序输出频率前k大的数字
        for (int i = lists.length - 1; i > 0 && res.size() < k; i--) {
            if (lists[i] == null) {
                continue;
            }
            res.addAll(lists[i]);
        }

        //4 list 转int[]
        return res.stream().mapToInt(Integer::valueOf).toArray();

    }

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        //1 使用hashmap 表示频率
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        //2 使用频率作为数组下标
        List<Character>[] lists = new List[chars.length + 1];
        for (char key : hashMap.keySet()) {
            int i = hashMap.get(key);
            if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }
            lists[i].add(key);
            //错误写法
           /* if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }else {
                lists[i].add(key);
            }*/

        }
        StringBuilder res = new StringBuilder();
        //3 根据数组下标 倒序
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] == null) {
                continue;
            }
            for (char c : lists[i]) {
                for (int j = 0; j < i; j++) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    //冒泡排序
    public int[] bubbleSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            //设定一个标记，若为true，则此次循环没有交换。也就是有序。
            boolean flag = true;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (false) {
                break;
            }
        }
        return arr;
    }

    //选择排序
    public int[] selectionSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            swap(arr, i, min);
        }
        return arr;
    }


    //快排
    public int[] quickSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSortHelper(arr, 0, arr.length - 1);
    }

    private int[] quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSortHelper(arr, left, partitionIndex - 1);
            quickSortHelper(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        //index指的是数组中第一个比arr[pivot]大的数的下标
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    //归并排序
    public int[] mergeSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2) {
            return arr;
        }
        merge_sort(arr, 0, arr.length - 1);
        return arr;
    }

    private void merge_sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int i1 = left;
        //注意i2的取值
        int i2 = mid + 1;
        int[] temp = new int[right - left + 1];
        int idx = 0;

        //注意 i1和i2的 取值范围
        while (i1 <= mid && i2 <= right) {
            if (arr[i1] <= arr[i2]) {
                temp[idx++] = arr[i1++];
            } else {
                temp[idx++] = arr[i2++];
            }
        }
        while (i1 <= mid) {
            temp[idx++] = arr[i1++];
        }
        while (i2 <= right) {
            temp[idx++] = arr[i2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i + left] = temp[i];
        }
    }


    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 23, 22, 76, 1, 5, 7, 2};
        Sorts sorts = new Sorts();
        String ss = "tree";
        //sorts.frequencySort(ss);
        sorts.quickSort(nums);


        //sorts.sortColors(nums);
    }
}
