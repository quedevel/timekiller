package com.inno.common.gen.repository;

import org.apache.ibatis.annotations.Mapper;
import com.inno.common.gen.vo.TcAuthMsBaseVO;
import java.util.List;

@Mapper
public interface TcAuthMsBaseMapper {

    TcAuthMsBaseVO selectTcAuthMsBase(TcAuthMsBaseVO vo) throws Exception;

    List<TcAuthMsBaseVO> selectTcAuthMsBasePaging(TcAuthMsBaseVO vo) throws Exception;

    void updateTcAuthMsBase(TcAuthMsBaseVO vo) throws Exception;

    void insertTcAuthMsBase(TcAuthMsBaseVO vo) throws Exception;

    void deleteTcAuthMsBase(TcAuthMsBaseVO vo) throws Exception;
}
