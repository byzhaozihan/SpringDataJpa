package com.zzh.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by zhao on 2017/5/22.
 */
public class JDBCUtilTest {
    @Test
    public void getConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}