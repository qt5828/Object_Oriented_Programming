
public class Board {
	private int[][] board;
	private int size;
	
	public Board(int N)
	{
		size = N;
		board = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				board[i][j] = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public int res(int row, int col) {
		int res = board[row][col];
		return res;
	}
	
	public void record(Pos p)
	{
		board[p.row][p.col] = 1;
	}
	
	public void origin(Pos p)
	{
		board[p.row][p.col] = 0;
	}

}
