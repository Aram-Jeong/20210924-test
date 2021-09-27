package test;
import test.ScanUtil;

/*
 * 각각 등록
 * 이름 성별로 조회
 * 수정: 배열의 주소값으로
 * 삭제: 배열의 인덱스값으로
 */
public class PersonExe {

	private static PersonExe singleton = new PersonExe();
	private Person[] persons;

	private PersonExe() {

		persons = new Person[100];
		persons[0] = new Person("김가봉", Gender.WOMEN, "010-1234-5678");
		persons[1] = new Person("박나봉", Gender.MEN, "010-1111-5678");
		persons[2] = new Person("도다봉", Gender.WOMEN, "010-1234-2222");
		persons[3] = new Worker("한라봉", Gender.WOMEN, "010-1111-2222", "예담");
		persons[4] = new Worker("윤마봉", Gender.MEN, "010-3333-5678", "태왕아너스");
		persons[5] = new Student("왕바봉", Gender.MEN, "010-1234-7777", "경북대학교");
		persons[6] = new Student("신사봉", Gender.MEN, "010-7777-4321", "계명대학교");
	}

	public static PersonExe getInstance() {
		return singleton;

	}

	public void execute() {
		while (true) {
			System.out.println("1.등록 | 2.조회 | 3. 수정 | 4. 삭제 | 5.종료");
			int menu = ScanUtil.readInt("메뉴를 선택하세요.");

			if (menu == 1) {
				System.out.println("등록");
				addPerson();
			} else if (menu == 2) {
				System.out.println("조회");
				showList();
			} else if (menu == 3) {
				System.out.println("수정");
				modify();
			} else if (menu == 4) {
				System.out.println("삭제");
				delete();
			} else if (menu == 5) {
				System.out.println("종료합니다.");
				break;
			}
		}
		System.out.println("끝.");
	}

	private void addPerson() {
		System.out.println("1.Person | 2.Student | 3.Worker");
		int choice = ScanUtil.readInt("추가할 유형 선택 >>");
		String name = ScanUtil.readStr("이름 입력");
		Gender gender = ScanUtil.readGender("성별 입력. [남자 | 여자]");
		
		String phone = ScanUtil.readStr("연락처 입력");
		Person person = null;
		if (choice == 1) {
			person = new Person(name, gender, phone);
		} else if (choice == 2) {
			String school = ScanUtil.readStr("학교 입력");
			person = new Student(name, gender, phone, school);
		} else if (choice == 3) {
			String company = ScanUtil.readStr("회사 입력");
			person = new Worker(name, gender, phone, company);
		}

		for (int i = 0; i < persons.length; i++) {
			if (persons[i] == null) {
				persons[i] = person;
				break;
			}
		}
		System.out.println("등록 성공");
	}

	private void showList() {
		String name = ScanUtil.readStr("조회할 사람의 이름을 입력하세요.");
		Gender gender = ScanUtil.readGender("성별 선택 >> 1.여자 | 2.남자");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				if (!name.equals("") && !gender.equals("")) {
					if (persons[i].getName().indexOf(name) != -1 && persons[i].getGender().compareTo(gender) != -1) {
						System.out.println(persons[i].toString());
					}
				} else if (!gender.equals("")) {
					if (persons[i].getGender().compareTo(gender) != -1) {
						System.out.println(persons[i].toString());
					}
				} else if (!name.equals("")) {
					if (persons[i].getName().indexOf(name) != -1) {
						System.out.println(persons[i].toString());
					}
				} else {
					System.out.println(persons[i].toString());
				}
			}
		}
	}

	private void modify() {
		System.out.println("[명단]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null)
				System.out.println("[" + i + "]" + persons[i].toString());
		}
		int num = ScanUtil.readInt("수정할 정보를 선택하세요.");
		Gender gender = ScanUtil.readGender("수정할 성별을 입력하세요.");
		if (!gender.equals(""))
			persons[num].setGender(gender);
		String phone = ScanUtil.readStr("수정할 연락처를 입력하세요.");
		if (!phone.equals(""))
			persons[num].setPhone(phone);
		if (persons[num] instanceof Student) {
			String school = ScanUtil.readStr("수정할 학교를 입력하세요");
			if (!school.equals(""))
				((Student) persons[num]).setSchool(school);
		} else if (persons[num] instanceof Worker) {
			String company = ScanUtil.readStr("수정할 회사를 입력하세요");
			if (!company.equals(""))
				((Worker) persons[num]).setCompany(company);

		}
		System.out.println("수정완료");
	}
	
	private void delete() {
		System.out.println("[명단]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null)
				System.out.println("[" + i + "]" + persons[i].toString());
		}
		int num = ScanUtil.readInt("삭제할 사람 선택하세요.");

		if (persons[num] != null) {
			persons[num] = null;
			System.out.println("삭제 완료.");

		} else {
			System.out.println("삭제할 정보가 없습니다.");
		}
	
	}

}
