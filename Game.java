import java.util.Random;
import java.util.Scanner;

public class Game {
  
  public static void main (String args[]) {
    
    // Random Generator to pick up players or bot turn
    // 0 - player1
    // 1 = player2
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    int turn = random.nextInt(2);

    System.out.println((turn == 0 ? "Player1" : "player2") + " starts the game.\n");
    
    Scanner scanner = new Scanner(System.in);
    char[][] board = new char[3][3];

    GameUtil util = new GameUtil();
    util.initBoard(board);
    char used = 'O';

    // Game Loops
    while (util.gameEnded(board) == '-') {
      char uses = (used == 'X' ? 'O' : 'X'); 
      if (turn == 0) {
        util.printBoard(board);        
        System.out.print("Player1 please enter 2 spaced integer row and column to insert '" + uses + "' into the space : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x > 0 && x <=3 && y > 0 && y <=3 && board[x - 1][y - 1] == '-') {
          board[x - 1][y - 1] = uses;
          turn = (turn == 0 ? 1 : 0);
          used = uses; 
        }
      } else {
        util.printBoard(board);        
        System.out.print("Player2 please enter 2 spaced integer row and column to insert '" + uses + "'into the space : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x > 0 && x <=3 && y > 0 && y <=3 && board[x - 1][y - 1] == '-') {
          board[x - 1][y - 1] = uses;
          turn = (turn == 0 ? 1 : 0);
          used = uses;
        }
      }
    }
    
    if (util.checkWinner(board) != '\0') System.out.println((turn == 1 ? "Player1" : "Player2")+ " has won the game.\n");
    else System.out.println("The match ends in a draw!!!\n");
    util.printBoard(board);        
  }
}
