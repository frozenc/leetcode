package leetcode.SearchProblem;

//查找山脉数组
public class Hard_1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int top = findInMountainTop(mountainArr);
        int res = findUpMountain(mountainArr, 0, top, target);
        if (res != -1) return res;

        return findDownMountain(mountainArr, top+1, mountainArr.length()-1, target);
    }

    public int findInMountainTop(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length()-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int findUpMountain(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left)/2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) return left;
        return -1;
    }

    public int findDownMountain(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left)/2;
            if(mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) return left;
        return -1;
    }

    interface MountainArray {
        public int get(int index);

        public int length();
    }


    class MountainArrayImpl implements MountainArray {
        private int[] arr;
        private int size;

        public MountainArrayImpl(int[] arr) {
            this.arr = arr;
            this.size = this.arr.length;
        }

        @Override
        public int get(int index) {
            return this.arr[index];
        }

        @Override
        public int length() {
            return this.size;
        }

    }
}
