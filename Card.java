
package kyle.s.excellent.blackjack.game;


public class Card {
    private Suit mySuitKRG;
        
        private int myNumberKRG;
        
        public Card(Suit aSuit, int aNumber)
        {
            mySuitKRG = aSuit;
            
            while (aNumber < 1 && aNumber > 13)
            {
                System.out.println(aNumber + "is not a valid number");//Set to labal or text ****************
            }
                myNumberKRG = aNumber;
            
        }
        
        public int getNumber()
        {
            return myNumberKRG;
        }
        
        public String toString()
        {
            String numStrKRG = "null";
            
            switch(myNumberKRG)
            {
                case 2:
                    numStrKRG = "Two";
                    break;
                    
                case 3:
                    numStrKRG = "Three";
                    break;
                    
                case 4:
                    numStrKRG = "Four";
                    break;
                    
                case 5:
                    numStrKRG = "Five";
                    break;
                    
                case 6:
                    numStrKRG = "Six";
                    break;
                    
                case 7:
                    numStrKRG = "Seven";
                    break;
                    
                case 8:
                    numStrKRG = "Eight";
                    break;
                    
                case 9:
                    numStrKRG = "Nine";
                    break;
                    
                case 10:
                    numStrKRG = "Ten";
                    break;
                    
                case 11:
                    numStrKRG = "Jack";
                    break;
                    
                case 12:
                    numStrKRG = "Queen";
                    break;
                    
                case 13:
                    numStrKRG = "King";
                    break;
                    
                case 1:
                    numStrKRG = "Ace";
                    break;
 
            }
            
            return numStrKRG + " of " + mySuitKRG.toString();
        }
        
}
