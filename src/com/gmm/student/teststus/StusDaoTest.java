package com.gmm.student.teststus;

import com.gmm.student.dao.StusDao;
import com.gmm.student.entity.Stus;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StusDaoTest {
    private StusDao dao = new StusDao();
//
//    @Test
//    public void stusLength() throws SQLException {
//        int i = dao.stusLength();
//        System.out.println(i);
//
//    }
    @Test
    public void selectAll() throws SQLException {
        List<Stus> stuses = dao.selectAll();
        for (Stus stus : stuses) {
            System.out.println(stus);
        }
    }
}