package test;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.TMember;

public class Main {
	@Test
	public void sampleTest() {
		UserDao userDao = UserDaoImpl.sharedInstance();
		TMember member = new TMember();
		member.setEmail("ggangpae1@gmail.com");
		member.setPw("12345678");
		member.setName("박문석");
		member.setPhone("01037901997");
		member.setAddr("서울시 양천구 목동");
		boolean r = userDao.registerMember(member);
		System.out.println(r);
	}
}
