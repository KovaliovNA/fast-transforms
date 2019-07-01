import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] data = new double[]{1, 1, 1 ,1, 0, 0, 0, 0};

        double[] fwt = FWT.fwt(data);
        double[] fht = FHT.fht(data);

        Complex[] realToComplexList = new Complex[data.length];
        for (int i = 0; i < data.length; i++) {
            realToComplexList[i] = new Complex(data[i], 0);
        }
        Complex[] fft = FFT.fft(realToComplexList);

        System.out.println("Data: " + Arrays.toString(data));
        System.out.println("FHT: " + Arrays.toString(fht));
        System.out.println("FWT: " + Arrays.toString(fwt));
        System.out.println("FFT: " + Arrays.toString(fft));
    }
}
