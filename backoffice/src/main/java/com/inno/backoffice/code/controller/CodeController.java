package com.inno.backoffice.code.controller;

import com.inno.backoffice.code.service.CodeService;
import com.inno.backoffice.common.controller.BaseController;
import com.inno.common.code.vo.CodeVO;
import com.inno.common.util.JsTreeUtil;
import com.inno.common.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /*
    @PostMapping("/menuInsert")
    public String menuInsert(@ModelAttribute MenuVO menuVO, RedirectAttributes redirectAttributes) throws Exception {
        String menuSn = CommonConstants.EMPTY.getValue();
        try{
            if(StringUtil.isNotEmpty(menuVO.getMenuSn())){
                menuSn = menuVO.getMenuSn();
                menuService.updateMenu(menuVO);
                redirectAttributes.addFlashAttribute("msg", CommonConstants.DB_UPDATE_SUCCESS_MESSAGE.getValue());
            } else {
                menuService.insertMenu(menuVO);
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_SUCCESS_MESSAGE.getValue());
            }
            return "redirect:/menu/menuList";
        } catch (Exception e) {
            if(StringUtil.isNotEmpty(menuSn)){
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_UPDATE_FAILURE_MESSAGE.getValue());
            } else {
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_FAILURE_MESSAGE.getValue());
            }
            return "redirect:/menu/menuList";
        }
    }
    */
}
