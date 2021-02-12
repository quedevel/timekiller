package com.inno.common.gen.repository;

import org.apache.ibatis.annotations.Mapper;
import com.inno.common.gen.vo.TcAdminMenuLsBaseVO;
import java.util.List;

@Mapper
public interface TcAdminMenuLsBaseMapper {

    TcAdminMenuLsBaseVO selectTcAdminMenuLsBase(TcAdminMenuLsBaseVO vo) throws Exception;
    
    List<TcAdminMenuLsBaseVO> selectTcAdminMenuLsBasePaging(TcAdminMenuLsBaseVO vo) throws Exception;
    
    void updateTcAdminMenuLsBase(TcAdminMenuLsBaseVO vo) throws Exception;
    
    void insertTcAdminMenuLsBase(TcAdminMenuLsBaseVO vo) throws Exception;
    
    void deleteTcAdminMenuLsBase(TcAdminMenuLsBaseVO vo) throws Exception;
}

