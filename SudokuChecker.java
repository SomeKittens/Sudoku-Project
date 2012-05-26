/**
 *Given a sudoku board, check to see if it is legal
 *Original author-Robert Willhoft
 *Modified by Randall Koutnik
 */
public class SudokuChecker
{
	/**
	 *Constructor.  Takes a Sudoku board and sets it to puzzle.
	 *@param input The Sudoku board
	 */
	public SudokuChecker( int[][] input )
	{
	  puzzle = input;
	}
	
	/**
	 *check to be sure there is an entry 1-9 in each position in the matrix
	 *exit with false as soon as you find one that is not
	 *@return true if the board has correct entries, false otherwise
	 */
	public boolean completed()
	{
		for(int i = 0; i < 9;i++)
		{
			for(int j = 0;j < 9;j++)
			{
				if(puzzle[i][j] > 9 || puzzle[i][j] < 1)
				{
					return false;
				}
			}
		}
		return true;
	}
	   
	public boolean checkPuzzle()
	{
	   // use checkRow to check each row
		for(int i = 0; i < 9;i++)
		{
			if(!checkRow(i))
			{
				return false;
			}
		}
	    
	   // use checkColumn to check each column
		 
		for(int i = 0; i < 9;i++)
		{
			if(!checkColumn(i))
			{
				return false;
			}
		}
	    
	   // use checkSquare to check each of the 9 blocks
		for(int i = 0; i < 9;i += 3)
		{
		 	for(int j = 0; j < 9;j += 3)
			{
				if(!checkSquare(i, j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 *Ensures that row r is legal
	 *@param r the row to check
	 *@return  true if legal, false otherwise.
	 */
	public boolean checkRow( int r )
	{
	   resetCheck();
	   for( int c=0; c<9; c++ )
	   {
	    	if( !digitCheck( puzzle[r][c] ) )
	    	{
	    		return false;
	   	}
	   }
		return true;
	}
	
	/**
	 *Ensures that column c is legal
	 *@param c the column to check
	 *@return  true if legal, false otherwise.
	 */
	public boolean checkColumn( int c )
	{
		resetCheck();
		for( int r=0; r<9; r++ )
		{
			if( !digitCheck( puzzle[r][c] ) )
			{
				return false;
			}
		}
		return true;
	}
	/**
	 *Ensures that a given square is legal
	 *@param row    the initial row of the square
	 *@param column the intial column of the square
	 *@return       true if legal, false otherwise.
	 */
	public boolean checkSquare( int row, int column )
	{
		resetCheck();
		for(int r = 0; r < 3;r++)
		{
			for(int c = 0; c < 3;c++)
			{
				if( !digitCheck( puzzle[r + row][c + column] ) )
				return false;
			}
		}
		return true;
	}
	
	/**
	 *Keeps track of numbers used during a row/column/square check
	 *@param n the number currently being checked
	 *@return  true if the number has not been used yet, false otherwise
	 */
	public boolean digitCheck( int n )
	{
		if( n != 0 && digits[n] )
		{
			return false;
		}
		else
		{
			digits[n] = true;
			return true;
		} 
	}
	
	/**
	 *Resets digits to false
	 */
	public void resetCheck()
	{
		digits = new boolean[10];
	}
	  
	// ***** Instance Variables *****
	int[][] puzzle;
	boolean[] digits;
	  
	// ***** Built-in Self-Test *****
	public static void main(String[] args)
	{
		int[][] puzzleLegacy = { { 7,8,1,6,0,2,9,0,5 },
	                       { 9,0,2,7,1,0,0,0,0 },
	                       { 0,0,6,8,0,0,0,1,2 },
	                       { 2,0,0,3,0,0,8,5,1 },
	                       { 0,7,3,5,0,0,0,0,4 },
	                       { 0,0,8,0,0,9,3,6,0 },
	                       { 1,9,0,0,0,7,0,8,0 },
	                       { 8,6,7,0,0,3,4,0,9 },
	                       { 0,0,5,0,0,0,1,0,0 } };
	                        
		int[][] puzzle = { { 7,8,1,6,3,2,9,4,5 },
	                       { 9,5,2,7,1,4,6,3,8 },
	                       { 4,3,6,8,9,5,7,1,2 },
	                       { 2,4,9,3,7,6,8,5,1 },
	                       { 6,7,3,5,8,1,2,9,4 },
	                       { 5,1,8,4,2,9,3,6,7 },
	                       { 1,9,4,2,6,7,5,8,3 },
	                       { 8,6,7,1,5,3,4,2,9 },
	                       { 3,2,5,9,4,8,1,7,8 } };
	                      
		SudokuChecker sudoku = new SudokuChecker( puzzle );                       
		if( sudoku.checkPuzzle() )
			System.out.println("There are no rule violations");
		if( sudoku.completed() )
			System.out.println("Puzzle is done");
		else
	      System.out.println("Puzzle is NOT done"); 
	}
}
