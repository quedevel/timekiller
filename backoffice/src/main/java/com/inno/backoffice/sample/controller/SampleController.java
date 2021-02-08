package com.inno.backoffice.sample.controller;

import com.inno.innotree.common.gen.repository.TcIdsInBaseMapper;
import com.inno.innotree.common.gen.vo.TcIdsInBaseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.stream.IntStream;

@RequestMapping("/sample")
@Controller
public class SampleController {

    @Resource
    private TcIdsInBaseMapper mapper;

    @GetMapping("/sample")
    public void sample() throws Exception{
        System.out.println("Sample.......................................");
    }

    @GetMapping("/insert")
    public void insert() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i->{
            TcIdsInBaseVO vo = new TcIdsInBaseVO();
            vo.setTblNm("tblNm..."+i);
            vo.setNextId(i);
            try {
                mapper.insertTcIdsInBase(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/update")
    public void update() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i->{
            TcIdsInBaseVO vo = new TcIdsInBaseVO();
            vo.setTblNm("tblNm..."+i);
            vo.setNextId(i+100);
            try {
                mapper.updateTcIdsInBase(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/delete")
    public void delete() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i->{
            TcIdsInBaseVO vo = new TcIdsInBaseVO();
            vo.setTblNm("tblNm..."+i);
            try {
                mapper.deleteTcIdsInBase(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/select")
    public void select() throws Exception{
        TcIdsInBaseVO vo = new TcIdsInBaseVO();
        vo.setTblNm("tblNm...10");
        System.out.println("=========================>>>>>>    "+mapper.selectTcIdsInBase(vo));
    }

    @GetMapping("/paging")
    public void paging() throws Exception{
        TcIdsInBaseVO vo = new TcIdsInBaseVO();
        vo.setPage(3);
        vo.setPageSize(10);
        System.out.println("-------------------------------------------------------------");
        mapper.selectTcIdsInBasePaging(vo).forEach(v -> {
            System.out.println(v.getTblNm());
        });
        System.out.println("-------------------------------------------------------------");
    }
}
