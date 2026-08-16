package vn.edu.eaut.lab6.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import vn.edu.eaut.lab6.model.Student;
import vn.edu.eaut.lab6.store.StudentStore;

@WebListener
public class AppContextListener
        implements ServletContextListener {

    @Override
    public void contextInitialized(
            ServletContextEvent event) {

        System.out.println(
                "Ứng dụng đang khởi động..."
        );

        // Thêm dữ liệu mẫu nếu chưa có
        if (!StudentStore.exists("SV003")) {

            StudentStore.add(
                    new Student(
                            "SV003",
                            "Le Van Cuong",
                            "DCCNTT13",
                            "cuong@example.com"
                    )
            );
        }

        if (!StudentStore.exists("SV004")) {

            StudentStore.add(
                    new Student(
                            "SV004",
                            "Pham Thi Dung",
                            "DCCNTT13",
                            "dung@example.com"
                    )
            );
        }

        if (!StudentStore.exists("SV005")) {

            StudentStore.add(
                    new Student(
                            "SV005",
                            "Hoang Van Em",
                            "DCCNTT14",
                            "em@example.com"
                    )
            );
        }

        System.out.println(
                "Đã khởi tạo "
                        + StudentStore.findAll().size()
                        + " sinh viên."
        );
    }

    @Override
    public void contextDestroyed(
            ServletContextEvent event) {

        System.out.println(
                "Ứng dụng đã dừng."
        );
    }
}