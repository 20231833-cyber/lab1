package vn.edu.eaut.lab1;

/**
 * Lớp So chứa các phương thức xử lý logic tính toán số học cho Bài Lab 1.
 * Thiết kế tuân thủ nguyên tắc tách biệt logic xử lý và giao diện người dùng.
 */
public class So {

    /**
     * Phương thức kiểm tra số nguyên dương
     * @param n Số nguyên cần kiểm tra
     * @throws IllegalArgumentException nếu n <= 0
     */
    private static void kiemTraNguyenDuong(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n phai la so nguyen duong (n > 0)");
        }
    }

    /**
     * Bài 1: Tính tổng các số chẵn từ 2 đến n
     * S = 2 + 4 + ... + n (hoặc số chẵn lớn nhất <= n)
     */
    public static int tongChanDenN(int n) {
        kiemTraNguyenDuong(n);
        int s = 0;
        for (int i = 2; i <= n; i += 2) {
            s += i;
        }
        return s;
    }

    /**
     * Bài 2: Tính tổng nghịch đảo S = 1 + 1/2 + 1/3 + ... + 1/n
     */
    public static double tongNghichDao(int n) {
        kiemTraNguyenDuong(n);
        double s = 0.0;
        for (int i = 1; i <= n; i++) {
            s += 1.0 / i;
        }
        return s;
    }

    /**
     * Bài 3: Kiểm tra n có phải là số nguyên tố hay không
     */
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Bài 4: Kiểm tra và phân loại tam giác dựa trên độ dài 3 cạnh a, b, c
     */
    public static String loaiTamGiac(double a, double b, double c) {
        final double EPS = 1e-9;

        if (a <= 0 || b <= 0 || c <= 0) {
            return "Khong phai tam giac (do dai canh phai > 0)";
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Khong phai tam giac (vi pham bat dang thuc tam giac)";
        }

        boolean deu = Math.abs(a - b) < EPS && Math.abs(b - c) < EPS;
        boolean can = Math.abs(a - b) < EPS || Math.abs(a - c) < EPS || Math.abs(b - c) < EPS;

        // Sắp xếp các cạnh x <= y <= z để kiểm tra vuông
        double x = a, y = b, z = c;
        if (x > y) { double temp = x; x = y; y = temp; }
        if (y > z) { double temp = y; y = z; z = temp; }
        if (x > y) { double temp = x; x = y; y = temp; }

        boolean vuong = Math.abs(x * x + y * y - z * z) < EPS;

        if (deu) {
            return "Tam giac deu";
        }
        if (vuong && can) {
            return "Tam giac vuong can";
        }
        if (vuong) {
            return "Tam giac vuong";
        }
        if (can) {
            return "Tam giac can";
        }
        return "Tam giac thuong";
    }

    /**
     * Bài 5: Hiển thị n số Fibonacci đầu tiên
     * Dãy Fibonacci: 0, 1, 1, 2, 3, 5, 8, ...
     */
    public static String dayFibonacci(int n) {
        kiemTraNguyenDuong(n);
        StringBuilder ketQua = new StringBuilder();
        long a = 0;
        long b = 1;

        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                ketQua.append(" ");
            }
            ketQua.append(a);
            long next = a + b;
            a = b;
            b = next;
        }
        return ketQua.toString();
    }
}
