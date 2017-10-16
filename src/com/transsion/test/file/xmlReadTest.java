package com.transsion.test.file;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-09-12 上午10:51:08
 * @version 0.0.1
 * 
 */
public class xmlReadTest {
	public static String filePath="C:\\Users\\pradmin\\Desktop\\CardBoxType.xml";
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
//		File file=new File(filePath);
//		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder=builderFactory.newDocumentBuilder();
//		Document doc=builder.parse(file);
//		NodeList list=doc.getElementsByTagName("element");
//		for(int i=0;i<list.getLength();i++) {
//			System.out.println(""+doc.getElementsByTagName("element").item(i).getFirstChild().getNodeValue());
//			System.out.println(""+doc.getElementsByTagName("element").item(i).getLastChild().getNodeValue());
//		}
		
//	   String testStr="\t       SN.  Lab\r\n\t    ";
//	   System.out.println(testStr);
//	   String fx=replaceBlank(testStr);
//	   System.out.print(replaceBlank(testStr));
//	   System.out.print(replaceBlank(testStr));
		System.out.println(createPartsnTable("fehf  fei"));
	}
	
	private static String createPartsnTable(String projectName) {
		String partsnTableSuffix="_partsn";
		StringBuilder createPartsnTableSQL=new StringBuilder();
		createPartsnTableSQL.append("CREATE TABLE `").append(projectName).append(partsnTableSuffix).append("`(")
		.append("`Work_Order` varchar(32) NOT NULL COMMENT '工单号',")
		.append("`Plant_No` char(4) NOT NULL COMMENT '工厂代码',")
		.append("`ID` int(11) NOT NULL AUTO_INCREMENT,")
		.append("`PART_TYPE` varchar(8) DEFAULT NULL COMMENT '关键料类型',")
		.append("`MAT_Code` varchar(32) DEFAULT NULL COMMENT '关键料编码',")
		.append("`PART_SN` varchar(32) NOT NULL COMMENT '关键料SN',")
		.append("`PCBA_SN` varchar(32) NOT NULL COMMENT '主板SN',")
		.append("`UNION_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '绑定时间',")
		.append("`SEPARATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '解绑时间',")
		.append("`IS_INACTIVE` char(1) NOT NULL DEFAULT '0' COMMENT '是否删除',")
		.append("PRIMARY KEY (`ID`)")
		.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主板绑定关键料表';");
		return createPartsnTableSQL.toString();
		//dao.insertObject("ProjectMapper.createProjectTable",createPartsnTableSQL.toString());	    			
	}
	
	public static String replaceBlank(String replacement) {
		if(replacement==null)
			return null;
		String pattern="\\t|\r|\n";
		return replacement.replaceAll(pattern,"").trim();
	}

}
