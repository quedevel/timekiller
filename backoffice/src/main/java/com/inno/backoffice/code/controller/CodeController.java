package com.inno.backoffice.code.controller;

import com.inno.backoffice.code.service.CodeService;
import com.inno.backoffice.common.controller.BaseController;
import com.inno.common.code.vo.CodeVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.util.JsTreeUtil;
import com.inno.common.util.StringUtil;
import com.sun.corba.se.impl.orbutil.ObjectUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/code")
@Controller
public class CodeController extends BaseController {

    @Resource
    private CodeService codeService;

    /**
     * 코드 리스트
     */
    @GetMapping("/codeList")
    public void codeList(){}

    /**
     * 코드 리스트 Ajax
     * @return
     * @throws Exception
     */
    @GetMapping("/codeListAjax")
    @ResponseBody
    public List<Map<String,String>> codeListAjax() throws Exception {
        return JsTreeUtil.makeJsTree(codeService.selectCodeAllList());
    }

    /**
     * 코드 상세
     * @param codeVO
     * @param model
     * @throws Exception
     */
    @GetMapping("/codeForm")
    public void codeForm(@ModelAttribute CodeVO codeVO, Model model) throws Exception{
        if(StringUtil.isNotEmpty(codeVO.getCdId())){
            codeVO = codeService.selectCodeByCdId(codeVO);
        }
        model.addAttribute("codeVO", codeVO);
    }

    @PostMapping("/codeInsert")
    public String codeInsert(@ModelAttribute CodeVO codeVO, RedirectAttributes redirectAttributes) throws Exception {
        CodeVO prevCode = codeService.selectCodeByCdId(codeVO);
        try{
            if(prevCode != null){
                codeService.updateTcComCd(codeVO);
                redirectAttributes.addFlashAttribute("msg", CommonConstants.DB_UPDATE_SUCCESS_MESSAGE.getValue());
            } else {
                codeService.insertCode(codeVO);
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_SUCCESS_MESSAGE.getValue());
            }
            return "redirect:/code/codeList";
        } catch (Exception e) {
            if(prevCode != null){
                redirectAttributes.addFlashAttribute("msg", CommonConstants.DB_UPDATE_FAILURE_MESSAGE.getValue());
            } else {
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_FAILURE_MESSAGE.getValue());
            }
            return "redirect:/code/codeList";
        }
    }
}
