package com.pgy.apache;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 云霁科技网络技术有限公司 idcos.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */

/**
 *
 * @author jiaohuizhe
 * @version $Id: CreateExcel.java, v 0.1 2016年2月4日 上午10:17:15 jiaohuizhe Exp $
 */
public class CreateExcel {
        private static String url      = "mysql.dev.idcos.net";
//    private static String url      = "localhost";
    //    private static String url    = "55.3.8.27";
    private static String schema   = "hf-csa-bak";
    private static String password = "P@ssw0rd";
//        private static String password = "yunjikeji";

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        File file = new File("/tmp/test.xlsx");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        toExcel(file, readDB());
    }

    public static void toExcel(File excel,
                               TreeMap<String, ArrayList<String[]>> map) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCellStyle cs = wb.createCellStyle();
        cs.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cs.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cs.setFillPattern(CellStyle.BIG_SPOTS);

        XSSFCellStyle tcs = wb.createCellStyle();
        tcs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFCellStyle hlinkstyle = wb.createCellStyle();
        XSSFFont hlinkfont = wb.createFont();
        hlinkfont.setUnderline(XSSFFont.U_SINGLE);
        hlinkfont.setColor(HSSFColor.BLUE.index);
        hlinkstyle.setFont(hlinkfont);

        XSSFSheet title = wb.createSheet("目录");
        title.setColumnWidth(0, 4000);
        title.setColumnWidth(1, 6000);
        title.setColumnWidth(2, 6000);
        int row = 0;
        addRow(cs, title, row++, "数据表分类", "数据表名称", "数据表说明");
        XSSFSheet curSheet = null;
        String curType = null;
        StringBuffer t = new StringBuffer();
        XSSFCreationHelper createHelper = wb.getCreationHelper();
        Integer begin = null;
        for (String tab : map.keySet()) {
            if (tab.startsWith("ACT_") || tab.startsWith("WF_") || tab.indexOf("_") == -1) {
                continue;
            }
            System.out.println(tab);
            String type = tab.substring(0, tab.indexOf("_"));
            String name = tab.substring(0, tab.indexOf(" "));
            String txt = tab.substring(tab.indexOf(" ") + 1);
            if (curType == null || !type.equals(curType)) {
                curSheet = wb.createSheet(type);
                //                if (curType != null) {
                //                    FileUtils.write(new File("TABLE/TXT/AUTO/" + curType + ".txt"), t);
                //                    t.delete(0, t.length());
                //
                //                }
                if (begin != null) {
                    CellRangeAddress region = new CellRangeAddress(begin, row - 1, 0, 0);
                    title.addMergedRegion(region);
                    XSSFCell tt = title.getRow(begin).createCell(0);
                    tt.setCellValue(getTypeName(curType));
                    tt.setCellStyle(tcs);
                }
                begin = row;
                curSheet.setColumnWidth(0, 6000);
                curSheet.setColumnWidth(1, 3000);
                curSheet.setColumnWidth(2, 2000);
                curSheet.setColumnWidth(3, 6000);
                curType = type;
            }
            //            File f = new File("TABLE/XML/" + curType.toLowerCase() + "/" + name + ".xml");
            //            if (!f.getParentFile().isDirectory()) {
            //                f.getParentFile().mkdirs();
            //            }
            //            FileUtils.write(f, xml);
            XSSFRow trow = addRow(null, title, row++, "", name, txt);
            if (t.length() != 0) {
                t.append("\n\n\n");
            }
            addTab(cs, hlinkstyle, trow, curSheet, name, txt, map.get(tab), t, createHelper);
        }
        if (begin != null) {
            CellRangeAddress region = new CellRangeAddress(begin, row - 1, 0, 0);
            title.addMergedRegion(region);
            XSSFCell tt = title.getRow(begin).createCell(0);
            tt.setCellValue(getTypeName(curType));
            tt.setCellStyle(tcs);
        }
        wb.write(new FileOutputStream(excel));
        wb.close();
    }

    private static String getTypeName(String type) {
        switch (type) {
            case "APP":
                return "应用数据";
            case "CFG":
                return "配置数据";
            case "IDC":
                return "数据中心";
            case "RES":
                return "资源数据";
            case "SRV":
                return "服务申请相关数据";
            case "SYS":
                return "系统配置类数据";
            case "TP":
                return "拓扑数据";
        }
        return type;
    }

    public static void addTab(XSSFCellStyle cs, XSSFCellStyle hlinkstyle, XSSFRow trow,
                              XSSFSheet curSheet, String name, String txt, ArrayList<String[]> cols,
                              StringBuffer t, XSSFCreationHelper createHelper) {
        int row = curSheet.getLastRowNum();
        if (row != 0) {
            row += 4;
        }
        XSSFRow curRow = addRow(cs, curSheet, row++, name, "类型", "是否必填", txt);
        {
            XSSFHyperlink hl = createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
            hl.setLocation(curSheet.getSheetName() + "!A" + row);
            XSSFCell cell = trow.createCell(3);
            cell.setCellValue("转至");
            cell.setHyperlink(hl);
            cell.setCellStyle(hlinkstyle);
        }
        {
            XSSFHyperlink hl = createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
            hl.setLocation("目录!A" + (trow.getRowNum() + 1));
            XSSFCell cell = curRow.createCell(4);
            cell.setHyperlink(hl);
            cell.setCellValue("返回目录");
            cell.setCellStyle(hlinkstyle);
        }
        putTxt(t, name, "类型", "是否必填", txt);
        for (String[] col : cols) {
            addRow(null, curSheet, row++, col);
            putTxt(t, col);
        }
    }

    public static void putTxt(StringBuffer t, String... cols) {
        boolean first = true;
        for (String col : cols) {
            if (first) {
                first = false;
            } else {
                t.append("\t");
            }
            t.append(col);
        }
        t.append("\n");
    }

    public static XSSFRow addRow(XSSFCellStyle cs, XSSFSheet sheet, int rowNum, String... cols) {
        XSSFRow row = sheet.createRow(rowNum);
        for (int i = 0; i < cols.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(cols[i]);
            if (cs != null) {
                cell.setCellStyle(cs);
            }
        }
        return row;
    }

    public static TreeMap<String, ArrayList<String[]>> readDB() throws Exception {
        TreeMap<String, ArrayList<String[]>> map = new TreeMap<>();
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String sql = "select t.table_name,t.table_comment,c.COLUMN_NAME,c.COLUMN_TYPE,c.IS_NULLABLE,c.COLUMN_COMMENT "
                     + " from TABLES t inner join COLUMNS c on t.TABLE_SCHEMA=c.TABLE_SCHEMA and t.TABLE_NAME=c.TABLE_NAME"
                     + " where t.TABLE_SCHEMA='" + schema
                     + "' and t.TABLE_TYPE='BASE TABLE'  order by 1,c.ORDINAL_POSITION";

        //        System.out.println(sql);
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://" + url + ":3306/information_schema?characterEncoding=UTF-8", user,
            password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String tabName = rs.getString(1);
            String tabTxt = rs.getString(2);
            //            if (tabTxt == null || tabTxt.equals("")) {
            //                continue;
            //            }
            String tab = tabName + " " + tabTxt;
            String[] col = { rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) };
            if ("NO".equals(col[2])) {
                col[2] = "Y";
            } else {
                col[2] = "N";
            }
            ArrayList<String[]> list = null;
            list = map.get(tab);
            if (list == null) {
                list = new ArrayList<>(20);
                map.put(tab, list);
            }
            list.add(col);
        }
        st.close();
        conn.close();

        return map;
    }

    private static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n<table>\n</table>";
}
