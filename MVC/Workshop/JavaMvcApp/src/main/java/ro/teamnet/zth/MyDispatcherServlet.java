package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.HashMap;


/**
 * Created by user on 7/14/2016.
 */
public class MyDispatcherServlet extends HttpServlet {
    //rol de registru
    //key: url path
    //value: informatii despre metoda care va procesa acest url
    HashMap<String, MethodAttributes> hash = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {
        //o sa facem un registru
        //pt fiecare controller si metoda trebuie sa cunoastem url-ul
        try {
            //cautare clase din pachet
            Iterable<Class> controllers =
                    AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers) {
                if (controller.isAnnotationPresent(MyController.class)) {
                    MyController myCtrlAnnotation =
                            (MyController) controller.getAnnotation(MyController.class);
                    String controllerUrlPath = myCtrlAnnotation.urlPath();
                    Method[] controllerMethods = controller.getMethods();
                    for (Method controllerMethod : controllerMethods) {
                        if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)) {
                            MyRequestMethod myRequestMethod =
                                    controllerMethod.getAnnotation(MyRequestMethod.class);
                            String methodUrlPath = myRequestMethod.urlPath();
                            //construiesc cheia pt hashmap
                            String urlPath = controllerUrlPath + methodUrlPath;
                            //construiesc valoarea
                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(myRequestMethod.methodType());
                            methodAttributes.setMethodName(controllerMethod.getName());
                            hash.put(urlPath, methodAttributes);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatchReply(String string, HttpServletRequest req, HttpServletResponse resp) {

        Object result = null;
        try {
            result = dispatch(req, resp);
        } catch (Exception e) {
            sendExceptionError(e, req, resp);
        }
        try {
            reply(result, req, resp);
        } catch (IOException e) {
            sendExceptionError(e, req, resp);
            e.printStackTrace();
        }

    }

    private void sendExceptionError(Exception e, HttpServletRequest req, HttpServletResponse resp) {
    }


    private void reply(Object result, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().printf(result.toString());
    }

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        //da tot ce e dupa path-ul definit in xml la servlet
        String path = req.getPathInfo();
        /*
        if (path.startsWith("/employees")) {
            EmployeeController employeeController = new EmployeeController();
            String result = employeeController.getAllEmployees();
            return result;
        } else if (path.startsWith("/departments")) {
            DepartmentController departmentController = new DepartmentController();
            String result = departmentController.getAllDepartments();
            return result;
        }
        */

        MethodAttributes methodAttributes = hash.get(path);
        if (methodAttributes == null)
            //nu putem procesa metoda
            return "hello";
        String controllerName = methodAttributes.getControllerClass();
        try {

            Class<?> controllerClass = Class.forName(controllerName);
            Object controllerInstance = controllerClass.newInstance();
            Method method =
                    controllerClass.getMethod(methodAttributes.getMethodName());
            Object result = method.invoke(controllerInstance);
            return result;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
         return  null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instructiuni de delegare
        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instructiuni de delegare
        dispatchReply("POST", req, resp);
    }
}
