package com.inno.backoffice.menu.controller;

import com.inno.backoffice.common.controller.BaseController;
import com.inno.backoffice.menu.service.MenuService;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.util.JsTreeUtil;
import com.inno.common.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Resource
    private MenuService menuService;

    /**
     * 메뉴 리스트
     */
    @GetMapping("/menuList")
    public void menuList(){}

    /**
     * 관리자 메뉴 등록 폼
     * @param menuVO
     * @param model
     */
    @GetMapping("/menuForm")
    public void menuForm(@ModelAttribute MenuVO menuVO, Model model) throws Exception{
        if(StringUtil.isNotEmpty(menuVO.getMenuSn())){
            menuVO = menuService.selectMenuByMenuSn(menuVO);
        }
        model.addAttribute("menuVO", menuVO);
    }

    /**
     * 관리자 메뉴 리스트 조회
     * @return
     */
    @GetMapping("/menuListAjax")
    @ResponseBody
    public List<Map<String,String>> menuListAjax() throws Exception {
        return JsTreeUtil.makeJsTree(menuService.selectMenuAllList());
    }

    /**
     * 메뉴 등록 & 수정
     * @param menuVO
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
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
}
