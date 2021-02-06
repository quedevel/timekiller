package com.inno.backoffice.sample.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

    String getNow() throws Exception;

}
