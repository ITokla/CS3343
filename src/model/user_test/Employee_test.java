package model.user_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.user.Employee;

class Employee_test {

	@Test
	void test_setEmployee() {
		Employee emp = new Employee("test","test");
		Employee emp2 = new Employee("test2","test2");
		emp.setEmployee(emp2);
		Boolean result = (emp.getUsername()).equals(emp2.getUsername()) && ((emp.getPassword()).equals(emp2.getPassword()));
		assertEquals(true,result);
	}
	@Test
	void test_getStatus_newEmployee() {
		Employee emp = new Employee("test","test");
		int result = emp.getStatus();
		assertEquals(0,result);
	}
	@Test
	void test_setStatus() {
		Employee emp = new Employee("test","test");
		emp.setStatus(1);
		int result = emp.getStatus();
		assertEquals(1,result);
	}
	@Test
	void test_setPwd() {
		Employee emp = new Employee("test","test");
		emp.setPassword("abc");
		String result = emp.getPassword();
		assertEquals("abc",result);
	}
	@Test
	void test_getInit_init() {
		Employee emp = new Employee("test","test");
		emp.setInit(true);
		Boolean result = emp.getInit();
		assertEquals(true,result);
	}
	@Test
	void test_getInit_notInit() {
		Employee emp = new Employee("test","test");
		emp.setStatus(1);
		Boolean result = emp.getInit();
		assertEquals(false,result);
	}
	@Test
	void test_setInit() {
		Employee emp = new Employee("test","test");
		emp.setInit(true);
		int result = emp.getStatus();
		assertEquals(0,result);
	}
	@Test
	void test_setNotInit() {
		Employee emp = new Employee("test","test");
		emp.setInit(false);
		int result = emp.getStatus();
		assertEquals(1,result);
	}
	@Test
	void test_lock() {
		Employee emp = new Employee("test","test");
		emp.lock(true);
		int result = emp.getStatus();
		assertEquals(2,result);
	}
	@Test
	void test_unlock() {
		Employee emp = new Employee("test","test");
		emp.lock(false);
		int result = emp.getStatus();
		assertEquals(1,result);
	}
	@Test
	void test_compare_true() {
		Employee emp = new Employee("test","test");
		Employee emp2 = new Employee("test","test");
		int result = emp.compareTo(emp2);
		assertEquals(0,result);
	}
	@Test
	void test_compare_getEmpId() {
		Employee emp = new Employee("test","test");
		String result = emp.getEmpId();
		assertEquals(false,(result==null));
	}
}
