package com.tzeloonneoh;

import java.util.*;

/**
 * Class Game will display all the menus, accept user responses, and
 * perform requested operations.
 * @author (Tze Loon Neoh)
 * @version (26 Aug 2021)
 */
public class Game
{
    private Player players;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        players = new Player();
    }

    public int castStringToInteger(String string)
    {
        int integer = Integer.parseInt(string);
        return integer;
    }

    public boolean checkCharacterIsDigit(char character)
    {
        return Character.isDigit(character);
    }

    public boolean checkStringIsEmpty(String string)
    {
        return string.isEmpty();
    }

    public boolean checkStringIsNumeric(String string)
    {
        int idx = 0;

        while (idx < string.length())
        {
            char character = string.charAt(idx);
            if (!checkCharacterIsDigit(character))
                return false;
            idx++;
        }
        return true;
    }

    public void getHelp()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("\nNumber Guessing Game - HELP Page");
        System.out.println("====================================================" +
                "=============================");
        System.out.println("Aim:");
        System.out.println("Your goal is to take a guess of what number between " +
                "1 and 50 has been randomly \ngenerated by the computer.");
        System.out.println("\nHow To Start: [Option (1)]");
        System.out.println("First, set yourself up as a new player by choosing " +
                "Option (1) and then enter your \nname when prompted.");
        System.out.println("Caution: \nChoosing this option in the middle of a game " +
                "will RESET ALL of the current \nplayer’s information " +
                "including remaining credit(s) to ZERO.");
        System.out.println("\nHow To Play:");
        System.out.println("Credits Needed [Option (2)]");
        System.out.println("Add some credits to your account to start playing the " +
                "guessing game by choosing \nOption (2).");
        System.out.println("You can decide to add between 1 and 20 credits but " +
                "ensure that you have at \nleast 5 credits to start " +
                "playing.");
        System.out.println("\nPlay Game [Option (3)]");
        System.out.println("Choose Option (3) to start a game.");
        System.out.println("You have a maximum of 3 chances to make your guess. " +
                "Your guess(es) must be a \nnumber between 1 and 50.");
        System.out.println("Caution: \nAny guesses out of the range of 1 to 50 is " +
                "considered ONE wrong guess.");
        System.out.println("\nThe rules are as follows:");
        System.out.println("┌───────────────────────────────────────────" +
                "───────────────────────┐");
        System.out.println("│ CORRECT on 1st Guess          ││ You win $15     " +
                "                            │");
        System.out.println("├───────────────────────────────────────────" +
                "───────────────────────┤");
        System.out.println("│ CORRECT on 2nd Guess          ││ You win $10     " +
                "                            │");
        System.out.println("├───────────────────────────────────────────" +
                "───────────────────────┤");
        System.out.println("│ CORRECT on 3rd Guess          ││ You win $5      " +
                "                            │");
        System.out.println("├───────────────────────────────────────────" +
                "───────────────────────┤");
        System.out.println("│ WRONG on ALL Guess BUT        ││ You win a random " +
                "consolation prize ($1 - $5)│");
        System.out.println("│ your guess = lucky number ± 5 ││                 " +
                "                            │");
        System.out.println("├───────────────────────────────────────────" +
                "───────────────────────┤");
        System.out.println("│ WRONG on All Guesses          ││ You lose $5     " +
                "                            │");
        System.out.println("└───────────────────────────────────────────" +
                "───────────────────────┘");
        System.out.println("\nWin-Loss Statistics [Option (4)]");
        System.out.println("Choose Option (4) to display your current win-loss " +
                "statistics, i.e., wins, \nlosses, amount of credit(s) " +
                "left, amount of credit(s) won, amount of credit(s) " +
                "\nlost, and percentage of wins.");
        System.out.println("\nHow To Exit Game: [Option (6)]");
        System.out.println("Choose Option (6) to exit game and ALL your information " +
                "will be CLEARED.");
        System.out.println("\nGOOD LUCK!!!");
        System.out.println("\nPlease hit 'ENTER' to exit help.");
        console.nextLine();
    }

    public void guessPrompt(String prompt, int count)
    {
        System.out.print("Sorry, you need to go " + (prompt) +
                " (" + (count + 1) + " of 3 guesses): ");
    }

    public void menuDisplay()
    {
        System.out.println("v(^-^)v Welcome to the Number Guessing Game v(^-^)v");
        System.out.println("===================================================");
        System.out.println("(1) Set Up New Player");
        System.out.println("(2) Insert Credit");
        System.out.println("(3) Play One Round");
        System.out.println("(4) Display Player Statistics");
        System.out.println("(5) Display Game Help");
        System.out.println("(6) Exit Game");
        System.out.print("Please choose an option from 1 to 6: ");
    }

    public void playerBingo(int amountWon)
    {
        players.setCredit(amountWon);
        players.setWinnings(amountWon);
        System.out.println("Congratulations!!! You WON $" + amountWon + "!\n");
    }

    public void playerExit()
    {
        players.resetPlayerToDefault();
        System.out.println("\nPlease come back and play again!\n");
    }

    public void playerGuessNumber()
    {
        Scanner console = new Scanner(System.in);
        int count = 1;
        String strPlayerPick = "";
        int playerPick = 0;
        int luckyNumber = LuckyNumberGenerator.generateNumber(50);
        System.out.print("\nEnter a number between 1-50 (1 of 3 guesses): ");

        while (count < 4)
        {
            strPlayerPick = console.nextLine();
            if (checkStringIsNumeric(strPlayerPick) &&
                    !checkStringIsEmpty(strPlayerPick))
            {
                playerPick = castStringToInteger(strPlayerPick);
                if (playerPick >= 0 && playerPick <= 50)
                {
                    if (luckyNumber == playerPick)
                    {
                        showResult(luckyNumber, playerPick);
                        players.setWin(1);
                        switch (count)
                        {
                            case 1:
                                playerBingo(15); break;
                            case 2:
                                playerBingo(10); break;
                            case 3:
                                playerBingo(5); break;
                        }
                        count = 4;
                    }
                    else
                    if (luckyNumber > playerPick && count < 3)
                        guessPrompt("HIGHER", count);
                    else if (luckyNumber < playerPick && count < 3)
                        guessPrompt("LOWER", count);
                }
                else
                {
                    if (count < 3)
                    {
                        System.out.println("Entry out of range!");
                        System.out.print("Enter a number between 1-50 (" +
                                (count + 1) + " of 3 guesses): ");
                    }
                }
                count++;
            }
            else
            {
                if (count < 3)
                    System.out.print("Invalid entry! (" + (count + 1) +
                            " of 3 guesses): ");
                playerPick = 0;
                count++;
            }
        }

        if ((count == 4) &&
                (playerPick != luckyNumber))
        {
            showResult(luckyNumber, playerPick);
            if (Math.abs(playerPick - luckyNumber) < 5 && playerPick != 0)
            {
                int consolationPrize = LuckyNumberGenerator.generateNumber(5);
                players.setCredit(consolationPrize);
                players.setWinnings(consolationPrize);
                players.setWin(1);
                System.out.println("You won a random consolation prize of $" +
                        consolationPrize + "!\n");
            }
            else
            {
                players.loseCredit(5);
                players.setLosings(5);
                players.setLoss(1);
                System.out.println("Sorry, better luck next time!\n");
            }
        }
    }

    public void showResult(int luckyNumber, int playerPick)
    {
        if (playerPick == 0)
            System.out.println("\nLucky Number was: " + luckyNumber +
                    ", your final guess was: Invalid input\n");
        else
            System.out.println("\nLucky Number was: " + luckyNumber +
                    ", your final guess was: " + playerPick + "\n");
    }

    public void startPlay()
    {
        int playerChoice = 0;
        String playerName = players.getName();

        do
        {
            menuDisplay();
            playerName = players.getName();
            playerChoice = userInputInteger();

            switch (playerChoice)
            {
                case 1:
                    players.resetPlayerToDefault();
                    System.out.print("\nPlease enter player's name: ");
                    players.setName();
                    System.out.print("\n"); break;
                case 2:
                    if (playerName.equals(""))
                        System.out.println("\nError: player has not been set " +
                                "up!\n");
                    else
                    {
                        System.out.print("\nPlease enter a credit amount " +
                                "between 1-20: ");
                        int newCredit = userInputInteger();
                        if (newCredit >= 1 && newCredit <= 20)
                        {
                            players.setCredit(newCredit);
                            System.out.print("\n");
                        }
                        else
                            System.out.println("\nError: only enter a number " +
                                    "between 1-20!\n");
                    }
                    break;
                case 3:
                    if (playerName.equals(""))
                        System.out.println("\nError: player has not been set up!\n");
                    else
                    {
                        int playerCredit = players.getCredit();
                        if (playerCredit == 0)
                            System.out.println("\nError: player has no credit!\n");
                        else if (playerCredit < 5)
                        {
                            System.out.println("\nError: a minimum of 5 credit is " +
                                    "required to play!\n");
                            System.out.println("Add " + (5 - playerCredit) +
                                    " more credits.\n");
                        }
                        else
                        {
                            playerGuessNumber();
                        }
                    }
                    break;
                case 4:
                    if (playerName.equals(""))
                        System.out.println("\nError: player has not been set up!\n");
                    else
                        players.displayStatistics();
                    break;
                case 5:
                    getHelp(); break;
                case 6:
                    playerExit(); break;
                default:
                    System.out.println("\nError: Invalid input!\n"); break;
            }
        } while (playerChoice != 6);
    }

    public int userInputInteger()
    {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        while (true)
        {
            System.out.println("\nError: Invalid input!\n");
            System.out.print("Please enter a valid number: ");
            input = console.nextLine();
            if (checkStringIsNumeric(input) && !checkStringIsEmpty(input))
                break;
        }
        return castStringToInteger(input);
    }
}