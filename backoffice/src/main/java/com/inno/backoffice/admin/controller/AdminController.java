package com.inno.backoffice.admin.controller;

import com.inno.backoffice.admin.service.AdminService;
import com.inno.backoffice.admin.vo.AdminVO;
import com.inno.backoffice.common.controller.BaseController;
import com.inno.common.constant.CommonConstants;
import com.inno.common.util.StringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Resource
    private AdminService adminService;

    /**
     * 운영자 리스트
     */
    @GetMapping("/adminList")
    public void adminList(){}

    /**
     * 운영자 리스트
     */
    @PostMapping("/adminListAjax")
    @ResponseBody
    public List<AdminVO> adminListAjax(@ModelAttribute AdminVO adminVO) throws Exception{
        return adminService.selectAdminListPaging(adminVO);
    }

    /**
     * 운영자 등록폼
     * @param adminVO
     * @param model
     */
    @GetMapping("/adminForm")
    public void adminForm(@ModelAttribute AdminVO adminVO, Model model) throws Exception {
        if(StringUtil.isNotEmpty(adminVO.getAdminSn())){
            model.addAttribute("adminVO", adminService.selectAdminByAdminSn(adminVO));
        }
    }

    /**
     * 아이디 중복 검사
     * @param adminVO
     * @return
     */
    @GetMapping("/adminIdChk")
    @ResponseBody
    public ResponseEntity<String> adminIdChk(@ModelAttribute AdminVO adminVO){
        String result = CommonConstants.FAIL_CODE.getValue();
        try{
            if(adminService.checkByAdminId(adminVO) == 0){
                result = CommonConstants.SUCCESS_CODE.getValue();
            } else {
                result = CommonConstants.UNEXPECTED_CODE.getValue();
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * 운영자 등록
     * @param adminVO
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/adminInsert")
    public String adminInsert(@ModelAttribute AdminVO adminVO, RedirectAttributes redirectAttributes){
        String adminSn = CommonConstants.EMPTY.getValue();
        try{
            if(StringUtil.isNotEmpty(adminVO.getAdminSn())){
                adminSn = adminVO.getAdminSn();
                adminService.updateAdmin(adminVO);
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_UPDATE_SUCCESS_MESSAGE.getValue());
            } else {
                adminService.insertAdmin(adminVO);
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_SUCCESS_MESSAGE.getValue());
            }
            return "redirect:/admin/adminList";
        } catch (Exception e) {
            if(StringUtil.isNotEmpty(adminSn)){
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_UPDATE_FAILURE_MESSAGE.getValue());
            } else {
                redirectAttributes.addFlashAttribute("msg",CommonConstants.DB_INSERT_FAILURE_MESSAGE.getValue());
            }
            return "redirect:/admin/adminList";
        }
    }
}
