import java.util.Scanner;

public class ParkingProgram {
	public static void main(String[] args) {
		
		int ans=0; //���
		Scanner sc = new Scanner(System.in);
		
		ParkingLot.Init();
		
		//����ڰ� ���α׷� ���Ḧ �����Ҷ����� �ݺ�
		while(ans!=5)
		{
			System.out.println("���ϴ� ����� �����ϼ���!\n1. ����\n2. ����\n3. �������� ����\n4. �� ���� ����\n5. ����");
			ans=sc.nextInt();
			
			//����
			if(ans==1)
			{
				ParkingLot.In();
			}
			//����
			else if(ans==2)
			{
				ParkingLot.Out();
			}
			//������������
			else if(ans==3)
			{
				ParkingLot.parkingList();
			}
			//�Ѽ��Ժ���
			else if(ans==4)
			{
				ParkingLot.AllCost();
			}
			//���α׷� ����
			else if(ans==5)
			{
				System.out.println("���α׷��� �����մϴ�.\n");
			}
			//�޴���ȣ �����˻�
			else
				System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�. 1-5�� ������ �޴��� ������ �ּ���.");
		}

	}
	
}
