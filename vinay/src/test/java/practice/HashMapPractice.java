package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapPractice {
	public static void main(String[] args) {
		HashMap<Integer,String> map= new HashMap<Integer,String>();{
			map.put(1,"vinay");
			map.put(2,"kumar");
			map.put(3, "chowdary");
			map.put(4,"vykuntam");
			System.out.println(map.size());
//			Set set = map.keySet();
//			Iterator it=  set.iterator();
//			while(it.hasNext()){
//				Object key= it.next();
//				System.out.println(key+" vlaue is "+map.get(key));
			
			Set set = map.entrySet();
			Iterator it= set.iterator();
			while(it.hasNext()){
				Map.Entry	mapentry= (Map.Entry)it.next();
				System.out.println(mapentry.getKey()+"===="+mapentry.getValue());				
			}
			}
			
		}
	
	}

