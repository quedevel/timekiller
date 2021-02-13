package com.inno.backoffice.auth.controller;

import com.inno.backoffice.auth.service.AuthService;
import com.inno.backoffice.auth.vo.AuthVO;
import com.inno.backoffice.common.controller.BaseController;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/auth")
@Controller
public class AuthController extends BaseController {

    @Resource
    private AuthService authService;

    @GetMapping("/authList")
    public void authList() throws Exception{

    }

    @PostMapping("/authListAjax")
    @ResponseBody
    public List<AuthVO> authListAjax(@ModelAttribute AuthVO authVO) throws Exception{
        return authService.selectAuthListPaging(authVO);
    }

    @GetMapping("/authForm")
    public void authForm(@ModelAttribute AuthVO authVO, Model model) throws Exception{
        if(StringUtil.isNotEmpty(authVO.getAuthSn())){
            model.addAttribute("authVO", authService.selectAuthByAuthSn(authVO));
        }
    }

    /**
     * 권한 등록 & 수정
     * @param authVO
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @PostMapping("/authInsert")
    public String authInsert(@ModelAttribute AuthVO authVO, RedirectAttributes redirectAttributes) throws Exception {
        String authSn = CommonConstants.EMPTY.getValue();
        try{
            if(StringUtil.isNotEmpty(authVO.getAuthSn())){
                authSn = authVO.getAuthSn();
                authService.updateAuth(authVO);
                redirectAttributes.addFlashAttribute("msg", CommonConstants.DB_UPDATE_SUCCESS_MESSAGE.getValue());
            } else {
                authService.insertAuth(authVO);
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_SUCCESS_MESSAGE.getValue());
            }
            return "redirect:/auth/authList";
        } catch (Exception e) {
            if(StringUtil.isNotEmpty(authSn)){
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_UPDATE_FAILURE_MESSAGE.getValue());
            } else {
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_FAILURE_MESSAGE.getValue());
            }
            return "redirect:/auth/authList";
        }
    }
}
