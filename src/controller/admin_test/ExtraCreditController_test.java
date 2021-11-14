package controller.admin_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.admin.AddRoomController;
import controller.admin.ExtraCreditController;
import system.MCRB;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import view.AddRoomView;
import view.ExtraCreditView;

class ExtraCreditController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	public void test_notFoundCompany() {
		class testExtraCreditView extends ExtraCreditView{
			public testExtraCreditView(Scanner input) {
				super(input);
			}
			public String getCompanyName() {
				return "cmp0";
			}
		}
		class testExtraCreditController extends ExtraCreditController{
			public testExtraCreditController(ExtraCreditView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		testExtraCreditView tec = new testExtraCreditView(input);
		testExtraCreditController tecc = new testExtraCreditController(tec);
		tecc.execute();
		assertEquals("Company not found\r\n", stream.toString());
	}
	
	@Test
	public void test_InvalidIndex() {
		class testExtraCreditView extends ExtraCreditView{
			public testExtraCreditView(Scanner input) {
				super(input);
			}
			public String getCompanyName() {
				return "cmp1";
			}
			public double getCredit() {
				return 30;
			}
			public int selectList(ArrayList<?> list) {
				return 999;
			}
		}
		class testExtraCreditController extends ExtraCreditController{
			public testExtraCreditController(ExtraCreditView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		testExtraCreditView tec = new testExtraCreditView(input);
		testExtraCreditController tecc = new testExtraCreditController(tec);
		tecc.execute();
		assertEquals("", stream.toString());
	}
	
	@Test
	public void test_CreditLower1() {
		class testExtraCreditView extends ExtraCreditView{
			public testExtraCreditView(Scanner input) {
				super(input);
			}
			public String getCompanyName() {
				return "cmp";
			}
			public int selectList(ArrayList<?> list) {
				return 1;
			}
			public double getCredit() {
				return 0.5;
			}
		}
		class testExtraCreditController extends ExtraCreditController{
			public testExtraCreditController(ExtraCreditView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		testExtraCreditView tec = new testExtraCreditView(input);
		testExtraCreditController tecc = new testExtraCreditController(tec);
		tecc.execute();
		assertEquals("Credit update must be >= 1\r\n", stream.toString());
	}
	
	@Test
	public void test_updateCreditSuccess() {
		class testExtraCreditView extends ExtraCreditView{
			public testExtraCreditView(Scanner input) {
				super(input);
			}
			public String getCompanyName() {
				return "cmp";
			}
			public int selectList(ArrayList<?> list) {
				return 1;
			}
			public double getCredit() {
				return 2;
			}
		}
		class testExtraCreditController extends ExtraCreditController{
			public testExtraCreditController(ExtraCreditView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		testExtraCreditView tec = new testExtraCreditView(input);
		testExtraCreditController tecc = new testExtraCreditController(tec);
		tecc.execute();
		double expected = 150;
		double result = MCRB.getInstance().searchCompany("cmp2").get(0).getCredit().toMinutes();
		assertEquals(expected, result,0);
	}
	
	@Test
	public void test_getFunctionDesc() {
		Scanner input = new Scanner(System.in);
		ExtraCreditView ec = new ExtraCreditView(input);
		ExtraCreditController ecc = new ExtraCreditController(ec);
		String result = ecc.getDescription();
		assertEquals("Extra Credit", result);	
	}

}
