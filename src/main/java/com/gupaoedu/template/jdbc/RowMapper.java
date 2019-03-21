package com.gupaoedu.template.jdbc;

import java.sql.ResultSet;

/**
 * Author:KEVIN
 * Time:2019/3/20
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rownum) throws Exception;
}
