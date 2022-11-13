
/**
 * Write a description of class app_ui here.
 *
 * @author Cruz, Lawrence; Jaafary, Fred; Quiambao. Lindley
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Locale;
import com.github.lgooddatepicker.components.*;
import java.text.*;

public class app_ui extends JFrame
{
    //Initializing object
    CustInfo customer = new CustInfo();
    OrderInfo order = new OrderInfo();
    
    //in-class variables
    private String menu_choice;
    //Fonts
    private Font labelFont = new Font("Segoe UI", 0, 16);
    private Font labelBigFont = new Font("Segoe UI", 0, 18);
    private Font labelBiggerFont = new Font("Segoe UI", 0, 24);
    private Font buttonFont = new Font("Segoe UI", 0, 14);
    
    private JPanel menuPanel = new JPanel(new GridBagLayout());
    //First panel buttons
    private JButton smallScaleBtn = new JButton();
    private JButton wedBtn = new JButton();
    private JButton corpoBtn = new JButton();
    private JButton mainExitBtn = new JButton();
    
    //First panel Label
    private JLabel mainMenuLabel = new JLabel();
    
    private JPanel eventInfoPanel = new JPanel(new GridBagLayout());
    //2nd Panel 
    private JLabel eventInfoLabel = new JLabel();
    private JLabel noAttendLabel = new JLabel();
    private JLabel eventDateLabel = new JLabel();
    
    //2nd panel Buttons
    private JButton eventOkBtn = new JButton();
    private JButton cancelEventBtn = new JButton();
    
    //2nd panel Text Fields
    private JTextField noAttendField = new JTextField();
    private DatePicker EventDatePicker = new DatePicker();
    
    private JPanel choicePanel = new JPanel(new GridBagLayout());
    private JPanel menuChoicePanel = new JPanel(new GridBagLayout());
    private JPanel westPanel = new JPanel(new GridBagLayout());
    private JPanel phPanel = new JPanel(new GridBagLayout());
    private JPanel medPanel = new JPanel(new GridBagLayout());
    
    //3rd Panel Tabbed Pane
    JTabbedPane menuPane = new JTabbedPane();
    
    //3rd Panel Labels
    private JLabel westMenuLabel = new JLabel();
    private JLabel phMenuLabel = new JLabel();
    private JLabel medMenuLabel = new JLabel();
    
    //3rd Panel Radio group
    private ButtonGroup menuGrp = new ButtonGroup();
    private JRadioButton westMenu = new JRadioButton();
    private JRadioButton phMenu = new JRadioButton();
    private JRadioButton medMenu = new JRadioButton();
    
    //3rd Panel Buttons
    private JButton menuOkBtn = new JButton();
    private JButton menuBackBtn = new JButton();
    
    //3rd Panel Text Areas
    private JTextArea westMenuField = new JTextArea();
    private JTextArea phMenuField = new JTextArea();
    private JTextArea medMenuField = new JTextArea();
    
    private JPanel paymentPanel = new JPanel(new GridLayout(0,2));
    private JPanel invoicePanel = new JPanel(new GridBagLayout());
    //4th Panel Labels
    private JLabel paymentLabel = new JLabel();
    private JLabel invoiceLabel = new JLabel();
    private JLabel paxLabel = new JLabel();
    private JLabel ppheadLabel = new JLabel();
    private JLabel subtotalLabel = new JLabel();
    private JLabel payOptionLabel = new JLabel();
    
    //4th Panel Buttons
    private ButtonGroup payGroup = new ButtonGroup();
    private JButton payBackBtn = new JButton();
    private JToggleButton cashBtn = new JToggleButton();
    private JToggleButton creditBtn = new JToggleButton();
    
    private JPanel custInfoPanel = new JPanel(new GridBagLayout());
    //5th Panel Labels
    private JLabel custInfoLabel = new JLabel();
    private JLabel firstNameLabel = new JLabel();
    private JLabel lastNameLabel = new JLabel();
    
    //5th Panel Fields
    private JTextField firstNameField = new JTextField();
    private JTextField lastNameField = new JTextField();
    private JTextField paxField = new JTextField();
    private JTextField ppHeadField = new JTextField();
    private JTextField subtotalField = new JTextField();
    //5th Panel Buttons
    private JButton cInfoOkBtn = new JButton();

    
    public app_ui(){
        main_menu();
        EventInfo();
        menu_choice();
        payment();
        setContentPane(menuPanel);
        pack();
    }
    
    public void main_menu(){
        setTitle("AAA Catering Services");
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.insets = new Insets(10, 10, 0, 10);
        
        mainMenuLabel.setText("Welcome to AAA Catering!");
        mainMenuLabel.setFont(labelBiggerFont);
        gc.gridwidth = 5;
        gc.gridx = 0;
        gc.gridy = 0;
        menuPanel.add(mainMenuLabel, gc);

        smallScaleBtn.setText("Small Scale");
        smallScaleBtn.setFont(buttonFont);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 1;
        menuPanel.add(smallScaleBtn, gc);
        
        smallScaleBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BtnActionPerformed(e, 1);
            }
        });
        
        wedBtn.setText("Weddings");
        wedBtn.setFont(buttonFont);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 2;
        menuPanel.add(wedBtn, gc);
        
        wedBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BtnActionPerformed(e, 2);
            }
        });
        
        corpoBtn.setText("Corporate");
        corpoBtn.setFont(buttonFont);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 3;
        menuPanel.add(corpoBtn, gc);
        
        corpoBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BtnActionPerformed(e, 3);
            }
        });
        
        mainExitBtn.setText("Exit");
        mainExitBtn.setFont(buttonFont);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.PAGE_END;
        gc.insets = new Insets(20,10,5,10);
        menuPanel.add(mainExitBtn, gc);
        
        mainExitBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BtnActionPerformed(e, 4);
            }
        });
        
        pack();
    }
    
    public void EventInfo(){
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.insets = new Insets(10,5,0,5);
        
        eventInfoLabel.setText("Enter Event Info Below:");
        eventInfoLabel.setFont(labelBigFont);
        gc.gridx = 0;
        gc.gridy = 0;
        eventInfoPanel.add(eventInfoLabel, gc);      
        
        noAttendLabel.setText("Number of Attendees: ");
        noAttendLabel.setFont(labelFont);
        gc.gridx = 0;
        gc.gridy = 1;
        eventInfoPanel.add(noAttendLabel, gc);
        
        eventDateLabel.setText("Date of Event: ");
        eventDateLabel.setFont(labelFont);
        gc.gridx = 0;
        gc.gridy = 2;
        eventInfoPanel.add(eventDateLabel, gc);
        
        noAttendField.setText("");
        gc.anchor = GridBagConstraints.WEST;
        noAttendField.setColumns(20);
        gc.weightx = 0.5;
        gc.gridx = 1;
        gc.gridy = 1;
        eventInfoPanel.add(noAttendField, gc);
        
        EventDatePicker.setDateToToday();
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 0.5;
        gc.gridx = 1;
        gc.gridy = 2;
        eventInfoPanel.add(EventDatePicker, gc);
        
        eventOkBtn.setText("OK");
        eventOkBtn.setFont(buttonFont);
        gc.insets = new Insets(20,5,5,5);
        gc.gridx = 0;
        gc.gridy = 3;
        eventInfoPanel.add(eventOkBtn, gc);
        
        eventOkBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                eventOkBtnActionPerformed(e);}
        });
        
        cancelEventBtn.setText("Cancel");
        cancelEventBtn.setFont(buttonFont);
        gc.insets = new Insets(20,0,5,5);
        gc.gridx = 1;
        gc.gridy = 3;
        eventInfoPanel.add(cancelEventBtn, gc);
        
        cancelEventBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cancelEventBtnActionPerformed(e);}
        });
    }
    
    public void menu_choice(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5,5,0,5);
        
        westMenu.setText("Western");
        westMenu.setFont(labelFont);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.WEST;
        westMenu.setSelected(true);
        menuGrp.add(westMenu);
        menuChoicePanel.add(westMenu, gc);

        westMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                westMenuActionPerformed(e);
            }
        });
        
        phMenu.setText("Filipino");
        phMenu.setFont(labelFont);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.WEST;
        menuGrp.add(phMenu);
        menuChoicePanel.add(phMenu, gc);
        
        phMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            { phMenuActionPerformed(e);
            }
        });
        
        medMenu.setText("Mediterranean");
        medMenu.setFont(labelFont);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.WEST;
        menuGrp.add(medMenu);
        menuChoicePanel.add(medMenu, gc);
        
        medMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            { medMenuActionPerformed(e);
            }
        });
        
        menuOkBtn.setText("Ok");
        menuOkBtn.setFont(buttonFont);
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        menuChoicePanel.add(menuOkBtn, gc);
        
        menuOkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menuOKActionPerformed(e);}
        });
        
        menuBackBtn.setText("Back");
        menuBackBtn.setFont(buttonFont);
        gc.gridx = 0;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.HORIZONTAL;
        menuChoicePanel.add(menuBackBtn, gc);
        
        menuBackBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuBackBtnActionPerformed(e);}
        });
        gc.gridx = 0;
        gc.gridy = 0;
        choicePanel.add(menuChoicePanel, gc);
        westMenuLabel.setText("Western Menu");
        westMenuLabel.setFont(labelBigFont);
        gc.gridx = 0;
        gc.gridy = 0;
        westPanel.add(westMenuLabel, gc);
        
        westMenuField.setEditable(false);
        westMenuField.setRows(15);
        westMenuField.setText("Appetizers\n"+
            "Hand-cut Fries\n" +
            "Cheese balls\n\n" +
            "Entrees\n" +
            "Beef Steak\n" +
            "Duck Breast Steak\n" +
            "Pumpkin and Pork Croquette\n" +
            "Shrimp Tempura and Spicy Sauce\n\n" +
            "Desserts\nTropical Fruits\nIce cream\n\nPrice per head: 550.00");
        westMenuField.setFont(new Font("Segoe UI", 1, 12));
        gc.gridx = 0;
        gc.gridy = 1;
        westPanel.add(westMenuField, gc);
        
        phMenuLabel.setText("Filipino Menu");
        phMenuLabel.setFont(labelBigFont);
        gc.gridx = 0;
        gc.gridy = 0;
        phPanel.add(phMenuLabel, gc);
        
        phMenuField.setEditable(false);
        phMenuField.setRows(15);
        phMenuField.setText("Appetizers\n" +
            "Tinapa Rolls\n" +
            "Baked Scallops\n\n" +
            "Entrees\nPork Sisig" +
            "\nChicken Binakol\nBeef Ribs Nilaga" +
            "\nBicol Express\n\nDesserts\nHalo-halo\n" +
            "Maja Blanca\n\nPrice per head: 525.00");
        phMenuField.setFont(new Font("Segoe UI", 1, 12));
        gc.gridx = 0;
        gc.gridy = 1;
        phPanel.add(phMenuField, gc);
        
        medMenuLabel.setText("Mediterranean Menu");
        medMenuLabel.setFont(labelBigFont);
        gc.gridx = 0;
        gc.gridy = 0;
        medPanel.add(medMenuLabel, gc);
        
        medMenuField.setEditable(false);
        medMenuField.setRows(15);
        medMenuField.setText("Appetizers\nHummus\nSafiha\n\n" +
            "Entrees\nShish Kabob\nLamb Kabob\nVeggie Kabob\n" +
            "Shrimp with Vegetables\n\nDesserts\n" +
            "Syrian Rice Pudding\nBaklava"+ 
            "\n\nPrice per head: 575.00");
        medMenuField.setFont(new Font("Segoe UI", 1, 12));
        gc.gridx = 0;
        gc.gridy = 1;
        medPanel.add(medMenuField, gc);
        
        menuPane.addTab("Western", westPanel);
        menuPane.addTab("Filipino", phPanel);
        menuPane.addTab("Mediterranean", medPanel);
        gc.weightx = 0.5;
        gc.weighty = 0.2;
        gc.gridx = 1;
        gc.gridy = 0;
        choicePanel.add(menuPane, gc);

    }
    
    public void payment(){
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.insets = new Insets(20,10,0,10);
        
        paymentLabel.setText("Payments");
        paymentLabel.setFont(labelBiggerFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 0;
        invoicePanel.add(paymentLabel, gc);
        
        invoiceLabel.setText("Invoice");
        invoiceLabel.setFont(labelBigFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 1;
        invoicePanel.add(invoiceLabel, gc);
        
        paxLabel.setText("Pax:");
        paxLabel.setFont(labelFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 2;
        invoicePanel.add(paxLabel, gc);
        
        paxField.setText("");
        paxField.setEditable(false);
        paxField.setColumns(20);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 2;
        invoicePanel.add(paxField, gc);
        
        ppheadLabel.setText("Price per head:");
        paxLabel.setFont(labelFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 3;
        invoicePanel.add(ppheadLabel, gc);
        
        ppHeadField.setText("");
        ppHeadField.setColumns(20);
        ppHeadField.setEditable(false);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 3;
        invoicePanel.add(ppHeadField, gc);
        
        subtotalLabel.setText("Subtotal:");
        subtotalLabel.setFont(labelFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 4;
        invoicePanel.add(subtotalLabel, gc);
        
        subtotalField.setText("");
        subtotalField.setColumns(20);
        subtotalField.setEditable(false);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 4;
        invoicePanel.add(subtotalField, gc);
        
        payOptionLabel.setText("Select Payment Option");
        payOptionLabel.setFont(labelFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 0;
        custInfoPanel.add(payOptionLabel, gc);
        
        cashBtn.setText("Cash");
        cashBtn.setFont(buttonFont);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 1;
        payGroup.add(cashBtn);
        custInfoPanel.add(cashBtn, gc);
        
        creditBtn.setText("Credit");
        creditBtn.setFont(buttonFont);
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 2;
        payGroup.add(creditBtn);
        custInfoPanel.add(creditBtn, gc);
        
        custInfoLabel.setText("Customer Info");
        custInfoLabel.setFont(labelFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 3;
        custInfoPanel.add(custInfoLabel, gc);
        
        firstNameLabel.setText("First Name:");
        firstNameLabel.setFont(labelFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 4;
        custInfoPanel.add(firstNameLabel, gc);
        
        firstNameField.setText("");
        firstNameField.setColumns(20);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 4;
        custInfoPanel.add(firstNameField, gc);
        
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setFont(labelFont);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 5;
        custInfoPanel.add(lastNameLabel, gc);
        
        lastNameField.setText("");
        lastNameField.setColumns(20);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 5;
        custInfoPanel.add(lastNameField, gc);
        
        cInfoOkBtn.setText("Order");
        cInfoOkBtn.setFont(buttonFont);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 6;
        custInfoPanel.add(cInfoOkBtn, gc);
        
        cInfoOkBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                paymentOkActionPerformed(e);
            }
        });
        
        payBackBtn.setText("Back");
        payBackBtn.setFont(buttonFont);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 6;
        custInfoPanel.add(payBackBtn, gc);
        
        paymentPanel.add(invoicePanel);
        paymentPanel.add(custInfoPanel);
    }

    //Event Handling Code
    //Main Menu events
    private void BtnActionPerformed(ActionEvent e, int choice){
        JFrame jf = new JFrame();
        switch(choice){
            case 1:
                customer.setEventType("Small Scale");
                setContentPane(eventInfoPanel);
                pack();
                break;
            case 2:
                customer.setEventType("Wedding");
                setContentPane(eventInfoPanel);
                pack();
                break;
            case 3:
                customer.setEventType("Corporate");
                setContentPane(eventInfoPanel);
                pack();
                break;
            case 4:
                JOptionPane.showMessageDialog(jf, "Exiting Program");
                System.exit(0);
            default:    
        }

    }
    
    //Event Info Events
    private void eventOkBtnActionPerformed(ActionEvent e){
        customer.setDate(EventDatePicker.getText());
        customer.setPax(noAttendField.getText());
        setContentPane(choicePanel);
        pack();
    }
    
    private void cancelEventBtnActionPerformed(ActionEvent e){
        setContentPane(menuPanel);
        pack();
    }
    
    //Menu Selection Events
    private void westMenuActionPerformed(ActionEvent e){
        menu_choice = "Western";
    }
    
    private void phMenuActionPerformed(ActionEvent e){
        menu_choice = "Filipino";
    }
    
    private void medMenuActionPerformed(ActionEvent e){
        menu_choice = "Mediterranean";
    }
    
    private void menuOKActionPerformed(ActionEvent e){
        if (menu_choice.equals("Western")){
            order.setWestPrice("550");
            ppHeadField.setText(NumberFormat.getCurrencyInstance(new Locale("en","PH")).format(Double.parseDouble(order.getWestPrice())));
            
            Double nPax = Double.parseDouble(order.getPax());
            Double WestSubTotal = 550 * nPax;
            
            order.setWestSubTotal(String.valueOf(WestSubTotal));
            subtotalField.setText(NumberFormat.getCurrencyInstance(new Locale("en","PH")).format(Double.parseDouble(order.getWestSubTotal())));
            
            setContentPane(paymentPanel);
            setValues();
            pack();
            //input here
        }
        else if (menu_choice.equals("Filipino")){
            order.setFilPrice("525");
            ppHeadField.setText(NumberFormat.getCurrencyInstance(new Locale("en","PH")).format(Double.parseDouble(order.getFilPrice())));
            
            Double nPax = Double.parseDouble(order.getPax());
            Double FilSubTotal = 525 * nPax;
            
            order.setFilSubTotal(String.valueOf(FilSubTotal));
            subtotalField.setText(NumberFormat.getCurrencyInstance(new Locale("en","PH")).format(Double.parseDouble(order.getFilSubTotal())));
            
            setContentPane(paymentPanel);
            setValues();
            pack();
        
            //input here
        }
        else if (menu_choice.equals("Mediterranean")){
            order.setMedPrice("575");
            ppHeadField.setText(NumberFormat.getCurrencyInstance(new Locale("en","PH")).format(Double.parseDouble(order.getMedPrice())));
            
            Double nPax = Double.parseDouble(order.getPax());
            Double MedSubTotal = 575 * nPax;
            
            order.setMedSubTotal(String.valueOf(MedSubTotal));
            subtotalField.setText(NumberFormat.getCurrencyInstance(new Locale("en","PH")).format(Double.parseDouble(order.getMedSubTotal())));
            
            setContentPane(paymentPanel);
            setValues();
            pack();
            //input here
        }
        else{
            System.out.print("Something went wrong @ menuOkActionPerfornmed");
            System.exit(0);
        }
        //setContentPane(paymentPanel);
        //setValues();
        //pack();
    }
    
    private void setValues(){
        paxField.setText(customer.getPax());
        //ppHeadField.setText("");//Get yung per head price
        //subtotalField.setText(""); //Set subtotal here
        
    }
    
    private void menuBackBtnActionPerformed(ActionEvent e){
        setContentPane(eventInfoPanel);
        pack();
    }
    
    //Payment Events
    private void paymentOkActionPerformed(ActionEvent e){
        JFrame frame = new JFrame();
        if (cashBtn.isSelected()){
            customer.setMOP("Cash");
        }
        else if (creditBtn.isSelected()){
            customer.setMOP("Credit");
        }
        customer.setCustFName(firstNameField.getText());
        customer.setCustLName(lastNameField.getText());
        
        JOptionPane.showMessageDialog(frame, "Thank You " +customer.getCustFName() 
            +"!\nHere's a review of your transaction:"
            +"\nFull name: " +customer.getCustFName() +" " +customer.getCustLName() 
            + "\nType of Event: " +customer.getEventType()
            +"\nDate of Event: " +customer.getDate() 
            +"\nNumber of Persons: " +customer.getPax()
            +"\nCuisine Type: " //+customer.getCuisineType() 
            +"\nMode of Payment: " +customer.getMOP()
            +"\nPrice per head: " +customer.getPax()
            +"\nTotal: " +customer.getTotal());
    }
    
    public static void main(String[]Args){
        new app_ui().show();
    
    }
    
}
