package com.gupaoedu.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:KEVIN
 * Time:2019/3/20
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object[] args){

        try {
            //获取连接
            Connection connection = getConnection();
            //创建语句集
//            PreparedStatement pstm = connection.prepareStatement(sql);
            PreparedStatement pstm = createPrepareStatement(connection, sql);
            //执行语句集
            ResultSet rs = executeQuery(pstm, args);
            //处理结果集
            List<?> result = pareResultSet(rs, rowMapper);
            //关闭结果集
            closeResultSet(rs);

            //关闭语句集
            closeStatement(pstm);

            //关闭连接
            closeConnection(connection);

            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private void closeStatement(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private List<?> pareResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> list = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()) {
            list.add(rowMapper.mapRow(rs, rowNum++));
        }
        return list;


    }

    private ResultSet executeQuery(PreparedStatement pstm, Object[] args) throws SQLException {
        for (int i = 0; i <= args.length; i++) {
            pstm.setObject(i,args[i]);
        }
        return pstm.executeQuery();
    }

    private PreparedStatement createPrepareStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
