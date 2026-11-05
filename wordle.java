import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Random;
/**
 *
 * Description
 *
 * @version 1.0 from 05.11.2026
 * @author 
 */

public class wordle extends JFrame {
  // start attributes
  private JLabel lA8 = new JLabel();
  private JLabel lB8 = new JLabel();
  private JLabel lC8 = new JLabel();
  private JLabel lD7 = new JLabel();
  private JLabel lE7 = new JLabel();
  private JTextField jEingabe = new JTextField();
  private JButton bPruefen1 = new JButton();
  private JLabel lVersuch1 = new JLabel();
  private JLabel l_runde_anzeige = new JLabel();
  private String gesuchtesWort = "";
  private char[] mainWordleWordChars;
  private int runde = 1;
  private int versuche = 6;
  private boolean isGameFinished = false;
  private boolean isGameRestart = false;
  private JLabel lA1 = new JLabel();
  private JLabel lA2 = new JLabel();
  private JLabel lA3 = new JLabel();
  private JLabel lA4 = new JLabel();
  private JLabel lB1 = new JLabel();
  private JLabel lB2 = new JLabel();
  private JLabel lB3 = new JLabel();
  private JLabel lB4 = new JLabel();
  private JLabel lC1 = new JLabel();
  private JLabel lC2 = new JLabel();
  private JLabel lC3 = new JLabel();
  private JLabel lC4 = new JLabel();
  private JLabel lD1 = new JLabel();
  private JLabel lD2 = new JLabel();
  private JLabel lD3 = new JLabel();
  private JLabel lD4 = new JLabel();
  private JLabel lE1 = new JLabel();
  private JLabel lE2 = new JLabel();
  private JLabel lE3 = new JLabel();
  private JLabel lE4 = new JLabel();
  private JLabel lDeinTipp1 = new JLabel();
  private JLabel lA5 = new JLabel();
  private JLabel lB5 = new JLabel();
  private JLabel lC5 = new JLabel();
  private JLabel lD5 = new JLabel();
  private JLabel lE5 = new JLabel();
  private JLabel lHinweis2 = new JLabel();
  private JLabel lA7 = new JLabel();
  private JLabel lB7 = new JLabel();
  private JLabel lC7 = new JLabel();
  private JLabel lBuchstabeankorrekterStelle1 = new JLabel();
  private JLabel lBuchstabeimWort2 = new JLabel();
  private JLabel lBuchstabenichtimWort1 = new JLabel();
  // end attributes
  
  public wordle() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 336; 
    int frameHeight = 670;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Wordle");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    
    lA8.setBounds(0, 0, 64, 64);
    lA8.setText("A1");
    lA8.setHorizontalAlignment(SwingConstants.CENTER);
    lA8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lA8);
    lB8.setBounds(64, 0, 64, 64);
    lB8.setText("B1");
    lB8.setHorizontalAlignment(SwingConstants.CENTER);
    lB8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lB8);
    lC8.setBounds(128, 0, 64, 64);
    lC8.setText("C1");
    lC8.setHorizontalAlignment(SwingConstants.CENTER);   
    lC8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lC8);
    lD7.setBounds(192, 0, 64, 64);
    lD7.setText("D1");
    lD7.setHorizontalAlignment(SwingConstants.CENTER);  
    lD7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lD7);
    lE7.setBounds(256, 0, 64, 64);
    lE7.setText("E1");
    lE7.setHorizontalAlignment(SwingConstants.CENTER); 
    lE7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lE7);
    jEingabe.setBounds(88, 392, 136, 24);
    cp.add(jEingabe);
    bPruefen1.setBounds(232, 392, 80, 24);
    bPruefen1.setText("Prüfen");
    bPruefen1.setMargin(new Insets(2, 2, 2, 2));
    bPruefen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bPruefen1_ActionPerformed(evt);
      }
    });
    cp.add(bPruefen1);
    lVersuch1.setBounds(16, 432, 55, 24);
    lVersuch1.setText("Versuch:");
    cp.add(lVersuch1);
    l_runde_anzeige.setBounds(80, 432, 232, 24);
    l_runde_anzeige.setText("1");
    cp.add(l_runde_anzeige);
    lA1.setBounds(0, 64, 64, 64);
    lA1.setText("A2");
    lA1.setHorizontalAlignment(SwingConstants.CENTER);  
    lA1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lA1);
    lA2.setBounds(0, 128, 64, 64);
    lA2.setText("A3");
    lA2.setHorizontalAlignment(SwingConstants.CENTER);  
    lA2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lA2);
    lA3.setBounds(0, 192, 64, 64);
    lA3.setText("A4");
    lA3.setHorizontalAlignment(SwingConstants.CENTER);    
    lA3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lA3);
    lA4.setBounds(0, 256, 64, 64);
    lA4.setText("A5");
    lA4.setHorizontalAlignment(SwingConstants.CENTER);    
    lA4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lA4);
    lB1.setBounds(64, 64, 64, 64);
    lB1.setText("B2");
    lB1.setHorizontalAlignment(SwingConstants.CENTER);  
    lB1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lB1);
    lB2.setBounds(64, 128, 64, 64);
    lB2.setText("B3");
    lB2.setHorizontalAlignment(SwingConstants.CENTER);  
    lB2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lB2);
    lB3.setBounds(64, 192, 64, 64);
    lB3.setText("B4");
    lB3.setHorizontalAlignment(SwingConstants.CENTER); 
    lB3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lB3);
    lB4.setBounds(64, 256, 64, 64);
    lB4.setText("B5");
    lB4.setHorizontalAlignment(SwingConstants.CENTER);   
    lB4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lB4);
    lC1.setBounds(128, 64, 64, 64);
    lC1.setText("C2");
    lC1.setHorizontalAlignment(SwingConstants.CENTER);    
    lC1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lC1);
    lC2.setBounds(128, 128, 64, 64);
    lC2.setText("C3");
    lC2.setHorizontalAlignment(SwingConstants.CENTER); 
    lC2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lC2);
    lC3.setBounds(128, 192, 64, 64);
    lC3.setText("C4");
    lC3.setHorizontalAlignment(SwingConstants.CENTER);  
    lC3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lC3);
    lC4.setBounds(128, 256, 64, 64);
    lC4.setText("C5");
    lC4.setHorizontalAlignment(SwingConstants.CENTER);  
    lC4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lC4);
    lD1.setBounds(192, 64, 64, 64);
    lD1.setText("D2");
    lD1.setHorizontalAlignment(SwingConstants.CENTER); 
    lD1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lD1);
    lD2.setBounds(192, 128, 64, 64);
    lD2.setText("D3");
    lD2.setHorizontalAlignment(SwingConstants.CENTER); 
    lD2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lD2);
    lD3.setBounds(192, 192, 64, 64);
    lD3.setText("D4");
    lD3.setHorizontalAlignment(SwingConstants.CENTER);   
    lD3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lD3);
    lD4.setBounds(192, 256, 64, 64);
    lD4.setText("D5");
    lD4.setHorizontalAlignment(SwingConstants.CENTER); 
    lD4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lD4);
    lE1.setBounds(256, 64, 64, 64);
    lE1.setText("E2");
    lE1.setHorizontalAlignment(SwingConstants.CENTER);  
    lE1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lE1);
    lE2.setBounds(256, 128, 64, 64);
    lE2.setText("E3");
    lE2.setHorizontalAlignment(SwingConstants.CENTER);   
    lE2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lE2);
    lE3.setBounds(256, 192, 64, 64);
    lE3.setText("E4");
    lE3.setHorizontalAlignment(SwingConstants.CENTER);  
    lE3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lE3);
    lE4.setBounds(256, 256, 64, 64);
    lE4.setText("E5");
    lE4.setHorizontalAlignment(SwingConstants.CENTER); 
    lE4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lE4);
    lDeinTipp1.setBounds(8, 392, 72, 24);
    lDeinTipp1.setText("Dein Tipp:");
    cp.add(lDeinTipp1);
    lA5.setBounds(0, 320, 64, 64);
    lA5.setText("A6");
    lA5.setHorizontalAlignment(SwingConstants.CENTER); 
    lA5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lA5);
    lB5.setBounds(64, 320, 64, 64);
    lB5.setText("B6");
    lB5.setHorizontalAlignment(SwingConstants.CENTER);
    lB5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lB5);
    lC5.setBounds(128, 320, 64, 64);
    lC5.setText("C6");
    lC5.setHorizontalAlignment(SwingConstants.CENTER); 
    lC5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lC5);
    lD5.setBounds(192, 320, 64, 64);
    lD5.setText("D6");
    lD5.setHorizontalAlignment(SwingConstants.CENTER);
    lD5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lD5);
    lE5.setBounds(256, 320, 64, 64);
    lE5.setText("E6");
    lE5.setHorizontalAlignment(SwingConstants.CENTER);
    lE5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lE5);
    lHinweis2.setBounds(16, 472, 80, 24);
    lHinweis2.setText("Hinweis:");
    cp.add(lHinweis2);
    lA7.setBounds(88, 472, 40, 40);
    lA7.setText("A");
    lA7.setHorizontalAlignment(SwingConstants.CENTER);
    lA7.setBackground(Color.GREEN);
    lA7.setOpaque(true);
    
    lA7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lA7);
    lB7.setBounds(88, 520, 40, 40);
    lB7.setText("B");
    lB7.setHorizontalAlignment(SwingConstants.CENTER);
    lB7.setBackground(Color.YELLOW);
    lB7.setOpaque(true);
    
    lB7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lB7);
    lC7.setBounds(88, 568, 40, 40);
    lC7.setText("C");
    lC7.setHorizontalAlignment(SwingConstants.CENTER);
    lC7.setOpaque(true);
    lC7.setBackground(new Color(0xC0C0C0));
    lC7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    cp.add(lC7);
    lBuchstabeankorrekterStelle1.setBounds(136, 480, 177, 24);
    lBuchstabeankorrekterStelle1.setText("Buchstabe an korrekter Stelle.");
    cp.add(lBuchstabeankorrekterStelle1);
    lBuchstabeimWort2.setBounds(136, 528, 116, 24);
    lBuchstabeimWort2.setText("Buchstabe im Wort.");
    cp.add(lBuchstabeimWort2);
    lBuchstabenichtimWort1.setBounds(136, 576, 147, 24);
    lBuchstabenichtimWort1.setText("Buchstabe nicht im Wort.");
    cp.add(lBuchstabenichtimWort1);
    // end components
    
    setVisible(true);
    start();
    
    
  } // end of public wordle
  
  private void start() {
    gesuchtesWort = getWord().toUpperCase().trim();
    System.out.println(gesuchtesWort);
    isGameFinished = false;
    isGameRestart = false;
    runde = 1;
    mainWordleWordChars = gesuchtesWort.toCharArray();
    for (int i = 0; i < 6; i++) {
      setzeWortInAusgabe(i+1,new char[] { ' ',' ',' ',' ',' '})  ;
    }
    bPruefen1.setText("Prüfen");
    l_runde_anzeige.setText(runde + " von " + versuche);
  }
  public void setzeWortInAusgabe(int zeile, char[] buchstaben){
    if(buchstaben.length !=5){
      JOptionPane.showMessageDialog(null, "Das Array ist keine 5 Zeichen lang!","Fehler", JOptionPane.ERROR_MESSAGE);
    }
    
    if(zeile == 1){
      lA8.setText(buchstaben[0]+"");
      lA8.setOpaque(false);
      lB8.setText(buchstaben[1]+"");
      lB8.setOpaque(false);
      lC8.setText(buchstaben[2]+"");
      lC8.setOpaque(false);
      lD7.setText(buchstaben[3]+"");
      lD7.setOpaque(false);
      lE7.setText(buchstaben[4]+"");
      lE7.setOpaque(false);
      
    } else if (zeile == 2) {
      lA1.setText(buchstaben[0]+"");
      lA1.setOpaque(false);
      lB1.setText(buchstaben[1]+"");  
      lB1.setOpaque(false);
      lC1.setText(buchstaben[2]+""); 
      lC1.setOpaque(false);
      lD1.setText(buchstaben[3]+""); 
      lD1.setOpaque(false);
      lE1.setText(buchstaben[4]+"");  
      lE1.setOpaque(false);
    } else if (zeile == 3) {
      lA2.setText(buchstaben[0]+"");  
      lA2.setOpaque(false);
      lB2.setText(buchstaben[1]+"");  
      lB2.setOpaque(false);
      lC2.setText(buchstaben[2]+""); 
      lC2.setOpaque(false);
      lD2.setText(buchstaben[3]+""); 
      lD2.setOpaque(false);
      lE2.setText(buchstaben[4]+""); 
      lE2.setOpaque(false); 
    }else if (zeile == 4) {
      lA3.setText(buchstaben[0]+""); 
      lA3.setOpaque(false);
      lB3.setText(buchstaben[1]+"");  
      lB3.setOpaque(false);
      lC3.setText(buchstaben[2]+""); 
      lC3.setOpaque(false);
      lD3.setText(buchstaben[3]+""); 
      lD3.setOpaque(false);
      lE3.setText(buchstaben[4]+""); 
      lE3.setOpaque(false); 
    } else if (zeile == 5) {
      lA4.setText(buchstaben[0]+""); 
      lA4.setOpaque(false);
      lB4.setText(buchstaben[1]+"");
      lB4.setOpaque(false);
      lC4.setText(buchstaben[2]+""); 
      lC4.setOpaque(false);
      lD4.setText(buchstaben[3]+""); 
      lD4.setOpaque(false);
      lE4.setText(buchstaben[4]+""); 
      lE4.setOpaque(false); 
    }  else if (zeile == 6) {
      lA5.setText(buchstaben[0]+""); 
      lA5.setOpaque(false);
      lB5.setText(buchstaben[1]+""); 
      lB5.setOpaque(false);
      lC5.setText(buchstaben[2]+""); 
      lC5.setOpaque(false);
      lD5.setText(buchstaben[3]+"");
      lD5.setOpaque(false);
      lE5.setText(buchstaben[4]+""); 
      lE5.setOpaque(false); 
    }
  }
  public String getWord(){
    // Reading words
    Path wordsPath = Path.of("./woerter.txt");
    try (Stream<String> lines = Files.lines(wordsPath)) {
      // Initializing game
      ArrayList wordsList =  new ArrayList<>(Arrays.asList(lines.toArray(String[]::new)));
      
      int zufall = new Random().nextInt(wordsList.size());
      return wordsList.get(zufall).toString();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, Files.exists(wordsPath) ? e.toString() : "woerter.txt existiert nicht", "Fehler", JOptionPane.ERROR_MESSAGE);
      return "";
    } 
  }
  // start methods
  
  public static void main(String[] args) {
    new wordle();
  } // end of main
  

  public void bPruefen1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    String eingabe =  jEingabe.getText().trim().toUpperCase();
    char[] eingabeArr = eingabe.toCharArray();
    jEingabe.setText("");
    
    
    if(isGameRestart){
      start();
    } else      if (eingabe.length() != 5) {
      JOptionPane.showMessageDialog(null, "Die Eingabe ist keine 5 Zeichen lang!","Fehler", JOptionPane.ERROR_MESSAGE);
    } else if(runde <= versuche && ! isGameFinished){
      
      setzeWortInAusgabe(runde,eingabeArr);
      isGameFinished = uberpruefeWort(runde,eingabeArr);
      
      runde++;
      
      
      if(  runde<=versuche && !isGameFinished){
        l_runde_anzeige.setText(runde + " von " + versuche);
      } else if(  runde<=versuche && isGameFinished){
        l_runde_anzeige.setText("Glückwunsch, das Wort ist korrekt!");
        JOptionPane.showMessageDialog(null, "Glückwunsch, das Wort ist korrekt!");
        bPruefen1.setText("Neustart");
        isGameRestart = true;
      } else {
        isGameFinished = true;
        l_runde_anzeige.setText("Fertig");
      } // end of if-else
    } // end of if-else
    
    
    
  } // end of bPruefen1_ActionPerformed
  
  
  public boolean uberpruefeWort(int zeile, char[] eingabeArr ) {
    
    int korrekt = 0;
    
    for (int i = 0; i < eingabeArr.length; i++) {
      
      Color labelColor;
      char currentChar = eingabeArr[i];
       
      if (currentChar == mainWordleWordChars[i]) {
        labelColor = Color.GREEN;
        korrekt++;
      } else if (gesuchtesWort.indexOf(currentChar) >= 0) {
        labelColor = Color.YELLOW;
      } else {
        labelColor = Color.LIGHT_GRAY;
      }
      
      if(i == 0){
        if (zeile==1) {
          lA8.setOpaque(true);
          lA8.setBackground(labelColor);  
        } else if (zeile==2) {
          lA1.setOpaque(true);
          lA1.setBackground(labelColor);   
        }  else if (zeile==3) {
          lA2.setOpaque(true);
          lA2.setBackground(labelColor);   
        }  else if (zeile==4) {
          lA3.setOpaque(true);
          lA3.setBackground(labelColor);   
        }  else if (zeile==5) {
          lA4.setOpaque(true);
          lA4.setBackground(labelColor);   
        }  else if (zeile==6) {
          lA5.setOpaque(true);
          lA5.setBackground(labelColor);   
        }           
        
      }else if(i == 1){         
        if (zeile==1) {
          lB8.setOpaque(true);
          lB8.setBackground(labelColor);  
        } else if (zeile==2) {
          lB1.setOpaque(true);
          lB1.setBackground(labelColor);   
        }  else if (zeile==3) {
          lB2.setOpaque(true);
          lB2.setBackground(labelColor);   
        }  else if (zeile==4) {
          lB3.setOpaque(true);
          lB3.setBackground(labelColor);   
        }  else if (zeile==5) {
          lB4.setOpaque(true);
          lB4.setBackground(labelColor);   
        }  else if (zeile==6) {
          lB5.setOpaque(true);
          lB5.setBackground(labelColor);   
        }          
      }else if(i == 2) {
        if (zeile==1) {
          lC8.setOpaque(true);
          lC8.setBackground(labelColor);  
        } else if (zeile==2) {
          lC1.setOpaque(true);
          lC1.setBackground(labelColor);   
        }  else if (zeile==3) {
          lC2.setOpaque(true);
          lC2.setBackground(labelColor);   
        }  else if (zeile==4) {
          lC3.setOpaque(true);
          lC3.setBackground(labelColor);   
        }  else if (zeile==5) {
          lC4.setOpaque(true);
          lC4.setBackground(labelColor);   
        } else if (zeile==6) {
          lC5.setOpaque(true);
          lC5.setBackground(labelColor);   
        }         
      }else if(i == 3)     {     
        if (zeile==1) {
          lD7.setOpaque(true);
          lD7.setBackground(labelColor);  
        } else if (zeile==2) {
          lD1.setOpaque(true);
          lD1.setBackground(labelColor);   
        }  else if (zeile==3) {
          lD2.setOpaque(true);
          lD2.setBackground(labelColor);   
        }  else if (zeile==4) {
          lD3.setOpaque(true);
          lD3.setBackground(labelColor);   
        }  else if (zeile==5) {
          lD4.setOpaque(true);
          lD4.setBackground(labelColor);   
        } else if (zeile==6) {
          lD5.setOpaque(true);
          lD5.setBackground(labelColor);   
        }            
      }else if(i == 4)  {
        if (zeile==1) {
          lE7.setOpaque(true);
          lE7.setBackground(labelColor);  
        } else if (zeile==2) {
          lE1.setOpaque(true);
          lE1.setBackground(labelColor);   
        }  else if (zeile==3) {
          lE2.setOpaque(true);
          lE2.setBackground(labelColor);   
        }  else if (zeile==4) {
          lE3.setOpaque(true);
          lE3.setBackground(labelColor);   
        }  else if (zeile==5) {
          lE4.setOpaque(true);
          lE4.setBackground(labelColor);   
        } else if (zeile==6) {
          lE5.setOpaque(true);
          lE5.setBackground(labelColor);   
        }         
      } 
    }
    
    if (korrekt == 5) {
      return true;
    } else {
      return false;
    } // end of if-else
    
  }
  // end methods
} // end of class wordl
