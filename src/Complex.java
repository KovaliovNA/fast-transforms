class Complex {
    public final double re;
    public final double im;

    public Complex() {
        this(0, 0);
    }

    public Complex(double r, double i) {
        re = r;
        im = i;
    }

    public Complex plus(Complex b) {
        return new Complex(this.re + b.re, this.im + b.im);
    }

    public Complex minus(Complex b) {
        return new Complex(this.re - b.re, this.im - b.im);
    }

    public Complex mult(Complex b) {
        return new Complex(this.re * b.re - this.im * b.im,
                this.re * b.im + this.im * b.re);
    }

    @Override
    public String toString() {
        return String.format("(%f,%f)", re, im);
    }
}