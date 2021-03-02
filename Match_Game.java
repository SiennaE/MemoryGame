


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
    static void printSymbols(String[][] cardGrid, String[][] gridWhole, String[] horizontalCoords, String[] verticalCoords, String letterGuess1, String letterGuess2, int numberGuess1, int numberGuess2, int letter1, int letter2, String[][] gridSymbols)
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
        
        gridWhole[letter1][numberGuess1] = gridSymbols[letter1-1][numberGuess1-1];
        gridWhole[letter2][numberGuess2] = gridSymbols[letter2-1][numberGuess2-1];
        
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
    //change so if grid symbols !" " then repeat the random number generator
    static String[][] randomSpace(String[] symbols, String[] letters, String[][] gridSymbols, String[][] duplicate)
    {
        int counter = 0;
        
        String lettersString;
        int letterCoords;
        String numbersString;
        int numberCoords;
        String symbolSpace;
        String[] noNoSpaces = {"0","0","0"};
        int v = 0;
        
        while (counter < 10)
        {
            int x = 0;
            while (x < 2)
            {
                do
                {
                    letterCoords = (int)(Math.random()*((4-1)+1)) +1;
                    lettersString = letters[letterCoords];
                    
                    numberCoords = (int)(Math.random() * ((5-1)+1)) +1;
                    numbersString = String.valueOf(numberCoords);
                    
                    gridSymbols[letterCoords][numberCoords] = symbols[v];
                    duplicate[counter][0] = lettersString + numbersString;
                } while (duplicate.equals(noNoSpaces[0]) || duplicate.equals(noNoSpaces[1]));
                x++;
            }
                
            noNoSpaces[v] = gridSymbols[counter][0];
            v++;
                
            counter++;
        }
        
        return gridSymbols;
    }
    //ask user
    static void revealSymbols(String ready, Scanner input, String letterGuess1, String letterGuess2, int numberGuess1, int numberGuess2, int letter1, int letter2, String[][] gridSymbols, String[] verticalCoords, String[] horizontalCoords, String[][] gridWhole, String[][] cardGrid)
    {
        if (letterGuess1.equals("A"))
        {
            letter1 = 1;
        }
        else if (letterGuess1.equals("B"))
        {
            letter1 = 2;
        }
        else if (letterGuess1.equals("C"))
        {
            letter1 = 3;
        }
        else if (letterGuess1.equals("D"))
        {
            letter1 = 4;
        }
        if (letterGuess2.equals("A"))
        {
            letter2 = 1;
        }
        else if (letterGuess2.equals("B"))
        {
            letter2 = 2;
        }
        else if (letterGuess2.equals("C"))
        {
            letter2 = 3;
        }
        else if (letterGuess2.equals("D"))
        {
            letter2 = 4;
        }
        
        printSymbols(cardGrid, gridWhole, horizontalCoords, verticalCoords, letterGuess1, letterGuess2, numberGuess1, numberGuess2, letter1, letter2, gridSymbols);
        
        if (gridSymbols[letter1-1][numberGuess1-1].equals(gridSymbols[letter2][numberGuess2]))
        {
            System.out.println("Congrats! You found a pair.");
        }
        
        System.out.println("Type anything when you are ready to continue");
        ready = input.next();
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
            String letterGuess1;
            int letter1 = 0;
            int numberGuess1;
            String letterGuess2;
            int letter2 = 0;
            int numberGuess2;
            String ready = " ";
            int countMatch = 0;
            
            String[] horizontalCoords = {" ", "1 ", "2 ", "3 ", "4 ", "5"};
            String[] verticalCoords = {" ", "A", "B", "C", "D"};
            //hidden board containing the locations of the symbols
            String[][] gridSymbols = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
            //just for show
            String[][] cardGrid = {{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"}};
            //print the coordinates and boxes
            String[][] gridWhole = {{" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}};
            //make sure no repeating spaces (maybe delete later)
            String[][] duplicate = {{" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}};
            
            String[] symbols = {"♕", "♫", "★", "☀", "▲", "☾", "♣", "♦", "♥", "♠"};
            
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
            //randomSpace(symbols,letters,gridSymbols,duplicate);
            
            //LOOP ask user to pick two grid spaces
            //      reveal what is under the spaces
            
            //do {
                System.out.println("Guess two spaces to compare by inputting a combination of vertical and horizontal coordinates.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Space 1");
                System.out.println(" ");
                System.out.print("Vertical Coordinate (capital letter A-D): ");
                letterGuess1 = input.next();
                System.out.print("Horizontal Coordinate (number 1-5): ");
                numberGuess1 = input.nextInt();
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Space 2");
                System.out.println(" ");
                System.out.print("Vertical Coordinate (capital letter A-D): ");
                letterGuess2 = input.next();
                System.out.print("Horizontal Coordinate (number 1-5): ");
                numberGuess2 = input.nextInt();
                
                revealSymbols(ready,input,letterGuess1,letterGuess2,numberGuess1,numberGuess2,letter1,letter2,gridSymbols,verticalCoords,horizontalCoords,gridWhole,cardGrid);
            //} while ();
            
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