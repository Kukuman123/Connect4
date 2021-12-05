// Karthik Renuprasad9
// Period 1
// 11/18/2020
// Connect_4_Main

import java.util.*;
public class Connect_4
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    char[][] board;
    int column = 0;
    String player = "Player 1";
    char marker = 'X';
    boolean play_on = true;
    boolean play_game = true;
    
    //creating the object for the Connect class
    Connect_4_Object game = new Connect_4_Object();
    
    //getting the board from the object 
    board = game.getCONNECT_FOUR_BOARD();
    
    //starting message
    System.out.println("CONNECT 4");
    System.out.println("---------");
    
    //loop to play the game
    while(play_game)
    {
      //printing the game board
      game.drawGameBoard(board);
      
      play_on = true;
      
      //loop to take the players input, till we find a winner or a draw
      while(play_on)
      {
        System.out.println("");
        System.out.println(player+" which column do you want to choose");
        column = Sc.nextInt();
        Sc.nextLine();
        
        //if the player enters a nonexistant column number, then ask the player to enter another column number
        if(column <= 0 || column > 7)
        {
          System.out.println("Not a valid column. Please choose a valid column "+player);
          continue;
        }
        
        //if the player enters a column number that is already full, then ask the player to enter another column number
        if ((column == 1 && game.getSlot1Full()) || (column == 2 && game.getSlot2Full()) || (column == 3 && game.getSlot3Full()) || (column == 4 && game.getSlot4Full()) || 
            (column == 5 && game.getSlot5Full()) || (column == 6 && game.getSlot6Full()) || (column == 7 && game.getSlot7Full()))
        {
          System.out.println("All slots are taken for column "+column+ ". Choose a different slot.");
          continue;
        }
        
        //checking if marker was placed on the board
        if(game.player_move(board, column, marker))
        {
          //checking if the board is filled, if so then print a draw message and end the game
          if (game.full())
          {
            game.drawGameBoard(board);
            System.out.println();
            System.out.println("DRAW. Play again!");
            play_game = false;
            break;
          }
          
          //checking if there is a winner
          if(game.check_winner(board, marker))
          {
            game.drawGameBoard(board);
            System.out.println("");
            System.out.println(player+" Won!");
            System.out.println("Hope you enjoyed the game!");
            play_game = false;
            break;
          }
          
          //giving the turn to the next player
          if(player == "Player 1")
          {
            player = "Player 2";
            marker = 'O';
          }
          else
          {
            player = "Player 1";
            marker = 'X';
          }
          play_on = false;
        }
      }
    }
  }
}