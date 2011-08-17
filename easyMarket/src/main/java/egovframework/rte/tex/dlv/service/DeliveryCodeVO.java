package egovframework.rte.tex.dlv.service;


/**
 * @Class Name : DeliveryCodeVO.java
 * @Description : DeliveryCodeVO class 
 * @author 신혜연
 * @since 2011. 7. 14
 * @version 1.0
 */
public class DeliveryCodeVO{
	private String dlvySe; // 배송코드
	private String dlvySttus; //배송상태
	
	public String getDlvySe() {
		return dlvySe;
	}
	public void setDlvySe(String dlvySe) {
		this.dlvySe = dlvySe;
	}
	public String getDlvySttus() {
		return dlvySttus;
	}
	public void setDlvySttus(String dlvySttus) {
		this.dlvySttus = dlvySttus;
	}
	
	
}
