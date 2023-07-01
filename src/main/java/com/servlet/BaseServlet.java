package com.servlet;

import com.alibaba.fastjson.JSON;
import com.bean.Result;
import com.service.StudentService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("*.action")
public class BaseServlet extends javax.servlet.http.HttpServlet {
    StudentService studentService = null;

    public BaseServlet() {
        studentService = new StudentService();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Result<Object> result = Result.success(studentService.getFirstStudentName());
        String resultJSONString = JSON.toJSONString(result);
        response.getWriter().print(resultJSONString);//普通文本字符串
    }
}
