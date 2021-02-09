package com.inno.common.gen.repository;

import org.apache.ibatis.annotations.Mapper;
import com.inno.common.gen.vo.TcAdminMsBaseVO;
import java.util.List;

@Mapper
public interface TcAdminMsBaseMapper {

    TcAdminMsBaseVO selectTcAdminMsBase(TcAdminMsBaseVO vo) throws Exception;
    
    List<TcAdminMsBaseVO> selectTcAdminMsBasePaging(TcAdminMsBaseVO vo) throws Exception;
    
    void updateTcAdminMsBase(TcAdminMsBaseVO vo) throws Exception;
    
    void insertTcAdminMsBase(TcAdminMsBaseVO vo) throws Exception;
    
    void deleteTcAdminMsBase(TcAdminMsBaseVO vo) throws Exception;
}

