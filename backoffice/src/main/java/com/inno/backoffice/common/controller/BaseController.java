package com.inno.backoffice.common.controller;

import com.inno.backoffice.menu.service.MenuService;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class BaseController {

    @Resource
    private MenuService menuService;

    @Autowired
    private ApplicationContext context;

    @ModelAttribute("backoffice_menu")
    public List<MenuVO> getBackofficeMenuList() throws Exception {
        System.out.println("getBackofficeMenuList......");
        MenuVO vo = new MenuVO();
        vo.setSupiMenuSn(CommonConstants.INNO_ROOT_SN.getValue());
        List<MenuVO> list = menuService.selectBackofficeMenu(vo);
        return list;
    }

    @GetMapping("/index")
    public void index(Model model) throws Exception {
        RequestMappingHandlerMapping requestMappings = context.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = requestMappings.getHandlerMethods();
        Set<RequestMappingInfo> set = map.keySet();
        List<String> list = set.stream().filter(r -> r.toString().contains("/sample/")).map(rm -> {
            String str = rm.toString().replace("{GET [","").replace("]}","");
            return str;
        }).collect(Collectors.toList());

        CodeUtil.getCodeChildren("code.common.useYN").stream().map(codeVO -> {return codeVO.getCdId();}).forEach(System.out::println);

        model.addAttribute("list", list);
    }

    @GetMapping("/")
    public String goIndex(){
        return "redirect:/index";
    }
}
