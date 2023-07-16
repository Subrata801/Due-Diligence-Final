/**
 * 
 */
package com.bankMitra.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
/**
 * 
 * Base class for all model entities which have properties required for each
 *
 */
@MappedSuperclass
public class CommonAuditEntity {
	
	@JsonProperty(access=Access.WRITE_ONLY)
	@Column(name="cr_dt",insertable=true,updatable=false)
	@ApiModelProperty()
	public LocalDateTime createdDT;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	@Column(name="cr_by",insertable=true,updatable=false)
	@ApiModelProperty()
	public String createdBy;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	@Column(name="upd_dt",insertable=true,updatable=true)
	@ApiModelProperty()
	public LocalDateTime updatedDT;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	@Column(name="upd_by",insertable=true,updatable=true)
	@ApiModelProperty()
	public String updatedBy;

}
