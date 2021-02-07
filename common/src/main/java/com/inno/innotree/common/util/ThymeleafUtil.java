package com.inno.innotree.common.util;

import com.inno.innotree.common.gen.vo.GenVO;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThymeleafUtil {

    private static final String VO_PATH = "C:\\innotree\\common\\src\\main\\java\\com\\inno\\innotree\\common\\gen\\vo\\";
    private static final String MAPPER_PATH = "C:\\innotree\\common\\src\\main\\java\\com\\inno\\innotree\\common\\gen\\mapper\\";

    private static String removeTag(String str){
        str = str.replaceAll("<html>\r\n","")
                .replaceAll("</html>","")
                .replaceAll("<p>","")
                .replaceAll("</p>","")
                .replaceAll("<div>","")
                .replaceAll("</div>","")
                .replaceAll("<body>\r\n","")
                .replaceAll("\r\r","")
                .replaceAll("</body>","");
        System.out.println(str);
        return str;
    }

    /**
     * BaseVO 생성
     * @param fileName
     * @param tableName
     * @param list
     */
    public static void parseVOHtmlToFile(String fileName, String tableName, List<GenVO> list){
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");    // templates 경로 아래에 있는 파일을 읽는다
        resolver.setSuffix("VO.html");    // .html로 끝나는 파일을 읽는다
        resolver.setTemplateMode(TemplateMode.HTML);    // 템플릿은 html 형식이다

        // 스프링 template 엔진을 thymeleafResolver를 사용하도록 설정
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        // 저장될 데이터 셋팅
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", StringUtil.convert2CamelCase("_"+tableName));
        map.put("list", list);
        Context context = new Context();
        context.setVariables(map);

        // VO 값 셋팅
        String result = ThymeleafUtil.removeTag(templateEngine.process(fileName, context));

        // BaseVO 생성
        try(FileWriter fileWriter = new FileWriter(VO_PATH+StringUtil.convert2CamelCase("_"+tableName)+"BaseVO.java")){
            fileWriter.write(result);
        } catch (IOException e){
            System.out.println("GenerateVO : "+e.getMessage());
        }
    }

    /**
     * Mapper interface 생성
     * @param fileName
     * @param tableName
     * @param list
     */
    public static void parseMapperHtmlToFile(String fileName, String tableName, List<GenVO> list){
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");    // templates 경로 아래에 있는 파일을 읽는다
        resolver.setSuffix("MAPPER.html");    // .html로 끝나는 파일을 읽는다
        resolver.setTemplateMode(TemplateMode.HTML);    // 템플릿은 html 형식이다

        // 스프링 template 엔진을 thymeleafResolver를 사용하도록 설정
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        // 저장될 데이터 셋팅
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", StringUtil.convert2CamelCase("_"+tableName));
        map.put("list", list);
        Context context = new Context();
        context.setVariables(map);

        // VO 값 셋팅
        String result = ThymeleafUtil.removeTag(templateEngine.process(fileName, context));

        // BaseMapper 생성
        try(FileWriter fileWriter = new FileWriter(MAPPER_PATH+StringUtil.convert2CamelCase("_"+tableName)+"BaseMapper.java")){
            fileWriter.write(result);
        } catch (IOException e){
            System.out.println("GenerateVO : "+e.getMessage());
        }
    }

    public static void parseXmlHtmlToFile(String fileName, String tableName, List<GenVO> list){
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");    // templates 경로 아래에 있는 파일을 읽는다
        resolver.setSuffix("VO.html");    // .html로 끝나는 파일을 읽는다
        resolver.setTemplateMode(TemplateMode.HTML);    // 템플릿은 html 형식이다

        // 스프링 template 엔진을 thymeleafResolver를 사용하도록 설정
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        // 저장될 데이터 셋팅
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", StringUtil.convert2CamelCase("_"+tableName));
        map.put("list", list);
        Context context = new Context();
        context.setVariables(map);

        // VO 값 셋팅
        String result = ThymeleafUtil.removeTag(templateEngine.process(fileName, context));

        // BaseVO 생성
        try(FileWriter fileWriter = new FileWriter(StringUtil.convert2CamelCase("_"+tableName)+"BaseVO.java")){
            fileWriter.write(result);
        } catch (IOException e){
            System.out.println("GenerateVO : "+e.getMessage());
        }
    }
}
