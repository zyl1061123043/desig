package com.example.desig.algorithm;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhouyulong@uyaogui.com
 * @date 2021/11/25
 * description  十大经典排序
 */
public class SortingDemo {
    public static void main(String[] args) {
        int[] demoArray = new int[]{4,1,3,2,0};
        /*for (int index = 0; index < 5; index++) {
            demoArray[index] = (int) (Math.random() * 5);
        }*/
        int[] temp = new int[demoArray.length];
        mergeSort(demoArray, 0, demoArray.length - 1);
        System.out.println(Arrays.toString(demoArray));
        LinkedList linkedList = new LinkedList();
        //linkedList.add();
    }

    /**
     * @author zhouyulong@uyaogui.com
     * @date 2021/12/1
     * description  希尔排序
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * <p>
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    private static void shellSort(int[] demoArray) {
        //增量每次都/2
        for (int step = demoArray.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < demoArray.length; i++) {

                int j = i;
                int temp = demoArray[j];

                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && demoArray[j - step] < temp) {
                    demoArray[j] = demoArray[j - step];
                    j = j - step;
                }
                demoArray[j] = temp;
            }
        }
    }

    /**
     * @author zhouyulong@uyaogui.com
     * @date 2021/12/1
     * description  插入排序
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     */
    private static void insertSort(int[] demoArray) {
        int preIndex;
        int current;
        for (int i = 1; i < demoArray.length; i++) {
            preIndex = i - 1;
            current = demoArray[i];
            while (preIndex >= 0 && demoArray[preIndex] > current) {
                demoArray[preIndex + 1] = demoArray[preIndex];
                preIndex--;
            }
            demoArray[preIndex + 1] = current;
        }
    }

    /**
     * @author zhouyulong@uyaogui.com
     * @date 2021/12/1
     * description  选择排序
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     */
    private static void selectionSort(int[] demoArray) {
        int minIndex;
        int temp;
        int length = demoArray.length;
        for (int i = 0; i < length; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (demoArray[j] < demoArray[minIndex]) {
                    minIndex = j;
                }
            }
            temp = demoArray[i];
            demoArray[i] = demoArray[minIndex];
            demoArray[minIndex] = temp;
        }
    }

    /**
     * @author zhouyulong@uyaogui.com
     * @date 2021/12/1
     * description  冒泡排序demo
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     */
    private static void bubbleSortingDemo(int[] demoArray) {
        //装载临时变量
        int temp;
        //记录是否发生了置换
        int isChange;
        //记录执行了多少趟
        int num = 0;
        //外层循环是排序的趟数
        for (int i = 0; i < demoArray.length - 1; i++) {
            //每比较一趟就重新初始化为0
            isChange = 0;
            //内层循环是当前趟数需要比较的次数
            for (int j = 0; j < demoArray.length - i - 1; j++) {
                //比较当前为和下一位数值
                if (demoArray[j] > demoArray[j + 1]) {
                    //进来说明当前位大于下一位，存放到临时变量中准备替换
                    temp = demoArray[j];
                    //将下一位数值赋予到当前位
                    demoArray[j] = demoArray[j + 1];
                    //将当前位放到下一位
                    demoArray[j + 1] = temp;
                    isChange = 1;
                }
            }
            if (isChange == 0) {
                break;
            }
            num++;
        }
        System.out.println(demoArray.length);
        System.out.println(Arrays.toString(demoArray));
        System.out.println("执行了" + num + "次");
    }

    /**
     * @author zhouyulong@uyaogui.com
     * @date 2021/12/2
     * description  归并排序
     */
    public static void mergeSort(int[] arr, int left, int right) {
        //left 0 right 4
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左
            mergeSort(arr, left, mid); // left 0 mid 2 1 0
            // 向右
            mergeSort(arr, mid + 1, right); //l=1 r=0 mid = 0
            merge(arr, left, mid, right);
        }
    }

    // 合并 l=1 r=0 mid = 0
    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left; //1
        int r = mid + 1; //1
        int t = 0;
        int[] temp = new int[arr.length];

        // 将左右两边有序放到临时数组中
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }

        // 找到左右两边有剩余的一方，全部放到临时数组中
        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }

        // 将临时数组的数据放回到原始数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }


    public static void mergeSort1(int arr,int left,int right){

    }

}
