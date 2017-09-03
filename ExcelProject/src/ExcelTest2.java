import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest2 {
	private static final int KEY_SIZE = 128;
    private static final int ITERATION_COUNT = 10000;
    private static final String IV = "F27D5C9927726BCEFE7510B1BDD3D137";
    private static final String SALT = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
    private static final String PASSPHRASE = "passPhrase passPhrase aes encoding algorithm";
 
    private static final String PLAIN_TEXT = "AES ENCODING ALGORITHM PLAIN TEXT";  
	public static void main(String[] args) throws IOException {
		String SHA = ""; 
		TestUser tu = new TestUser("xzc", "aqw", "	sss", "zz", "dq"); 
		FileInputStream fis=new FileInputStream("test3.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
 
 

		ArrayList<String> arr2 = new ArrayList<>();
		ArrayList<String> arrsha = new ArrayList<>();
		arr2.add(tu.getId());
		arr2.add(tu.getPwd());
		arr2.add(tu.getName());
		arr2.add(tu.getGen());
		arr2.add(tu.getHire());			
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		//2���� sheet����
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		//������ ��
		XSSFRow row=null;
		//������ ��
		XSSFCell cell=null;			

		//��� row ����
		System.out.println(sheet.getLastRowNum());
		row = sheet.createRow(rows+1);

		for (int i = 0; i < arr2.size(); i++) {
			String encrypt = util.encrypt(SALT, IV, PASSPHRASE, arr2.get(i));
			String decrypt = util.decrypt(SALT, IV, PASSPHRASE, encrypt);

			System.out.println(arr2.get(i));
			//1���� workbook�� ����
			row.createCell(i).setCellValue(encrypt);
			System.out.println("���ڿ� : " + arr2.get(i) );
			System.out.println("��ȣȭ : " + encrypt);
			System.out.println("��ȣȭ : " + decrypt);
			System.out.println(encrypt.getBytes().length);
		}
		System.out.println("�������ϻ�������");

		//��� cell ����
						
		FileOutputStream fileoutputstream=new FileOutputStream("test3.xlsx");
		//������ ����
		workbook.write(fileoutputstream);
		//�ʼ��� �ݾ��־����
		fileoutputstream.close();
		

	}
}
