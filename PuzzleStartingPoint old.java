import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuzzleStartingPoint implements MouseListener
{
   Drawing draw = new Drawing();
   int [][] board = {{1,2,3,4},                    //4X4 puzzle board 
                     {5,6,7,8},                    //0 is the blank spot
                     {9,10,11,12},
                     {13,14,15,0}};
	int [][]checkBoard={{1,2,3,4},                    //4X4 puzzle board 
                     {5,6,7,8},                    //0 is the blank spot
                     {9,10,11,12},
                     {13,14,15,0}};
   ImageIcon[] boardPictures = new ImageIcon[16];  //stores the 16 tile pictures
   int blankRow, blankCol;
  
   public PuzzleStartingPoint()  // constructor
   {
			

     for (int i = 0; i < boardPictures.length; i++)
         boardPictures[i] = new ImageIcon(i + ".jpg");
      JFrame frame = new JFrame("Puzzle");
      frame.add(draw);
      draw.addMouseListener(this);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(420, 440);
      initializeBoard();
      frame.setVisible(true);
   }

   // gets the 4X4 puzzle board ready to play
    public void initializeBoard()    
   {
      for (int count = 0; count <= 50; count++)
      {
         shuffleBoard();
         for(int rowNum=0; rowNum<board.length ; rowNum++)
		   {
			for(int colNum=0; colNum<board[rowNum].length;colNum++)
			   {

				   if(board[rowNum][colNum]==checkBoard[rowNum][colNum] && checkBoard[rowNum][colNum]!=0)
        			   boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]+15) + ".jpg");
               else if (board[rowNum][colNum]==checkBoard[rowNum][colNum])
                  boardPictures[board[rowNum][colNum]] = new ImageIcon(0 + ".jpg");
			      else
					   boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]) + ".jpg");

			   }
		   } 
     }	
   } // initializeBoard


   // finds a blank spot and picks a tile randomly to move into it
   public void shuffleBoard() 
   {


   } // shuffleBoard
   
   
   // finds where the blank spot is and stores its row and column into blankRow and blankCol
   public void findBlank()
   {
   	for (int row = 0 ; row < board.length ; row ++)
		{
			for (int column = 0 ; column < board[row].length ; column ++)
			{
				if ( board[row][column]==0)
				{
					blankRow=row;
					blankCol=column;
				}
			}
		}					
   } // findBlank


   // moves the chosen (mouse-clicked) tile into a blank spot if possible
   public void moveTile(int row, int col)
   {

		findBlank();
		
		if (row==0 && col == 0)											//checks if the row clicked is the top left corner
		{
				if ( board[0][1]==0)										// checks if the space to the right of the corner is blank
				{
					board[blankRow][blankCol]=	board[row][col];	//swaps the blank space value with clicked space value
					board[row][col]=0;
				}
				else if ( board[1][0]==0)								//checks if the space below the corner is blank
				{
					board[blankRow][blankCol]=	board[row][col];
					board[row][col]=0;									//swaps the blank space value with clicked space value
				}
		}		
		else if ( row ==0 && col==3 )									//checks if the space clicked is the top right corner
		{
			if (board[0][2]==0)											//checks if the space left to the space clicked is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if ( board[1][3]==0)									// checks if the space clicked is below blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}	
		
		else if (row==3 && col ==0)									//checks if the space clicked is the bottom left corner
		{
			if (board[2][0]==0)											//checks if the space above is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;	
			}
			else if (board[3][1]==0)									//checks if the space to the right is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}	
		else if (row==3 && col ==3)									//checks if the space clicked is the bottom right corner
		{
			if (board[2][3]==0)											//checks if the space above is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[3][2]==0)									//checks if the space to the left is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}
		else if ( row==0)													//checks if the space clicked is in the top row
		{
			if (board[row][col-1]==0)									//checks if the space to the left is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row][col+1]==0)							//checks if the space to the right is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row+1][col]==0)							//checks if the space below is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}
		else if (row==3)													//checks if the space clicked is on the bottom row
		{
			if (board[row][col-1]==0)									//checks if the space to the left is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row][col+1]==0)							//checks if the space to the right is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row-1][col]==0)							//checks if the space above is bank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}
		else if (col==0)													//checks if the space clicked is in the first column
		{
			if (board[row][col+1]==0)									//checks if the space to the right is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row-1][col]==0)							//checks if the space below is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row+1][col]==0)							//checks if the space above is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}
		else if (col==3)													//checks if the space clicked is in the third column
		{
			if (board[row][col-1]==0)									//checks if the space to the left is blank
			{			
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row-1][col]==0)							//checks if the space above is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row+1][col]==0)							//checks if the space above is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}
		else																	//checks if the position clicked is the middle four tiles
		{
			if (board[row][col-1]==0)									//checks if the space to the left is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row][col+1]==0)							//checks if the space to the right is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row-1][col]==0)							//checks if the space below is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
			else if (board[row+1][col]==0)							//checks if the space above is blank
			{
				board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
				board[row][col]=0;
			}
		}		
			
         for(int rowNum=0; rowNum<board.length ; rowNum++)
		   {
			for(int colNum=0; colNum<board[rowNum].length;colNum++)
			   {

				   if(board[rowNum][colNum]==checkBoard[rowNum][colNum] && checkBoard[rowNum][colNum]!=0)				//checks if the pieces are in the right spot
        			   boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]+15) + ".jpg");	//switches the image to the blue gredient assets
			      else
					   boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]) + ".jpg");		//switches the image to the normal assets

			   }
		   } 
     


	//System.out.println(row+" "+col);	
   } // moveTile
   
   class Drawing extends JComponent
   {
      public void paint(Graphics g)
      {
         for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++)
               g.drawImage(boardPictures[board[row][col]].getImage(),col * 100, row * 100,100,100,this);
      }
   }

// --> starting implementing MouseListener - it has 5 methods 
   public void mousePressed(MouseEvent e)
   {
   }
      
   public void mouseReleased(MouseEvent e)
   {
      // find coords of mouse click
      int row = e.getY()/100;
      int col = e.getX()/100;
 
      moveTile(row, col);
      
      // get paint to be called to reflect your mouse work
      draw.repaint();
   }
   
   public void mouseClicked(MouseEvent e)
   {
   }
   
   public void mouseEntered(MouseEvent e)
   {
   }
   
   public void mouseExited(MouseEvent e)
   {
   }
// finishing implementing MouseListener  <---
   public static void main(String[] args)
   {
      new PuzzleStartingPoint();
   }
}