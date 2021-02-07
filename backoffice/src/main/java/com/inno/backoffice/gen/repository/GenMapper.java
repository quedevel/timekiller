package com.inno.backoffice.gen.repository;

import com.inno.innotree.common.gen.vo.GenVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenMapper {

    /**
     * 테이블 목록 조회
     * @param vo
     * @return
     * @throws Exception
     */
    List<String> selectAllTables(GenVO vo) throws Exception;

    /**
     * 테이블 컬럼 조회
     * @param vo
     * @return
     * @throws Exception
     */
    List<GenVO> selectAllColumns(String tableName) throws Exception;
}
