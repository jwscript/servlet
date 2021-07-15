package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
1. 스프링 빈의 이름을 '/springmvc/request-handler'로 지정하였다.
2. 핸들러 매핑은...
스프링 부트의 HandlerMapping에 BeanNameUrlHandlerMapping 이라는 것이 동작하면서 스프링 빈의 이름으로 핸들러(컨트롤러)를 찾음.
3. 핸들러 어댑터는...
HttpRequestHandler를 구현하였으므로 HttpRequestHandlerAdapter 객체가 사용될 것임.
 */
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
