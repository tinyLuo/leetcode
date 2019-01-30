package com.ly.competition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ly
 *
 */
public class Code981 {
	
	public static class TimeMap {
		private Map<String, List<TimeValue>> map;
		/** Initialize your data structure here. */
	    public TimeMap() {
	    	    map = new HashMap<>();
	    }
	    
	    public void set(String key, String value, int timestamp) {
	        List<TimeValue> list = map.getOrDefault(key, new ArrayList<>());
	        TimeValue timeValue = new TimeValue(value, timestamp);
	        list.add(timeValue);
	        map.put(key, list);
	    }
	    
	    public String get(String key, int timestamp) {
	        List<TimeValue> list = map.get(key);
	        if(list == null || list.isEmpty()) {
	        	    return "";
	        }
	        list.sort(new Comparator<TimeValue>() {

				@Override
				public int compare(TimeValue o1, TimeValue o2) {
					return o2.getTime() - o1.getTime();
				}
			});
	        for(TimeValue timeValue : list) {
	            if(timeValue.getTime() <= timestamp) {
	            	    return timeValue.getValue();
	            }
	        }
	        return "";
	    }
	    
	    public static class TimeValue {
	    		private String value;
	    		private int time;
	    		
	    		public TimeValue(String value, int time) {
	    		    this.value = value;
	    		    this.time = time;
	    		}
	    		
			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public int getTime() {
				return time;
			}

			public void setTime(int time) {
				this.time = time;
			}
	    }
	}
	
	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("love", "high", 10);
		timeMap.set("love", "low", 20);
		System.out.println(timeMap.get("love", 5));
		System.out.println(timeMap.get("love", 10));
		System.out.println(timeMap.get("love", 15));
		System.out.println(timeMap.get("love", 20));
		System.out.println(timeMap.get("love", 25));
	}
}
