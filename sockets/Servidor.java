package sockets;



import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.net.ServerSocket;
import java.io.*;
public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
        
        Thread mihilo = new Thread(this);
        mihilo.start();
		}
	
	private	JTextArea areatexto;

    public void run(){
         //System.out.println("hola");
        try {
            ServerSocket servidor = new ServerSocket(9999);
            Socket misocket = servidor.accept();

            DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());

            String mensaje_texto = flujo_entrada.readUTF();

            areatexto.append("\n" + mensaje_texto);

            misocket.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    
        }

}

