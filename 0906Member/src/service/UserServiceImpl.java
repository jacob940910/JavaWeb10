package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.TMember;

public class UserServiceImpl implements UserService {
	//외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설정
	private UserDao userDao;
	
	private UserServiceImpl() {
		userDao = UserDaoImpl.sharedInstance();
	}
	
	//인스턴스 1개의 주소를 저장할 수 있는 변수를 생성
	private static UserService userService;
	
	//외부에서 인스턴스를 사용할 수 있도록 public으로 
	//인스턴스의 주소를 리턴해주는 메소드
	public static UserService sharedInstance() {
		//처음 한 번만 인스턴스를 생성하도록 해주는 코드
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
	
	@Override
	public TMember login(HttpServletRequest request) {
		//파라미터 전부 읽기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		//이 메시지가 안나오는 경우는 Controller의
		//URL을 확인 해보고 메소드 이름을 확인해야 합니다.
		//파라미터가 잘못나오는 경우는 jsp 파일의 name과 
		//getParameter의 이름을 확인
		//System.out.println("email:" + email);
		//System.out.println("pw:" + pw);
		
		//수행할 연산이 있으면 연산을 수행
		
		//호출할 Dao 메소드의 매개변수를 생성 
		TMember member = new TMember();
		member.setEmail(email);
		member.setPw(pw);
		
		//Dao 메소드 호출
		TMember user = userDao.login(member);
		
		//결과 리턴
		return user;
	}

	@Override
	public boolean registerMember(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터를 읽기
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		//Dao 메소드의 파라미터 만들기
		TMember member = new TMember();
		member.setEmail(email);
		member.setPw(pw);
		member.setName(name);
		member.setPhone(phone);
		member.setAddr(addr);
		
		//Dao 메소드 호출
		result = userDao.registerMember(member);

		return false;
	}

	@Override
	public boolean emailCheck(HttpServletRequest request) {
		//파라미터 읽어오기 
		String email = request.getParameter("email");
		//Dao의 메소드 호출
		boolean result = userDao.emailCheck(email);
		return false;
	}
}
