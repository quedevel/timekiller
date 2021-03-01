package com.inno.backoffice.common.controller;

import com.inno.backoffice.menu.service.MenuService;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.backoffice.util.CodeUtil;
import com.inno.common.constant.CommonConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BaseController {

    @Resource
    private MenuService menuService;

    @ModelAttribute("backoffice_menu")
    public List<MenuVO> getBackofficeMenuList() throws Exception {
        System.out.println("getBackofficeMenuList......");
        MenuVO vo = new MenuVO();
        vo.setSupiMenuSn(CommonConstants.INNO_ROOT_SN.getValue());
        List<MenuVO> list = menuService.selectBackofficeMenu(vo);
        return list;
    }

    @GetMapping("/index")
    public void index(){
        System.out.println(">>>>>>>>>>> CodeUtil  "+CodeUtil.getCodeChildren("code.common.useYN"));
    }

    @GetMapping("/")
    public String goIndex(){
        return "redirect:/index";
    }
}
