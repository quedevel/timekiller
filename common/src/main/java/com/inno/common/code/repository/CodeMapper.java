package com.inno.common.code.repository;

import com.inno.common.code.vo.CodeVO;
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

    /**
     * 코드 상세 조회
     * @param codeVO
     * @return
     * @throws Exception
     */
    CodeVO selectCodeByCdId(CodeVO codeVO) throws Exception;
}
