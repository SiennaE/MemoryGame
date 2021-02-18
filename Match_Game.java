
/**
 * Write a description of class Match_Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Match_Game
{
    static boolean ynBoolean(String ynAnswer, boolean tOrF)
    {
        if (ynAnswer.equals("yes") || ynAnswer.equals("Yes") || ynAnswer.equals("YES") || ynAnswer.equals("Y") || ynAnswer.equals("y"))
            {
                tOrF = true;
            }
            else if (ynAnswer.equals("no") || ynAnswer.equals("No") || ynAnswer.equals("NO") || ynAnswer.equals("N") || ynAnswer.equals("n"))
            {
                tOrF = false;
            }
            else
            {
                System.out.println("Input not recognized; playing tutorial");
                System.out.println(" ");
            }
        return tOrF;
    }
    static void tutorial(boolean tOrF)
    {
        if (tOrF)
        {
            System.out.println("Displaying: Tutorial");
            System.out.println(" ");
            System.out.println("The goal of Memory Match is to correctly pair corresponding");
            System.out.println("symbols. In this game, you will be shown a 5x4 board, with");
            System.out.println("a total of 10 different symbols. In order to guess corresponding");
            System.out.println("symbols, you will guess two grid positions, whose symbols will be");
            System.out.println("temporarily revealed to you. Can you memorize the positions of the");
            System.out.println("symbols so you can correctly match them?");
            System.out.println(" ");
            System.out.println("Good luck! Enjoy Memory Match!");
            System.out.println(" ");
        }
    }
    //create board
    //REMEMBER TO PRINT GRIDWHOLE BY COMBINING W/ CARDGRID
    static void print(String[][] cardGrid, String[][] gridWhole, String[] horizontalCoords, String[] verticalCoords)
    {
        for (int j = 1; j < 6; j++)
        {
            gridWhole[0][j] = horizontalCoords[j];
        }
        
        for (int s = 1; s < 5; s++)
        {
            gridWhole[s][0] = verticalCoords[s];
        }
        
        for (int a = 1; a < 5; a++)
        {
            for (int b = 1; b < 6; b++)
            {
                gridWhole[a][b] = cardGrid[a-1][b-1];
            }
        }
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                System.out.print(gridWhole[i][j] + "     ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }
    static void randomSpace()
    {
        
    }
    //ask user
    static void userGuess()
    {
        
    }
    static void revealSymbols()
    {
        
    }
    static void matched()
    {
        
    }
    //main code
    public static void main(String[] args)
    {
        boolean play = true;
        do {
            Scanner input = new Scanner(System.in);
            
            String ynAnswer;
            boolean tOrF = false;
            
            String[] horizontalCoords = {" ", "1 ", "2 ", "3 ", "4 ", "5"};
            String[] verticalCoords = {" ", "A", "B", "C", "D"};
            String[][] gridSymbols = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
            String[][] cardGrid = {{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"}};
            String[][] gridWhole = {{" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}};
            
            String symbol1 = "♕";
            String symbol2 = "♫";
            String symbol3 = "★";
            String symbol4 = "☀";
            String symbol5 = "▲";
            String symbol6 = "☾";
            String symbol7 = "♣";
            String symbol8 = "♦";
            String symbol9 = "♥";
            String symbol10 = "♠";
            
            System.out.println("Welcome to Memory Match!");
            System.out.println(" ");
            System.out.println("Would you like a tutorial of how to play? (Type \"yes\" or \"no\")");
            ynAnswer = input.next();
            
            if (ynAnswer.equals("yes") || ynAnswer.equals("Yes") || ynAnswer.equals("YES") || ynAnswer.equals("Y") || ynAnswer.equals("y"))
            {
                tOrF = true;
            }
            else if (ynAnswer.equals("no") || ynAnswer.equals("No") || ynAnswer.equals("NO") || ynAnswer.equals("N") || ynAnswer.equals("n"))
            {
                tOrF = false;
            }
            else
            {
                System.out.println("Input not recognized; playing tutorial");
                System.out.println(" ");
            }
            
            tutorial(tOrF);
            
            
            //print board
            print(cardGrid, gridWhole, horizontalCoords, verticalCoords);
            
            //assign symbols to grid spaces
            
            //LOOP ask user to pick two grid spaces
            //      reveal what is under the spaces
            
            //user matches all symbols
            
            System.out.println("Would you like to play again? (Type \"yes\" or \"no\")");
            ynAnswer = input.next();
            if (ynAnswer.equals("yes") || ynAnswer.equals("Yes") || ynAnswer.equals("YES") || ynAnswer.equals("Y") || ynAnswer.equals("y"))
            {
                play = true;
            }
            else if (ynAnswer.equals("no") || ynAnswer.equals("No") || ynAnswer.equals("NO") || ynAnswer.equals("N") || ynAnswer.equals("n"))
            {
                play = false;
            }
        } while (play);
    }
}

/**
 * NOTES
 * 
 * 5x4 board - grid spaces (cards) marked with: ☐
 * assign two of the same objects to random grid spaces
 *      assign to random spaces: 4 random number generators (2 for each symbol), NO duplicate numbers - if number =  (any previous number) then repeat the generator until a new number appears
 *      objects: ♕ (crown), ♫ (music note), ★ (star), ☀ (sun), ▲ (triangle), ☾️(moon), ♣ (clubs), ♦️(diamonds), ♥ (heart), ♠ (spades)
 * 
 * !
 * ask the user to pick two grid spaces
 * reveal the symbol that lies beneath the cards (reprint the board with the symbols in their respective positions)
 *      if the symbols match, print "You matched two cards!"
 * ask the user to type anything when they are done memorizing the positions of the symbols
 *      if the symbols matched, replace the grid positions with "-"
 * 
 * (repeat from "!" until all cards are matched)
 * 
 * congrats you win! 🏆
 */