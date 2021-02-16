package com.inno.common.gen.repository;

import org.apache.ibatis.annotations.Mapper;
import com.inno.common.gen.vo.TcComCdBaseVO;
import java.util.List;

@Mapper
public interface TcComCdBaseMapper {

    TcComCdBaseVO selectTcComCdBase(TcComCdBaseVO vo) throws Exception;

    List<TcComCdBaseVO> selectTcComCdBasePaging(TcComCdBaseVO vo) throws Exception;

    void updateTcComCdBase(TcComCdBaseVO vo) throws Exception;

    void insertTcComCdBase(TcComCdBaseVO vo) throws Exception;

    void deleteTcComCdBase(TcComCdBaseVO vo) throws Exception;
}
