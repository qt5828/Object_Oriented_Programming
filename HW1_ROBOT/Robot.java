
public class Robot {
	public Board board;
	private String name;
	public Pos pos;
	static int Count = 0;
	private static boolean TF=true;
	
	public Robot(Board b, String n, Pos p)
	{
		board = b;
		name = n;
		pos = p;
		++Count;
		board.record(p);
	}
	public Robot(Board b, String n)
	{
		board = b;
		name = n;
		pos = new Pos(0,0);
		Count++;
		board.record(pos);
	}
	public void setPos(Pos p)
	{
		board.origin(new Pos(pos.row,pos.col));
		pos = p;
		board.record(p);
	}
	
	public String getName() {
		return name;
	}
	
	public String getPos() {
		return "("+pos.row+","+pos.col+")";
	}
	
	public void move(int n)
	{
		int i;
		int R,C;
		R = pos.row;
		C = pos.col;
		
		TF=true;
		for(i=0;i<n;i++)
		{
			switch (this.pos.dir)
			{
			case 1 :
					C++;
				break;
			case 2 :
					C--;
				break;
			case 3 :
					R++;
				break;
			case 4 :
					R--;
				break;
			}
			if ((R>(board.getSize()-1)) || (C>(board.getSize())-1))
			{
				System.out.printf("보드를 벗어났습니다.\n");
				TF=false;
				break;
			}
			else if(R<0 || C<0)
			{
				System.out.printf("보드를 벗어났습니다.\n");
				TF=false;
				break;
			}
			else if(board.res(R, C)==1)
			{
				System.out.printf("다른로봇이 있어 이동이 어렵습니다.\n");
				TF=false;
				break;
			}
		}
		if (TF==true)
		{
			this.board.origin(new Pos(pos.row,pos.col));
			this.pos.row = R;
			this.pos.col = C;
			this.board.record(this.pos);
		}
		
	}
	
	public static boolean getTF() {
		return TF;
	}

	
	
	public void turnRight() {
		switch (this.pos.dir)
		{
		case 1 :
			pos.dir = 3;
			break;
		case 2 :
			pos.dir = 4;
			break;
		case 3 :
			pos.dir = 2;
			break;
		case 4 :
			pos.dir = 1;
			break;
		}
	}
	
	public void turnLeft() {
		switch (this.pos.dir)
		{
		case 1 :
			pos.dir = 4;
			break;
		case 2 :
			pos.dir = 3;
			break;
		case 3 :
			pos.dir = 1;
			break;
		case 4 :
			pos.dir = 2;
			break;
		}
	}
	
	public void traverse()
	{
		setPos(new Pos(0,0));
		turnRight();
		System.out.printf("%s", getPos());
		int n=0;
		for(int i=0;i<(board.getSize());i++) {
			for(int j=0;j<board.getSize()-1;j++)
			{
				move(1);
				System.out.printf("%s", getPos());
			}
			if (n%2==0)
			{
				turnLeft();
				if(pos.col<board.getSize()-1)
				{
					move(1);
					System.out.printf("%s", getPos());
				}
				turnLeft();
			}
			else
			{
				turnRight();
				if(pos.col<board.getSize()-1)
				{
					move(1);
					System.out.printf("%s", getPos());
				}
				turnRight();
			}
			n++;
		}
		System.out.printf("\n");
	}
	
	public static int count() {
		return Count;
	}

}
