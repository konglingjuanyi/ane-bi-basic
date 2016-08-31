package com.ane56.bi.common.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class CreateExcelUtils {
	 /**
     * 构造器
     * 
     */
    public CreateExcelUtils() {

    }
    public static HSSFCellStyle setCellStyle(HSSFWorkbook wb){
		// 创建单元格样式
		HSSFCellStyle cellStyleTitle = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定当单元格内容显示不下时自动换行
		cellStyleTitle.setWrapText(true);
		// ------------------------------------------------------------------
		HSSFCellStyle cellStyle = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定当单元格内容显示不下时自动换行
		cellStyle.setWrapText(true);
		// ------------------------------------------------------------------
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 200);
		cellStyleTitle.setFont(font);
		return cellStyleTitle;
	};
	
	 public static HSSFCellStyle setHeaderCellStyle(HSSFWorkbook wb){
		// 另一个样式    
		    HSSFCellStyle headerStyle = wb.createCellStyle();  
			 // 设置字体    
		    HSSFFont headfont = wb.createFont();    
		    headfont.setFontName("黑体");    
		    headfont.setFontHeightInPoints((short) 14);// 字体大小    
		    headfont.setFontHeight((short) 14);
		    headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗    
		    //headfont.setColor(HSSFColor.WHITE.index);
		    headerStyle.setFont(headfont);    
		    headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中    
		    headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中    
		    headerStyle.setLocked(true);   
		    headerStyle.setFillBackgroundColor(HSSFColor.AQUA.index);
		   // headerStyle.setFillForegroundColor(HSSFColor.GREEN.index);
		    return headerStyle;
		};
		/**
		 * 设置标题样式
		 * @param wb
		 * @return
		 */
		public static HSSFCellStyle setTitleStyle(HSSFWorkbook wb){
			// 另一个样式    
		    HSSFCellStyle titleStyle = wb.createCellStyle();  
			 // 设置字体    
		    HSSFFont headfont = wb.createFont();    
		    headfont.setFontName("黑体");    
		    headfont.setFontHeightInPoints((short) 14);// 字体大小    
		    headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗    
		    headfont.setColor(HSSFColor.RED.index);
		    titleStyle.setFont(headfont);    
		    titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中    
		    titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中    
		    titleStyle.setLocked(true);    
		    titleStyle.setWrapText(true);// 自动换行   
		    return titleStyle;
		}
    //创建excel文件和样式
    public static HSSFSheet createExcelTitleAndStyle(String worksheetTitle,HSSFWorkbook wb,Map<String, String> excelTitleMap,int num){
    	if(num>0){
    		num--;
    	}
    	//创建一个sheet
    	HSSFSheet sheet = wb.createSheet();
    	//标题样式
    	HSSFCellStyle titleStyle = setTitleStyle(wb);
		// 定义第一行
		HSSFRow row0 = sheet.createRow(0);
		HSSFCell cell0 = row0.createCell(0);		
		 // 设置行高    
	    row0.setHeight((short) 900);       
	    cell0.setCellValue(new HSSFRichTextString(worksheetTitle));    
	    cell0.setCellStyle(titleStyle);    
	      /**  
	       * 合并单元格  
	       *    第一个参数：第一个单元格的行数（从0开始）  
	       *    第二个参数：第二个单元格的行数（从0开始）  
	       *    第三个参数：第一个单元格的列数（从0开始）  
	       *    第四个参数：第二个单元格的列数（从0开始）  
	       */    
	    CellRangeAddress range = new CellRangeAddress(0, 0, 0,num);    
	    sheet.addMergedRegion(range);    
		if(excelTitleMap !=null){
			// 创建第二行    
		    HSSFRow row1 = sheet.createRow(1);  
		    row1.setHeight((short)25);
		    //菜单样式
		    HSSFCellStyle headerStyle = setHeaderCellStyle(wb);
		    HSSFCell cell1 = row1.createCell(0);  
		    int i=0;
			for (String key : excelTitleMap.keySet()) {
				   if(i==0){
					// 第一行第一列
					cell1.setCellValue(new HSSFRichTextString(excelTitleMap.get(key)));
					cell1.setCellStyle(headerStyle);
					
					 i++;
				   }else{
					// 第一行第2列
					cell1 = row1.createCell(i);
					cell1.setCellValue(new HSSFRichTextString(excelTitleMap.get(key)));
					cell1.setCellStyle(headerStyle);
					i++;
				   }
			}
		}
		return sheet;
	};
	public static void paraseDataToExcelSheet(List<Map<String, Object>> value,HSSFSheet sheet,Map<String, String> excelTitleMap){
		int indexRow = 2;  //行号
		int indexCell = 0;  //列
		//Map<String, String> titleMap = DimensionKpiMapper.getExcelTitle();
		for(Map<String,Object> map: value){
			//创建一行
			Row row1 = sheet.createRow(indexRow);
			indexRow ++;
			indexCell = 0;
			for(String cellTitle : excelTitleMap.keySet()){
				//创建一个单元格
				Cell cell = row1.createCell(indexCell);
				Object obj = map.get(cellTitle.toString());
				String cellValue = "";
				if(obj!=null){
					cellValue = obj.toString();
				}
				cell.setCellValue(cellValue);
				indexCell++;
			}
		}
	}
}
