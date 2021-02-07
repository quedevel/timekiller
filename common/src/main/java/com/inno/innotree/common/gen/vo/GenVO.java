package com.inno.innotree.common.gen.vo;

import com.inno.innotree.common.util.StringUtil;
import com.inno.innotree.common.vo.PageVO;

public class GenVO extends PageVO {

    private String tableSchema;
    private String tableName;
    private String columnName;
    private String columnName2;
    private String columnName3;
    private String paramColumnName;
    private String dataType;
    private String columnComment;
    private String columnKey;
    private String columns;
    private String params;
    private String updateParams;


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
    public String getParamColumnName() {
        return StringUtil.convert2CamelCase(paramColumnName.replaceAll("\\{", "#{"));
    }
    public void setParamColumnName(String paramColumnName) {
        this.paramColumnName = paramColumnName;
    }
    public String getColumnKey() {
        return columnKey;
    }
    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }
    public String getColumns() {
        return columns;
    }
    public void setColumns(String columns) {
        this.columns = columns;
    }
    public String getParams() {
        return StringUtil.convert2CamelCase(params.replaceAll("\\{", "#{"));
    }
    public void setParams(String params) {
        this.params = params;
    }
    public String getUpdateParams() {
        return StringUtil.convert2CamelCase(updateParams.replaceAll("\\{", "#{"));
    }
    public void setUpdateParams(String updateParams) {
        this.updateParams = updateParams;
    }
    public String getColumnName3() {
        return columnName3;
    }
    public void setColumnName3(String columnName3) {
        this.columnName3 = columnName3;
    }
}
