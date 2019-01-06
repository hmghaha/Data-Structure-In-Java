package v1chap05.objectAnalyzer;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.lang.reflect.AccessibleObject;

/**
 * Convert an object to a string represtation that lists all fields.
 * @author Code
 *
 */

public class ObjectAnalyzer {
	private ArrayList<Object> visited = new ArrayList<>();
	
	public String toString(Object obj) {
		if(obj == null) return "null";
		if(visited.contains(obj)) return "...";
		visited.add(obj);
		Class cl = obj.getClass();
		if(cl == String.class) return (String) obj;
		if(cl.isArray()) {
			String r = cl.getComponentType() + "[]{";
			for(int i = 0; i < Array.getLength(obj); i++) {
				if(i > 0) r += ",";
				Object val = Array.get(obj, i);
				if(cl.getComponentType().isPrimitive()) r += val;
				else r += toString(val); //递归
			}
			return r + "}";
		}
		
		String r =cl.getName();
		//inspect the fields of this class and superclass
		do {
			r += "[";
			Field[] fields = cl.getDeclaredFields();
			//屏蔽Java语言的访问检查，使对象的私有属性也可以被查询设置
			AccessibleObject.setAccessible(fields, true); 
			//get the names and values of all fields
			for(Field f: fields) {
				if(!Modifier.isStatic(f.getModifiers())) {
					if(!r.endsWith("[")) r += ",";
					r += f.getName() + "=";
					try {
						Class t = f.getType();
						Object val = f.get(obj);
						if(t.isPrimitive()) r += val;
						else r +=toString(val);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			r += "]";
			cl = cl.getSuperclass();
		}
		while(cl != null);
		return r;
	}
}
