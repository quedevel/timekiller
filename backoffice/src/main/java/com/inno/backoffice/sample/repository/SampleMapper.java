package com.inno.backoffice.sample.repository;

import com.inno.backoffice.sample.vo.SampleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SampleMapper {

    String getNow() throws Exception;

    Map<String, String> selectAllTables(String schemaName);

    List<SampleVO> selectAllColumns(String tableName);

}
