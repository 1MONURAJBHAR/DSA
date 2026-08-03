public class BookAllocationProblem {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;

        if (k > n)
            return -1;

        int low = 0;
        int high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canAllocate(int[] arr, int k, int maxPages) {

        int students = 1;
        int pages = 0;

        for (int book : arr) {

            if (pages + book <= maxPages) {
                pages += book;
            } else {
                students++;
                pages = book;

                if (students > k)
                    return false;
            }
        }

        return true;
    }
}
