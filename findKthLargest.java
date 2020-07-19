public int findKthLargest(int[] nums, int k) {
    
      // find kth largest in unsorted array
      // use quicksort to do this
      int low = 0;
      int high = nums.length - 1;

      int targetIdx = k - 1;

      while (low < high) {
          int pivotIdx = partition (nums, low, high);
          if (pivotIdx == targetIdx) return nums[pivotIdx];
          // the element that needs to be found is bigger than the current element at pivot
          else if (pivotIdx > targetIdx) {high = pivotIdx - 1;}
          else {low = pivotIdx + 1;}  
      }

      // only at this point when there is one element (nothing is found in the while loop)
      return nums[targetIdx];

  }


  private int partition (int[] nums, int low, int high) {
      int pivot = nums[low];
      int i = low;
      int j = high + 1;

      while(true) {
          // find a number on the left that is smaller than pivot
          // this is because doesn't have to compare nums[i] at i = low because it is the current pivot
          while (nums[++i] > pivot) {
              if (i >= high) break;
          }
          // find a number on the right that is bigger than the pivot
          while (nums[--j] < pivot) {
              if (j <= low)  break;
          }

          // swap so that all elements on the right are bigger than pivot, all elements on the left are smaller than pivot

          if (i >= j) break;
          swap(nums, i, j);
      }

      // j is now at the right most position where all elements to its right are smaller than the pivot
      swap (nums, low, j);
      return j;
  }

  private void swap (int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
