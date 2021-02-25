package com.inno.backoffice.code.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CodeMapper {

    /**
     * 코드 리스트
     * @return
     * @throws Exception
     */
    List<Map<String,String>> selectCodeAllList() throws Exception;
}
