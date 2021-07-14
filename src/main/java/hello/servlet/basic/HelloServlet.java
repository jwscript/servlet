package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
1. @WebServlet
서블릿임을 의미하는 어노테이션
 */
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    /*
    1. 이 서블릿(HelloServlet)이 호출되면 아래의 service 메서드가 동작된다.

    2. HttpServletRequest
    1) HTTP 요청 메시지를 개발자가 직접 파싱해서 사용하면 매우 불편하기 때문에, 서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 요청 메시지를 파싱해준다.
    2) HttpServletRequest 객체는 HTTP 요청의 시작부터 끝날 때까지 유지되는 임시 저장소 기능으로도 활용된다. (?? Scope와 관계된 것일듯)
    3) 세션 관리 기능으로 사용 가능. ex) request.getSession(create: true);

    3. HttpServletResponse
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // http header에 데이터 추가
        response.setContentType("text/plain"); // 단순히 문자로 보낼 것이다.
        response.setCharacterEncoding("utf-8");

        // http body에 message 추가
        response.getWriter().write("hello " + username); // http message body에 메시지를 쓰는 것.
    }
}
