package crsework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Arunas
 * 
 */





public class GUI implements ActionListener{
        private String algorithm="",function="";
        private JFrame myFrame,myFrame2,myFrame3; 
        private JTextArea displayTextArea;  //TextArea is same as textfield but its area can be increased
        private JScrollPane scroll;         // Scroll pane i have used for in text area to display text completely
        private JLabel rangeLabel,decimalLabel;
        private JTextField rangeTextField,decimalTextField;
        private JLabel rangeLabel2,decimalLabel2,xInputLabel2;
        private JTextField rangeTextField2,decimalTextField2,xInputTextField2;
        private JButton submitBtn,submitBtn2,submitBtn3;          
        private JComboBox algorithmComboBox,functionComboBox;       //ComboBox to select function and algorithms
    public GUI()
    {
        initGUI();
    }
    public void initializeJFrame3()
    {
            myFrame3=new JFrame();
            //myFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame3.setSize(500,350);
            
            rangeLabel2=new JLabel("Write your f(x) range:");
            rangeLabel2.setBounds(100, 100, 125, 20);
            rangeTextField2=new JTextField(10);
            rangeTextField2.setBounds(230, 100, 100, 20);
            decimalLabel2=new JLabel("Decimal places (0.01):");
            decimalLabel2.setBounds(100, 140, 125, 20);
            decimalTextField2=new JTextField(10);
            decimalTextField2.setBounds(230, 140, 100, 20);
            xInputLabel2=new JLabel("Enter x input here:");
            xInputLabel2.setBounds(100, 180, 125, 20);
            xInputTextField2=new JTextField(10);
            xInputTextField2.setBounds(230, 180, 100, 20);
            
            submitBtn3=new JButton("SUBMIT");
            submitBtn3.setBounds(175, 210,100,20);
            
            Container c3=myFrame3.getContentPane();
            c3.setLayout(null);
            
            c3.add(rangeLabel2);
            c3.add(decimalLabel2);
            c3.add(rangeTextField2);
            c3.add(decimalTextField2);
            c3.add(xInputTextField2);
            c3.add(xInputLabel2);
            c3.add(submitBtn3);
            submitBtn3.addActionListener(this);
    }
    public void initializeJFrame2()
    {
            myFrame2=new JFrame();
            //myFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame2.setSize(500,350);
            
            rangeLabel=new JLabel("Write your f(x) range:");
            rangeLabel.setBounds(100, 100, 125, 20);
            rangeTextField=new JTextField(10);
            rangeTextField.setBounds(230, 100, 100, 20);
            decimalLabel=new JLabel("Decimal places (0.01):");
            decimalLabel.setBounds(100, 140, 125, 20);
            decimalTextField=new JTextField(10);
            decimalTextField.setBounds(230, 140, 100, 20);
            submitBtn2=new JButton("SUBMIT");
            submitBtn2.setBounds(175, 170,100,20);
            
            Container c2=myFrame2.getContentPane();
            c2.setLayout(null);
            
            c2.add(rangeLabel);
            c2.add(decimalLabel);
            c2.add(rangeTextField);
            c2.add(decimalTextField);
            c2.add(submitBtn2);
            submitBtn2.addActionListener(this);
    }
    public void initGUI(){
        initializeJFrame2();
        initializeJFrame3();
        myFrame=new JFrame();   //Initializing window
        Container c=myFrame.getContentPane();
        c.setLayout(null);

        displayTextArea=new JTextArea();    //Initializing textArea
        scroll=new JScrollPane(displayTextArea);    
        scroll.setBounds(20, 230,550,300);          //Placing scroll on frame and telling its location and width and height
        displayTextArea.setEditable(false);   //You can remove this line if you want to edit textarea  
        JLabel functionLabel=new JLabel("Select a Function");
        functionLabel.setBounds(40, 100, 100, 20);
        JLabel algorithmLabel=new JLabel("Select an Algorithm");
        algorithmLabel.setBounds(40, 140, 150, 20);

        submitBtn=new JButton("SUBMIT");

        String functions[]={"x-x^2","ln(x+1)+1","e^x-3x"};      //Initializing array to place in combobox
        String algorithms[]={"Newton-Raphson","Secant","Bisection","Other method"};

        algorithmComboBox=new JComboBox(algorithms);   
        algorithmComboBox.setBounds(190, 140,130,20);

        //adding all things in container
        c.add(algorithmComboBox);
        c.add(functionLabel);
        c.add(algorithmLabel);


        functionComboBox=new JComboBox(functions);    
        functionComboBox.setBounds(190, 100,100,20);

        submitBtn.setBounds(40, 180,100,20);    

        c.add(functionComboBox);
        c.add(algorithmComboBox);
        c.add(submitBtn);
        c.add(scroll);

        //adding action listener of submit button
        submitBtn.addActionListener(this);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(640,640);
        myFrame.setVisible(true);
    }
        
    public void actionPerformed(ActionEvent event){
        //This if statement will tell us which button is pressed. Button Jframe1 or on JFrame2
        if(event.getSource()==submitBtn3)
        {
            //This if statement will check if we had entered something in all textfields.
            if(rangeTextField2.getText().equals("") || decimalTextField2.getText().equals("")|| xInputTextField2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter All Fields");
            }else{
                String decimalString="",rangeString="",xInputString="";
                double decimal=0.000001,range=0,xInput=0;
                myFrame3.setVisible(false); //This will make jframe2 invisible after button is pressed on jframe2
                try{
                    decimalString=decimalTextField2.getText().toString();//This is getting textField value
                }catch(Exception e){
                    System.err.println("Cannot parse string into integer");
                }
                try{
                    rangeString=rangeTextField2.getText().toString();
                }catch(Exception e){
                    System.err.println("Cannot parse string into integer");
             
                }try{
                    xInputString=xInputTextField2.getText().toString();//This is getting textField value
                }catch(Exception e){
                    System.err.println("Cannot parse string into integer");
                }
                try{
                     decimal=Double.parseDouble(decimalString);
                }catch(Exception e){
                    System.err.println("Cannot parse string into integer");
                }
                try{
                      range=Double.parseDouble(rangeString);
                }catch(Exception e){
                      System.err.println("Cannot parse string into integer");
                }
                try{
                      xInput=Double.parseDouble(xInputString);
                }catch(Exception e){
                      System.err.println("Cannot parse string into integer");
                }
                //These if else statements will call their respective classes
                //I have passed the range and decimal in class constructor.
                //The code of algorithms was written in constructor but i moved that code in a function findRoots because
                // We cannot return a String from constructor.
                // I have assigned that string to textarea here
                if(algorithm.equals("Secant")){
                    SecantMethod sm=new SecantMethod();
                    String intervals=sm.findRoots(range,decimal,xInput);
                    displayTextArea.setText(intervals);
                }else if(algorithm.equals("Bisection")){
                    BisectionMethod bsm=new BisectionMethod();
                    String intervals=bsm.findRoots(range,decimal,xInput);
                    displayTextArea.setText(intervals);
                }else if(algorithm.equals("Other method")){

                }
            }
        }
        if(event.getSource()==submitBtn2)
        {
            //This if statement will check if we had entered something in both textfields.
            if(rangeTextField.getText().equals("") || decimalTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter All Fields");
            }
            else{
                String decimalString="",rangeString="";
                double decimal=0.000001,range=0;
                myFrame2.setVisible(false); //This will make jframe2 invisible after button is pressed on jframe2
                try{
                    decimalString=decimalTextField.getText().toString();//This is getting textField value
                }catch(Exception e){
                    System.err.println("Cannot parse string into integer");
                }
                try{
                    rangeString=rangeTextField.getText().toString();
                }catch(Exception e){
                    System.err.println("Cannot parse string into integer");
             
                }
                
                try{
                     decimal=Double.parseDouble(decimalString);
                }catch(Exception e){
                    System.err.println("Cannot parse string into integer");
                }
                try{
                      range=Double.parseDouble(rangeString);
                }catch(Exception e){
                      System.err.println("Cannot parse string into integer");
                }
                //These if else statements will call their respective classes
                if(algorithm.equals("Newton-Raphson")){
                    //I have passed the range and decimal in class constructor. you can modify it according to your need
                    NewtonRaphson nrs=new NewtonRaphson();
                    //The code of algorithms was written in constructor but i moved that code in a function findRoots because
                    // We cannot return a String from constructor.
                    String intervals=nrs.findRoots(range,decimal);
                    // I have assigned that string to textarea here
                    displayTextArea.setText(intervals);
                }
            }
        }
        else if(event.getSource()==submitBtn)
        {
            //Place selected algorithm and function from combo box in these varibles 
            try{
            //These variables i have declared on class level now to access them easily on pressing button
                algorithm=algorithmComboBox.getSelectedItem().toString();
            }catch(Exception e){
                System.err.println(e);
            }
            try{
                function=functionComboBox.getSelectedItem().toString();
            }catch(Exception e){
                System.err.println(e);
            }
            if(algorithm.equals("Secant") || algorithm.equals("Bisection")){
                myFrame3.setVisible(true);
            
            }else if (algorithm.equals("Newton-Raphson")){
                myFrame2.setVisible(true);
                
            }
            
        }
    } 
}

