package com.inno.backoffice.util;

import com.inno.backoffice.code.service.CodeService;
import com.inno.common.code.vo.CodeVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class CodeUtil {

    @Resource
    private static CodeService codeService;

    /**
     * 코드 children 조회
     * @param supiCdId
     * @return
     */
    public static List<CodeVO> getCodeChildren(String supiCdId){
        List<CodeVO> result = new ArrayList<>();
        try {
            result = codeService.getCodeChildren(supiCdId);
            return result;
        } catch (Exception e){
            return result;
        }
    }
}
