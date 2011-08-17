package egovframework.rte.tex.com.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import egovframework.rte.tex.gds.service.GoodsVO;

public class EgovExcel extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook wb, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HSSFCell cell = null;
		 
		HSSFSheet sheet = wb.createSheet("Goods List");
		sheet.setDefaultColumnWidth((short) 12);
 
		// put text in first cell
		cell = getCell(sheet, 0, 0);
		setText(cell, "Goods List");
 
		// set header information
		setText(getCell(sheet, 2, 0), "No.");
		setText(getCell(sheet, 2, 1), "NAME");
		setText(getCell(sheet, 2, 2), "PRICE");
		setText(getCell(sheet, 2, 3), "CATEGORY NAME");
		setText(getCell(sheet, 2, 4), "MAKER");
 
		List<GoodsVO> goods = (List<GoodsVO>) model.get("goodsList");
 
 
		for (int i = 0; i < goods.size(); i++) {
				GoodsVO goodsVO = goods.get(i);
 
				cell = getCell(sheet, 3 + i, 0);
				setText(cell, Integer.toString(i+1));
 
				cell = getCell(sheet, 3 + i, 1);
				setText(cell, goodsVO.getGoodsNm());
				
				cell = getCell(sheet, 3 + i, 2);
				setText(cell, Integer.toString(goodsVO.getPrice()));
				
				cell = getCell(sheet, 3 + i, 3);
				setText(cell, goodsVO.getCategoryVO().getCtgryNm());

				cell = getCell(sheet, 3 + i, 4);
				setText(cell, goodsVO.getMakr());
 
		}
		
	}

}
