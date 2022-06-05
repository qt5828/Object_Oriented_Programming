import java.util.*;

public class CardGame {
	static int[] Card=new int[52]; //카드정보를 저장할 배열
	static int[] amount= {80,80}; //playerA와 playerB의 잔액을 저장(초기금액은 모두 80으로 설정)
	static int[] nowcard=new int[2]; //playerA와 playerB가 현재 가지고 있는 카드정보를 저장
	static String[] Suit=new String[2]; //playerA와 playerB가 현재 가지고 있는 카드의 suit정보 저장
	static String[] Rank=new String[2]; //playerA와 playerB가 현재 가지고 있는 카드의 rank정보 저장
	static String rank; //카드의 rank정보를 문자열로 저장하기 위함
	static String suit; //카드의 suit정보를 문자열로 저장하기 위함
	static char win; //승자의 정보
	static int bet=10; //베팅금액,10으로 설정
	static int count=0; //한번 사용한 카드는 사용하지 않도록 하기위해 생성
	static int round=1; //게임의 round를 세는 변수
	static int i; //반복문을 위한 변수
	static int r; //랜덤넘버생성을 위한변수
	static int temp; //임시로 값을 저장하기 위한 변수

	public static void main(String[] args) {
		
		System.out.println("Let's start CARD GAME!");
		System.out.println("Player A: $"+amount[0]+",\tPlayer B: $"+amount[1]+", Bet Amount: $"+bet+"\n");
		
		//카드 초기화
		initialize();
		//카드섞기
		shuffle();
		
		//playerA와 playerB의 잔고가 베팅금액보다 적을때까지 게임을 진행
		while((amount[0]>=bet)&&(amount[1]>=bet)) {
			System.out.println("Round"+round);
			
			//섞인 카드덱을 중복되지 않도록 앞에서 하나씩 나누어준다.
			//카드덱을 다 사용하면 게임이 중단된다.
			dealCards(count);
			count++;
			count++;
			
			//승자를 결정
			decideWinner();
			//결과를 출력
			printResults();
			round++;
			
			//카드덱을 모두 사용하면 게임 종료
			if (count==52) {
				System.out.println("카드덱이 모두 사용되어 게임을 종료합니다.\n");
				break;
			}
		}
		if (count!=52)
			System.out.println("잔고가 베팅금액보다 적어서 게임을 종료합니다.\n");
		//게임이 끝난 후, 사용자 정보를 출력
		printPlayers();
	}
	
	//카드를 초기화
	public static void initialize() {
		//0~12:Club,13~25:Heart,26~38:Diamond,39~51:Spade
		for(i=0;i<52;i++)
		{
			Card[i]=i;
		}

	}
	
	//카드를 랜덤하게 섞음
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
	
	//playerA와 playerB에게 카드를 하나씩 줌
	//사용한 카드는 재사용하지 않는다.
	public static void dealCards(int count) {
		nowcard[0]=Card[count];
		nowcard[1]=Card[count+1];
	}
	
	//승자를 결정
	public static void decideWinner() {
		//카드숫자비교
		if((nowcard[0]%13)<(nowcard[1]%13))
			win='B';
		else if((nowcard[0]%13)>(nowcard[1]%13))
			win='A';
		else {
			//카드문양비교
			if (nowcard[0]<nowcard[1])
				win='B';
			else if (nowcard[0]>nowcard[1])
				win='A';
		}
		
		//승자에 따라 playerA와 playerB의 잔액을 바꾸어줌
		if (win=='A') {
			amount[0]+=bet;
			amount[1]-=bet;
		}
		else {
			amount[0]-=bet;
			amount[1]+=bet;
		}
		
		//playerA와 playerB가 가지고 있는 카드의 suit정보와 rank의 정보를 문자열형태로 저장
		strcard(nowcard[0]);
		Suit[0]=suit;
		Rank[0]=rank;
		strcard(nowcard[1]);
		Suit[1]=suit;
		Rank[1]=rank;
		
	}
	
	//주어진 카드의 suit정보와 rank정보를 문자열형태로 반환
	public static void strcard(int n) {
		//카드rank 결정 및 string으로 변환
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
		
		//카드suit 결정 및 string변환
		if ((n>=0)&&(n<=12))
			suit="Club";
		else if ((n>=13)&&(n<=25))
			suit="Heart";
		else if ((n>=26)&&(n<=38))
			suit="Diamond";
		else if ((n>=39)&&(n<=51))
			suit="Spade";

	}
	
	//게임의 결과를 출력
	public static void printResults() {
		System.out.println("Player A: "+Rank[0]+" of "+Suit[0]+", Player B: "+Rank[1]+" of "+Suit[1]);
		if (win=='A')
			System.out.println("Player A won $"+bet+"\n");
		else
			System.out.println("Player B won $"+bet+"\n");
	}
	
	//게임종료 후, playerA와 playerB의 정보를 출력
	public static void printPlayers() {
		System.out.println("Player A has $"+ amount[0]);
		System.out.println("Player B has $"+ amount[1]);
	}
}

