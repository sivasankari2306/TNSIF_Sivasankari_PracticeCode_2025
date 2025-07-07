package c2tc_oopsday3;

public class EncapsulationDemo {

	

		//CSK Team
		//data members

		int age;
		String name;
		int jersyNo;
		
		
		//Getter and Setter Method
		
		public int getAge()
		{
			return age;
		}
		
		public void setAge(int age)
		{
			this.age = age;
		}
		
		
		public String getName()
		{
			return name;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public int getJersyNo()
		{
			return jersyNo;
		}
		
		public void setJersyNo(int jersyNo)
		{
			this.jersyNo = jersyNo;
		}

		@Override
		public String toString() {
			return "EncapsulationDemo [Age=" + age + ", Name=" + name + ", JersyNo=" + jersyNo + "]";
		}

	

}
