/**
 * Remember the locations of symbols on a grid and pair them to win.
 *
 * @author (Sienna)
 * @version (1.0)
 */

import java.util.Scanner;

public class Match_Game
{
    static void clear()
    {
        System.out.print('\u000C');
    }
    
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
    
    static String[][] randomSpace(String[] symbols, String[] verticalCoords, String[][] gridSymbols, String[][] duplicate)
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
                    letterCoords = (int)(Math.random()*((3-0) +1)) + 0;
                    //lettersString = verticalCoords[letterCoords];
                    
                    numberCoords = (int)(Math.random()*((4-0)+1))+0;
                    //numbersString = String.valueOf(numberCoords);
                    
                } while (gridSymbols[letterCoords][numberCoords].equals(symbols[0]) || gridSymbols[letterCoords][numberCoords].equals(symbols[1]) || gridSymbols[letterCoords][numberCoords].equals(symbols[2]) || gridSymbols[letterCoords][numberCoords].equals(symbols[3]) || gridSymbols[letterCoords][numberCoords].equals(symbols[4]) || gridSymbols[letterCoords][numberCoords].equals(symbols[5]) || gridSymbols[letterCoords][numberCoords].equals(symbols[6]) || gridSymbols[letterCoords][numberCoords].equals(symbols[7]) || gridSymbols[letterCoords][numberCoords].equals(symbols[8]) || gridSymbols[letterCoords][numberCoords].equals(symbols[9]));
                gridSymbols[letterCoords][numberCoords] = symbols[v];
                
                x++;
            }
            
            v++;
                
            counter++;
        }
        
        return gridSymbols;
    }
    
    static void matchedAll()
    {
        System.out.println("Congrats! You successfully matched all the cards.");
    }
    //main code
    public static void main(String[] args)
    {
        boolean play = true;
        do {
            Scanner input = new Scanner(System.in);
            
            String ynAnswer;
            boolean tOrF = false;
            String letterGuess1 = " ";
            int letter1 = 0;
            String numberGuess1s;
            int numberGuess1 = 0;
            String letterGuess2 = " ";
            int letter2 = 0;
            String numberGuess2s;
            int numberGuess2 = 0;
            String ready = " ";
            int countMatch = 0;
            int matched = 0;
            
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
            
            clear();
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
                tOrF = true;
                System.out.println("Input not recognized; playing tutorial");
                System.out.println(" ");
            }
            
            
            tutorial(tOrF);
            
            System.out.println("Type anything when you are ready to continue");
            ready = input.next();
            
            //assign symbols to grid spaces
            randomSpace(symbols,verticalCoords,gridSymbols,duplicate);
            
            do {
                clear();
                //print board
                print(cardGrid, gridWhole, horizontalCoords, verticalCoords);
                
                System.out.println("Guess two spaces to compare by inputting a combination of vertical and horizontal coordinates.");
                
                do {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Space 1");
                    System.out.println(" ");
                    System.out.print("Vertical Coordinate (letter A-D): ");
                    letterGuess1 = input.next();
                    System.out.print("Horizontal Coordinate (number 1-5): ");
                    numberGuess1s = input.next();
                    if (numberGuess1s.equals("1"))
                    {
                        numberGuess1 = 1;
                    }
                    else if (numberGuess1s.equals("2"))
                    {
                        numberGuess1 = 2;
                    }
                    else if (numberGuess1s.equals("3"))
                    {
                        numberGuess1 = 3;
                    }
                    else if (numberGuess1s.equals("4"))
                    {
                        numberGuess1 = 4;
                    }
                    else if (numberGuess1s.equals("5"))
                    {
                        numberGuess1 = 5;
                    }
                    else
                    {
                        numberGuess1 = 6;
                    }
                    if (letterGuess1.equals("A") || letterGuess1.equals("a"))
                    {
                        letter1 = 1;
                    }
                    else if (letterGuess1.equals("B") || letterGuess1.equals("b"))
                    {
                        letter1 = 2;
                    }
                    else if (letterGuess1.equals("C") || letterGuess1.equals("c"))
                    {
                        letter1 = 3;
                    }
                    else if (letterGuess1.equals("D") || letterGuess1.equals("d"))
                    {
                        letter1 = 4;
                    }
                    else
                    {
                        letter1 = 5;
                    }
                    
                    if (letter1==5 || numberGuess1==6)
                    {
                        clear();
                        print(cardGrid, gridWhole, horizontalCoords, verticalCoords);
                        System.out.println("Input for Space 1 is not recognized. Please re-enter the coordinates.");
                    }
                } while (letter1==5 || numberGuess1==6);
                System.out.println(" ");
                do {
                    System.out.println(" ");
                    System.out.println("Space 2");
                    System.out.println(" ");
                    System.out.print("Vertical Coordinate (letter A-D): ");
                    letterGuess2 = input.next();
                    System.out.print("Horizontal Coordinate (number 1-5): ");
                    numberGuess2s = input.next();
                    if (numberGuess2s.equals("1"))
                    {
                        numberGuess2 = 1;
                    }
                    else if (numberGuess2s.equals("2"))
                    {
                        numberGuess2 = 2;
                    }
                    else if (numberGuess2s.equals("3"))
                    {
                        numberGuess2 = 3;
                    }
                    else if (numberGuess2s.equals("4"))
                    {
                        numberGuess2 = 4;
                    }
                    else if (numberGuess2s.equals("5"))
                    {
                        numberGuess2 = 5;
                    }
                    else
                    {
                        numberGuess2 = 6;
                    }
                    if (letterGuess2.equals("A") || letterGuess2.equals("a"))
                    {
                        letter2 = 1;
                    }
                    else if (letterGuess2.equals("B") || letterGuess2.equals("b"))
                    {
                        letter2 = 2;
                    }
                    else if (letterGuess2.equals("C") || letterGuess2.equals("c"))
                    {
                        letter2 = 3;
                    }
                    else if (letterGuess2.equals("D") || letterGuess2.equals("d"))
                    {
                        letter2 = 4;
                    }
                    else
                    {
                        letter2 = 5;
                    }
                    
                    if (letter2==5 || numberGuess2==6)
                    {
                        clear();
                        print(cardGrid, gridWhole, horizontalCoords, verticalCoords);
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Space 1");
                        System.out.println(" ");
                        System.out.println("Vertical Coordinate (letter A-D): " + letterGuess1);
                        System.out.println("Horizontal Coordinate (number 1-5): " + numberGuess1s);
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Input for Space 2 is not recognized. Please re-enter the coordinates.");
                        System.out.println(" ");
                    }
                } while (letter2==5 || numberGuess2==6);
                
                printSymbols(cardGrid, gridWhole, horizontalCoords, verticalCoords, letterGuess1, letterGuess2, numberGuess1, numberGuess2, letter1, letter2, gridSymbols);
        
                if (gridSymbols[letter1-1][numberGuess1-1].equals(gridSymbols[letter2-1][numberGuess2-1]))
                {
                    matched++;
                    if (matched<10)
                    {
                        System.out.println("Congrats! You found a pair.");
                    }
                    cardGrid[letter1-1][numberGuess1-1] = " X";
                    cardGrid[letter2-1][numberGuess2-1] = " X";
                }
                
                if (matched==10)
                {
                    break;
                }
                System.out.println("Type anything when you are ready to continue");
                ready = input.next();
            } while (matched != 10);
            
            //user matches all symbols
            matchedAll();
            System.out.println(" ");
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
            else
            {
                play = false;
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Input not recogized; ending program");
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
 * congrats you win!🏆
 */