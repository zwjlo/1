package com.entity.view;

import com.entity.JubaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 举报信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-01 20:34:11
 */
@TableName("jubaoxinxi")
public class JubaoxinxiView  extends JubaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JubaoxinxiView(){
	}
 
 	public JubaoxinxiView(JubaoxinxiEntity jubaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jubaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
