package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg1 {
	@BeforeClass
	public void beforeclass() {
		System.out.println("beforeclass");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("beforemethod");
	}
	@Test
	public void test1() {
		System.out.println("test1");
		Assert.fail();
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@Test
	public void test3() {
		System.out.println("test3");
	}
	@Test
	public void test4() {
		System.out.println("test4");
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("afterclass");
	}
}


