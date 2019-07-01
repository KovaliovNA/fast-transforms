/**
 * Быстрое преобразование Фурье (БПФ, FFT) — алгоритм ускоренного вычисления дискретного преобразования Фурье,
 * позволяющий получить результат за время,
 * меньшее чем O(N^2) (требуемого для прямого, поформульного вычисления).
 * Иногда под быстрым преобразованием Фурье понимается один из алгоритмов,
 * называемый алгоритмом прореживания по частоте — времени, имеющий сложность O(N\log(N)).
 */
public class FFT {

    public static Complex[] fft(Complex[] data) {
        int n = data.length;
        Complex[] fft = new Complex[n];

        if (n == 1) {
            return data;
        }
        Complex[] even = new Complex[n / 2];
        Complex[] odd = new Complex[n / 2];

        for (int i = 0; i < data.length; i++) {
            if (i % 2 == 0) {
                even[i / 2] = data[i];
            } else {
                odd[(i - 1) / 2] = data[i];
            }
        }

        Complex[] evenFFT = fft(even);
        Complex[] oddFFT = fft(odd);

        for (int i = 0; i < n / 2; i++) {
            double arg = 2 * Math.PI * i / n;
            Complex multiplier = new Complex(Math.cos(arg), Math.sin(arg));

            fft[i] = evenFFT[i].plus(multiplier.mult(oddFFT[i]));
            fft[i + n / 2] = evenFFT[i].minus(multiplier.mult(oddFFT[i]));

        }
        return fft;
    }
}