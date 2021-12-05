// Karthik Renuprasad
// Period 1
// 11/18/2020
// Connect_4_Object

import java.util.*;
//new class for Connect 4 game
public class Connect_4_Object
{
  //defining the variables 
  public int width;
  public int height;
  public int total_moves;
  char [][] Connect_Four_Board;
  public boolean slot1_col_full = false, slot2_col_full = false, slot3_col_full = false, slot4_col_full = false, slot5_col_full = false,slot6_col_full = false, slot7_col_full = false;
  
  //Default Constructor
  public Connect_4_Object()
  {
    width = 7;
    height = 6;
    Connect_Four_Board = new char[height][width];
    total_moves = 0;
    
    fill_board_with_blanks();
    
  }
  
  //Custom Constructor
  public Connect_4_Object(int value1, int value2)
  {
    width = value2;
    height = value1;
    Connect_Four_Board = new char[height][width];
    total_moves = 0;
    
    fill_board_with_blanks();
  }
  
  //getters
  public int getWidth()
  {
    return width;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public int getTotalMoves()
  {
    return total_moves;
  }
  
  public boolean getSlot1Full()
  {
    return slot1_col_full;
  }
  public boolean getSlot2Full()
  {
    return slot2_col_full;
  }
  public boolean getSlot3Full()
  {
    return slot3_col_full;
  }
  public boolean getSlot4Full()
  {
    return slot4_col_full;
  }
  public boolean getSlot5Full()
  {
    return slot5_col_full;
  }
  public boolean getSlot6Full()
  {
    return slot6_col_full;
  }
  public boolean getSlot7Full()
  {
    return slot7_col_full;
  } 
  public char[][] getCONNECT_FOUR_BOARD()
  {
    return Connect_Four_Board;
  }
  
  //setters
  public void setWidth(int w)
  {
    width = w; 
  }
  
  public void setHeight(int h)
  {
    height = h;
  }
  
  public void setSlot1Full(boolean flag)
  {
    slot1_col_full = flag;
  }  
  public void setSlot2Full(boolean flag)
  {
    slot2_col_full = flag;
  }  
  public void setSlot3Full(boolean flag)
  {
    slot3_col_full = flag;
  }  
  public void setSlot4Full(boolean flag)
  {
    slot4_col_full = flag;
  }  
  public void setSlot5Full(boolean flag)
  {
    slot5_col_full = flag;
  }  
  public void setSlot6Full(boolean flag)
  {
    slot6_col_full = flag;
  }  
  public void setSlot7Full(boolean flag)
  {
    slot7_col_full = flag;
  }  
  public void setTotalMoves(int t)
  {
    total_moves = t;
  }
  public void setCONNECT_FOUR_BOARD(int row, int column)
  {
    Connect_Four_Board = new char[row][column];;
  }
  
  //filling the board with empty spaces
  public void fill_board_with_blanks()
  {
    
    for(int i = 0; i < height; i++) 
    {
      for (int j = 0; j < width; j++) 
      {
        Connect_Four_Board[i][j] = ' ';
      }
    }
  }
  
  //printing the actaul playing board(chart) for Connect 4
  public void drawGameBoard(char[][] board)
  {
    int i, j;
    
    for(i = height-1; i >= 0; i--)
    {
      
      for(j = 0; j < width;  j++)
      {
        
        System.out.print("["+board[i][j]+"]");
      }
      
      System.out.println();
    }
    for(i = 1; i <= width; i++)
    {
      System.out.print(" "+i+" ");
    }
  }     
  
  //capturing the player's input marker on the board depending on what slot they choose
  public boolean player_move(char[][] board, int slot, char marker)
  {
    int i;
    boolean success = false;
    for(i = 0; i <= height; i++)
    {
      if(board[i][slot-1] == ' ')
      {
        board[i][slot-1] = marker;
        success = true;
        break;
      }
    }
    
    //checking to see if each column's slots is full
    if(i == 5 && slot == 1)
    {
      slot1_col_full = true;
    } 
    else if(i == 5 && slot == 2)
    {
      slot2_col_full = true;
    }
    else if(i == 5 && slot == 3)
    {
      slot3_col_full = true;
    }
    else if(i == 5 && slot == 4)
    {
      slot4_col_full = true;
    }
    else if(i == 5 && slot == 5)
    {
      slot5_col_full = true;
    }
    else if(i == 5 && slot == 6)
    {
      slot6_col_full = true;
    }
    else if(i == 5 && slot == 7)
    {
      slot7_col_full = true;
    }
    
    total_moves++;
    return success;
  }
  
  //checking if the whole board is full
  public boolean full()
  {
    if (total_moves >= 42)
    {
      return true;
    }
    else 
    {
      return false;
    }
  }
  
  //logic to check if a player won the game or not
  public boolean check_winner(char[][] board, char marker)
  {
    //Checking for a winner vertically
    for(int i = 0; i < 3; i++) 
    {
      for (int j = 0; j < 7; j++) 
      {
        if(board[i][j] == marker && board[i+1][j] == marker && board[i+2][j] == marker && board[i+3][j] == marker ) 
        {
          return true;
        }
      }
    }
    
    //Checking for a winner horizontally
    for(int i = 0; i < 6; i++) 
    {
      for (int j = 0; j < 4; j++) 
      {
        if(board[i][j] == marker && board[i][j+1] == marker && board[i][j+2] == marker && board[i][j+3] == marker ) 
        {
          return true;
        }
      }
    }
    
    //Checking for a winner diagonal up and to the left
    for(int i = 3; i < 6; i++) 
    {
      for (int j = 0; j < 4; j++) 
      {
        if(board[i][j] == marker && board[i-1][j+1] == marker && board[i-2][j+2] == marker && board[i-3][j+3] == marker ) 
        {
          return true;
        }
      }
    }
    
    //Checking for a winner diagonal down and to the right
    for(int i = 0; i < 3; i++) 
    {
      for (int j = 0; j < 4; j++) 
      {
        if(board[i][j] == marker && board[i+1][j+1] == marker && board[i+2][j+2] == marker && board[i+3][j+3] == marker ) 
        {
          return true;
        }
      }
    }
    
    //there is no winner yet
    return false;
  }
  
}



