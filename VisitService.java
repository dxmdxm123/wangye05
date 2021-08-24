package com.du.service;


import com.du.bean.Visit;
import com.du.dao.VisitDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitService {
    //增加
    public Map addVisit(Visit visit){
        VisitDao visitDao = new VisitDao();
        int i = visitDao.addVisit(visit);
        Map codeMap = new HashMap();
        if (i == 1) {
            codeMap.put("code",0);
            codeMap.put("msg","ok");
            return codeMap;
        }else{
            codeMap.put("code",400);
            codeMap.put("msg","no");
            return codeMap;
        }
    }

    //全查
    public Map selectAllByParam(Map map){
        VisitDao dao=new VisitDao();
        List<Map> maps=dao.selectAllByParam(map);
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("data",maps);
        codeMap.put("msg","查询成功！");
        Map countMap =selectAllParamCount(map);
        int count= (int) countMap.get("data");
        codeMap.put("count",count);

        return codeMap;
    }

    //全查 数量
    public Map selectAllParamCount(Map map){
        Map codeMap=new HashMap();
        VisitDao dao=new VisitDao();
        int i=dao.selectAllByParamCount(codeMap);
        codeMap.put("code",0);
        codeMap.put("data",i);
        codeMap.put("msg","ok");
        return codeMap;
    }

    //单个的删除
    public Map VisitdeleteById(Integer id){
        System.out.println("进入到 service 层了---");
        VisitDao dao=new VisitDao();
        int i=dao.deleteByVisitId(id);
        System.out.println("i = " + i);
        Map map=new HashMap();
        if(i==1){
            map.put("code",0);
            map.put("msg","删除成功");
        }else{
            map.put("code",400);
            map.put("msg","删除不成功");
        }
        return map;
    }

}
