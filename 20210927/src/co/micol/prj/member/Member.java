package co.micol.prj.member;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String address;

	public Member(String id, String pw, String name, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
	}

	private void memberPrint() { // 정보은폐
		System.out.print("아이디: " + id + " | ");
		System.out.print("비밀번호: " + pw + " | ");
		System.out.print("이 름: " + name + " | ");
		System.out.println("주 소: " + address + " ");
	}
	
	public void run() {
		memberPrint();
	}
}
