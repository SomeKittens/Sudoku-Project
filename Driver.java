/**
 *Runs through every other class.
 *Mainly used for testing.
 */
public class Driver
{
	public static void main(String[] args)
	{
		SudokuGenerator sg = new SudokuGenerator();
		PerverseSudokuSolver ss = new PerverseSudokuSolver();
		int numSolved = 0;
		
		for(int i=0;i<1000;i++)
		{
			ss.reset(sg.nextBoard(35));
			if(ss.solve())
			{
				numSolved++;
			}
		}
		System.out.println(numSolved);
		ss.print();
		SudokuChecker sudoku = new SudokuChecker( ss.board );
		if( sudoku.checkPuzzle() )
		{
		  System.out.println("There are no rule violations");
		}
		if( sudoku.completed() )
		{
		  System.out.println("Puzzle is done");
		}
		else
		{
		  System.out.println("Puzzle is NOT done");
		}
	}
}
