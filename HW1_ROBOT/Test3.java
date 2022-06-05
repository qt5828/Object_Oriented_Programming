
public class Test3 {
	public static void main(String[] args)
	{
		int N=5;
		Board board = new Board(N);
		Robot rb1 = new Robot(board, "Kiro", new Pos(1,2));
		Robot rb2 = new Robot(board, "Miro");
		int count = Robot.count();
		System.out.println("# of robots : "+count);
		
		rb2.move(2);
		rb2.turnRight();
		rb2.move(1);
		System.out.printf("%s in %s & %s in %s%n", 
				rb1.getName(), rb1.getPos(), rb2.getName(), rb2.getPos());
		rb1.turnLeft();
		rb1.turnLeft();
		rb1.move(3);
		rb1.move(2);
		System.out.printf("%s in %s%n", rb1.getName(), rb1.getPos());
		rb2.move(2);
		System.out.printf("%s in %s%n", rb2.getName(), rb2.getPos());
		rb1.setPos(new Pos(1,0));
		traverse2(rb1);
		System.out.printf("%s in %s%n", rb1.getName(), rb1.getPos());
	}
	public static void traverse2(Robot rb) {
		if(rb.pos.col%2==0)
			rb.pos.dir=3;
		else
			rb.pos.dir=4;
		System.out.printf("("+rb.pos.row+","+rb.pos.col+") ");
		int TF=1;
		while(rb.pos.col < rb.board.getSize())
		{
			while(rb.pos.row < rb.board.getSize())
			{
				rb.move(1);
				if(Robot.getTF()==false) {
					TF=0;
					break;
				}
				if(rb.pos.row==rb.board.getSize()-1 || rb.pos.row==0) {
					System.out.printf("("+rb.pos.row+","+rb.pos.col+") ");
					break;
				}
				System.out.printf("("+rb.pos.row+","+rb.pos.col+") ");
				
			}
			if(TF==0)
				break;
			if(rb.pos.dir==3) {
				rb.turnLeft();
				rb.move(1);
				if(Robot.getTF()==false) 
					break;
				System.out.printf("("+rb.pos.row+","+rb.pos.col+") ");
				rb.turnLeft();
			}
			else {
				rb.turnRight();
				rb.move(1);
				if(Robot.getTF()==false) 
					break;
				System.out.printf("("+rb.pos.row+","+rb.pos.col+") ");
				rb.turnRight();
			}	

		}
		
	}
}