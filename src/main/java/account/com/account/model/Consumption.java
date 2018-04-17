/**
 * 
 */
package com.account.model;

import java.util.Date;

/**
 * 说明：支出表
 * @author Lewis
 * @since 2018年3月27日
 */
public class Consumption {
	private Long consume_id;
	private String type;
	private String pay_type;
	private String by_name;
	private Long amount;
	private Long price;
	private Long quantity;
	private Date pay_time;
	private String isdelete;
	private Long ledger_id;
	private String note;
	private Long create_user;
	private Date create_time;
	public Long getConsume_id() {
		return consume_id;
	}
	public void setConsume_id(Long consume_id) {
		this.consume_id = consume_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getBy_name() {
		return by_name;
	}
	public void setBy_name(String by_name) {
		this.by_name = by_name;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	public String getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	public Long getLedger_id() {
		return ledger_id;
	}
	public void setLedger_id(Long ledger_id) {
		this.ledger_id = ledger_id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getCreate_user() {
		return create_user;
	}
	public void setCreate_user(Long create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
}
