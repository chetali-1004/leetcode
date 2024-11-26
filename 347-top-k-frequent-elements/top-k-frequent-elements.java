class Solution {
    class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums; // Handle single-element array edge case
        
        // Priority queue for storing elements based on frequency (max-heap)
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> p2.freq - p1.freq);

        // Sort the array to group the same elements together
        Arrays.sort(nums);

        // Traverse the sorted array and count frequencies
        int freq = 1; // Start frequency for the first element
        for (int i = 1; i <= nums.length; i++) {
            // If the current element is different or it's the end of the array
            if (i == nums.length || nums[i] != nums[i - 1]) {
                pq.offer(new Pair(nums[i - 1], freq)); // Add the previous element and its frequency to the heap
                freq = 1; // Reset frequency for the next group
            } else {
                freq++; // Increment frequency if the same element repeats
            }
        }

        // Extract the top k elements from the heap
        int[] sol = new int[k];
        for (int i = 0; i < k; i++) {
            sol[i] = pq.poll().num; // Get the element with the highest frequency
        }

        return sol;
    }
}
