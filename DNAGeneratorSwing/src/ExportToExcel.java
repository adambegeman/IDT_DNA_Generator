import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExportToExcel {

	public static void Export(String location, String orderName, String[] DNA, int seqStart) {
		// create a new workbook
		Workbook wb = new HSSFWorkbook();
		// create a new sheet
		Sheet s = wb.createSheet();
		// declare a row object reference
		Row r = null;
		int rownum;
		int count = 1;
		String wellLet = "A";
		int wellNum = 1;
		wb.setSheetName(0, orderName);
		r = s.createRow(0);
		r.createCell(0).setCellValue("Well Position");
		r.createCell(1).setCellValue("Name");
		r.createCell(2).setCellValue("Sequence");
		for (rownum = (short) 1; rownum <= DNA.length; rownum++)
		{
			// create a row
			r = s.createRow(rownum);
			String wellPos = wellLet + wellNum;
			if (count == 12) {
				wellLet = "B";
				wellNum = 0;
			}
			if (count == 24) {
				wellLet = "C";
				wellNum = 0;
			}
			if (count == 36) {
				wellLet = "D";
				wellNum = 0;
			}
			if (count == 48) {
				wellLet = "E";
				wellNum = 0;
			}
			if (count == 60) {
				wellLet = "F";
				wellNum = 0;
			}
			if (count == 72) {
				wellLet = "G";
				wellNum = 0;
			}
			if (count == 84) {
				wellLet = "H";
				wellNum = 0;
			}
			String name = "Seq" + (rownum+seqStart-1);
			r.createCell(0).setCellValue(wellPos);
			r.createCell(1).setCellValue(name);
			r.createCell(2).setCellValue(DNA[rownum-1]);
			count++;
			wellNum++;
		}
		
		FileOutputStream out;
		try {
			out = new FileOutputStream("c:\\Users\\bronco26118\\Desktop\\" + orderName + ".xls");
			wb.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
