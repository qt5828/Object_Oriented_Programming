import java.util.Scanner;

public class ParkingLot {
	private static int size = 100; //���� �ִ� ���� ��
	public static Car[] Cars = new Car[size]; //�迭������ ������
	public static int count=0; //�����忡 �ִ� ������
	public static int COST=0; //�Ѽ���
	
	public static void Init() {
		for(int i=0;i<size;i++) {
			Cars[i] = new Car();
		}
	}
	
	//����
	public static void In() {
		//�������� á���� Ȯ��
		if (count>size) {
			System.out.printf("�������� �� á���ϴ�.\n)");
			return;
		}
		count++;
		String name;	int n; //��������, �뷮
		int num; //������ȣ
		Time in; int y; int m; int d; int h; int mm; //�����ð�����
		boolean TF;
		Scanner sc = new Scanner(System.in);
		
		//�������� �˻�
		while(true) {
			System.out.println("���� ���� �� �뷮�� �Է��ϼ���! �¿���(c), Ʈ��(t), ����(b)");
			name=sc.next();
			n=sc.nextInt();
			
			if(name.equals("c")) {
				if(n<0) 
					System.out.println("�������� ���͸� �ܷ��� 0���� ���� �� �����ϴ�.\n");
				//�ִ���͸����� �Ѿ�����
				else if(n>60)
					System.out.println("�������� �ִ� ���͸� ���� 60�Դϴ�.\n");
				else
					break;
			}
			else if(name.equals("t")) {
				if(n<0) 
					System.out.println("Ʈ���� �߷��� 0���� Ŀ���մϴ�.\n");
				//�͹��Ͼ��� ū n���� �Է��� �� �����Ƿ� �ִ� 20���� ����
				else if(n>20)
					System.out.println("���԰����� Ʈ���� �ִ��߷��� 20�Դϴ�.\n");
				else
					break;
			}
			else if(name.equals("b")) {
				if(n<0) 
					System.out.println("������ �°� ���� 0���� Ŀ���մϴ�.\n");
				//�͹��Ͼ��� ū n���� �Է��� �� �����Ƿ� �ִ� 60���� ����
				else if(n>60)
					System.out.println("���԰����� ������ �ִ� �°����� 60���Դϴ�.\n");
				else
					break;
			}
			else
				System.out.println("�������� �ʴ� ���� ������ �Է��Ͽ����ϴ�.\n");
		}

		System.out.println("���� ��ȣ�� �Է��ϼ���! (4�ڸ� ����)");
		num=sc.nextInt();

		
		System.out.println("�����ð��� �Է��ϼ���! (�� �� �� �� ��)");
		y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
		TF=Time.isValid(y, m, d, h, mm);
		
		//�Է¹��� �ð��� ���� ��ȿ�� üũ
		while(!TF) {
			System.out.println("�߸��� �ð�(�������� �ʴ� �ð�or��¥)�� �Է��Ͽ����ϴ�. �ùٸ� �ð��� �Է��� �ּ���.");
			System.out.println("�����ð��� �Է��ϼ���! (�� �� �� �� ��)");
			y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
			TF=Time.isValid(y, m, d, h, mm);
		}
		
		in = new Time(y,m,d,h,mm);
		
		int idx=check();
		
		if(name.equals("c")) {
			if(n==0)
				Cars[idx]=new Normal(num, in);
			else
				Cars[idx]=new Electric(num,in,n);
		}
		else if(name.equals("b")) {
			if(n>=40)
				Cars[idx]=new BusL(num,in);
			else if(n<40 && n>=24)
				Cars[idx]=new BusM(num,in);
			else
				Cars[idx]=new BusS(num,in);
		}
		else if(name.equals("t")){
			if(n>=10)
				Cars[idx]=new TruckL(num,in);
			else if(n<10 && n>=5)
				Cars[idx]=new TruckM(num,in);
			else
				Cars[idx]=new TruckS(num,in);
		}
	}
	
	//����
	public static void Out() {
		count--;
		int num, cost=0, min=0;
		boolean TF, TF2;
		int y; int m; int d; int h; int mm;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ ������ȣ�� �Է��ϼ���!");
		num = sc.nextInt();
		
		//����������ȣ�� ������Ͽ� �����ϴ��� üũ
		boolean Check=false;
		while(!Check) {
			int i=0;
			while(i<size) {
				if(Cars[i].getNow()==true && Cars[i].getNum()==num) {
					Check=true;
					break;
				}
				i++;
			}
			if(Check)
				break;
			System.out.println("�������� �ʴ� ������ȣ�Դϴ�.");
			System.out.println("������ ������ȣ�� �Է��ϼ���!");
			num = sc.nextInt();
		}
		
		System.out.println("�����ð��� �Է��ϼ���!");
		y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
		TF=Time.isValid(y, m, d, h, mm);
		
		//�Է¹��� �ð��� ���� ��ȿ�� üũ
		while(!TF) {
			System.out.println("�߸��� �ð�(�������� �ʴ� �ð�or��¥)�� �Է��Ͽ����ϴ�. �ùٸ� �ð��� �Է��� �ּ���.");
			System.out.println("�����ð��� �Է��ϼ���! (�� �� �� �� ��)");
			y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
			TF=Time.isValid(y, m, d, h, mm);
		}
		
		for(Car car : Cars)
		{
			if(car.getNum() == num) {
				car.outNow();
				car.setOut(y,m,d,h,mm);
				
				//�����ð��� �����ð��� ���� ��ȿ�� üũ
				TF2=Time.isValid2(car.getIn(), car.getOut());///////////////////////////////////////////////////////???????
				while(!TF2) {
					System.out.println("�����ð��� �����ð����� �����ϴ�. �ùٸ� �����ð��� �Է��� �ּ���.");
					System.out.println("�����ð��� �Է��ϼ���! (�� �� �� �� ��)");
					y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
					car.setOut(y,m,d,h,mm);
					TF2=Time.isValid2(car.getIn(), car.getOut());
					
					//���� �Է¹��� �ð��� ���� ��ȿ�� üũ
					TF=Time.isValid(y, m, d, h, mm);
					while(!TF) {
						System.out.println("�߸��� �ð�(�������� �ʴ� �ð�or��¥)�� �Է��Ͽ����ϴ�. �ùٸ� �ð��� �Է��� �ּ���.");
						System.out.println("�����ð��� �Է��ϼ���! (�� �� �� �� ��)");
						y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
						TF=Time.isValid(y, m, d, h, mm);
					}
				}
				
				cost=car.CalCost();
				min=car.getDuration();
				break;
				}
		}
		COST+=cost;
		System.out.printf("�����ð��� %d�ð� %d���Դϴ�.\n", min/60, min%60);
		System.out.printf("��������� %,d���Դϴ�.\n\n", cost);
	}
	
	//������������
	public static void parkingList() {
		if (count==0) {
			System.out.println("������ ������ �����ϴ�.\n");
			return;
		}
		
		int a=0,b=0,c=0;
		Bus[] bus = new Bus[size];
		Truck[] truck = new Truck[size];
		Normal[] normal = new Normal[size];
		
		for(int i=0;i<size;i++) {
			bus[i]=new Bus();
			truck[i]=new Truck();
			normal[i]=new Normal();
		}
			
		//Cars�� ����ִ� ���� ������ ���� ���� ������ ���� �з��ؼ� �迭�� ����
		for(Car car : Cars) {
			if(car.getNow()) {
				if(car instanceof Bus)
					bus[a++]=(Bus)car;
				if(car instanceof Truck)
					truck[b++]=(Truck)car;
				if(car instanceof Normal)
					normal[c++]=(Normal)car;
			}
		}
		
		//�����ð� �������� sorting, bubble sort algorithm ���
		int i,j;
		Car temp;
		for(i=0;bus[i].getNow();i++)
			for(j=0;bus[j+1].getNow();j++)
				if(compare(bus[j],bus[j+1])==1) {
					temp=bus[j]; bus[j]=bus[j+1]; bus[j+1]=(Bus)temp;
				}
		for(i=0;truck[i].getNow();i++)
			for(j=0;truck[j+1].getNow();j++)
				if(compare(truck[j],truck[j+1])==1) {
					temp=truck[j]; truck[j]=truck[j+1]; truck[j+1]=(Truck)temp;
				}
		for(i=0;normal[i].getNow();i++)
			for(j=0;normal[j+1].getNow();j++)
				if(compare(normal[j],normal[j+1])==1) {
					temp=normal[j]; normal[j]=normal[j+1]; normal[j+1]=(Normal)temp;
				}
		
		//���
		for(i=0;normal[i].getNow();i++)
			System.out.printf("�¿��� %04d %04d/%02d/%02d %02d:%02d\n",normal[i].getNum(),normal[i].getIn().getYear(),normal[i].getIn().getMonth(),normal[i].getIn().getDay(),normal[i].getIn().getHour(),normal[i].getIn().getMin());
		for(i=0;bus[i].getNow();i++)
			System.out.printf("���� %04d %04d/%02d/%02d %02d:%02d\n",bus[i].getNum(),bus[i].getIn().getYear(),bus[i].getIn().getMonth(),bus[i].getIn().getDay(),bus[i].getIn().getHour(),bus[i].getIn().getMin());
		for(i=0;truck[i].getNow();i++)
			System.out.printf("Ʈ�� %04d %04d/%02d/%02d %02d:%02d\n",truck[i].getNum(),truck[i].getIn().getYear(),truck[i].getIn().getMonth(),truck[i].getIn().getDay(),truck[i].getIn().getHour(),truck[i].getIn().getMin());
	
		
		System.out.println();
	}
	
	//�� ���� ����
	public static void AllCost() {
		System.out.printf("�� ������ %,d�� �Դϴ�.\n", COST);
	}
	
	//�����ð��� ���ϴ� method
	public static int compare(Car a, Car b) {
		if(a.getIn().getYear() > b.getIn().getYear())
			return 1;
		else if(a.getIn().getYear() < b.getIn().getYear())
			return -1;
		else {
			if(a.getIn().getMonth() > b.getIn().getMonth())
				return 1;
			else if(a.getIn().getMonth() < b.getIn().getMonth())
				return -1;
			else 
			{
				if(a.getIn().getDay() > b.getIn().getDay())
					return 1;
				else if(a.getIn().getDay() < b.getIn().getDay())
					return -1;
				else {
					if(a.getIn().getHour() > b.getIn().getHour())
						return 1;
					else if(a.getIn().getHour() < b.getIn().getHour())
						return -1;
					else {
						if(a.getIn().getMin() > b.getIn().getMin())
							return 1;
						else if(a.getIn().getMin() < b.getIn().getMin())
							return -1;
						else
							return 0;
					}
				}
			}
		}
	}
	
	//�������� ���ڸ� üũ
	public static int check() {
		for(int i=0;i<size;i++) {
			if(!Cars[i].getNow())
				return i;
		}
		return -1;
	}
}
