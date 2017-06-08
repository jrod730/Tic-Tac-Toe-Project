import java.util.Scanner;

public class ProgrammingProject
{
   public static void main(String[] args)
   {
      char[][] ticTac = {{'1', '2', '3'}, {'4','5', '6'}, {'7', '8', '9'}};
      print2DArray(ticTac);
      
      //lets play the game
      gameStart(ticTac);
      //ask for user input
   }//main ends
   public static void gameStart(char[][] gameArray)
   {
      Scanner kb = new Scanner(System.in);
      int[] arrayToSaveInput = new int[9];
      int playerInput, index = 0, inValid;
      boolean occupiedBefore, winningGame = false;
      for (int round = 1; round <= 9; round++)
      {
         inValid = 0;
         do {
               if (inValid != 0)
                  System.out.println("Invalid input.");
                  
               if (round % 2 != 0)
                  System.out.print("X - Which square? [1-9]: ");
                  
               else
                  System.out.print("O - Which square? [1-9]: ");
                  
               playerInput = kb.nextInt();
               
               if (playerInput >= 10 || playerInput <= 0)
               inValid++;
                       
            }while (playerInput <= 0 || playerInput >= 10);
         
         occupiedBefore = placeHolder(arrayToSaveInput, playerInput); //checks if number is previously entered
             
         if (occupiedBefore)
         {
            System.out.println("Space occupied"); // will start same loop again
            round--;
         }
         else
         {
            arrayToSaveInput[index] = playerInput;
            index++;
            insertInSquare(gameArray, playerInput, round);
            if (round >= 5)
            winningGame = winner(gameArray);
            
            if (winningGame)
            {
               if (round % 2 != 0)
                  System.out.println("X wins!");
               else
                  System.out.println("O wins!");
               round = 10;
            }
         }//else ends        
      }//for ends
      if(!winningGame)
            System.out.println("Cat Game!");
    }//gameOver
    
    public static boolean winner(char[][] x)
    {
      boolean win = false;
      if (x[0][0] == x[0][1] && x[0][1] == x[0][2]) //first row
         win = true;
      else if (x[1][0] == x[1][1] && x[1][1] == x[1][2])//second row
         win = true;
      else if (x[2][0] == x[2][1] && x[2][1] == x[2][2])//third row
         win = true;
      else if (x[0][0] == x[1][0] && x[1][0] == x[2][0])//First column
         win = true;
      else if (x[0][1] == x[1][1] && x[1][1] == x[2][1])//Second column
         win = true;
      else if (x[0][2] == x[1][2] && x[1][2] == x[2][2])//third column
         win = true;
      else if (x[0][0] == x[1][1] && x[1][1] == x[2][2])//diagonal
         win = true;
      else if (x[0][2] == x[1][1] && x[1][1] == x[2][0])//diagonal 
         win = true;
         
      return win;
    }//winner ends
    
    public static char[][] insertInSquare(char[][] array, int input, int round)
    { 
      String temp = "" + input;
      char inputInChar = temp.charAt(0);
      for (int row = 0; row < array.length; row++)
      {
         for (int column = 0; column < array[row].length; column++)
         {
            if (array[row][column] == inputInChar)
            {
               if (round % 2 != 0)
                  array[row][column] = 'X';
               else
                  array[row][column] = 'O';
            }
         }
      }
      print2DArray(array);
      return array;
    }//Inserts X or O in the square and prints everytime
    
    public static boolean placeHolder(int[] userInputArray, int userInput)
    {
      boolean previous = false;
      for (int i = 0; i < userInputArray.length; i++)
      {
       if (userInputArray[i] == userInput)
            previous = true;
      }
      return previous;
    }//checks if number has been previously entered or not
      
   public static void print2DArray(char[][] array)
   {
      for (int row = 0; row < array.length; row++)
      {
         System.out.println("  |   |");
         for (int column = 0; column < array[row].length; column++)
         {
            if (column == 2)
            System.out.println(array[row][column]+ " ");
            else
            System.out.print(array[row][column]+ " | ");
         }
         System.out.println("  |   |");
         if (row < 2)
         System.out.println("----------");
      }
      System.out.println();
   }//print2DArray ends
}