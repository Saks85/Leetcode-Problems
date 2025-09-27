class Solution {
    public double getArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double dist(int[] p1, int[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + 
                         (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = dist(points[i], points[j]);
                for (int k = j + 1; k < n; k++) {
                    double b = dist(points[i], points[k]);
                    double c = dist(points[j], points[k]);
                    if (a + b > c && a + c > b && b + c > a)
                        maxArea = Math.max(maxArea, getArea(a, b, c));
                }
            }
        }
        return maxArea;
    }
}
