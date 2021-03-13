package com.inno.common.util;

import com.inno.common.code.service.CodeService;
import com.inno.common.code.vo.CodeVO;

import java.util.ArrayList;
import java.util.List;

public final class CodeUtil {

    /**
     * 코드 children 조회
     * @param supiCdId
     * @return
     */
    public static List<CodeVO> getCodeChildren(String supiCdId) throws Exception {
        List<CodeVO> result = new ArrayList<>();
        CodeService codeService = (CodeService) ApplicationContextProvider.getContext().getBean("codeService");
        result = codeService.getCodeChildren(supiCdId);
        try {
            return result;
        } catch (Exception e){
            return result;
       }
    }



}
