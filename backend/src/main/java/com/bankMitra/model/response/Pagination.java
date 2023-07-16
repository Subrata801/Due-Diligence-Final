/**
 * 
 */
package com.bankMitra.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
@JsonInclude(Include.NON_NULL)
public class Pagination {
	
	@ApiModelProperty(value="Number of Items" , required=true)
	private long limit;
	
	@ApiModelProperty(value="Initial Position" , required=true)
	private long offset;
	
	@ApiModelProperty(value="Total number of items" , required=true)
	private long total;
	
    public Pagination() {}
    
    public Pagination(long offset,long limit,long total) {
    	if(total<limit) {
    		this.offset = total;
    	} else {
    		this.offset =  offset  + Long.valueOf(limit);
    	}
    	this.limit = limit;
    	this.total = total;
    }

	/**
	 * @return the limit
	 */
	public long getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(long limit) {
		this.limit = limit;
	}

	/**
	 * @return the offset
	 */
	public long getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(long offset) {
		this.offset = offset;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
    
}
