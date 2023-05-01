package coffeeshop;

import java.awt.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
		
public class Coffeeshop extends JFrame implements ActionListener {

	JPanel mainPanel = new JPanel();
        
        ImageIcon image = new ImageIcon("starbucks.png");
        ImageIcon companyIcon = new ImageIcon("cute.png");
        ImageIcon matchaIcon = new ImageIcon("matcha.jpg");
        ImageIcon nescafeIcon = new ImageIcon("nescafe.jpg");
        ImageIcon pinkIcon = new ImageIcon("pinkdrink.png");
        ImageIcon amerikanoIcon = new ImageIcon("amerikano.png");
        ImageIcon cappuccinoIcon = new ImageIcon("cappucino.png");
        ImageIcon chaiteaIcon = new ImageIcon("chaitea.png");
        ImageIcon frappeIcon = new ImageIcon("frappe.png");
        ImageIcon latteIcon = new ImageIcon("latte.png");
        ImageIcon macchiatoIcon = new ImageIcon("macchiato.png");
        ImageIcon mochaIcon = new ImageIcon("mocha.png");
        ImageIcon dripIcon  = new ImageIcon("drip.png");
        ImageIcon espressoIcon = new ImageIcon("espresso.png");
        ImageIcon flatIcon = new ImageIcon("flatwhite.png");

	JLabel companyLabel = new JLabel ("    DEJA BREW       ");

	JLabel customerNameLabel = new JLabel (" Customer Name ");

	JTextField customerNameTextField = new JTextField(12);

	JLabel quantityPurchasedLabel = new JLabel ("Quantity Purchased");

	JTextField quantityPurchasedTextField = new JTextField(5);
        
        JLabel cashLabel = new JLabel("Cash"); 
        
        JTextField cashTextField = new JTextField(5);
              
	JRadioButton invisibleRadioButton = new JRadioButton();
	JRadioButton mochaRadioButton = new JRadioButton("[₱‎85]MOCHA");
        JRadioButton macchiatoRadioButton = new JRadioButton("₱[₱‎70]MACCHIATO");
	JRadioButton latteRadioButton = new JRadioButton("[₱‎80]LATTE");
	JRadioButton dripRadioButton = new JRadioButton("[₱‎90]DRIP");
	JRadioButton MatchaRadioButton = new JRadioButton("[₱‎120]MATCHA");
	JRadioButton AmerikanoRadioButton = new JRadioButton("[₱‎110]AMERIKANO");
	JRadioButton PinkDrinkRadioButton = new JRadioButton("[₱‎100]PINK DRINK");
	JRadioButton ChaiTeaRadioButton = new JRadioButton("[₱‎90]CHAI TEA");
	JRadioButton IcedEspressoRadioButton = new JRadioButton("[₱‎80]ICED ESPRESSO");
	JRadioButton CappuccinoRadioButton = new JRadioButton("[₱‎80]CAPPUCCINO");
	JRadioButton FlatWhiteRadioButton = new JRadioButton("[₱‎90]FLAT WHITE");
	JRadioButton FrappeRadioButton = new JRadioButton("[₱‎90]FRAPPE");
        JRadioButton NescafeRadioButton = new JRadioButton("[₱‎20]NESCAFE");
	ButtonGroup buttonGroup = new ButtonGroup();

	JTextArea outputTextArea = new JTextArea(5, 35);

	JScrollPane scrollPane = new JScrollPane(outputTextArea);

	JButton addToOrderButton = new JButton("Add To Order");

	JButton completeOrderButton = new JButton("Complete Order");

	JButton clearButton = new JButton ("Clear");

	JLabel grandTotalOutputLabel = new JLabel ();

	DecimalFormat currencyPattern = new DecimalFormat("₱#0.00");

	JLabel developerLabel = new JLabel ("DEVELOPER : TEAM CEDRICK");

	Font bigfont = new Font ("Helvetica", Font.ITALIC, 45);
        
        Font recieptfont = new Font("Times New Roman", Font.BOLD, 25);
        
        Font Quantityfont = new Font("Helvitica", Font.ITALIC, 16);

	int quantityPurchasedInteger;
        int cashInt;
	
        String customerNameString;
	String coffeeTypeString;
	
        float coffeePriceFloat;
	float accumulatedCostFloat;
        float taxTotalFloat;

	int HEIGHT_INTEGER = 720;
	int WIDTH_INTEGER = 520;


    final float MOCHA_PRICE_FLOAT = 85f;
    final float LATTE_PRICE_FLOAT = 80f;
    final float DRIP_PRICE_FLOAT = 89f;
    final float MATCHA_PRICE_FLOAT = 120f;
    final float AMERIKANO_PRICE_FLOAT = 110f;
    final float PINKDRINK_PRICE_FLOAT = 100f;
    final float CHAITEA_PRICE_FLOAT = 90f;
    final float ICEDESPRESSO_PRICE_FLOAT = 80f;
    final float CAPPUCCINO_PRICE_FLOAT = 80f;
    final float FLATWHITE_PRICE_FLOAT = 90f;
    final float FRAPPE_PRICE_FLOAT = 90f;
    final float NESCAFE_PRICE_FLOAT = 20f;
    final float MACCHIATO_PRICE_FLOAT = 70f;
    final float TAX_RATE_FLOAT = 0.00975f;

    float subTotalFloat; 

	public static void main(String[] args){
            Coffeeshop isMorningLift = new Coffeeshop();
            isMorningLift.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	}
                
        
	public Coffeeshop(){
		designClass();
		addListeners();
                setTitle("COFFEE SHOP");
                
                setIconImage(image.getImage());
		setContentPane(mainPanel);
                getContentPane().setBackground(Color.WHITE);
		
		setSize(WIDTH_INTEGER, HEIGHT_INTEGER);
		setVisible(true);

   }
	
        public void addListeners(){
		addToOrderButton.addActionListener(this);
		quantityPurchasedTextField.addActionListener(this);
                cashTextField.addActionListener(this);
		invisibleRadioButton.setSelected(true);
		completeOrderButton.addActionListener(this);
		clearButton.addActionListener(this);
	}	
        
	public void designClass(){
                                //set font on GUI
				companyLabel.setFont(bigfont);
                                companyLabel.setIcon(companyIcon);
                                companyLabel.setVerticalTextPosition(JLabel.BOTTOM);
                                companyLabel.setHorizontalTextPosition(JLabel.CENTER);
                                
                                //set images on GUI
                                MatchaRadioButton.setIcon(matchaIcon);
                                MatchaRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                MatchaRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                NescafeRadioButton.setIcon(nescafeIcon);
                                NescafeRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                NescafeRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                PinkDrinkRadioButton.setIcon(pinkIcon);
                                PinkDrinkRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                PinkDrinkRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                AmerikanoRadioButton.setIcon(amerikanoIcon);
                                AmerikanoRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                AmerikanoRadioButton.setHorizontalTextPosition(JLabel.CENTER);                                
                                
                                CappuccinoRadioButton.setIcon(cappuccinoIcon);
                                CappuccinoRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                CappuccinoRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                ChaiTeaRadioButton.setIcon(chaiteaIcon);
                                ChaiTeaRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                ChaiTeaRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                FrappeRadioButton.setIcon(frappeIcon);
                                FrappeRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                FrappeRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                latteRadioButton.setIcon(latteIcon);
                                latteRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                latteRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                macchiatoRadioButton.setIcon(macchiatoIcon);
                                macchiatoRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                macchiatoRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                        
                                dripRadioButton.setIcon(dripIcon);
                                dripRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                dripRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                mochaRadioButton.setIcon(mochaIcon);
                                mochaRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                mochaRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                IcedEspressoRadioButton.setIcon(espressoIcon);
                                IcedEspressoRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                IcedEspressoRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                
                                FlatWhiteRadioButton.setIcon(flatIcon);
                                FlatWhiteRadioButton.setVerticalTextPosition(JLabel.BOTTOM);
                                FlatWhiteRadioButton.setHorizontalTextPosition(JLabel.CENTER);
                                        
				//put JRadioButtons on GUI(graphical user interface)
				buttonGroup.add(invisibleRadioButton);
				buttonGroup.add(mochaRadioButton);
				buttonGroup.add(latteRadioButton);
				buttonGroup.add(dripRadioButton);
				buttonGroup.add(MatchaRadioButton);
				buttonGroup.add(AmerikanoRadioButton);
				buttonGroup.add(PinkDrinkRadioButton);
				buttonGroup.add(ChaiTeaRadioButton);
				buttonGroup.add(IcedEspressoRadioButton);
				buttonGroup.add(CappuccinoRadioButton);
				buttonGroup.add(FlatWhiteRadioButton);
				buttonGroup.add(FrappeRadioButton);
                                buttonGroup.add(NescafeRadioButton);
                                buttonGroup.add(macchiatoRadioButton);
				//add all labels company name and customer name.
				mainPanel.add(companyLabel);
				mainPanel.add(customerNameLabel);
				//add customer name text field to graphical user interface.
				mainPanel.add(customerNameTextField);
				//add quantity purchased label to GUI
				mainPanel.add(quantityPurchasedLabel);
				//add quantity purchased text field to GUI
				mainPanel.add(quantityPurchasedTextField);

				//add JRadioButtons to GUI
				mainPanel.add(mochaRadioButton);
				mainPanel.add(latteRadioButton);
				mainPanel.add(dripRadioButton);
				mainPanel.add(MatchaRadioButton);
				mainPanel.add(AmerikanoRadioButton);
				mainPanel.add(PinkDrinkRadioButton);
				mainPanel.add(ChaiTeaRadioButton);
				mainPanel.add(IcedEspressoRadioButton);
				mainPanel.add(CappuccinoRadioButton);
				mainPanel.add(FlatWhiteRadioButton);
				mainPanel.add(FrappeRadioButton);
                                mainPanel.add(NescafeRadioButton);
                                mainPanel.add(macchiatoRadioButton);
                                
				//add scroll pane to GUI
				mainPanel.add(scrollPane);
				//add the add to order button to GUI
				mainPanel.add(addToOrderButton);
				//add complete order button to GUI
				mainPanel.add(completeOrderButton);
				//add clear button to GUI
				mainPanel.add(clearButton);

		        //JLabels add to GUI

				//mainPanel.add(grandTotalLabel);

				//mainPanel.add(grandTotalOutputLabel);
                                
                                mainPanel.add(cashLabel);
                                
                                mainPanel.add(cashTextField);
                                
                                mainPanel.add(developerLabel);
                                
	}

                //action performed and 
	public void actionPerformed(ActionEvent e) {
                Object sourceObject = e.getSource();

	if(sourceObject == addToOrderButton ){	

	if(validation()){
            addToOrder(); //in the Processing instructions you said do NOT reset the textfields or the radio buttons unless clear button is pressed.
    }
        }
            else if (sourceObject == completeOrderButton){
			    	//calculates tax based on tax rate of 9.75% of total coffee purchase added to the subtotal for the grand total owed by the customer
					//displayed in a label below the text area next to Total Order Cost
			    	calculateTotal(); 
				}
				else if(sourceObject == clearButton)
			    {
				//call the method clear
					clearAll();
			    }
}
        
	public boolean validation(){
            boolean validationBoolean = false;

				if(customerNameTextField.getText().equals("")){
					customerNameTextField.requestFocus();
					JOptionPane.showMessageDialog(null, "Please enter name");
					customerNameTextField.requestFocus();
					validationBoolean = false;
				}else if(quantityPurchasedTextField.getText().equals("")){
					quantityPurchasedTextField.requestFocus();
					JOptionPane.showMessageDialog(null, "Please enter quantity");
					quantityPurchasedTextField.requestFocus();
					validationBoolean = false;
				}else if(invisibleRadioButton.isSelected()==true){
					JOptionPane.showMessageDialog(null, "Please select coffee type");
					validationBoolean = false;
				}else if(cashTextField.getText().equals("")){
                                        cashTextField.requestFocus();
                                        JOptionPane.showMessageDialog(null, "Please enter cash");
                                        validationBoolean = false;
                                }else{
					validationBoolean = true;
				}

				return validationBoolean;

			}
			
                    public void addToOrder(){
				float itemCostFloat;

				//if JRadioButtons are selected store cost 	
					if(mochaRadioButton.isSelected()==true){
						coffeeTypeString = "Mocha";
						coffeePriceFloat = MOCHA_PRICE_FLOAT;
					}
                                        else if(macchiatoRadioButton.isSelected()==true){
                                            coffeeTypeString = "Macchiato";
                                            coffeePriceFloat = MACCHIATO_PRICE_FLOAT;
                                        }
                                        else if(NescafeRadioButton.isSelected()==true){
                                                coffeeTypeString = "Nescafe";
                                                coffeePriceFloat = NESCAFE_PRICE_FLOAT;
                                        }
					else if(FrappeRadioButton.isSelected()==true){
						coffeeTypeString = "Frappe";
						coffeePriceFloat = FRAPPE_PRICE_FLOAT;
					}
					else if(FlatWhiteRadioButton.isSelected()==true){
						coffeeTypeString = "Flat White";
						coffeePriceFloat = FLATWHITE_PRICE_FLOAT;
					}
					else if(CappuccinoRadioButton.isSelected()==true){
						coffeeTypeString = "Cappuccino";
						coffeePriceFloat = CAPPUCCINO_PRICE_FLOAT;
					}
					else if(IcedEspressoRadioButton.isSelected()==true){
						coffeeTypeString = "Iced Espresso";
						coffeePriceFloat = ICEDESPRESSO_PRICE_FLOAT;
					}
					else if(ChaiTeaRadioButton.isSelected()==true){
						coffeeTypeString = "Chai Tea";
						coffeePriceFloat = CHAITEA_PRICE_FLOAT;
					}
					else if(PinkDrinkRadioButton.isSelected()==true){
						coffeeTypeString = "Pink Drink";
						coffeePriceFloat = PINKDRINK_PRICE_FLOAT;
					}
					else if(AmerikanoRadioButton.isSelected()==true){
						coffeeTypeString = "Amerikano";
						coffeePriceFloat = AMERIKANO_PRICE_FLOAT;
					}
					else if(MatchaRadioButton.isSelected()==true){
						coffeeTypeString = "Matcha";
						coffeePriceFloat = MATCHA_PRICE_FLOAT;
					}
					else if(latteRadioButton.isSelected()==true){
						coffeeTypeString = "Latte";
						coffeePriceFloat = LATTE_PRICE_FLOAT;
					}
					else {
						coffeeTypeString = "Drip";
						coffeePriceFloat = DRIP_PRICE_FLOAT;
					}
					
					        customerNameString = customerNameTextField.getText();
						quantityPurchasedInteger = Integer.parseInt(quantityPurchasedTextField.getText());
                                                cashInt = Integer.parseInt(cashTextField.getText());
                                                

						itemCostFloat = quantityPurchasedInteger * coffeePriceFloat;
						subTotalFloat += itemCostFloat;

						outputTextArea.append("Name: " + customerNameString + "\t"
											+ "Quantity: " + quantityPurchasedInteger + "\t"
											+ "Coffee Type: " + coffeeTypeString + "\t"
											+ "Total: " + currencyPattern.format(itemCostFloat)+"\n");

						// Just clears the THE QTY TEXTFIELD AND CLEAR THE RADIO BUTTONS
						buttonGroup.clearSelection();
						quantityPurchasedTextField.setText("");
			}						
                        
        public void clearAll(){
            customerNameTextField.setText("");
            customerNameTextField.requestFocus();
            quantityPurchasedTextField.setText("");
            cashTextField.setText("");
            outputTextArea.setText("");
            buttonGroup.clearSelection();
            grandTotalOutputLabel.setText("");
	}
                        
	public void calculateTotal(){
            float accumulatedCostFloat; 
            
            accumulatedCostFloat = cashInt - subTotalFloat;
            
            
            // Just clears the THE QTY TEXTFIELD AND CLEAR THE RADIO BUTTONS
            buttonGroup.clearSelection();
            quantityPurchasedTextField.setText("");

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

            String formattedDate = time.format(format);
            
            Random random = new Random();
            int min = 1;
            int max = 10000;
            int randomNumber = random.nextInt(max - min + 1) + min;
           
            JFrame RecieptFrame = new JFrame("Reciept");
            
            JPanel RecieptPanel = new JPanel();
            RecieptPanel.setLayout(new BoxLayout(RecieptPanel, BoxLayout.Y_AXIS));
            JLabel StoreLabel = new JLabel("DEJA BREW");
            StoreLabel.setFont(recieptfont);
            StoreLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel LocationLabel = new JLabel("789 C3 ROAD, DAGAT-DAGATAN");
            LocationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel LandmarkLabel = new JLabel("CALOOCAN CITY, PHILIPPINES");
            LandmarkLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel NumberLabel = new JLabel("Phone:" + " 0919 258 4378");
            NumberLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Line = new JLabel("__________________________________");
            Line.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel NumberDate = new JLabel();
            NumberDate.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            NumberDate.setText("Order #" + randomNumber + " Date " + formattedDate);
            
            JLabel ServerName = new JLabel("Server Name: " + "YUANNE CARY");
            ServerName.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Name = new JLabel("Customer Name: " + customerNameString);
            Name.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Blank = new JLabel("                            ");
            
            
            JLabel Items = new JLabel("Item Quantity Price");
            Items.setFont(Quantityfont);
            Items.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Quantity = new JLabel();
            Quantity.setText("Quantity : " + quantityPurchasedInteger);
            Quantity.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Coffee = new JLabel();
            Coffee.setText("Coffee Type : " + coffeeTypeString);
            Coffee.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Cash = new JLabel("Cash : ₱" + cashInt);
            Cash.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel SubTotal = new JLabel("Sub Total : ₱" + subTotalFloat);
            SubTotal.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Total = new JLabel("Total Change : ₱" + accumulatedCostFloat);
            Total.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel Line2 = new JLabel("__________________________________");
            Line2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            JLabel End = new JLabel("Thank you for dining with us!");
            End.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            
            RecieptFrame.setVisible(rootPaneCheckingEnabled);
            RecieptFrame.setSize(300, 330);

            RecieptFrame.setContentPane(RecieptPanel);
            
            //add to reciept panel
            RecieptPanel.add(StoreLabel);
            RecieptPanel.add(LocationLabel);
            RecieptPanel.add(LandmarkLabel);
            RecieptPanel.add(NumberLabel);
            RecieptPanel.add(Line);
            RecieptPanel.add(NumberDate);
            RecieptPanel.add(ServerName);
            RecieptPanel.add(Name);
            RecieptPanel.add(Blank);
            RecieptPanel.add(Items);
            RecieptPanel.add(Quantity);
            RecieptPanel.add(Coffee);
            RecieptPanel.add(SubTotal);
            RecieptPanel.add(Cash);
            RecieptPanel.add(Total);
            RecieptPanel.add(Line2);
            RecieptPanel.add(End);
            
	}
        
}