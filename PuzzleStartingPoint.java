   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    public class PuzzleStartingPoint implements MouseListener
   {
      Drawing draw = new Drawing();
      int [][] board = {{1,2,3,4},                   	//Stores location of the actual 4 by 4 board 
                  {5,6,7,8},                    		//0 is the blank tile
                  {9,10,11,12},
                  {13,14,15,0}};
      int [][]checkBoard={{1,2,3,4},                  //Stores location of where the solved pieces should be 
                  	 {5,6,7,8},                    	//0 is the blank tile
                      {9,10,11,12},
                      {13,14,15,0}};
      ImageIcon[] boardPictures = new ImageIcon[16]; 	 //Stores the 16 original tile pictures
      int blankRow, blankCol;									 //Stores the row and column of the blank tile.
   
       public PuzzleStartingPoint() 
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
      }//PuzzleStartingPoint
   /*///////////////////////////////////////////////////////////////////////////////*/
   //	Method Name:		initializeBoard                                             //
   //	Method Parameters:none																			//
   //	Return Value:		none																			//
   //	Description:		This Method repeatedly shuffles the board for 80 times to	//
   //							create the inital state of the board.								//
   /*///////////////////////////////////////////////////////////////////////////////*/
      
       public void initializeBoard()    
      {
         for (int count = 0; count <= 80; count++)							 //Repeats shuffling the tile 80 times										
         {
            shuffleBoard();														 //Randomly chooses a tile to shuffle
            
            for(int rowNum=0; rowNum<board.length ; rowNum++)			 //Looks through the rows of the board
            {
               for(int colNum=0; colNum<board[rowNum].length;colNum++)//Looks through the columns of the board
               {
               
                  if(board[rowNum][colNum]==checkBoard[rowNum][colNum] && checkBoard[rowNum][colNum]!=0)
                  
                  																	 //Checks if the piece is not zero as well
                  																	 //as if the piece is in the solved position
                  																		
                     boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]+15) + ".jpg");
                  	
                  																	 //Swaps the original image of the tile
                  																	 //with a different colot one that indicates
                  																	 //it is in the right position
                  else
                     boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]) + ".jpg");
               		
               																		 //If the tile is not in the correct position
               																		 //the image of the tile is set to the original
               																		 //image
               }
            }
         } 
      } // initializeBoard
   	 
   	/*///////////////////////////////////////////////////////////////////////////////*/
   	//	Method Name:		shuffleBoard                                                //
   	//	Method Parameters:none																			//
   	//	Return Value:		none																			//
   	//	Description:		This Method first checks the location of the blank tile and //
   	//							chooses a random move from availible adjacent tiles.It then //
   	//							swaps that tile with the blank tile.								//	
   	/*///////////////////////////////////////////////////////////////////////////////*/
     
       public void shuffleBoard() 
      {
         double randomNumber;															
         int shuffleRow,shuffleCol; 						
         findBlank();																 //locates the row and column of the blank tile and
         																				 //then stores their values in blankRow and blankCol
      	
         if (blankRow==0 && blankCol == 0)									 //checks if the blank tile is in the top left corner
         {
            randomNumber = Math.floor(Math.random()*2);   			    //generates either 1 or 2 randomly        
         																					        
            if (randomNumber==0 )  												 //checks if the random number is 0          
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol+1];//The value of the blank tile is switched with the 
               board[blankRow][blankCol+1]=0;								 //value of the tile above it
            }
            else																		 //otherwise the number must be 1
            {
               board[blankRow][blankCol]=	board[blankRow+1][blankCol];//The value of the blank tile is switched with the 
               board[blankRow+1][blankCol]=0;								 //tile to the right of it
            }
         }		
         else if ( blankRow ==0 && blankCol==3 )							 //checks if the blank tile is in the top right corner	
         {
            randomNumber = Math.floor(Math.random()*2); 					 //generates either 1 or 2 randomly
            if (randomNumber==0 ) 
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol-1];//The value of the blank tile is switched with the
               board[blankRow][blankCol-1]=0;								 //tile to the left of it
            }
            else
            {
               board[blankRow][blankCol]=	board[blankRow+1][blankCol];//The value of the blank tile is switched with the
               board[blankRow+1][blankCol]=0;								 //tile to the above it
            }
         }	
            
         else if (blankRow==3 && blankCol ==0)								 //checks if tile is in bottom left corner
         {
            randomNumber = Math.floor(Math.random()*2); 					 //generates either 1 or 2 randomly
            if (randomNumber==0 )
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol+1];//The value of the blank tile is switched with the
               board[blankRow][blankCol+1]=0;								 //tile to the right of it
            }
            else
            {
               board[blankRow][blankCol]=	board[blankRow-1][blankCol];//The value of the blank tile is switched with the
               board[blankRow-1][blankCol]=0;								 //tile to below it
            }            }	
         else if (blankRow==3 && blankCol ==3)								 //checks if tile is in bottom right corner
         {
            randomNumber = Math.floor(Math.random()*2); 					 //generates either 1 or 2 randomly
            if (randomNumber==0 ) 
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol-1];//The value of the blank tile is switched with the
               board[blankRow][blankCol-1]=0;								 //tile to the right of it
            }
            else
            {
               board[blankRow][blankCol]=	board[blankRow-1][blankCol];//The value of the blank tile is switched with the
               board[blankRow-1][blankCol]=0;								 //tile below it
            }            }
         else if ( blankRow==0)													 //checks if the tile is in the first row
         {
            randomNumber = Math.floor(Math.random()*3); 					 //generates a number from 0 to 2 randomly
            if (randomNumber==0)
            {
               board[blankRow][blankCol]=	board[blankRow+1][blankCol];//The value of the blank tile is switched with the
               board[blankRow+1][blankCol]=0;								 //tile above it
            }
            else if (randomNumber==1)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol-1];//The value of the blank tile is switched with the
               board[blankRow][blankCol-1]=0;								 //tile to the left of it
            }
            else if (randomNumber==2)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol+1];//The value of the blank tile is switched with the
               board[blankRow][blankCol+1]=0;								 //tile to the right of it
            }
         }
         else if (blankRow==3)													 //checks if the tile is in the last row
         {
            randomNumber = Math.floor(Math.random()*3); 					 //generates a number from 0 to 2 randomly
            if (randomNumber==0)
            {
               board[blankRow][blankCol]=	board[blankRow-1][blankCol];//The value of the blank tile is switched with the
               board[blankRow-1][blankCol]=0;								 //tile below it
            }
            else if (randomNumber==1)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol-1];//The value of the blank tile is switched with the
               board[blankRow][blankCol-1]=0;								 //tile to the left of it
            }
            else if (randomNumber==2)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol+1];//The value of the blank tile is switched with the
               board[blankRow][blankCol+1]=0;								 //tile to the right of it
            }
         }            
         else if (blankCol==0)													 //checks if the tile is in the first column
         {
            randomNumber = Math.floor(Math.random()*3); 					 //generates a number from 0 to 2 randomly
            if (randomNumber==0)
            {
               board[blankRow][blankCol]=	board[blankRow-1][blankCol];//The value of the blank tile is switched with the
               board[blankRow-1][blankCol]=0;								 //tile below it
            }
            else if (randomNumber==1)
            {
               board[blankRow][blankCol]=	board[blankRow+1][blankCol];//The value of the blank tile is switched with the
               board[blankRow+1][blankCol]=0;								 //tile above it
            }
            else if (randomNumber==2)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol+1];//The value of the blank tile is switched with the
               board[blankRow][blankCol+1]=0;								 //tile to the right of it
            }
         }
         else if (blankCol==3)													 // checks if the tile is in the 3rd column
         {
            randomNumber = Math.floor(Math.random()*3); 					 //generates a number from 0 to 2 randomly
            if (randomNumber==0)
            {
               board[blankRow][blankCol]=	board[blankRow-1][blankCol];//The value of the blank tile is switched with the
               board[blankRow-1][blankCol]=0;								 //tile below it
            }
            else if (randomNumber==1)
            {
               board[blankRow][blankCol]=	board[blankRow+1][blankCol];//The value of the blank tile is switched with the
               board[blankRow+1][blankCol]=0;								 //tile above it
            }
            else if (randomNumber==2)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol-1];//The value of the blank tile is switched with the
               board[blankRow][blankCol-1]=0;								 //tile to the left of it
            }
         }
         else																			//checeks if the tile is in the middle 4 spaces
         {
            randomNumber = Math.floor(Math.random()*4); 					 //generates a number from 0 to 3 randomly
            if (randomNumber==0)
            {
               board[blankRow][blankCol]=	board[blankRow+1][blankCol];//The value of the blank tile is switched with the
               board[blankRow+1][blankCol]=0;								 //tile above it
            }
            else if (randomNumber==1)
            {
               board[blankRow][blankCol]=	board[blankRow-1][blankCol];//The value of the blank tile is switched with the
               board[blankRow-1][blankCol]=0;								 //tile below it
            }
            else if (randomNumber==2)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol+1];//The value of the blank tile is switched with the
               board[blankRow][blankCol+1]=0;								 //tile to the right of it
            }
            else if (randomNumber==3)
            {
               board[blankRow][blankCol]=	board[blankRow][blankCol-1];//The value of the blank tile is switched with the
               board[blankRow][blankCol-1]=0;								 //tile to the left of it
            }
         }    
      } // shuffleBoard
   
   
   	/*///////////////////////////////////////////////////////////////////////////////*/
   	//	Method Name:		findBlank                                           		   //
   	//	Method Parameters:none																			//
   	//	Return Value:		none																			//
   	//	Description:		This program searches through the board array until it finds//
   	//							a zero. It then saves the row and column in blankRow and    //
   	//							blankCol.																	//
   	/*///////////////////////////////////////////////////////////////////////////////*/
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
   
   	/*///////////////////////////////////////////////////////////////////////////////*/
   	//	Method Name:		moveTile                                           		   //
   	//	Method Parameters:row and col																	//
   	//	Return Value:		none																			//
   	//	Description:		This program uses the coordinates of the tile the user      //
   	//							clicks and depending on depending on the blank is adjacent  //
   	//							to it and switches the tile clicked with the blank tile     //
   	/*///////////////////////////////////////////////////////////////////////////////*/
      
       public void moveTile(int row, int col)
      {
      	
         findBlank();
      
         if (row==0 && col == 0)											//checks if the row clicked is the top left corner
         {
            if ( board[0][1]==0)											//checks if the space to the right of the corner is blank
            {
               board[blankRow][blankCol]=	board[row][col];		//swaps the blank space value with clicked space value
               board[row][col]=0;
            }
            else if ( board[1][0]==0)									//checks if the space below the corner is blank
            {
               board[blankRow][blankCol]=	board[row][col];
               board[row][col]=0;										//swaps the blank space value with clicked space value
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
            
               if(board[rowNum][colNum]==checkBoard[rowNum][colNum] && checkBoard[rowNum][colNum]!=0)
                  boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]+15) + ".jpg");
               else if (board[rowNum][colNum]==checkBoard[rowNum][colNum])
                  boardPictures[board[rowNum][colNum]] = new ImageIcon(0 + ".jpg");
               else
                  boardPictures[board[rowNum][colNum]] = new ImageIcon((board[rowNum][colNum]) + ".jpg");
            
            }
         } 
       	
      }  
      
   
   
   
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



