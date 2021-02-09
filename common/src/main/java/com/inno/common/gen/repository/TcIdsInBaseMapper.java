package com.inno.common.gen.repository;

import org.apache.ibatis.annotations.Mapper;
import com.inno.common.gen.vo.TcIdsInBaseVO;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("tcIdsInBaseMapper")
public interface TcIdsInBaseMapper {

    TcIdsInBaseVO selectTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
    
    List<TcIdsInBaseVO> selectTcIdsInBasePaging(TcIdsInBaseVO vo) throws Exception;
    
    void updateTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
    
    void insertTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
    
    void deleteTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
}

