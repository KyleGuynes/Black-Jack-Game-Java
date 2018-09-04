
package kyle.s.excellent.blackjack.game;

import java.util.Random;

public class Deck {
        private Card [] myCardsKRG;
        private int numCardsKRG;
        
        public Deck(int numDecks, boolean shuffle)
        {
            numCardsKRG = numDecks * 52;
            myCardsKRG = new Card[numCardsKRG];
            int c = 0;
            
            for (int s = 0; s < 4; s++)
            {
                for (int n = 1; n <= 13; n++)
                {
                    myCardsKRG[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }
            //////////////////////could probobaly delete the this. stuff
            
            if (shuffle == true)
            {
                shuffle();
            }
        }
        
        public void shuffle()
        {
            Random rng = new Random();
            
            Card temp;
            
            int j;
            for (int i = 0; i < numCardsKRG; i++)
            {
                j = rng.nextInt(numCardsKRG);
                
                temp = myCardsKRG[i];
                myCardsKRG[i] = myCardsKRG[j];
                myCardsKRG[j] = temp;
            }
        }
        
        public Card dealNextCard() 
        {
            Card top = myCardsKRG[0];
            
            for (int c = 1; c < numCardsKRG; c++)
            {
                myCardsKRG[c-1] = myCardsKRG[c];
            }
            myCardsKRG[numCardsKRG-1] = null;
            
            numCardsKRG--;
            
            return top;
            
        }
        
        public void printDeck(int numToPrint)
        {
            for (int c = 0; c < numToPrint; c++)
            {
                System.out.println(c+1 + numCardsKRG + myCardsKRG[c].toString());//If i wanted to print the deck
            }
            System.out.println(numCardsKRG-numToPrint);//if i wanted to print the deck
        }
}
