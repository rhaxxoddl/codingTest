class Solution {
    private final int DIVIDE_NUMBER = 1234567;

    public int solution(int n) {
        int[] fibonacciList = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0)
                fibonacciList[0] = 0;
            else if (i == 1)
                fibonacciList[1] = 1;
            else {
                fibonacciList[i] = (fibonacciList[i - 1] % DIVIDE_NUMBER) + (fibonacciList[i - 2] % DIVIDE_NUMBER);
            }
        }
        return fibonacciList[n] % DIVIDE_NUMBER;
    }
}