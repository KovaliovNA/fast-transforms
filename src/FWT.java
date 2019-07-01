/**
 * O(N\log(N))
 */
public class FWT {
    public static double[] fwt(double[] data) {
        int n = data.length;
        if (data.length == 1)
            return data;
        double[] firstPart = new double[n / 2];
        double[] secondPart = new double[n / 2];

        for (int i = 0; i < n / 2; ++i) {
            firstPart[i] = 0.5 * data[2 * i] + 0.5 * data[2 * i + 1];
            secondPart[i] = 0.5 * data[2 * i] - 0.5 * data[2 * i + 1];
        }
        firstPart = fwt(firstPart);
        secondPart = fwt(secondPart);

        double[] fwt = new double[n];
        for (int j = 0; j < n / 2; j++) {
            fwt[j] = firstPart[j];
            fwt[j + n / 2] = secondPart[j];
        }
        return fwt;
    }
}
