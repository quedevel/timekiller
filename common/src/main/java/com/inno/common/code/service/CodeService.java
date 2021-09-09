package com.inno.common.code.service;

import com.inno.common.code.repository.CodeMapper;
import com.inno.common.code.vo.CodeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CodeService {

    @Resource
    private CodeMapper codeMapper;

    /**
     * 코드 리스트
     * @return
     * @throws Exception
     */
    public List<Map<String,String>> selectCodeAllList() throws Exception{
        return codeMapper.selectCodeAllList();
    }

    /**
     * 코드 상세
     * @param codeVO
     * @return
     * @throws Exception
     */
    public CodeVO selectCodeByCdId(CodeVO codeVO) throws Exception{
        return codeMapper.selectCodeByCdId(codeVO);
    }

    /**
     * 코드 등록
     * @param codeVO
     * @throws Exception
     */
    public void insertCode(CodeVO codeVO) throws Exception{
        codeMapper.insertTcComCd(codeVO);
    }

    /**
     * 코드 수정
     * @param codeVO
     * @throws Exception
     */
    public void updateTcComCd(CodeVO codeVO) throws Exception{
        codeMapper.updateTcComCd(codeVO);
    }

    /**
     * 코드 children 조회
     * @param supiCdId
     * @return
     * @throws Exception
     */
    public List<CodeVO> getCodeChildren(String supiCdId) throws Exception{
        return codeMapper.getCodeChildren(supiCdId);
    }

}
