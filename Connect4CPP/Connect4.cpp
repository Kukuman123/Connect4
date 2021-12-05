#include <iostream>
#include <string>
using namespace std;

//g++ connect4.cpp -o c4.o && ./c4.o 
class Connect4 {
  //defining the variables
  int width;
  int height;
  int total_moves;
  char[][] board;
  bool slot1_col_full = false, slot2_col_full = false, slot3_col_full = false, slot4_col_full = false, slot5_col_full = false, slot6_col_full = false, slot7_col_full = false;

  public:
    //Default Constructor
    Connect4() {
      width = 7;
      height = 6;
      board = new char[height][width];
      total_moves = 0;
      fill_board_with_blanks();
    }

  //Custom Constructor
  Connect4(int value1, int value2) {
    width = value2;
    height = value1;
    board = new char[height][width];
    total_moves = 0;
    fill_board_with_blanks();
  }

  //getters
  int getWidth() {return width;}

  int getHeight() {return height;}

  int getTotalMoves() {return total_moves;}

  bool getSlot1Full() {return slot1_col_full;}
  bool getSlot2Full() {return slot2_col_full;}
  bool getSlot3Full() {return slot3_col_full; }
  bool getSlot4Full() {return slot4_col_full; }
  bool getSlot5Full() {return slot5_col_full;}
  bool getSlot6Full() { return slot6_col_full;}
  bool getSlot7Full() {return slot7_col_full; }

  char[][] getboard() {
    return board;
  }

  //setters
  void setWidth(int w) {width = w; }

  void setHeight(int h) {height = h;}

  void setSlot1Full(bool flag) {slot1_col_full = flag;}
  void setSlot2Full(bool flag) {slot2_col_full = flag;}
  void setSlot3Full(bool flag) {slot3_col_full = flag;}
  void setSlot4Full(bool flag) { slot4_col_full = flag;}
  void setSlot5Full(bool flag) {slot5_col_full = flag;}
  void setSlot6Full(bool flag) {slot6_col_full = flag; }
  void setSlot7Full(bool flag) {slot7_col_full = flag;}
  void setTotalMoves(int t) { total_moves = t;}
  void setboard(int row, int column) {board = new char[row][column];}

  //filling the board with empty spaces
    void fill_board_with_blanks() {

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board[i][j] = ' ';
      }
    }
  }

  //printing the actaul playing board(chart) for Connect 4
  void drawGameBoard(char[][] board) {
    int i, j;

    for (i = height - 1; i >= 0; i--) {

      for (j = 0; j < width; j++) {

        cout <<"[" << board[i][j] << "]";
      }

      cout << endl;
    }
    for (i = 1; i <= width; i++) {
      cout <<" " << i << " ";
    }
  }

  //capturing the player's input marker on the board depending on what slot they choose
  bool player_move(char[][] board, int slot, char marker) {
    int i;
    bool success = false;
    for (i = 0; i <= height; i++) {
      if (board[i][slot - 1] == ' ') {
        board[i][slot - 1] = marker;
        success = true;
        break;
      }
    }

    //checking to see if each column's slots is full
    if (i == 5 && slot == 1) {
      slot1_col_full = true;
    } else if (i == 5 && slot == 2) {
      slot2_col_full = true;
    } else if (i == 5 && slot == 3) {
      slot3_col_full = true;
    } else if (i == 5 && slot == 4) {
      slot4_col_full = true;
    } else if (i == 5 && slot == 5) {
      slot5_col_full = true;
    } else if (i == 5 && slot == 6) {
      slot6_col_full = true;
    } else if (i == 5 && slot == 7) {
      slot7_col_full = true;
    }

    total_moves++;
    return success;
  }

  //checking if the whole board is full
  bool full() {
    if (total_moves >= 42) {
      return true;
    } else {
      return false;
    }
  }

  //logic to check if a player won the game or not
  bool check_winner(char[][] board, char marker) {
    //Checking for a winner vertically
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 7; j++) {
        if (board[i][j] == marker && board[i + 1][j] == marker && board[i + 2][j] == marker && board[i + 3][j] == marker) {
          return true;
        }
      }
    }

    //Checking for a winner horizontally
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == marker && board[i][j + 1] == marker && board[i][j + 2] == marker && board[i][j + 3] == marker) {
          return true;
        }
      }
    }

    //Checking for a winner diagonal up and to the left
    for (int i = 3; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == marker && board[i - 1][j + 1] == marker && board[i - 2][j + 2] == marker && board[i - 3][j + 3] == marker) {
          return true;
        }
      }
    }

    //Checking for a winner diagonal down and to the right
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == marker && board[i + 1][j + 1] == marker && board[i + 2][j + 2] == marker && board[i + 3][j + 3] == marker) {
          return true;
        }
      }
    }

    //there is no winner yet
    return false;
  }
}

int main() {
    char[][] board;
    int column = 0;
    string player = "Player 1";
    char marker = 'X';
    bool play_on = true;
    bool play_game = true;
    while (play_game) {
        
        game.drawGameBoard(board);
        play_on = true;
        while (play_on) {
            cout <<"" << endl;
            cout <<player << " which column do you want to choose"<< endl;
            cin >> column;

            if (column <= 0 || column > 7) {
                cout <<"Not a valid column. Please choose a valid column " << player<< endl;
                continue;
            }

            if ((column == 1 && game.getSlot1Full()) || (column == 2 && game.getSlot2Full()) || (column == 3 && game.getSlot3Full()) || (column == 4 && game.getSlot4Full()) ||
                (column == 5 && game.getSlot5Full()) || (column == 6 && game.getSlot6Full()) || (column == 7 && game.getSlot7Full())) {
                cout <<"All slots are taken for column " << column << ". Choose a different slot."<< endl;
                continue;
            }

            if (game.player_move(board, column, marker)) {
                if (game.full()) {
                    game.drawGameBoard(board);
                    cout << endl;
                    cout <<"DRAW. Play again!"<< endl;
                    play_game = false;
                    break;
            }

            if (game.check_winner(board, marker)) {
                game.drawGameBoard(board);
                cout <<""<< endl;
                cout <<player << " Won!"<< endl;
                cout <<"Hope you enjoyed the game!" << endl;
                play_game = false;
                break;
            }

            if (player == "Player 1") {
                player = "Player 2";
                marker = 'O';
            } else {
                player = "Player 1";
                marker = 'X';
            }
            play_on = false;
        
            }
        }
     
    }
}

    
    