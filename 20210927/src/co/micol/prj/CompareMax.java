package co.micol.prj;

public class CompareMax { // �� Ŭ������ ����: ���� ���� �� ������ ū ���� �����Ѵ�.
	private int n;
	private int m;

	public CompareMax(int n, int m) { // ������
		this.n = n;
		this.m = m;

	}

	public int getMax() {
		int max = 0; // �� ���� ���� ������ 0�� �����Ѵ�.
		int n=1;
		int m=10;
		if (n > m) {
			max = n;
		} else if (n < m) {
			max = m;
		}
		return max;
	}
}
