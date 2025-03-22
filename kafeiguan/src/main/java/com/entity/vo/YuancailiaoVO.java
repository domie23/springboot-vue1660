package com.entity.vo;

import com.entity.YuancailiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 原材料
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuancailiao")
public class YuancailiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 原材料编号
     */

    @TableField(value = "yuancailiao_uuid_number")
    private String yuancailiaoUuidNumber;


    /**
     * 原材料名称
     */

    @TableField(value = "yuancailiao_name")
    private String yuancailiaoName;


    /**
     * 原材料照片
     */

    @TableField(value = "yuancailiao_photo")
    private String yuancailiaoPhoto;


    /**
     * 单位
     */

    @TableField(value = "yuancailiao_danwei")
    private String yuancailiaoDanwei;


    /**
     * 原材料类型
     */

    @TableField(value = "yuancailiao_types")
    private Integer yuancailiaoTypes;


    /**
     * 原材料库存
     */

    @TableField(value = "yuancailiao_kucun_number")
    private Integer yuancailiaoKucunNumber;


    /**
     * 购买获得积分
     */

    @TableField(value = "yuancailiao_price")
    private Integer yuancailiaoPrice;


    /**
     * 原材料进价
     */

    @TableField(value = "yuancailiao_jinjia_money")
    private Double yuancailiaoJinjiaMoney;


    /**
     * 热度
     */

    @TableField(value = "yuancailiao_clicknum")
    private Integer yuancailiaoClicknum;


    /**
     * 原材料介绍
     */

    @TableField(value = "yuancailiao_content")
    private String yuancailiaoContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：原材料编号
	 */
    public String getYuancailiaoUuidNumber() {
        return yuancailiaoUuidNumber;
    }


    /**
	 * 获取：原材料编号
	 */

    public void setYuancailiaoUuidNumber(String yuancailiaoUuidNumber) {
        this.yuancailiaoUuidNumber = yuancailiaoUuidNumber;
    }
    /**
	 * 设置：原材料名称
	 */
    public String getYuancailiaoName() {
        return yuancailiaoName;
    }


    /**
	 * 获取：原材料名称
	 */

    public void setYuancailiaoName(String yuancailiaoName) {
        this.yuancailiaoName = yuancailiaoName;
    }
    /**
	 * 设置：原材料照片
	 */
    public String getYuancailiaoPhoto() {
        return yuancailiaoPhoto;
    }


    /**
	 * 获取：原材料照片
	 */

    public void setYuancailiaoPhoto(String yuancailiaoPhoto) {
        this.yuancailiaoPhoto = yuancailiaoPhoto;
    }
    /**
	 * 设置：单位
	 */
    public String getYuancailiaoDanwei() {
        return yuancailiaoDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setYuancailiaoDanwei(String yuancailiaoDanwei) {
        this.yuancailiaoDanwei = yuancailiaoDanwei;
    }
    /**
	 * 设置：原材料类型
	 */
    public Integer getYuancailiaoTypes() {
        return yuancailiaoTypes;
    }


    /**
	 * 获取：原材料类型
	 */

    public void setYuancailiaoTypes(Integer yuancailiaoTypes) {
        this.yuancailiaoTypes = yuancailiaoTypes;
    }
    /**
	 * 设置：原材料库存
	 */
    public Integer getYuancailiaoKucunNumber() {
        return yuancailiaoKucunNumber;
    }


    /**
	 * 获取：原材料库存
	 */

    public void setYuancailiaoKucunNumber(Integer yuancailiaoKucunNumber) {
        this.yuancailiaoKucunNumber = yuancailiaoKucunNumber;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getYuancailiaoPrice() {
        return yuancailiaoPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setYuancailiaoPrice(Integer yuancailiaoPrice) {
        this.yuancailiaoPrice = yuancailiaoPrice;
    }
    /**
	 * 设置：原材料进价
	 */
    public Double getYuancailiaoJinjiaMoney() {
        return yuancailiaoJinjiaMoney;
    }


    /**
	 * 获取：原材料进价
	 */

    public void setYuancailiaoJinjiaMoney(Double yuancailiaoJinjiaMoney) {
        this.yuancailiaoJinjiaMoney = yuancailiaoJinjiaMoney;
    }
    /**
	 * 设置：热度
	 */
    public Integer getYuancailiaoClicknum() {
        return yuancailiaoClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setYuancailiaoClicknum(Integer yuancailiaoClicknum) {
        this.yuancailiaoClicknum = yuancailiaoClicknum;
    }
    /**
	 * 设置：原材料介绍
	 */
    public String getYuancailiaoContent() {
        return yuancailiaoContent;
    }


    /**
	 * 获取：原材料介绍
	 */

    public void setYuancailiaoContent(String yuancailiaoContent) {
        this.yuancailiaoContent = yuancailiaoContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
