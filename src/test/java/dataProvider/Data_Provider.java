package dataProvider;

import org.apache.poi.ss.usermodel.*;
import excelReader.ExcelReader;


public class Data_Provider {

    private Sheet sheet;
    static ExcelReader datatable = null;
   // String sheetname="ModifySearch";
    public Row row;
    private Cell cell;



    public static Object[][] getdata(String sheetname){

        datatable = new ExcelReader("C:\\Users\\XPO8584\\IdeaProjects\\Travelomind\\TestData\\bill.xlsx");
       int rowC=datatable.getRowCount(sheetname);
       int column=datatable.getColumnCount(sheetname);
       System.out.println(rowC);
       System.out.println(column);
       Object[][] data=new  Object[rowC-1][column];

       for(int row0=2;row0<=rowC;row0++){

           for(int col0=0;col0<column;col0++){

               data[row0-2][col0]=datatable.getCellData(sheetname,col0,row0);

           }
       }

      return data;

    }

    //@Test(dataProvider = "GetData")
    //public void Login(String First_Name,String Last_Name){


        //System.out.println(First_Name+"----"+Last_Name);

    //}


}
