import java.util.Scanner;

public class ParkingLot {
	private static int size = 100; //주차 최대 차량 수
	public static Car[] Cars = new Car[size]; //배열형태의 주차장
	public static int count=0; //주차장에 있는 차량수
	public static int COST=0; //총수입
	
	public static void Init() {
		for(int i=0;i<size;i++) {
			Cars[i] = new Car();
		}
	}
	
	//입차
	public static void In() {
		//주차장이 찼는지 확인
		if (count>size) {
			System.out.printf("주차장이 꽉 찼습니다.\n)");
			return;
		}
		count++;
		String name;	int n; //차량종류, 용량
		int num; //차량번호
		Time in; int y; int m; int d; int h; int mm; //입차시간정보
		boolean TF;
		Scanner sc = new Scanner(System.in);
		
		//차량종류 검사
		while(true) {
			System.out.println("차량 종류 및 용량을 입력하세요! 승용자(c), 트럭(t), 버스(b)");
			name=sc.next();
			n=sc.nextInt();
			
			if(name.equals("c")) {
				if(n<0) 
					System.out.println("전기차의 배터리 잔량은 0보다 작을 수 없습니다.\n");
				//최대배터리양을 넘었을때
				else if(n>60)
					System.out.println("전기차의 최대 배터리 양은 60입니다.\n");
				else
					break;
			}
			else if(name.equals("t")) {
				if(n<0) 
					System.out.println("트럭의 중량은 0보다 커야합니다.\n");
				//터무니없이 큰 n값을 입력할 수 있으므로 최대 20으로 제한
				else if(n>20)
					System.out.println("출입가능한 트럭의 최대중량은 20입니다.\n");
				else
					break;
			}
			else if(name.equals("b")) {
				if(n<0) 
					System.out.println("버스의 승객 수는 0보다 커야합니다.\n");
				//터무니없이 큰 n값을 입력할 수 있으므로 최대 60으로 제한
				else if(n>60)
					System.out.println("출입가능한 버스의 최대 승객수는 60명입니다.\n");
				else
					break;
			}
			else
				System.out.println("존재하지 않는 차량 종류를 입력하였습니다.\n");
		}

		System.out.println("차량 번호를 입력하세요! (4자리 숫자)");
		num=sc.nextInt();

		
		System.out.println("입차시간을 입력하세요! (년 월 일 시 분)");
		y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
		TF=Time.isValid(y, m, d, h, mm);
		
		//입력받은 시간에 대한 유효성 체크
		while(!TF) {
			System.out.println("잘못된 시간(존재하지 않는 시간or날짜)을 입력하였습니다. 올바른 시간을 입력해 주세요.");
			System.out.println("입차시간을 입력하세요! (년 월 일 시 분)");
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
	
	//출차
	public static void Out() {
		count--;
		int num, cost=0, min=0;
		boolean TF, TF2;
		int y; int m; int d; int h; int mm;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("출차할 차량번호를 입력하세요!");
		num = sc.nextInt();
		
		//출차차량번호가 차량목록에 존재하는지 체크
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
			System.out.println("존재하지 않는 차량번호입니다.");
			System.out.println("출차할 차량번호를 입력하세요!");
			num = sc.nextInt();
		}
		
		System.out.println("출차시간을 입력하세요!");
		y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
		TF=Time.isValid(y, m, d, h, mm);
		
		//입력받은 시간에 대한 유효성 체크
		while(!TF) {
			System.out.println("잘못된 시간(존재하지 않는 시간or날짜)을 입력하였습니다. 올바른 시간을 입력해 주세요.");
			System.out.println("출차시간을 입력하세요! (년 월 일 시 분)");
			y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
			TF=Time.isValid(y, m, d, h, mm);
		}
		
		for(Car car : Cars)
		{
			if(car.getNum() == num) {
				car.outNow();
				car.setOut(y,m,d,h,mm);
				
				//입차시간과 출차시간에 대한 유효성 체크
				TF2=Time.isValid2(car.getIn(), car.getOut());///////////////////////////////////////////////////////???????
				while(!TF2) {
					System.out.println("출차시간이 입차시간보다 빠릅니다. 올바른 출차시간을 입력해 주세요.");
					System.out.println("출차시간을 입력하세요! (년 월 일 시 분)");
					y=sc.nextInt(); m=sc.nextInt(); d=sc.nextInt(); h=sc.nextInt(); mm=sc.nextInt();
					car.setOut(y,m,d,h,mm);
					TF2=Time.isValid2(car.getIn(), car.getOut());
					
					//새로 입력받은 시간에 대한 유효성 체크
					TF=Time.isValid(y, m, d, h, mm);
					while(!TF) {
						System.out.println("잘못된 시간(존재하지 않는 시간or날짜)을 입력하였습니다. 올바른 시간을 입력해 주세요.");
						System.out.println("출차시간을 입력하세요! (년 월 일 시 분)");
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
		System.out.printf("주차시간은 %d시간 %d분입니다.\n", min/60, min%60);
		System.out.printf("주차요금은 %,d원입니다.\n\n", cost);
	}
	
	//주차차량보기
	public static void parkingList() {
		if (count==0) {
			System.out.println("주차된 차량이 없습니다.\n");
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
			
		//Cars에 들어있는 차량 정보를 각각 차량 종류에 따라 분류해서 배열에 저장
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
		
		//입차시간 순서별로 sorting, bubble sort algorithm 사용
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
		
		//출력
		for(i=0;normal[i].getNow();i++)
			System.out.printf("승용차 %04d %04d/%02d/%02d %02d:%02d\n",normal[i].getNum(),normal[i].getIn().getYear(),normal[i].getIn().getMonth(),normal[i].getIn().getDay(),normal[i].getIn().getHour(),normal[i].getIn().getMin());
		for(i=0;bus[i].getNow();i++)
			System.out.printf("버스 %04d %04d/%02d/%02d %02d:%02d\n",bus[i].getNum(),bus[i].getIn().getYear(),bus[i].getIn().getMonth(),bus[i].getIn().getDay(),bus[i].getIn().getHour(),bus[i].getIn().getMin());
		for(i=0;truck[i].getNow();i++)
			System.out.printf("트럭 %04d %04d/%02d/%02d %02d:%02d\n",truck[i].getNum(),truck[i].getIn().getYear(),truck[i].getIn().getMonth(),truck[i].getIn().getDay(),truck[i].getIn().getHour(),truck[i].getIn().getMin());
	
		
		System.out.println();
	}
	
	//총 수입 보기
	public static void AllCost() {
		System.out.printf("총 수입은 %,d원 입니다.\n", COST);
	}
	
	//입차시간을 비교하는 method
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
	
	//주차장의 빈자리 체크
	public static int check() {
		for(int i=0;i<size;i++) {
			if(!Cars[i].getNow())
				return i;
		}
		return -1;
	}
}
