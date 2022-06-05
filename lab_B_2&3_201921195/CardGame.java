import java.util.*;

public class CardGame {
	static int[] Card=new int[52]; //ī�������� ������ �迭
	static int[] amount= {80,80}; //playerA�� playerB�� �ܾ��� ����(�ʱ�ݾ��� ��� 80���� ����)
	static int[] nowcard=new int[2]; //playerA�� playerB�� ���� ������ �ִ� ī�������� ����
	static String[] Suit=new String[2]; //playerA�� playerB�� ���� ������ �ִ� ī���� suit���� ����
	static String[] Rank=new String[2]; //playerA�� playerB�� ���� ������ �ִ� ī���� rank���� ����
	static String rank; //ī���� rank������ ���ڿ��� �����ϱ� ����
	static String suit; //ī���� suit������ ���ڿ��� �����ϱ� ����
	static char win; //������ ����
	static int bet=10; //���ñݾ�,10���� ����
	static int count=0; //�ѹ� ����� ī��� ������� �ʵ��� �ϱ����� ����
	static int round=1; //������ round�� ���� ����
	static int i; //�ݺ����� ���� ����
	static int r; //�����ѹ������� ���Ѻ���
	static int temp; //�ӽ÷� ���� �����ϱ� ���� ����

	public static void main(String[] args) {
		
		System.out.println("Let's start CARD GAME!");
		System.out.println("Player A: $"+amount[0]+",\tPlayer B: $"+amount[1]+", Bet Amount: $"+bet+"\n");
		
		//ī�� �ʱ�ȭ
		initialize();
		//ī�弯��
		shuffle();
		
		//playerA�� playerB�� �ܰ� ���ñݾ׺��� ���������� ������ ����
		while((amount[0]>=bet)&&(amount[1]>=bet)) {
			System.out.println("Round"+round);
			
			//���� ī�嵦�� �ߺ����� �ʵ��� �տ��� �ϳ��� �������ش�.
			//ī�嵦�� �� ����ϸ� ������ �ߴܵȴ�.
			dealCards(count);
			count++;
			count++;
			
			//���ڸ� ����
			decideWinner();
			//����� ���
			printResults();
			round++;
			
			//ī�嵦�� ��� ����ϸ� ���� ����
			if (count==52) {
				System.out.println("ī�嵦�� ��� ���Ǿ� ������ �����մϴ�.\n");
				break;
			}
		}
		if (count!=52)
			System.out.println("�ܰ� ���ñݾ׺��� ��� ������ �����մϴ�.\n");
		//������ ���� ��, ����� ������ ���
		printPlayers();
	}
	
	//ī�带 �ʱ�ȭ
	public static void initialize() {
		//0~12:Club,13~25:Heart,26~38:Diamond,39~51:Spade
		for(i=0;i<52;i++)
		{
			Card[i]=i;
		}

	}
	
	//ī�带 �����ϰ� ����
	public static void shuffle() {
		r=0;
		temp=0;
		
		for(i=0; i<52 ; i++) {
			r = (int)(Math.random()*52);
			temp = Card[i];
			Card[i] = Card[r];
			Card[r] = temp;
		}
	}
	
	//playerA�� playerB���� ī�带 �ϳ��� ��
	//����� ī��� �������� �ʴ´�.
	public static void dealCards(int count) {
		nowcard[0]=Card[count];
		nowcard[1]=Card[count+1];
	}
	
	//���ڸ� ����
	public static void decideWinner() {
		//ī����ں�
		if((nowcard[0]%13)<(nowcard[1]%13))
			win='B';
		else if((nowcard[0]%13)>(nowcard[1]%13))
			win='A';
		else {
			//ī�幮���
			if (nowcard[0]<nowcard[1])
				win='B';
			else if (nowcard[0]>nowcard[1])
				win='A';
		}
		
		//���ڿ� ���� playerA�� playerB�� �ܾ��� �ٲپ���
		if (win=='A') {
			amount[0]+=bet;
			amount[1]-=bet;
		}
		else {
			amount[0]-=bet;
			amount[1]+=bet;
		}
		
		//playerA�� playerB�� ������ �ִ� ī���� suit������ rank�� ������ ���ڿ����·� ����
		strcard(nowcard[0]);
		Suit[0]=suit;
		Rank[0]=rank;
		strcard(nowcard[1]);
		Suit[1]=suit;
		Rank[1]=rank;
		
	}
	
	//�־��� ī���� suit������ rank������ ���ڿ����·� ��ȯ
	public static void strcard(int n) {
		//ī��rank ���� �� string���� ��ȯ
		switch (n%13) {
		case 0 :
			rank="2";
			break;
		case 1 :
			rank="3";
			break;
		case 2 :
			rank="4";
			break;
		case 3 :
			rank="5";
			break;
		case 4 :
			rank="6";
			break;
		case 5 :
			rank="7";
			break;
		case 6 :
			rank="8";
			break;
		case 7 :
			rank="9";
			break;
		case 8 :
			rank="10";
			break;
		case 9 :
			rank="Jack";
			break;
		case 10 :
			rank="Queen";
			break;
		case 11 :
			rank="King";
			break;
		case 12 :
			rank="Ace";
			break;	
		}
		
		//ī��suit ���� �� string��ȯ
		if ((n>=0)&&(n<=12))
			suit="Club";
		else if ((n>=13)&&(n<=25))
			suit="Heart";
		else if ((n>=26)&&(n<=38))
			suit="Diamond";
		else if ((n>=39)&&(n<=51))
			suit="Spade";

	}
	
	//������ ����� ���
	public static void printResults() {
		System.out.println("Player A: "+Rank[0]+" of "+Suit[0]+", Player B: "+Rank[1]+" of "+Suit[1]);
		if (win=='A')
			System.out.println("Player A won $"+bet+"\n");
		else
			System.out.println("Player B won $"+bet+"\n");
	}
	
	//�������� ��, playerA�� playerB�� ������ ���
	public static void printPlayers() {
		System.out.println("Player A has $"+ amount[0]);
		System.out.println("Player B has $"+ amount[1]);
	}
}

