package com.entity.view;

import com.entity.YuancailiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 原材料
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yuancailiao")
public class YuancailiaoView extends YuancailiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 原材料类型的值
		*/
		private String yuancailiaoValue;



	public YuancailiaoView() {

	}

	public YuancailiaoView(YuancailiaoEntity yuancailiaoEntity) {
		try {
			BeanUtils.copyProperties(this, yuancailiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 原材料类型的值
			*/
			public String getYuancailiaoValue() {
				return yuancailiaoValue;
			}
			/**
			* 设置： 原材料类型的值
			*/
			public void setYuancailiaoValue(String yuancailiaoValue) {
				this.yuancailiaoValue = yuancailiaoValue;
			}














}
