package labex4;
import java.awt.*;
import java.awt.event.*;

public class TitleGui extends Frame
{
    public static String WHICH_GAME;
    public static final List GAME_LIST = new List(4, false);
    public static final String WAR = "War (The Card Game)";
    public static final String SHUFFLE = "Poker Hand Shuffler";
    public static final String BRIDGE = "Card Comparison (Bridge)";
    public static final String TAROT = "Tarot Card Readings";
    
    public TitleGui()
    {   
        setResizable(false);
        Button btnSubmit = new Button("Submit");
        Button btnExit = new Button("Exit");
        
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx =0.0;
        
        setTitle("HappyHeart Card Games");
        constraints.gridwidth = 0;
        constraints.gridheight = 2;
        
        add(new Label("Welcome to the Card Game Simulation v0.4"),constraints);
        add(new Label("                Please Select a game:"),constraints);
        
        add(GAME_LIST,constraints);
        GAME_LIST.add(SHUFFLE);
        GAME_LIST.add(WAR);
        GAME_LIST.add(BRIDGE);
        GAME_LIST.add(TAROT);
        GAME_LIST.select(0);
        //submit button
        add(btnSubmit,constraints);
        btnSubmit.addActionListener(new SubmitHandler(this));
        //exit button
        add(btnExit,constraints);
        btnExit.addActionListener(new ExitHandler(this));
        addWindowListener( new CloseWindow( ));
    }

    class ExitHandler implements ActionListener 
    {
            TitleGui f;
            ExitHandler(TitleGui pf)
            {
                f = pf;
            }
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
    }
    class SubmitHandler implements ActionListener
    {
        TitleGui f;
        SubmitHandler(TitleGui pf)
        {
            f = pf;
        }
        public void actionPerformed(ActionEvent event)
        {
            f.submitMethod();
            f.setVisible(false);
            switch (WHICH_GAME) 
            {
                case SHUFFLE:
                    ShuffleGui shGui= new ShuffleGui();
                    shGui.setSize(220,430);
                    shGui.setVisible(true);
                    shGui.setLocationRelativeTo(null);
                    break;
                case WAR:
                    WarGui waGui= new WarGui();
                    waGui.setSize(550,520);
                    waGui.setVisible(true);
                    waGui.setLocationRelativeTo(null);
                    break;
                case BRIDGE:
                    BridgeGui brGui = new BridgeGui();
                    brGui.setVisible(true);
                    brGui.setLocationRelativeTo(null);
                    break;
                case TAROT:
                    TarotGui taGui = new TarotGui();
                    taGui.setVisible(true);
                    taGui.setLocationRelativeTo(null);
                    break;
            }
        }
    }
    void submitMethod()
    {
        String s=GAME_LIST.getSelectedItem();
        WHICH_GAME=s;
    }
     public class CloseWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }
}
