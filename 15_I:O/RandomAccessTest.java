package lab_B_15_201921195;
import java.io.*;
import java.util.*;
import java.time.*;

public class RandomAccessTest {
	
	public static void main(String[] args) throws IOException{
		Employee[] staff= new Employee[3];
		staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))){
			for(Employee e : staff)
				writeData(out,e);
		}
		try(RandomAccessFile in = new RandomAccessFile("employee.dat","r")){
			int n = (int)(in.length()/Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			for(int i=n-1;i>=0;i--) {
				in.seek(i*Employee.RECORD_SIZE);
				newStaff[i]=readData(in);
			}
			for(Employee e : newStaff)
				System.out.println(e);
		}
		
		System.out.printf("\n");
		
		//Harry Hacker의 연봉 10% 인상
		staff[1].raiseSalary(10);
		RandomAccessFile in2 = new RandomAccessFile("employee.dat","rw"); //덮어쓰기 위함
		//Harry Hacker의 위치 찾음
		in2.seek(1*Employee.RECORD_SIZE);
		writeData(in2,staff[1]); //변경된 연봉 반영하여 덮어쓰기
		
		//읽어들이기
		int n = (int)(in2.length()/Employee.RECORD_SIZE);
		Employee[] newStaff = new Employee[n];
		for(int i=n-1;i>=0;i--) {
			in2.seek(i*Employee.RECORD_SIZE);
			newStaff[i]=readData(in2);
		}
		//인상된 연봉이 반영된 employee출력
		for(Employee e : newStaff)
			System.out.println(e);
		in2.close();

		
	}
	public static void writeData(DataOutput out, Employee e) throws IOException{
		DataIO.writeFixedString(e.getName(),Employee.NAME_SIZE,out);
		out.writeDouble(e.getSalary());
		LocalDate hireDay = e.getHireDay();
		out.writeInt(hireDay.getYear());
		out.writeInt(hireDay.getMonthValue());
		out.writeInt(hireDay.getDayOfMonth());
	}
	public static Employee readData(DataInput in)throws IOException{
		String name = DataIO.readFixedString(Employee.NAME_SIZE,in);
		double salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		return new Employee(name,salary,y,m,d);
	}

}
