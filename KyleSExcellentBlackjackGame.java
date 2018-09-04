/*
This game is a black jack game 

*/
package kyle.s.excellent.blackjack.game;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KyleSExcellentBlackjackGame extends JFrame implements ActionListener {

    JButton HitKRG = new JButton("Hit");
    JButton StayKRG = new JButton("Stay");
    JButton DealKRG = new JButton("Deal");
    JLabel PlayerNameKRG = new JLabel("Player's Cards");
    JLabel DealerNameKRG = new JLabel("Dealer's Cards");
    JLabel CardsDealtKRG = new JLabel(" ");
    JLabel HitorStayKRG = new JLabel(" ");
    JLabel DealerHitKRG = new JLabel(" ");
    JLabel DealerStaysKRG = new JLabel(" ");
    JLabel PlayerWinsKRG = new JLabel(" ");
    JLabel DealerWinsKRG = new JLabel(" ");
    Deck theDeckKRG;
    Player meKRG = new Player("Player");
    Player dealerKRG = new Player("Dealer");
    boolean meDoneKRG = false;
    boolean dealerDoneKRG = false;
    JLabel myHandKRG = new JLabel(" ");
    JLabel BustedKRG = new JLabel(" ");
        
    
    public KyleSExcellentBlackjackGame()
    {
        Font fontWinKRG = new Font("Verdana", Font.BOLD, 30);
        Font normalFontKRG = new Font("Times Roman", Font.PLAIN, 15);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        panel.setPreferredSize(new Dimension(1000, 500));
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);
        this.setResizable(false);
        pack();
        
        setTitle("Kyle's Excellent BlackJack Game");
        panel.add(HitKRG);
        HitKRG.setBounds(0, 0, 200, 200);
        HitKRG.setFont(normalFontKRG);
        HitKRG.setEnabled(false);
        
        panel.add(StayKRG);
        StayKRG.setBounds(800, 0, 200, 200);
        StayKRG.setFont(normalFontKRG);
        StayKRG.setEnabled(false);
        
        panel.add(DealKRG);
        DealKRG.setBounds(900, 400, 100, 100);
        DealKRG.setFont(normalFontKRG);
        
        HitKRG.addActionListener(this);
        StayKRG.addActionListener(this);
        DealKRG.addActionListener(this);
        
        panel.add(PlayerNameKRG);
        PlayerNameKRG.setBounds(200, 200, 100, 100);
        PlayerNameKRG.setFont(normalFontKRG);
        
        panel.add(DealerNameKRG);
        DealerNameKRG.setBounds(600, 200, 100, 100);
        DealerNameKRG.setFont(normalFontKRG);
        
        panel.add(CardsDealtKRG);
        CardsDealtKRG.setBounds(400, 0, 300, 100);
        CardsDealtKRG.setFont(normalFontKRG);
        
        panel.add(HitorStayKRG);
        HitorStayKRG.setBounds(370, 40, 300, 100);
        HitorStayKRG.setFont(normalFontKRG);
        
        panel.add(DealerHitKRG);
        panel.add(DealerStaysKRG);
        panel.add(PlayerWinsKRG);
        PlayerWinsKRG.setBounds(500, 250, 300, 300);
        PlayerWinsKRG.setFont(fontWinKRG);
        
        panel.add(DealerWinsKRG);
        panel.add(myHandKRG);
        panel.add(BustedKRG);
        BustedKRG.setBounds(500, 250, 300, 300);
        BustedKRG.setFont(fontWinKRG);
        
    }
     
    public static void main(String[] args) {
        
        KyleSExcellentBlackjackGame KRG = new KyleSExcellentBlackjackGame();
        KRG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KRG.setVisible(true);
        KRG.pack();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        int mySum;
        int dealerSum;
        
        if (e.getSource().toString().contains("Deal"))
        {
            meKRG.emptyHand();
            dealerKRG.emptyHand();
            meDoneKRG = false;
            dealerDoneKRG = false;
            BustedKRG.setText(" ");
            
            theDeckKRG = new Deck(1, true);
            meKRG.addCard(theDeckKRG.dealNextCard());
            
            dealerKRG.addCard(theDeckKRG.dealNextCard());
            meKRG.addCard(theDeckKRG.dealNextCard());
            dealerKRG.addCard(theDeckKRG.dealNextCard());
            
            System.out.println("****************");
            System.out.println("Cards are dealt");// //Set to labal or text
            System.out.println("****************\n");
            CardsDealtKRG.setText("Cards are Dealt");
            
            
            meKRG.printHand(true);
            dealerKRG.printHand(false);
            
            System.out.println("Do you want to hit or stay\n");
            HitorStayKRG.setText("Do you want to hit or Stay?");
            DealKRG.setEnabled(false);
            HitKRG.setEnabled(true);
            StayKRG.setEnabled(true);
        }

        if (e.getSource().toString().contains("Hit") && !meDoneKRG)
        {
            meDoneKRG = !meKRG.addCard(theDeckKRG.dealNextCard());
            meKRG.printHand(true);
                        
            if(meKRG.getHandSum() > 21)
            {
                meDoneKRG = true;
                System.out.println("You busted");      
                BustedKRG.setText("You Busted");
                HitKRG.setEnabled(false);
                StayKRG.setEnabled(false);
                            
            }
                        
            if (!dealerDoneKRG)
            {
                if (dealerKRG.getHandSum() < 17)
                {
                    System.out.println("The Dealer hits\n"); //set label
                    DealerHitKRG.setText("The Dealer hits");
                    
                    dealerDoneKRG = !dealerKRG.addCard(theDeckKRG.dealNextCard());
                    dealerKRG.printHand(false);
                }else
                {
                    System.out.println("The Dealer stays\n"); //set Label
                    DealerStaysKRG.setText("The Dealer stays");
                    dealerDoneKRG = true;
                }
            
            }
                   
        }
        if (e.getSource().toString().contains("Stay") || meDoneKRG == true)
        {
            meDoneKRG = true;
                        
            if (!dealerDoneKRG)
            {
                if (dealerKRG.getHandSum() < 17)
                {
                    System.out.println("The Dealer hits\n"); //set label
                    DealerHitKRG.setText("The Dealer hits");
                    
                    dealerDoneKRG = !dealerKRG.addCard(theDeckKRG.dealNextCard());
                    dealerKRG.printHand(false);
                }else
                {
                    System.out.println("The Dealer stays\n"); //set Label
                    DealerStaysKRG.setText("The Dealer stays");
                    dealerDoneKRG = true;
                }
                        
            }
                    
            
            if (meDoneKRG == true && dealerDoneKRG == true)  
            {
                meKRG.printHand(true);
                dealerKRG.printHand(true);
        
                mySum = meKRG.getHandSum();
                dealerSum = dealerKRG.getHandSum();
        
                if (mySum > dealerSum && mySum <= 21 || dealerSum > 21)
                {
                    System.out.println("You win!\n"); // set label
                    PlayerWinsKRG.setText("You win!");
                }else
                {
                System.out.println("Dealer wins!\n"); //set label
                DealerWinsKRG.setText("Dealer wins!");
                }
                HitKRG.setEnabled(false);
                StayKRG.setEnabled(false);
                DealKRG.setEnabled(true);
            }
        }
    
    
    }
}
