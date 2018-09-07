package service;

import javax.servlet.http.HttpServletRequest;

import vo.TMember;

//비지니스 로직을 처리할 메소드를 선언할 인터페이스
//여기의 메소드는 클라이언트의 요청 당 1개로 매핑이 되어야 합니다.
public interface UserService {
	//로그인을 처리하는 메소드 
	public TMember login(HttpServletRequest request);
	
	public boolean registerMember(HttpServletRequest request);
	
	public boolean emailCheck(HttpServletRequest request);
}
