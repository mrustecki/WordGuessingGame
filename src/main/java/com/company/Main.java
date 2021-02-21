package com.company;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import static com.company.WebWordScrapper.getRandomWord;

//to do: display the word with one initial letter revealed
//continue the game unless user presses [escape]

public class Main {

    public static void main(String[] args){

        String secretWord = getRandomWord("");
        //String secretWord = "recommendation";

        int triesLeftCounter = 5;

        ArrayList<Character> letters = new ArrayList<Character>(); //our container for all the letters user is providing
        boolean letterMatch = false;
        char c = 'a';
        boolean isLetterInTheSecretWord;
        boolean unrevealedLetter;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a letter and hit enter");
            unrevealedLetter = false;

            isLetterInTheSecretWord = false;
            char usersLetter = scan.next().charAt(0);
            letters.add(usersLetter);

            for(int i=0;i< secretWord.length();i++){
                if(usersLetter == secretWord.charAt(i)){
                    isLetterInTheSecretWord = true;
                    break;
                }
            }

            if(!isLetterInTheSecretWord) triesLeftCounter--;

            //add the char to a list
            for(int i=0;i< secretWord.length();i++){
                for(int listItem = 0;listItem < letters.size();listItem++){
                    c = letters.get(listItem);
                    if(c == secretWord.charAt(i)){ //
                        letterMatch = true;
                        break;
                    }
                    else { 
                        letterMatch = false;
                    }
                }
                if(letterMatch){
                    System.out.print(c + " ");

                }else{
                    System.out.print("_ ");
                    unrevealedLetter = true;
                }
            }
            System.out.println("\n" + "tries left: " + triesLeftCounter);
            if(triesLeftCounter==0){
                System.out.println("You lost, you human toilet! *** " + secretWord.toUpperCase(Locale.ROOT) + " *** was the word.");
            }

            //check if there are any letters left to guess
            if(!unrevealedLetter){
                System.out.println("Congratulations! You won.");
                break;
            }
        } while (triesLeftCounter>0);
    }
}
