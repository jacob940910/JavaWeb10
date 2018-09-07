package test;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;

public class TestCase {
 	@Test
 	public void sampleTest() {
 		UserDao userDao = UserDaoImpl.sharedInstance();
 		System.out.println(userDao.emailCheck(
 			"ggangpae5@gmail.com"));
 	}
}