package com.service;

import com.dao.StudentDao;

public class StudentService {

    StudentDao studentDao = null;

    public StudentService() {
        studentDao = new StudentDao();
    }
    public String getFirstStudentName(){
        return  studentDao.getFirstStudentName();
    }
}

