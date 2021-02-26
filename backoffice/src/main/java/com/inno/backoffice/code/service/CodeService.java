package com.inno.backoffice.code.service;

import com.inno.backoffice.code.repository.CodeMapper;
import com.inno.backoffice.code.vo.CodeVO;
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

}
