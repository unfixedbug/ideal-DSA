public class misc_skits {

    // get a random number between a - b

    // number is multiple of 3;
    static int isMultipleof3(int n) {

        // if set bits at even - odd position is multiple of 3 then, number is multiple
        // of threee
        int oddCount = 0, evenCount = 0;
        if (n < 0)
            n = -n;
        if (n == 0)
            return 1;
        if (n == 1)
            return 0;

        while (n != 0) {
            if ((n & 1) != 0) {
                oddCount++;
            }
            if ((n & 2) != 0) {
                evenCount++;
            }
            n = n >> 2;
        }
        return isMultipleof3(Math.abs(oddCount - evenCount));
    }
    public static void main(String[] args) {
        System.out.println("dori");
    }
}