class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    public int[] sort(int[] nums, int startIdx, int endIdx) {
        if (startIdx == endIdx) return nums;
        if (startIdx + 1 == endIdx) {
            if (nums[startIdx] <= nums[endIdx]) return nums;

            int tmp = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx]= tmp;
            return nums;
        }
        
        int midLen = (endIdx + startIdx) / 2;
        sort(nums, startIdx, midLen);
        sort(nums, midLen + 1, endIdx);
        return merge(nums, startIdx, midLen, endIdx);
    }

    public int[] merge(int[] nums, int startIdx, int mid, int endIdx) {
        int[] arr = nums.clone();
        int leftIdx = startIdx;
        int rightIdx = mid + 1;

        int idx = startIdx;
        while (leftIdx <= mid && rightIdx <= endIdx) {
            if (nums[leftIdx] < nums[rightIdx]) arr[idx++] = nums[leftIdx++];
            else arr[idx++] = nums[rightIdx++];
        }
        
        while (rightIdx <= endIdx) {
            arr[idx++] = nums[rightIdx++];
        }

        while (leftIdx <= mid) {
            arr[idx++] = nums[leftIdx++];
        }

        for (int i = startIdx; i <= endIdx; i++) {
            nums[i] = arr[i];
        }
        
        return nums;
    }
}

// 병합 정렬
// 구간 반으로 분리 -> 왼쪽 정렬 , 오른쪽 정렬 후 합치기
// 정렬 종류
// 선택, 삽입, 버블, 머지, 퀵