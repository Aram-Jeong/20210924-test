package co.micol.prj.fortest;

public class ForTest {
	private int m;
	private int n;

	public ForTest(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public void getSum() {
		int max;
		int min;

		if (n > m) {
			max = n;
			min = m;
		} else {
			max = m;
			min = n;
		}
		int sum = 0;
		for (int i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println("n부터 m까지의 합: "+sum);

	}
	public void run() {
		getSum();
	}

}
