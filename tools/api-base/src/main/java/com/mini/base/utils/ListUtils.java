package com.mini.base.utils;

import java.util.*;

/**
 * @author LIUDONGFANG002
 * @version 1.0
 * @date 2019/6/16
 */
public class ListUtils {
    /**
     * 获取allOpenidList中不被dbOpenidList包含的集合
     * @param allOpenidList
     * @param dbOpenidList
     * @return
     */
    public static List<Long> getNeedOpenidList(List<Long> allOpenidList, List<Long> dbOpenidList) {
        if (dbOpenidList != null && !dbOpenidList.isEmpty()) {
            Map<Long, Long> dataMap = new HashMap<Long, Long>();
            for (Long id : dbOpenidList) {
                dataMap.put(id, id);
            }

            List<Long> newList = new ArrayList<Long>();
            for (Long id : allOpenidList) {
                if (!dataMap.containsKey(id)) {
                    newList.add(id);
                }
            }
            return newList;
        } else {
            return allOpenidList==null? Collections.emptyList():allOpenidList;
        }
    }
}
