package labex4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;
public class WarGui extends Frame
{
    static String sWarGameType;
    static final String GAME_MODE_1 = "End at first reshuffle";
    static final String GAME_MODE_2 = "Reshuffle until one player wins";
    static JTextArea jTextDisplay = new JTextArea("Output:\n");
    
    static Stack stackMyDeck = new Stack();
    static Stack stackMyDiscard = new Stack();
    static Stack stackOppDeck = new Stack();
    static Stack stackOppDiscard= new Stack();
    
    static TextField tfMyDeckRemaining = new TextField(2);
    static TextField tfOppDeckRemaining = new TextField(2);
    
    static TextField tfMyCard = new TextField(10);
    static TextField tfOppCard = new TextField(10);
    
    static TextField tfMyDiscard= new TextField(2);
    static TextField tfOppDiscard = new TextField(2);
    
    static int iMyDeckRemaining = 26;
    static int iOppDeckRemaining = 26;
    
    static int iMyDiscard = 0;
    static int iOppDiscard = 0;
    
    Card tempCard = new Card();
        String tempFaceValue = "null";
        String tempDisplayValue;
        String tempSuit = "null";
        
        Card tempOppCard = new Card();
        String tempOppFaceValue = "null";
        String tempOppDisplayValue;
        String tempOppSuit = "null";
/************************************************************************/    
    public WarGui()
    {   
        //sets the gametype
        Object[] possibilities={GAME_MODE_1/*,GAME_MODE_2*/};
        sWarGameType = (String)JOptionPane.showInputDialog(
            null,"Which game mode do you want to play?","War Game Type Input",
            JOptionPane.PLAIN_MESSAGE,null,possibilities,null);
        switch (sWarGameType) 
        { //sets the title based on gametype
            case GAME_MODE_1:
                setTitle("War -- Type 1");
                break;
            case GAME_MODE_2:
                setTitle("War -- Type 2");
                break;
            default:
                setTitle("War -- Default");
                break;
        }
        Button btnNext = new Button("Next");
        Button btnNew = new Button("New Game");
        Button btnExit = new Button("Exit");
        
        jTextDisplay.setWrapStyleWord(true);
        jTextDisplay.setEditable(false);
        jTextDisplay.setFocusable(false);
        
        tfOppDeckRemaining.setEditable(false);
        tfOppDeckRemaining.setFocusable(false);
        
        tfMyDeckRemaining.setEditable(false);
        tfMyDeckRemaining.setFocusable(false);
        
        tfMyCard.setEditable(false);
        tfMyCard.setFocusable(false);
        
        tfOppCard.setEditable(false);
        tfOppCard.setFocusable(false);
        
        tfMyDiscard.setText(String.valueOf(iMyDiscard));
        tfMyDiscard.setEditable(false);
        tfMyDiscard.setFocusable(false);
        
        tfOppDiscard.setText(String.valueOf(iOppDiscard));
        tfOppDiscard.setEditable(false);
        tfOppDiscard.setFocusable(false);
/************************************************************************/    
        //GUI creation
        setResizable(false);
        addWindowListener( new CloseWindow());
        //gridbag stuff
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        //title area on gui
        c.fill=GridBagConstraints.BOTH;
        c.insets= new Insets(0,210,0,10);
        c.weightx=0;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=5;
        add(new Label("War, The Card Game"),c);
        c.insets= new Insets(0,212,0,0);
        c.gridy=1;
        add(new Label("Welcome to War v0.1"),c);
        c.gridy=2;
        c.insets= new Insets(0,180,20,0);
        add(new Label("Programmed by: Kyle Jolicoeur"),c);
        
        //reset defaults for the rest
        c.insets= new Insets(5,10,5,20);
        c.weightx=0;
        c.gridwidth=1;
        
        //Your Card Label
        c.gridx=0;
        c.gridy=3;
        add(new Label("Your Card"),c);
        //Your card's card
        c.anchor=GridBagConstraints.LINE_START;
        c.weightx=0.5;
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=1;
        add(tfMyCard,c);
        
        //Their card's Label
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=3;
        c.gridwidth=1;
        add(new Label("Opponent's Card"),c);
        //Their card's card
        c.gridx=1;
        c.gridy=4;
        c.gridwidth=1;
        add(tfOppCard,c);
        
        c.weightx=0;
        c.gridx=2;
        c.gridy=6;
        c.gridwidth=1;
        add(new Label("Your Deck:"),c);
        c.gridx=2;
        c.gridy=7;
        add(tfMyDeckRemaining,c);
        
        c.gridx=2;
        c.gridy=8;
        add(new Label("Opponent's Deck:"),c);
        c.gridx=2;
        c.gridy=9;
        add(tfOppDeckRemaining,c);
        
        c.gridx=2;
        c.gridy=10;
        add(new Label("My Discard:"),c);
        c.gridx=2;
        c.gridy=11;
        add(tfMyDiscard,c);
        
        c.gridx=2;
        c.gridy=12;
        add(new Label("Opponent's Discard:"),c);
        c.gridx=2;
        c.gridy=13;
        add(tfOppDiscard,c);
        
        c.insets= new Insets(0,10,100,20);
        c.gridx=0;
        c.gridy=5;
        c.gridwidth=2;
        c.gridheight=9;
        c.insets= new Insets(0,10,10,20);
        JScrollPane jDisplay= new JScrollPane(jTextDisplay, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jDisplay.setPreferredSize(new Dimension(0,170));
        add(jDisplay,c);
        
        c.gridx=0;
        c.gridy=14;
        c.weighty=0;
        c.gridwidth=1;
        c.gridheight=0;
        c.insets=new Insets(10,30,10,30);
        add(btnNext,c);
        btnNext.addActionListener(new NextListener(this));
        c.gridx=1;
        btnNew.addActionListener(new NewListener(this));
        add(btnNew,c);
        c.gridx=2;
        btnExit.addActionListener(new ExitListener(this));
        add(btnExit,c);
    }    
/************************************************************************/        
    boolean iWin()
    {
        boolean bWin = false;
        switch (sWarGameType) 
        {
            case GAME_MODE_1:
                if (stackMyDeck.isEmpty())
                {
                    bWin = (iMyDiscard > iOppDiscard);
                }
                break;
//            case GAME_MODE_2:
//                    bWin = ((iOppDiscard == 0) && (iOppDeckRemaining == 0));
//                break;
        }
        return bWin;
    }
    boolean oppWin()
    {
        boolean bWin = false;
        switch (sWarGameType) 
        {
            case GAME_MODE_1:
                if (stackOppDeck.isEmpty())
                {
                    bWin = (iOppDiscard > iMyDiscard);
                }
                break;
//            case GAME_MODE_2:
//                    bWin = ((iMyDiscard == 0) && (iMyDeckRemaining == 0));
//                break;
        }
        return bWin;
    }
    boolean bothWin()
    {
        boolean bWin = false;
        switch (sWarGameType) 
        {
            case GAME_MODE_1:
                if (stackMyDeck.isEmpty() || stackOppDeck.isEmpty())
                {
                    bWin = (iOppDiscard == iMyDiscard);
                }
                break;
//            case GAME_MODE_2:
//                    bWin = ((iMyDiscard == 0) && (iMyDeckRemaining == 0));
//                break;
        }
        return bWin;
    }
    void newDecks()
    {
            //Splitting the deck for the game
        Deck deck1 = new Deck();
        deck1.arrayDeck[0].setFaceValue("13");
        deck1.arrayDeck[13].setFaceValue("13");
        deck1.arrayDeck[26].setFaceValue("13");
        deck1.arrayDeck[39].setFaceValue("13");
        Stack fullDeck = (Stack) deck1.shuffleDeck();
        
        for(int i=0; i<26; i++)
        {
            stackMyDeck.push(fullDeck.pop());
            stackOppDeck.push(fullDeck.pop());
        }
    }
    void refreshFields()//Updates the right column
    {
        tfMyDiscard.setText(String.valueOf(iMyDiscard));
        tfOppDiscard.setText(String.valueOf(iOppDiscard));
        tfMyDeckRemaining.setText(String.valueOf(iMyDeckRemaining));
        tfOppDeckRemaining.setText(String.valueOf(iOppDeckRemaining));
    }
/************************************************************************/   
    class NextListener implements ActionListener
    {
        WarGui f;
        NextListener(WarGui pf)
        {
            f=pf;
        }
        public void actionPerformed(ActionEvent e)
        {
            switch (sWarGameType) 
            {
                case GAME_MODE_1:
                    if(tfMyDeckRemaining.getText().isEmpty())
                    {//if you dont start a new game
                        JOptionPane.showMessageDialog(null,
                                "Please start a new game first", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else if(iWin())
                    {//if you win
                        JOptionPane.showMessageDialog(null,
                                "You have won the game! please start a new game",
                                "You Win!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(oppWin())
                    {//if you lose
                        JOptionPane.showMessageDialog(null,
                                "You have lost the game, please start a new game",
                                "You Lose...", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(bothWin())
                    {
                          JOptionPane.showMessageDialog(null,
                                "You have tied, please start a new game",
                                "You Tie", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {//to continue playing the game
                        nextHandler();
                    }   
                    break;
//                case GAME_MODE_2:
//                    if(tfMyDeckRemaining.getText().isEmpty())
//                    {//if you dont start a new game
//                        JOptionPane.showMessageDialog(null,
//                                "Please start a new game first", "Error",
//                                JOptionPane.ERROR_MESSAGE);
//                    }
//                    else if(iWin())
//                    {//if you lose
//                        JOptionPane.showMessageDialog(null,
//                                "You have won the game! please start a new game",
//                                "You Win!", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                    else if(oppWin())
//                    {//if you win
//                        JOptionPane.showMessageDialog(null,
//                                "You have lost the game, please start a new game",
//                                "You Lose...", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                    else
//                    {//to continue playing the game
//                        nextHandler();
//                    }   
//                    break;
            }
        }
    }
    void nextHandler()
    {
        if(!stackMyDeck.isEmpty())
        {
            tempCard = (Card)stackMyDeck.pop();
            iMyDeckRemaining-=1;
            tempFaceValue = tempCard.getFaceValue();//face value for comparison
            tempDisplayValue = tempCard.checkFaceValue();//face value for display
            tempDisplayValue = tempDisplayValue.trim();
            tempSuit = tempCard.getSuit();//suit for displaying
            tfMyCard.setText(tempDisplayValue + " of " + tempSuit);//displays card
        }
        else if(stackMyDeck.isEmpty())
        {
//            if(sWarGameType.equals(GAME_MODE_2))
//            {
//                jTextDisplay.append("Your Deck is empty.\n "
//                        + "Reshuffle your discard for your deck!\n");
//                for(int i=0; i <= iMyDiscard; i++)
//                {
//                    stackMyDeck.push(stackMyDiscard.pop());
//                }
//                iMyDeckRemaining=iMyDiscard;
//                iMyDiscard=0;
//                refreshFields();
//                
//                tempCard = (Card)stackMyDeck.pop();
//                iMyDeckRemaining-=1;
//                tempFaceValue = tempCard.getFaceValue();//face value for comparison
//                tempDisplayValue = tempCard.checkFaceValue();//face value for display
//                tempDisplayValue = tempDisplayValue.trim();
//                tempSuit = tempCard.getSuit();//suit for displaying
//                tfMyCard.setText(tempDisplayValue + " of " + tempSuit);//displays card
//            }
        }
        if(!stackOppDeck.isEmpty())
        {
            tempOppCard = (Card) stackOppDeck.pop();
            iOppDeckRemaining-=1;
            tempOppFaceValue = tempOppCard.getFaceValue();//for comparison
            tempOppDisplayValue = tempOppCard.checkFaceValue(); //display
            tempOppDisplayValue = tempOppDisplayValue.trim();
            tempOppSuit = tempOppCard.getSuit();//display
            //Displays Opponents card
            tfOppCard.setText(tempOppDisplayValue + " of " + tempOppSuit);
        }
        else if(stackOppDeck.isEmpty())
        {
//            if(sWarGameType.equals(GAME_MODE_2))
//            {
//                jTextDisplay.append("Opponent's Deck is empty.\n "
//                        + "They reshuffle their discard into their deck!\n\n");
//                stackOppDeck=stackOppDiscard;
//                iOppDeckRemaining=iOppDiscard;
//                tfOppDeckRemaining.setText(tfOppDiscard.getText());
//                iOppDiscard=0;
//                tfOppDiscard.setText(String.valueOf(iOppDiscard));
//                
//                tempOppCard = (Card)stackOppDeck.pop();
//                iOppDeckRemaining-=1;
//                tempOppFaceValue = tempOppCard.getFaceValue();//for comparison
//                tempOppDisplayValue = tempOppCard.checkFaceValue(); //display
//                tempOppDisplayValue = tempOppDisplayValue.trim();
//                tempOppSuit = tempOppCard.getSuit();//display
//                //Displays Opponents card
//                tfOppCard.setText(tempOppDisplayValue + " of " + tempOppSuit);
//            }
        }
 /******************************************************************************/
        if (Integer.valueOf(tempFaceValue) > Integer.valueOf(tempOppFaceValue))
        {
            jTextDisplay.append("You won this flip!\n");
            jTextDisplay.append("You earn the 2 cards!\n\n");
            iMyDiscard+=2;
            stackMyDiscard.push(tempCard);
            stackMyDiscard.push(tempOppCard);
            refreshFields();
        }
        else if(Integer.valueOf(tempOppFaceValue) > Integer.valueOf(tempFaceValue))
        {
            jTextDisplay.append("Opponent won this flip...\n");
            jTextDisplay.append("Opponent earns the 2 cards..\n\n");
            iOppDiscard+=2;
            stackOppDiscard.push(tempCard);
            stackOppDiscard.push(tempOppCard);
            refreshFields();
        }
        else if(Integer.valueOf(tempFaceValue) == Integer.valueOf(tempOppFaceValue) )
        {
            warSequence();
        }
        else
        {
            jTextDisplay.append("You have run out of cards!\n"
                                + "The game has ended!");  
        }
    }
    void warSequence()
    {
        Stack tempDiscard = new Stack();
        int tempDiscardPile = 0;
        int iSkipFinished=0;
        int loopExiter=0;
        do
        {
            jTextDisplay.append("There is a tie! Commence the War!\n");
            switch (sWarGameType) 
            {
                case GAME_MODE_1:
                    if(iMyDeckRemaining > 3 || iOppDeckRemaining > 3)
                    {
                        jTextDisplay.append("Card 1: W.\nCard 2: A.\nCard 3: R.\n");
                        tempDiscard.push(stackMyDeck.pop());//W
                        tempDiscard.push(stackMyDeck.pop());//A
                        tempDiscard.push(stackMyDeck.pop());//R
                        tempDiscard.push(stackOppDeck.pop());//W
                        tempDiscard.push(stackOppDeck.pop());//A
                        tempDiscard.push(stackOppDeck.pop());//R
                        iMyDeckRemaining-=3;
                        iOppDeckRemaining-=3;
                        tempDiscardPile+=6;
                    }
                    else if(iMyDeckRemaining == 3 || iOppDeckRemaining == 3)
                    {
                        jTextDisplay.append("uh oh, your deck will run out!\n"
                                + "Let's reshuffle when you run out "
                                + "of cards! Card 1: W.\nCard 2: A.\n Card 3: R.\n");
                        tempDiscard.push(stackMyDeck.pop());//W
                        tempDiscard.push(stackMyDeck.pop());//AR
                        tempDiscard.push(stackOppDeck.pop());//W
                        tempDiscard.push(stackOppDeck.pop());//AR
                        iMyDeckRemaining-=2;
                        iOppDeckRemaining-=2;
                        tempDiscardPile+=4;
                        refreshFields();
                    }
                    else if(iMyDeckRemaining == 2 || iOppDeckRemaining == 2)
                    {
                        jTextDisplay.append("uh oh, your deck will run out!\n"
                                + "Let's reshuffle when you run out "
                                + "of cards! Card 1: W.\n Card 2: A.\n Card 3: R.\n");
                        tempDiscard.push(stackMyDeck.pop());//WAR
                        tempDiscard.push(stackOppDeck.pop());//WAR
                        iMyDeckRemaining-=1;
                        iOppDeckRemaining-=1;
                        tempDiscardPile+=2;
                        refreshFields();
                    }
                    else if(iMyDeckRemaining == 1 || iOppDeckRemaining == 1)
                    {
                        jTextDisplay.append("uh oh, your deck will run out!\n"
                                + " There isn't enough cards to duel this out\n");
                    }
                    else
                    {
                        jTextDisplay.append("You have run out of cards!\n"
                            + "You and the opponent discard the tied cards "
                                + "to your own piles\nThe game has ended!");             
                        jTextDisplay.append("Your card: " + 
                            Integer.valueOf(tempFaceValue) + " of " + tempSuit + "\n");
                        jTextDisplay.append("Opponent's card: " + 
                            Integer.valueOf(tempOppFaceValue) + " of " 
                                + tempOppSuit + "\n\n");
                        iOppDiscard=+1;
                        iSkipFinished+=1;
                        loopExiter+=1;
                    }
                    break;
    /*************************************************************************/
//                    case GAME_MODE_2:
//                        if((iMyDeckRemaining + iMyDiscard) > 4)
//                        {
//                            jTextDisplay.append("Card 1: W.\nCard 2: A.\nCard 3: R.\n");
//                            tempDiscard.push(stackMyDeck.pop());//W
//                            tempDiscard.push(stackMyDeck.pop());//A
//                            tempDiscard.push(stackMyDeck.pop());//R
//                            tempDiscard.push(stackOppDeck.pop());//W
//                            tempDiscard.push(stackOppDeck.pop());//A
//                            tempDiscard.push(stackOppDeck.pop());//R
//                            iMyDeckRemaining-=3;
//                            iOppDeckRemaining-=3;
//                            tempDiscardPile+=6;
//                            refreshFields();
//                        }
//                        else if(iMyDeckRemaining == 3 || iOppDeckRemaining == 3)
//                        {
//                            jTextDisplay.append("uh oh, your deck will run out!\n"
//                                    + "You will reshuffle your discard into your deck "
//                                    + "of cards! Card 1: W.\nCard 2: A.R.\n");
//                            tempDiscard.push(stackMyDeck.pop());//W
//                            tempDiscard.push(stackMyDeck.pop());//AR
//                            tempDiscard.push(stackOppDeck.pop());//W
//                            tempDiscard.push(stackOppDeck.pop());//AR
//                            iMyDeckRemaining-=2;
//                            iOppDeckRemaining-=2;
//                            tempDiscardPile+=4;
//                            refreshFields();
//                        }
//                        else if(iMyDeckRemaining == 2 || iOppDeckRemaining == 2)
//                        {
//                            jTextDisplay.append("uh oh, your deck will run out!\n"
//                                    + " Let's finish this without running out "
//                                    + "of cards! Card 1: W.A.R.\n");
//                            tempDiscard.push(stackMyDeck.pop());//WAR
//                            tempDiscard.push(stackOppDeck.pop());//WAR
//                            iMyDeckRemaining-=1;
//                            iOppDeckRemaining-=1;
//                            tempDiscardPile+=2;
//                            refreshFields();
//                        }
//                        else if(iMyDeckRemaining == 1 || iOppDeckRemaining == 1)
//                        {
//                            jTextDisplay.append("uh oh, your deck will run out!\n"
//                                    + " There isn't enough cards to duel this out\n");
//                        }
//                        else
//                        {      
//                            jTextDisplay.append("You have no more cards! Your card: " + 
//                                Integer.valueOf(tempFaceValue) + " of " + tempSuit + "\n");
//                            jTextDisplay.append("Opponent's card: " + 
//                                Integer.valueOf(tempOppFaceValue) + " of " 
//                                    + tempOppSuit + "\n\n");
//                            iSkipFinished+=1;
//                        }
//                        break;
            }
            if(iSkipFinished==0)//skip this if theres no more cards in the deck
            {
                tempCard=(Card)stackMyDeck.pop();//Flip
                iMyDeckRemaining-=1;
                tempOppCard=(Card)stackOppDeck.pop();//flip
                iOppDeckRemaining-=1;
                tempDiscardPile+=2;

                tempFaceValue=tempCard.getFaceValue();
                tempSuit = tempCard.getSuit();//suit for displaying
                tempDiscard.push(tempCard);//puts the flip on the discard

                tempOppFaceValue=tempOppCard.getFaceValue();
                tempOppSuit = tempOppCard.getSuit();//display
                tempDiscard.push(tempOppCard);//puts the flip on the discard

                refreshFields();
                jTextDisplay.append("Your card: " + 
                    Integer.valueOf(tempFaceValue) + " of " + tempSuit + "\n");
                jTextDisplay.append("Opponent's card: " + 
                    Integer.valueOf(tempOppFaceValue) + " of " + 
                    tempOppSuit + "\n\n");
                checkWarWin(tempDiscard,tempDiscardPile,tempFaceValue
                        ,tempOppFaceValue);
                if((Integer.valueOf(tempOppFaceValue)) != 
                (Integer.valueOf(tempFaceValue)) || iSkipFinished!=1)
                {
                    loopExiter+=1;
                }
            }
        }
        while(loopExiter==0);
    }
    void checkWarWin(Stack tempDiscard,int tempDiscardPile,String tempFaceValue,
            String tempOppFaceValue)
    {
        switch (sWarGameType) 
        {
            case GAME_MODE_1:
                
                if(Integer.valueOf(tempFaceValue) > Integer.valueOf(tempOppFaceValue))
                {
                    refreshFields();
                    for( int i = 0; tempDiscardPile > i ; i++ )
                    {
                        stackMyDiscard.push(tempDiscard.pop());
                        iMyDiscard+=1;
                        refreshFields();
                    }
                    iMyDiscard+=2; //for the tied cards
                    refreshFields();
                }
                else if(Integer.valueOf(tempFaceValue) < Integer.valueOf(tempOppFaceValue))
                {
                    refreshFields();
                    for( int i = 1; tempDiscardPile >= i ; i++ )
                    {
                        stackOppDiscard.push(tempDiscard.pop());
                        iOppDiscard+=1;
                        refreshFields();
                    }
                    iOppDiscard+=2; //for tied cards
                    refreshFields();
                }
                else
                {
                }
                break;
//            case GAME_MODE_2:
//                if(Integer.valueOf(tempFaceValue) > Integer.valueOf(tempOppFaceValue))
//                {
//                    refreshFields();
//                    for( int i = 1; tempDiscardPile >= i ; i++ )
//                    {
//                        stackMyDiscard.push(tempDiscard.pop());
//                        iMyDiscard+=1;
//                        refreshFields();
//                    }
//                }
//                else if(Integer.valueOf(tempFaceValue) < Integer.valueOf(tempOppFaceValue))
//                {
//                    refreshFields();
//                    for( int i = 1; tempDiscardPile >= i ; i++ )
//                    {
//                        stackOppDiscard.push(tempDiscard.pop());
//                        iOppDiscard+=1;
//                        refreshFields();
//                    }
//                }
//                else
//                {
//                }
//                break;
        }
    }
/************************************************************************/    
    class NewListener implements ActionListener
    {
        WarGui f;
        NewListener(WarGui pf)
        {
            f=pf;
        }
        public void actionPerformed(ActionEvent event)
        {
           WarGui.iMyDeckRemaining =26;
           WarGui.iOppDeckRemaining=26;
           refreshFields();
           jTextDisplay.setText("Starting a new game!\nOutput:\n");
           tfMyCard.setText("");
           tfOppCard.setText("");
           iMyDiscard = 0;
           if(stackMyDeck != null && stackOppDeck != null)
           {
                stackMyDeck=null;
                stackMyDeck=new Stack();
                stackOppDeck=null;
                stackOppDeck= new Stack();
           }
           stackMyDiscard=null;
           stackMyDiscard = new Stack();
           stackOppDiscard = null;
           stackOppDiscard= new Stack();
           iOppDiscard = 0;
           tfMyDiscard.setText("0");
           tfOppDiscard.setText("0");
           f.newDecks();
        }
    }
/************************************************************************/        
    class ExitListener implements ActionListener
    {
        WarGui f;
        ExitListener(WarGui pf)
        {
            f=pf;
        }
        public void actionPerformed(ActionEvent event)
        {
           System.exit(0);
        }
    }
/************************************************************************/        
    public class CloseWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }
}