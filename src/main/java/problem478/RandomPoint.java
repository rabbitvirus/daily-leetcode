package problem478;

public final class RandomPoint {

    private static final double RAD_MAX = 2 * Math.PI;

    private final double x0;
    private final double y0;
    private final double r;

    public RandomPoint(final double radius, final double xCenter, final double yCenter) {
        x0 = xCenter;
        y0 = yCenter;
        r = radius;
    }

    public double[] randPoint() {
        final double rRand = r * Math.sqrt(Math.random());
        final double fiRand = RAD_MAX * Math.random();

        return new double[]{x0 + rRand * Math.cos(fiRand), y0 + rRand * Math.sin(fiRand)};
    }

}
