package ro.teamnet.zth.web;
import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by user on 7/13/2016.
 */
public class HeadersLogFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames;
        headerNames = req.getHeaderNames();
        String key,value;
        while (headerNames.hasMoreElements()) {
            key = (String) headerNames.nextElement();
            value = req.getHeader(key);
            map.put(key, value);
        }

        for(String st : map.keySet()){
            LogFileWriter.logHeader(st,map.get(st));
        }
       filterChain.doFilter(req,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
