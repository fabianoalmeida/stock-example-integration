package com.example.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.example.stock.view.BaseDTO;

/**
 * @author fabiano.barreto
 *
 */
public class Util {

	public static Object copyProperties( Class< ? extends BaseDTO > clazz, Object object ) {
		
		Object clazz2 = null;
		
		try {
			
			clazz2 = clazz.newInstance();
			
			BeanUtils.copyProperties( clazz2, object );
			
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		return clazz2;
	}
	
}
