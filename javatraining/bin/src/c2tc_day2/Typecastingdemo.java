package c2tc_day2;

public class Typecastingdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Type Casting Example
		
				//Wideining - Implicilt type casting
				
				byte b = 10;
				int i = b;
				System.out.println(i);
				System.out.println(b);
				
				
				float f = 22.14f;
				double d = f;
				System.out.println(d);
				
				
				//Narrowing - Explicit Type Casting
				
				double d1 = 10.52f;
				long l = (long) d1;
				System.out.println(l);
				
				
				float f2 = 43.45f;
				int i2 = (int)f2;
				
				System.out.println(i2);


	}

}
