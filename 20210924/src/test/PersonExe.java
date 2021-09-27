package test;
import test.ScanUtil;

/*
 * ���� ���
 * �̸� ������ ��ȸ
 * ����: �迭�� �ּҰ�����
 * ����: �迭�� �ε���������
 */
public class PersonExe {

	private static PersonExe singleton = new PersonExe();
	private Person[] persons;

	private PersonExe() {

		persons = new Person[100];
		persons[0] = new Person("�谡��", Gender.WOMEN, "010-1234-5678");
		persons[1] = new Person("�ڳ���", Gender.MEN, "010-1111-5678");
		persons[2] = new Person("���ٺ�", Gender.WOMEN, "010-1234-2222");
		persons[3] = new Worker("�Ѷ��", Gender.WOMEN, "010-1111-2222", "����");
		persons[4] = new Worker("������", Gender.MEN, "010-3333-5678", "�¿վƳʽ�");
		persons[5] = new Student("�չٺ�", Gender.MEN, "010-1234-7777", "��ϴ��б�");
		persons[6] = new Student("�Ż��", Gender.MEN, "010-7777-4321", "�����б�");
	}

	public static PersonExe getInstance() {
		return singleton;

	}

	public void execute() {
		while (true) {
			System.out.println("1.��� | 2.��ȸ | 3. ���� | 4. ���� | 5.����");
			int menu = ScanUtil.readInt("�޴��� �����ϼ���.");

			if (menu == 1) {
				System.out.println("���");
				addPerson();
			} else if (menu == 2) {
				System.out.println("��ȸ");
				showList();
			} else if (menu == 3) {
				System.out.println("����");
				modify();
			} else if (menu == 4) {
				System.out.println("����");
				delete();
			} else if (menu == 5) {
				System.out.println("�����մϴ�.");
				break;
			}
		}
		System.out.println("��.");
	}

	private void addPerson() {
		System.out.println("1.Person | 2.Student | 3.Worker");
		int choice = ScanUtil.readInt("�߰��� ���� ���� >>");
		String name = ScanUtil.readStr("�̸� �Է�");
		Gender gender = ScanUtil.readGender("���� �Է�. [���� | ����]");
		
		String phone = ScanUtil.readStr("����ó �Է�");
		Person person = null;
		if (choice == 1) {
			person = new Person(name, gender, phone);
		} else if (choice == 2) {
			String school = ScanUtil.readStr("�б� �Է�");
			person = new Student(name, gender, phone, school);
		} else if (choice == 3) {
			String company = ScanUtil.readStr("ȸ�� �Է�");
			person = new Worker(name, gender, phone, company);
		}

		for (int i = 0; i < persons.length; i++) {
			if (persons[i] == null) {
				persons[i] = person;
				break;
			}
		}
		System.out.println("��� ����");
	}

	private void showList() {
		String name = ScanUtil.readStr("��ȸ�� ����� �̸��� �Է��ϼ���.");
		Gender gender = ScanUtil.readGender("���� ���� >> 1.���� | 2.����");
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
		System.out.println("[���]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null)
				System.out.println("[" + i + "]" + persons[i].toString());
		}
		int num = ScanUtil.readInt("������ ������ �����ϼ���.");
		Gender gender = ScanUtil.readGender("������ ������ �Է��ϼ���.");
		if (!gender.equals(""))
			persons[num].setGender(gender);
		String phone = ScanUtil.readStr("������ ����ó�� �Է��ϼ���.");
		if (!phone.equals(""))
			persons[num].setPhone(phone);
		if (persons[num] instanceof Student) {
			String school = ScanUtil.readStr("������ �б��� �Է��ϼ���");
			if (!school.equals(""))
				((Student) persons[num]).setSchool(school);
		} else if (persons[num] instanceof Worker) {
			String company = ScanUtil.readStr("������ ȸ�縦 �Է��ϼ���");
			if (!company.equals(""))
				((Worker) persons[num]).setCompany(company);

		}
		System.out.println("�����Ϸ�");
	}
	
	private void delete() {
		System.out.println("[���]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null)
				System.out.println("[" + i + "]" + persons[i].toString());
		}
		int num = ScanUtil.readInt("������ ��� �����ϼ���.");

		if (persons[num] != null) {
			persons[num] = null;
			System.out.println("���� �Ϸ�.");

		} else {
			System.out.println("������ ������ �����ϴ�.");
		}
	
	}

}
