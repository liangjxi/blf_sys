/**
 * 
 */
package com.blf.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.common.annotation
 * DateTime: 2016年6月6日 下午7:26:49
 * Description:防止重复提交自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
	boolean save() default false;  
    boolean remove() default false;
}
