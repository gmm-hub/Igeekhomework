package com.gmm.student.dao;

import com.gmm.student.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BaseDao<T> {
    private QueryRunner runner = new QueryRunner();
    //增删改
    public int update(String sql, Object...params) throws SQLException {
        int i = runner.update(JDBCUtils.getConn(),sql,params);
        return i;
    }
    //查询单个字段
    public Object getStringValue(String sql, Object...params) throws SQLException {
        Object query = runner.query(JDBCUtils.getConn(),sql,new ScalarHandler(),params);
        return query;
    }

    //查询单个对象
    public T getBen(Class<T> type,String sql, Object...params) throws SQLException {
        T t = runner.query(JDBCUtils.getConn(),sql,new BeanHandler<>(type),params);
        return t;
    }
    //查询一组相同类型的对象信息（集合列表）
    public List<T> getBeanList(Class<T> type,String sql,Object...params) throws SQLException {
        List<T> list = runner.query(JDBCUtils.getConn(), sql, new BeanListHandler<>(type), params);
        return list;
    }

    //查询一组不同类型的对象信息
    public List<Map<String,Object>> getMapList(String sql, Object...params) throws SQLException {
        List<Map<String, Object>> mapList = runner.query(JDBCUtils.getConn(), sql, new MapListHandler(), params);
        return mapList;
    }

}
