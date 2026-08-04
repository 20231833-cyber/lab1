package vn.edu.eaut.lab1;

import java.util.Scanner;

/**
 * Lớp App đóng vai trò Entry Point cho ứng dụng Java SE Console.
 * Quản lý menu, nhập dữ liệu từ Scanner và gọi các phương thức trong lớp So.
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            hienThiMenu();
            System.out.print("Chon bai tap (0-5): ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Loi: Vui long nhap mot so nguyen hop le!");
                scanner.next(); // Đọc bỏ giá trị không hợp lệ
                System.out.println();
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        bai1(scanner);
                        break;
                    case 2:
                        bai2(scanner);
                        break;
                    case 3:
                        bai3(scanner);
                        break;
                    case 4:
                        bai4(scanner);
                        break;
                    case 5:
                        bai5(scanner);
                        break;
                    case 0:
                        System.out.println(">> Ket thuc chuong trinh. Cam on ban da su dung!");
                        break;
                    default:
                        System.out.println("Loi: Lua chon khong hop le! Vui long chon tu 0 den 5.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Loi xu ly: " + ex.getMessage());
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    private static void hienThiMenu() {
        System.out.println("==========================================");
        System.out.println("     LAB 1 - JAVA SE CONSOLE APPLICATION  ");
        System.out.println("        Khoa CNTT - Truong DH CNDA        ");
        System.out.println("==========================================");
        System.out.println("1. Tinh S = 2 + 4 + ... + n");
        System.out.println("2. Tinh S = 1 + 1/2 + ... + 1/n");
        System.out.println("3. Kiem tra so nguyen to");
        System.out.println("4. Kiem tra va phan loai tam giac");
        System.out.println("5. Hien thi n so Fibonacci dau tien");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("==========================================");
    }

    private static void bai1(Scanner scanner) {
        System.out.print("Nhap n (nguyen duong): ");
        int n = scanner.nextInt();
        int ketQua = So.tongChanDenN(n);
        System.out.println(">> Ket qua: S = " + ketQua);
    }

    private static void bai2(Scanner scanner) {
        System.out.print("Nhap n (nguyen duong): ");
        int n = scanner.nextInt();
        double ketQua = So.tongNghichDao(n);
        System.out.printf(">> Ket qua: S = %.4f%n", ketQua);
    }

    private static void bai3(Scanner scanner) {
        System.out.print("Nhap n nguyên: ");
        int n = scanner.nextInt();
        if (So.laSoNguyenTo(n)) {
            System.out.println(">> Kết quả: " + n + " là số nguyên tố.");
        } else {
            System.out.println(">> Kết quả: " + n + " không phải là số nguyên tố.");
        }
    }

    private static void bai4(Scanner scanner) {
        System.out.print("Nhap canh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap canh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap canh c: ");
        double c = scanner.nextDouble();
        String ketQua = So.loaiTamGiac(a, b, c);
        System.out.println(">> Ket qua: " + ketQua);
    }

    private static void bai5(Scanner scanner) {
        System.out.print("Nhap n (nguyen duong): ");
        int n = scanner.nextInt();
        String ketQua = So.dayFibonacci(n);
        System.out.println(">> Day Fibonacci (" + n + " so dau tien): " + ketQua);
    }
}
