/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {
    
    private final JTextField txtFile; // displays file
    private final JTextArea text; // displays file
    private final JButton encryptJButton;
    private final JButton decryptJButton;
    private final JButton saveJButton;

	Ventana(){
    	super("Testing cipher");
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        JPanel fileJPanel = new JPanel();
    	fileJPanel.setLayout(new FlowLayout());
        JLabel lblFile = new JLabel( "Archivo de texto/cifrado:" );
        fileJPanel.add(lblFile);
        txtFile = new JTextField(20);
        fileJPanel.add(txtFile);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(10,15);
    	add(text, BorderLayout.CENTER);
        
        JPanel buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new BorderLayout());
        encryptJButton = new JButton("encrypt");
    	buttonJPanel.add(encryptJButton, BorderLayout.NORTH);
    	decryptJButton = new JButton("decrypt"	);
    	buttonJPanel.add(decryptJButton, BorderLayout.CENTER);
    	saveJButton = new JButton("Guardar");
    	buttonJPanel.add(saveJButton, BorderLayout.SOUTH);
        add(buttonJPanel, BorderLayout.EAST);
        
        txtFile.addActionListener(new txtAccion());
        btnEncriptar e = new btnEncriptar();
        btnDESncriptar e2 = new btnDESncriptar();
        
        encryptJButton.addActionListener(e);
        decryptJButton.addActionListener(e2);
    }
    
    class txtAccion implements ActionListener{
    	@Override
          public void actionPerformed(ActionEvent event)
          {
          	text.setText(event.getActionCommand());
          }
    }
    
    class btnEncriptar implements ActionListener{
    	@Override
        public void actionPerformed(ActionEvent e){
            Encriptado en = new Encriptado();
            
            //1.-Leer el texto del textarea
            	String encript = text.getText();
            //2.-Encriptar el texto
            	String textoEncriptado = en.encriptar(en.chars(txtFile.getText()));
            //3.-Poner el texto en el text area
            	text.setText(textoEncriptado);
        }
    }		
    
    class btnDESncriptar implements ActionListener{
    	@Override
        public void actionPerformed(ActionEvent e){
            Encriptado en = new Encriptado();
            
            //1.-Leer el texto del textarea
            	String encript = text.getText();
            //2.-Encriptar el texto
            	String textoEncriptado = en.desencriptar(en.chars(txtFile.getText()));
            //3.-Poner el texto en el text area
            	text.setText(textoEncriptado);
        }
    }
    

    
    String encriptar(String s){
    	return s + "encriptado";
    }
    
    
   public static void main(String[] args)
   { 
      Ventana ventana = new Ventana(); 
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(350, 100); 
      ventana.setVisible(true); 
   } 
}