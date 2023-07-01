package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.action")
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;
        // 响应参数格式设置
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");//设置响应回去的内容的格式     等同dataType

        HttpServletResponse response1 = (HttpServletResponse) response;
        /* 允许跨域的主机地址 */
        response1.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response1.setHeader("Access-Control-Allow-Methods", "*·");
        /* 重新预检验跨域的缓存时间 (s) */
        response1.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response1.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response1.setHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, response1);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
