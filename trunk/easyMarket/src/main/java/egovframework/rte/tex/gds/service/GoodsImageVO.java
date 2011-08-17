package egovframework.rte.tex.gds.service;

public class GoodsImageVO {
	
	private String goodsImageId;
	private String fileNm;
	
		
	public GoodsImageVO() {
		super();
	}

	public GoodsImageVO(String goodsImageId, String fileNm) {
		super();
		this.goodsImageId = goodsImageId;
		this.fileNm = fileNm;
	}

	/**
	 * 조회
	 * 
	 * @return
	 */
	public String getGoodsImageId() {
		return goodsImageId;
	}

	/**
	 * 등록
	 * 
	 * @param goodsImageId
	 */
	public void setGoodsImageId(String goodsImageId) {
		this.goodsImageId = goodsImageId;
	}

	/**
	 * 조회
	 * 
	 * @return
	 */
	public String getFileNm() {
		return fileNm;
	}

	/**
	 * 등록
	 * 
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "GoodsImageVO [goodsImageId=" + goodsImageId + ", fileNm="
				+ fileNm + "]";
	}

}
