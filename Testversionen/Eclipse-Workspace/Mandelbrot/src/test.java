
public class test {
double x1;
double x2;
double y1;
double y2;
double ab;
double a;
int t = 0;
double zn;
ComplexNumber zn1  = new ComplexNumber(0, 0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test h =  new test();
		h.te();
	}

	public void looptest() {
		for(int i   = 0; i != 11; i++) {
			System.out.println(i);
		}
	}

	/*public void ctest(double x1, double y1, int t){

		x2 = Math.pow(x1, 2) - Math.pow(y1, 2) + x1;
		y2 = 2 * x1 * y1 + y1;
		ab =  Math.pow(x2, 2) + Math.pow(y2, 2);
		a = Math.sqrt(ab);
		System.out.println(a);
		t++;

		if(t != 10) {
			ctest(x2, y2, t);
		}
		*/
		/*
		x1 = x2;
		y1 = y2;

		x2 = Math.pow(x1, 2) - Math.pow(y1, 2) + x1;
		y2 = 2 * x1 * y1 + y1;
		ab =  Math.pow(x2, 2) + Math.pow(y2, 2);
		a = Math.sqrt(ab);
		System.out.println(a);
		i++;*/


	//}

	public void ttest(double re, double im) {
		ComplexNumber c1 = new ComplexNumber(re, im);
		ComplexNumber zn = ComplexNumber.add(zn1, c1);

	}
	public void te() {
		double x = -0.4;
		double y = 0.7;

		double zReal = 0;
		double zImaginary = 0;
		int iteration = 0;
		int maxIteration = 20;
		double cReal = x;
		double cImaginary = y;
		while(iteration < maxIteration) {
				double temp = zReal * zReal - zImaginary * zImaginary + cReal;
				zImaginary = 2 * zReal * zImaginary * cImaginary;
				zReal = temp;
				double z = Math.sqrt(zReal * zReal + zImaginary * zImaginary);
				System.out.println(iteration + "     " + z);
				iteration++;

		}
	}
}
