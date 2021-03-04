package com.inno.backoffice.auth.controller;

import com.inno.backoffice.auth.service.AuthService;
import com.inno.backoffice.auth.vo.AuthVO;
import com.inno.backoffice.common.controller.BaseController;
import com.inno.backoffice.menu.service.MenuService;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.util.StringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/auth")
@Controller
public class AuthController extends BaseController {

    @Resource
    private AuthService authService;

    @Resource
    private MenuService menuService;

    /**
     * 권한 리스트
     * @throws Exception
     */
    @GetMapping("/authList")
    public void authList() throws Exception{}

    /**
     * 권한 검색
     * @param authVO
     * @return
     * @throws Exception
     */
    @PostMapping("/authListAjax")
    @ResponseBody
    public List<AuthVO> authListAjax(@ModelAttribute AuthVO authVO) throws Exception{
        return authService.selectAuthListPaging(authVO);
    }

    /**
     * 권한 등록 폼
     * @param authVO
     * @param model
     * @throws Exception
     */
    @GetMapping("/authForm")
    public void authForm(@ModelAttribute AuthVO authVO, Model model) throws Exception{
        if(StringUtil.isNotEmpty(authVO.getAuthSn())){
            MenuVO menuVO = new MenuVO();
            menuVO.setMenuSn(CommonConstants.INNO_ROOT_SN.getValue());
            model.addAttribute("authVO", authService.selectAuthByAuthSn(authVO));
            model.addAttribute("menuList",menuService.selectMenuChildren(menuVO));
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

    /**
     * 메뉴 Children 조회 Ajax
     * @param menuVO
     * @return
     */
    @GetMapping("/selectMenuChildren")
    @ResponseBody
    public ResponseEntity<List<MenuVO>> selectMenuChildren(@ModelAttribute MenuVO menuVO){
        List<MenuVO> result = new ArrayList<>();
        try{
            result = menuService.selectMenuChildren(menuVO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * 권한 메뉴 매핑 리스트
     * @param menuVO
     * @return
     * @throws Exception
     */
    @PostMapping("/menuListAjax")
    @ResponseBody
    public List<MenuVO> menuListAjax(@ModelAttribute MenuVO menuVO) throws Exception{
        if(StringUtil.isEmpty(menuVO.getMenuSn())){
            menuVO.setMenuSn(CommonConstants.INNO_ROOT_SN.getValue());
        }
        return authService.selectAuthMenuListPaging(menuVO);
    }

    /**
     * 권한 부여 및 미부여
     * @param menuVO
     * @return
     */
    @PostMapping("/authMenuMppgAjax")
    @ResponseBody
    public ResponseEntity<String> authMenuMppgAjax(@ModelAttribute MenuVO menuVO){
        try{
            authService.insertAuthMenu(menuVO);
            return new ResponseEntity<>(CommonConstants.SUCCESS_CODE.getValue(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(CommonConstants.FAIL_CODE.getValue(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
