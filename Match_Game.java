
/**
 * Write a description of class Match_Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Match_Game
{
    //create board
    //REMEMBER TO PRINT GRIDWHOLE BY COMBINING W/ CARDGRID
    static void print(String[][] cardGrid)
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(cardGrid[i][j] + "     ");
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
        Scanner input = new Scanner(System.in);
        
        String[] horizontalCoords = {" ", "1", "2", "3", "4", "5"};
        String[] verticalCoords = {"A", "B", "C", "D"};
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
        
        //print board
        print(cardGrid);
        
        //assign symbols to grid spaces
        
        //LOOP ask user to pick two grid spaces
        //      reveal what is under the spaces
        
        //user matches all symbols
        
        //replay game?
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