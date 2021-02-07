package com.inno.innotree.common.gen.vo;

import com.inno.innotree.common.vo.PageVO;

public class GenVO extends PageVO {

    private String tableSchema;
    private String tableName;
    private String columnName;
    private String columnName2;
    private String dataType;
    private String columnComment;


    public String getTableSchema() {
        return tableSchema;
    }
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getColumnComment() {
        return columnComment;
    }
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
    public String getColumnName2() {
        return columnName2;
    }
    public void setColumnName2(String columnName2) {
        this.columnName2 = columnName2;
    }
}
