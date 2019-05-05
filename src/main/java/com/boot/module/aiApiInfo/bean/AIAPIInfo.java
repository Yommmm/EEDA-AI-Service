package com.boot.module.aiApiInfo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "e_ai_api_info")
@ApiModel(value = "AIAPIInfo", description = "AI接口控制")
public class AIAPIInfo {
    
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "eaa_info_id")
    @ApiModelProperty(value = "数据流水号")
	private String eaaInfoId;
	
    @Column(name = "e_mac")
    @ApiModelProperty(value = "数据来源设备mac地址")
	private String eMac;
    
    @Column(name = "e_count")
    @ApiModelProperty(value = "当天使用次数")
    private Integer eCount;
	
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

	public String getEaaInfoId() {
		return eaaInfoId;
	}

	public void setEaaInfoId(String eaaInfoId) {
		this.eaaInfoId = eaaInfoId;
	}

	public String geteMac() {
		return eMac;
	}

	public void seteMac(String eMac) {
		this.eMac = eMac;
	}

	public Integer geteCount() {
		return eCount;
	}

	public void seteCount(Integer eCount) {
		this.eCount = eCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
}