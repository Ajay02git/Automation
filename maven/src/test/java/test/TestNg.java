package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg {

	@BeforeClass
	public void beforeclass() {
		System.out.println("beforeclass");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("beforemethod");
	}
	@Test
	public void testA() {
		System.out.println("testA");
		Assert.fail();
	}
	@Test
	public void testB() {
		System.out.println("testB");
	}
	@Test
	public void testC() {
		System.out.println("testC");
	}
	@Test
	public void testD() {
		System.out.println("testD");
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
