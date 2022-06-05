import java.util.Scanner;

public class ParkingProgram {
	public static void main(String[] args) {
		
		int ans=0; //대답
		Scanner sc = new Scanner(System.in);
		
		ParkingLot.Init();
		
		//사용자가 프로그램 종료를 선택할때까지 반복
		while(ans!=5)
		{
			System.out.println("원하는 기능을 선택하세요!\n1. 입차\n2. 출차\n3. 주차차량 보기\n4. 총 수입 보기\n5. 종료");
			ans=sc.nextInt();
			
			//입차
			if(ans==1)
			{
				ParkingLot.In();
			}
			//출차
			else if(ans==2)
			{
				ParkingLot.Out();
			}
			//주차차량보기
			else if(ans==3)
			{
				ParkingLot.parkingList();
			}
			//총수입보기
			else if(ans==4)
			{
				ParkingLot.AllCost();
			}
			//프로그램 종료
			else if(ans==5)
			{
				System.out.println("프로그램을 종료합니다.\n");
			}
			//메뉴번호 범위검사
			else
				System.out.println("잘못된 번호를 입력하였습니다. 1-5번 사이의 메뉴를 선택해 주세요.");
		}

	}
	
}
