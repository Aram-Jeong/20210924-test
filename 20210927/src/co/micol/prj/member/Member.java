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

	private void memberPrint() { // ��������
		System.out.print("���̵�: " + id + " | ");
		System.out.print("��й�ȣ: " + pw + " | ");
		System.out.print("�� ��: " + name + " | ");
		System.out.println("�� ��: " + address + " ");
	}
	
	public void run() {
		memberPrint();
	}
}
