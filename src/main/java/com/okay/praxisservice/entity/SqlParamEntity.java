package com.okay.praxisservice.entity;

import java.math.BigInteger;

/**
 * Created by kate on 2017/6/30.
 */
public class SqlParamEntity {

    private String tableName;
    private int startNum;
    private int size;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
