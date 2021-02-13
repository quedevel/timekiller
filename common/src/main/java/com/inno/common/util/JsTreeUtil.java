package com.inno.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsTreeUtil {

    public static List<Map<String, String>> makeJsTree(List<Map<String, String>> children){
        List<Map<String, String>> result = new ArrayList<>();
        if(children != null){
            children.forEach( m -> {
                Map<String,String> map = new HashMap<>();
                map.put("id", m.get("id"));
                map.put("parent", m.get("parent"));
                map.put("text", m.get("text"));
                result.add(map);
            });
        }
        return result;
    }
}
