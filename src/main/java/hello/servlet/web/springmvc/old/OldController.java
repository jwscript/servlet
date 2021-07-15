package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
1. 스프링 빈의 이름을 '/springmvc/old-controller'로 지정하였다.
2. 핸들러 매핑은...
localhost:8080/springmvc/old-controller를 호출하였을 때, 이 컨트롤러가 동작할 수 있는 이유는
스프링 부트의 HandlerMapping에 BeanNameUrlHandlerMapping 이라는 것이 동작하면서 스프링 빈의 이름으로 핸들러(컨트롤러)를 찾기 때문임.
3. 핸들러 어댑터는...
스프링 부트에서 등록해둔 몇 개의 어댑터 중 SimpleControllerHandlerAdapter 객체가 사용됨.
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
