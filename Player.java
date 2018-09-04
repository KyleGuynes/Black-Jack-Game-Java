
package kyle.s.excellent.blackjack.game;


public class Player {
    
    private String nameKRG;
    
    private Card[] handKRG = new Card[10];
    
    private int numCardsKRG;
    
    
    
    public Player(String aName)
    {
        nameKRG = aName;
        
        emptyHand();
    }
    
    public void emptyHand()
    {
        for (int c = 0; c < 10; c++)
        {
            handKRG[c] = null;
        }
        numCardsKRG = 0;
    }
    
    public boolean addCard(Card aCard)
    {
        if (numCardsKRG == 10)
        {
            System.out.println(nameKRG + "'s hand already has 10 cards ; " +
                    "cannot add another");//Set to labal or text ****************
        }
        
        handKRG[numCardsKRG] = aCard;
        numCardsKRG++;
        
        return (getHandSum() <= 21);
    }
    
    public int getHandSum()
    {
        int handSum = 0;
        int cardNum;
        int numAces = 0;
        
        for (int c = 0; c < numCardsKRG; c++)
        {
            cardNum = handKRG[c].getNumber();
            
            if (cardNum == 1)
            {
                numAces++;
                handSum += 11;
                
            }else if (cardNum > 10)
            {
                handSum += 10;
            }else
            {
                handSum += cardNum;
            }
        }
        
        while (handSum > 21 && numAces > 0)
        {
            handSum -= 10;
            numAces--;
        }
        
        return handSum;
    }
    
    public void printHand(boolean showFirstCard)
    {
        System.out.println(nameKRG + " cards:");//Set to labal or text ****************
        
        
        for (int c = 0; c < numCardsKRG; c++)
        {
            if (c == 0 && !showFirstCard)
            {
                System.out.println(" [hidden]");//Set to labal or text ****************
                
            }else
            {
                System.out.println(" " + handKRG[c].toString());//Set to labal or text ****************
                
            }
            
        }
        System.out.println(" ");
    }
}
