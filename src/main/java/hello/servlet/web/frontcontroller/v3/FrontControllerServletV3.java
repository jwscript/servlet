package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
1. V2 방식

*/
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    /*
    어떤 URL이 들어오면 어떤 컨트롤러가 동작할지 정할 Map
     */
    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI();
        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView modelView = controller.process(paramMap);

        String viewName = modelView.getViewName();// 논리 이름
        MyView view = viewResolver(viewName);

        /*
        V3 버전에서는 V2와 달리 view 자체에 model에 추가된 member 또는 members 데이터를 가지고 있지 않으므로,
        modelView.getModel()을 통해 파라미터에 넣어준다.
         */
        view.render(modelView.getModel(), request, response); // JSP로 포워드 후 렌더링 처리.
    }

    /**
     * 컨트롤러가 반환한 논리 이름을 실제 물리 뷰 경로로 변경한다.
     * 그리고 실제 물리 경로가 있는 MyView 객체를 반환한다.
     *
     * @param viewName
     * @return
     */
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    /**
     * HttpServletRequest에서 파라미터 정보를 꺼내서 Map으로 변환한다.
     *
     * @param request
     * @return
     */
    private Map<String, String> createParamMap(HttpServletRequest request) {
        // paramMap
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}

