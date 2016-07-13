package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 7/12/2016.
 */
public class InfoHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //map cheie --- val || string --- string
        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames;
        headerNames = req.getHeaderNames();
        String key, value;
        while (headerNames.hasMoreElements()) {
            key = (String) headerNames.nextElement();
            value = req.getHeader(key);
            map.put(key, value);
        }
        //The html table with all the headers and their values
        StringBuilder http_table;
        http_table = new StringBuilder();

        http_table.append("<table> <tr>");
        for (String st : map.keySet()) {
            http_table.append("<th>" + st + "</th>");
        }
        http_table.append("</tr><tr>");
        for (String s : map.keySet()) {
            http_table.append("<td>" + map.get(s) + "</td>");
        }
        http_table.append("</tr></table>\n");
        resp.getWriter().write(http_table.toString());
        //The method of the http request
        resp.getWriter().write(req.getRequestURI() + "\n");
        //The QueryString of the http request
        resp.getWriter().write(req.getQueryString() + "\n");

        //The html table with the cookies from the request
        Cookie[] cookies = new Cookie[50];
        cookies = req.getCookies();

        StringBuilder cookie_table;
        cookie_table = new StringBuilder();

        cookie_table.append("<table><tr>");
        for (Cookie c : cookies) {
            cookie_table.append("<td>" + c.toString() + "</td>");
        }
        cookie_table.append("</tr></table>\n");
        resp.getWriter().write(cookie_table.toString());

        //The html table with the parameters and their values
        StringBuilder parameters_table;
        parameters_table = new StringBuilder();
        Enumeration param;
        param = req.getParameterNames();

        parameters_table.append("<table> <tr>");
        while (param.hasMoreElements()) {
            parameters_table.append("<td>" + param.nextElement().toString() + "</td>");
        }
        parameters_table.append("</tr><tr>");
        String[] param_values = new String[100];

        //...
        for (String st : param_values) {
            parameters_table.append("<td>" + st + "</td>");
        }
        parameters_table.append("</tr></table>\n");

        resp.getWriter().write(parameters_table.toString());


    }
}