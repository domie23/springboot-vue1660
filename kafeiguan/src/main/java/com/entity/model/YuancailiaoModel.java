package com.entity.model;

import com.entity.YuancailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 原材料
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuancailiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 原材料编号
     */
    private String yuancailiaoUuidNumber;


    /**
     * 原材料名称
     */
    private String yuancailiaoName;


    /**
     * 原材料照片
     */
    private String yuancailiaoPhoto;


    /**
     * 单位
     */
    private String yuancailiaoDanwei;


    /**
     * 原材料类型
     */
    private Integer yuancailiaoTypes;


    /**
     * 原材料库存
     */
    private Integer yuancailiaoKucunNumber;


    /**
     * 购买获得积分
     */
    private Integer yuancailiaoPrice;


    /**
     * 原材料进价
     */
    private Double yuancailiaoJinjiaMoney;


    /**
     * 热度
     */
    private Integer yuancailiaoClicknum;


    /**
     * 原材料介绍
     */
    private String yuancailiaoContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：原材料编号
	 */
    public String getYuancailiaoUuidNumber() {
        return yuancailiaoUuidNumber;
    }


    /**
	 * 设置：原材料编号
	 */
    public void setYuancailiaoUuidNumber(String yuancailiaoUuidNumber) {
        this.yuancailiaoUuidNumber = yuancailiaoUuidNumber;
    }
    /**
	 * 获取：原材料名称
	 */
    public String getYuancailiaoName() {
        return yuancailiaoName;
    }


    /**
	 * 设置：原材料名称
	 */
    public void setYuancailiaoName(String yuancailiaoName) {
        this.yuancailiaoName = yuancailiaoName;
    }
    /**
	 * 获取：原材料照片
	 */
    public String getYuancailiaoPhoto() {
        return yuancailiaoPhoto;
    }


    /**
	 * 设置：原材料照片
	 */
    public void setYuancailiaoPhoto(String yuancailiaoPhoto) {
        this.yuancailiaoPhoto = yuancailiaoPhoto;
    }
    /**
	 * 获取：单位
	 */
    public String getYuancailiaoDanwei() {
        return yuancailiaoDanwei;
    }


    /**
	 * 设置：单位
	 */
    public void setYuancailiaoDanwei(String yuancailiaoDanwei) {
        this.yuancailiaoDanwei = yuancailiaoDanwei;
    }
    /**
	 * 获取：原材料类型
	 */
    public Integer getYuancailiaoTypes() {
        return yuancailiaoTypes;
    }


    /**
	 * 设置：原材料类型
	 */
    public void setYuancailiaoTypes(Integer yuancailiaoTypes) {
        this.yuancailiaoTypes = yuancailiaoTypes;
    }
    /**
	 * 获取：原材料库存
	 */
    public Integer getYuancailiaoKucunNumber() {
        return yuancailiaoKucunNumber;
    }


    /**
	 * 设置：原材料库存
	 */
    public void setYuancailiaoKucunNumber(Integer yuancailiaoKucunNumber) {
        this.yuancailiaoKucunNumber = yuancailiaoKucunNumber;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getYuancailiaoPrice() {
        return yuancailiaoPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setYuancailiaoPrice(Integer yuancailiaoPrice) {
        this.yuancailiaoPrice = yuancailiaoPrice;
    }
    /**
	 * 获取：原材料进价
	 */
    public Double getYuancailiaoJinjiaMoney() {
        return yuancailiaoJinjiaMoney;
    }


    /**
	 * 设置：原材料进价
	 */
    public void setYuancailiaoJinjiaMoney(Double yuancailiaoJinjiaMoney) {
        this.yuancailiaoJinjiaMoney = yuancailiaoJinjiaMoney;
    }
    /**
	 * 获取：热度
	 */
    public Integer getYuancailiaoClicknum() {
        return yuancailiaoClicknum;
    }


    /**
	 * 设置：热度
	 */
    public void setYuancailiaoClicknum(Integer yuancailiaoClicknum) {
        this.yuancailiaoClicknum = yuancailiaoClicknum;
    }
    /**
	 * 获取：原材料介绍
	 */
    public String getYuancailiaoContent() {
        return yuancailiaoContent;
    }


    /**
	 * 设置：原材料介绍
	 */
    public void setYuancailiaoContent(String yuancailiaoContent) {
        this.yuancailiaoContent = yuancailiaoContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
