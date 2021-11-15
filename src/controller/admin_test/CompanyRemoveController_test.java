package controller.admin_test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import controller.admin.CompanyCreateController;
import controller.admin.CompanyRemoveController;
import factory.CompanyDBOFactory;
import system.MCRB;
import view.CompanyCreateView;
import view.CompanyRemoveView;

public class CompanyRemoveController_test {
	@Test
	public void execute_test1() {
		class CompanyRemoveView2 extends CompanyRemoveView{

			public CompanyRemoveView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			public String getCompanyName() {
				return "Testing";
			}

			
		}
		Scanner sc = new Scanner(System.in);
		CompanyRemoveView2 view2 = new CompanyRemoveView2(sc);
		CompanyRemoveController adc = new CompanyRemoveController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		adc.execute();
		
		assertEquals("Not found.\r\n", stream.toString());
	}
	
	@Test
	public void execute_test2_success() {
		class CompanyRemoveView2 extends CompanyRemoveView{

			public CompanyRemoveView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			public String getCompanyName() {
				return "cmp1";
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
			public boolean Confirm() {
				return true;
			}
			
		}
		Scanner sc = new Scanner(System.in);
		CompanyRemoveView2 view2 = new CompanyRemoveView2(sc);
		CompanyRemoveController adc = new CompanyRemoveController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		adc.execute();
		
		assertEquals("Company Removed.\r\n", stream.toString());
	}
	
	@Test
	public void execute_test_exit() {
		class CompanyRemoveView2 extends CompanyRemoveView{

			public CompanyRemoveView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			public String getCompanyName() {
				return "cmp1";
			}
			public int selectList(ArrayList<?> list) {
				return 1;
			}
			
		}
		Scanner sc = new Scanner(System.in);
		CompanyRemoveView2 view2 = new CompanyRemoveView2(sc);
		CompanyRemoveController adc = new CompanyRemoveController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		MCRB.getInstance().setCompanyList(CompanyDBOFactory.create());;
		adc.execute();
		
		assertEquals(false, stream.toString().contains("Company Removed."));
	}
	
	@Test
	public void execute_test_notConfirm() {
		class CompanyRemoveView2 extends CompanyRemoveView{

			public CompanyRemoveView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			public String getCompanyName() {
				return "cmp1";
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
			public boolean Confirm() {
				return false;
			}
			
		}
		Scanner sc = new Scanner(System.in);
		CompanyRemoveView2 view2 = new CompanyRemoveView2(sc);
		CompanyRemoveController adc = new CompanyRemoveController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		MCRB.getInstance().setCompanyList(CompanyDBOFactory.create());;
		adc.execute();
		
		assertEquals(false, stream.toString().contains("Company Removed."));
	}
	
	@Test
	public void execute_test_getDesc() {
		Scanner sc = new Scanner(System.in);
		CompanyRemoveView view2 = new CompanyRemoveView(sc);
		CompanyRemoveController adc = new CompanyRemoveController(view2);
		String result = adc.getDescription();
		
		assertEquals("Remove Company", result);
	}
	
}
