package com.inno.common.gen.repository;

import org.apache.ibatis.annotations.Mapper;
import com.inno.common.gen.vo.TcAuthMenuMppgLsBaseVO;
import java.util.List;

@Mapper
public interface TcAuthMenuMppgLsBaseMapper {

    TcAuthMenuMppgLsBaseVO selectTcAuthMenuMppgLsBase(TcAuthMenuMppgLsBaseVO vo) throws Exception;

    List<TcAuthMenuMppgLsBaseVO> selectTcAuthMenuMppgLsBasePaging(TcAuthMenuMppgLsBaseVO vo) throws Exception;

    void updateTcAuthMenuMppgLsBase(TcAuthMenuMppgLsBaseVO vo) throws Exception;

    void insertTcAuthMenuMppgLsBase(TcAuthMenuMppgLsBaseVO vo) throws Exception;

    void deleteTcAuthMenuMppgLsBase(TcAuthMenuMppgLsBaseVO vo) throws Exception;
}
