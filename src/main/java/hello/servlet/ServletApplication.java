package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/*
1. @ServletComponentScan
SpringBoot에서 Servlet을 쓰려면 @ServletComponentScan이라는 어노테이션을 써야한다.
이 패키지 하위의 모든 Servlet을 스캔해서 자동으로 등록해준다.
 */
@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

}
