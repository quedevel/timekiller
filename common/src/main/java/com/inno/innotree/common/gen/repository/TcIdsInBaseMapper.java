package com.inno.innotree.common.gen.repository;

import org.apache.ibatis.annotations.Mapper;
import com.inno.innotree.common.gen.vo.TcIdsInBaseVO;
import java.util.List;

@Mapper
public interface TcIdsInBaseMapper {

    TcIdsInBaseVO selectTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
    
    List<TcIdsInBaseVO> selectTcIdsInBasePaging(TcIdsInBaseVO vo) throws Exception;
    
    void updateTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
    
    void insertTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
    
    void deleteTcIdsInBase(TcIdsInBaseVO vo) throws Exception;
}

