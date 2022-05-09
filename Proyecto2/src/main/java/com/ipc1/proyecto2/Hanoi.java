package com.ipc1.proyecto2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;



public class Hanoi extends JFrame
{
    //creando variables
   private  String Nombre_de_usuario;
   int DTorre, toTower, DLocalizacion, ALocalizacon;
   int Ejecutar_b=1;
   
   MD_panel Dibjar_pn;
    //en esta parte el espacio es pa agrandar el tamanyo de los nontoes
    JButton P1 = new JButton("           " +
            "                        1   " +
            "                                ");
          
    JButton P2 = new JButton("2");
    JButton P3 = new JButton("           " +
            "                        3   " +
            "                                ");
    JSlider CDL = new JSlider(1,10,2);
    int Num_d_discos;
    int[][] juego;
    int[][] Juego2;
    //total del objetivo = TdB
    int TdB =0;
    int Dsuperior=0;
    boolean Mover=false;
    //estableciendo una tabla de colores
    static Color[] colores = {Color.black, Color.blue,
     Color.PINK, Color.green, Color.magenta, Color.YELLOW, Color.RED, Color.cyan};
    ArrayList<Integer> MoVimientos = new ArrayList<Integer>();
    public static void main(String args[])
    {
        //creando juego para hacerlo visible
        Hanoi window = new Hanoi();
        window.setVisible(true); 
        window.setResizable(false);
        
        Random rgen = new Random();
        for (int i=0; i<colores.length; i++) {
            int Z = rgen.nextInt(colores.length);
            Color temp = colores[i];
            colores[i] = colores[Z];
            colores[Z] = temp;
        }
    }
    public Hanoi()
    {
        setTitle("Hanoi");  
        setSize(800,500); 
        setLocationRelativeTo(null);
        Container contenidoP = getContentPane(); 
        contenidoP.setLayout(new BorderLayout());
        Dibjar_pn = new MD_panel();
        contenidoP.add(Dibjar_pn, BorderLayout.CENTER);
       Container BotonPanel = new Container();
       contenidoP.add(BotonPanel, BorderLayout.NORTH);
       Container BotonTores = new Container();
       BotonTores.setLayout(new BorderLayout());
       contenidoP.add(BotonTores, BorderLayout.SOUTH);
       BotonTores.add(P1, BorderLayout.WEST);
       BotonTores.add(P2, BorderLayout.CENTER);
       BotonTores.add(P3, BorderLayout.EAST);
       //e esta parte mostramos un mensaje para que ingrese el nombr que desee
       Nombre_de_usuario = JOptionPane.showInputDialog
         (null,"Ingrese nombre de usuario");
       
                //esto seria pa captar erroes
        try
        {
            //Num_d_discos= Integer.parseInt(Cstring);
            Num_d_discos= Integer.parseInt("3");
        }
        catch (NumberFormatException E)
        {JOptionPane.showMessageDialog
                (new JFrame(), "Invalido");
            System.exit(5);
        }juego= new int[Num_d_discos][3];
          //armando fila
        for (int FilA=0;FilA<juego.length;FilA++)
        
        
        
        
            for (int Col=0;Col<juego[0].length;Col++)
            
            
                juego[FilA][Col]=0;
      
        int num_a_insertar=8;
                  for (int i=Num_d_discos; i>0; i--)
        
        {
            
            juego[i-1][0]=num_a_insertar;
            
            num_a_insertar--;
        }
      
        Juego2 = new int[Num_d_discos][3];
        
        for (int Fila=0;Fila<juego.length;Fila++)
       
            for (int Col=0;Col<juego[0].length;Col++)
       
                Juego2[Fila][Col]=Juego2[Fila][Col];
    
        Button1 boton1 = new Button1();
        
        Button2 boton2 = new Button2();
        
        Button3 boton3 = new Button3();
        
        P1.addActionListener(boton1);
        
        
        P2.addActionListener(boton2);
        
        P3.addActionListener(boton3);
      
        
       // JUGAR JugarL = new JUGAR();
     
      
        for (int Fila=0;Fila<juego.length;Fila++)
        {
            TdB+=juego[Fila][0];
        }
      
    }
  

    //------------------Generador de platos  
 
    private class MD_panel extends JPanel
    {
        public void paintComponent (Graphics g)
        {      
          
            super.paintComponent(g);
           
            g.fillRect(50,335,700,50);
  
            g.setColor(Color.GRAY);
            g.fillRect(150, 67, 17, 270);
            
            g.fillRect(375, 67, 17, 270);
            g.fillRect(620, 67, 17, 270);
       
            g.setColor(Color.BLUE);
            for (int row=juego.length-1;row>=0;row--)
            {
                g.setColor(Color.blue);
                if (juego[row][0]==8){g.setColor(colores[7]);
                    g.fillRoundRect(67, 100+(29*(row+(8-Num_d_discos))), 180, 25, 10, 10);}
                if (juego[row][0]==7){g.setColor(colores[6]);
                    
                    g.fillRoundRect(77,100+(29*(row+(8-Num_d_discos))),160,25, 10, 10);}
                if (juego[row][0]==6){g.setColor(colores[5]);
                    g.fillRoundRect(87,100+(29*(row+(8-Num_d_discos))),140,25, 10, 10);}
                if (juego[row][0]==5){g.setColor(colores[4]);
                    
                    g.fillRoundRect(97,100+(29*(row+(8-Num_d_discos))),120,25, 10, 10);}
                if (juego[row][0]==4){g.setColor(colores[3]);
                    g.fillRoundRect(107,100+(29*(row+(8-Num_d_discos))),100,25, 10, 10);}
                if (juego[row][0]==3){g.setColor(colores[2]);
                    g.fillRoundRect(117,100+(29*(row+(8-Num_d_discos))),80,25, 10, 10);}
                    
                    
                if (juego[row][0]==2){g.setColor(colores[1]);
                    g.fillRoundRect(127,100+(29*(row+(8-Num_d_discos))),60,25, 10, 10);}
                if (juego[row][0]==1){g.setColor(colores[0]);
                    g.fillRoundRect(137,100+(29*(row+(8-Num_d_discos))),40,25, 10, 10);}
            }
            for (int row=0;row<juego.length;row++)
            {
                g.setColor(Color.blue);
                if (juego[row][1]==8){g.setColor(colores[7]);
                    g.fillRoundRect(293,100+(29*(row+(8-Num_d_discos))),180,25, 10, 10);}
                if (juego[row][1]==7){g.setColor(colores[6]);
                    
                    g.fillRoundRect(303,100+(29*(row+(8-Num_d_discos))),160,25, 10, 10);}
                if (juego[row][1]==6){g.setColor(colores[5]);
                    g.fillRoundRect(313,100+(29*(row+(8-Num_d_discos))),140,25, 10, 10);}
                if (juego[row][1]==5){g.setColor(colores[4]);
                    g.fillRoundRect(323,100+(29*(row+(8-Num_d_discos))),120,25, 10, 10);}
                if (juego[row][1]==4){g.setColor(colores[3]);
                    g.fillRoundRect(333,100+(29*(row+(8-Num_d_discos))),100,25, 10, 10);}
                if (juego[row][1]==3){g.setColor(colores[2]);
                    g.fillRoundRect(343,100+(29*(row+(8-Num_d_discos))),80,25, 10, 10);}
                if (juego[row][1]==2){g.setColor(colores[1]);
                    
                    g.fillRoundRect(353,100+(29*(row+(8-Num_d_discos))),60,25, 10, 10);}
                if (juego[row][1]==1){g.setColor(colores[0]);
                    g.fillRoundRect(363,100+(29*(row+(8-Num_d_discos))),40,25, 10, 10);}
            } 
              for (int row=0;row<juego.length;row++)
            {
                g.setColor(Color.blue);
                if (juego[row][2]==8){g.setColor(colores[7]);
                    
                    g.fillRoundRect(67+470,100+(29*(row+(8-Num_d_discos))),180,25, 10, 10);}
                if (juego[row][2]==7){g.setColor(colores[6]);
                    
                    g.fillRoundRect(77+471,100+(29*(row+(8-Num_d_discos))),160,25, 10, 10);}
                if (juego[row][2]==6){g.setColor(colores[5]);
                    
                    g.fillRoundRect(87+471,100+(29*(row+(8-Num_d_discos))),140,25, 10, 10);}
                if (juego[row][2]==5){g.setColor(colores[4]);
                    g.fillRoundRect(97+471,100+(29*(row+(8-Num_d_discos))),120,25, 10, 10);}
                    
                if (juego[row][2]==4){g.setColor(colores[3]);
                    g.fillRoundRect(107+471,100+(29*(row+(8-Num_d_discos))),100,25, 10, 10);}
                if (juego[row][2]==3){g.setColor(colores[2]);
                    g.fillRoundRect(117+471,100+(29*(row+(8-Num_d_discos))),80,25, 10, 10);}
                if (juego[row][2]==2){g.setColor(colores[1]);
                    g.fillRoundRect(127+471,100+(29*(row+(8-Num_d_discos))),60,25, 10, 10);}
                    
                if (juego[row][2]==1){g.setColor(colores[0]);
                    g.fillRoundRect(137+471,100+(29*(row+(8-Num_d_discos))),40,25, 10, 10);}
            }
          
        }
    }
  
    //-----------
  
  
   //acciones a ejecutarce en caso se aprete el boton 1
  
    private class Button1 implements ActionListener
    
    {      
        
        public void actionPerformed(ActionEvent e)
        {  
            
            repaint();

            if (Mover)
          
            {
                int Ubicacinbaja=0;
                for (int i=0; i<juego.length; i++)
                {
                    
                          if (juego[i][0]==0)
                    {
                        Ubicacinbaja=i;
                                      
                    }
               
                }       
              
                juego[Ubicacinbaja][0]=Dsuperior;
                Dsuperior=0;
                Ubicacinbaja=0;
                Mover=false;
              
                P1.setEnabled(true);
                P2.setEnabled(true);
                P3.setEnabled(true);
                Triunfo();
            }            else            {
                for (int i=0; i<juego.length; i++)
                {
                    if (juego[i][0]!=0)
                    {
                        Dsuperior=juego[i][0];
                        juego[i][0]=0;
                      
                        Mover=true;
                                                         
                          i=juego.length+1;
                              }
                                             }
              
                
                int ubicacionalta=0;
                for (int i=0; i<juego.length; i++)
                {
                    
                    if (juego[i][1]!=0)
                    {
                        ubicacionalta=i;
                        
                        i=juego.length+1;
                                         }
                    
                }
              
                if (ubicacionalta==0)
              {
                  
                                       }
                else if(Dsuperior>juego[ubicacionalta][1])
                 
                
                P2.setEnabled(false);
              
                
                
                int localizacionn3=0;
                for (int i=0; i<juego.length; i++)
                                    {
                    if (juego[i][2]!=0)
                    {
                        localizacionn3=i;
                        i=juego.length+1;
                                    }
                      
                }
              
                if (localizacionn3==0)                {
                  
                 
                       }                 else
                if(Dsuperior>juego[localizacionn3][2])
                
                
                                     P3.setEnabled(false);
            }
            
            
       
        }
        
    }
  
       //acciones a ejecutarce en caso se aprete el boton 2
    private class Button2 implements ActionListener
    {      
        public void actionPerformed(ActionEvent e)
        
        {
            repaint();
          
          
            if (Mover)
            {
                int localizacion1=0;                for (int i=0; i<juego.length; i++)
                {
                              if (juego[i][1]==0)
                    {
                                      localizacion1=i;
                    }
                    
                    
                    
                }
              
                juego[localizacion1][1]=Dsuperior;
                Dsuperior=0;
                
                localizacion1=0;
                
                
                Mover=false;
                
              
                P1.setEnabled(true);
                
                P2.setEnabled(true);
                
                P3.setEnabled(true);
                Triunfo();
            }
            
            
            else            {      
                
                
                for (int i=0; i<juego.length; i++)
                {
                    
                     
                                 if (juego[i][1]!=0)
                    {
                        
                        Dsuperior=juego[i][1];
                        juego[i][1]=0;
                      
                        Mover=true;
                           
                        i=juego.length+1; 
                    }
                }
              
               
                int localizacion2=0;
                for (int i=0; i<juego.length; i++)
                {
                    if (juego[i][0]!=0)
                    {
                        localizacion2=i;
                        i=juego.length+1;
                    }
                    
                    
                }
              
                 if (localizacion2==0)
                {
                  
                }//localizacion2
                                      else if(Dsuperior>juego[localizacion2][0])
                    P1.setEnabled(false);
               
                                   int localizacion3=0;
                for (int i=0; i<juego.length; i++)
                {
                    if (juego[i][2]!=0)
                    {
                        localizacion3=i;
                        i=juego.length+1;
                        
                        
                    }
                    
                }
              
                
                if (localizacion3==0)
                {
                  
                }
                
                else if(Dsuperior>juego[localizacion3][2])
                
                
                    P3.setEnabled(false);
            }
        //    printArray();
        }
    }
  
       //acciones a ejecutarce en caso se aprete el boton 3
    private class Button3 implements ActionListener
    {      
        public void actionPerformed(ActionEvent e)
        {
            
                repaint();
              
                if (Mover)
                {
                    int localizacion1=0;
                  
                    for (int i=0; i<juego.length; i++)                    {
                        if (juego[i][2]==0)
                        { 
                            localizacion1=i;   
                            
                            
                        }
                        
                    }
                    
                  
                    juego[localizacion1][2]=Dsuperior;
                    Dsuperior=0;
                    localizacion1=0;
                    Mover=false;
                  
                    P1.setEnabled(true);
                    P2.setEnabled(true);
                    P3.setEnabled(true);
                  
                    Triunfo();
                }
                else
                                                      {
                    for (int i=0; i<juego.length; i++)
                               {
                        if (juego[i][2]!=0)
                                 {
                            Dsuperior=juego[i][2];
                            juego[i][2]=0;
                          
                            Mover=true;
                             
                            
                            i=juego.length+1;
                        }
              
                    }  
                    
                  
                   
                    int localizacion2=0;
                    for (int i=0; i<juego.length; i++)
                    {
                        
                        
                        
                        if (juego[i][1]!=0)
                        {
                            localizacion2=i;
            
                            i=juego.length+1;
                                                }
   
                    }
                  
                    if (localizacion2==0)
                    {
                      
                    }
                    else if(Dsuperior>juego[localizacion2][1])
                        P2.setEnabled(false);
                  
                   
                    int localizacion3=0;
                    
                    for (int i=0; i<juego.length; i++)
                    {
                                   if (juego[i][0]!=0)
                        {
                            localizacion3=i;
                            i=juego.length+1;
                        }
                        
                     
                    }
                  
                    if (localizacion3==0)
                    {
                      
                    }
                    else if(Dsuperior>juego[localizacion3][0])
                        P1.setEnabled(false);
                }//printArray();
              
        }
    }
 
                   //play
                 
        
    //triunfo en caso gane ejecutara la siguiente accion
     private void Triunfo()
    {
        int TC=0;
        for (int tope=0;tope<juego.length;tope++)
        {
            TC+=juego[tope][2];
            
                    }
      
                 if (TdB==TC)
        {
            
            JOptionPane.showMessageDialog
            (new JFrame(), "Felicidades has ganado "+Nombre_de_usuario/*+HD?*/);
            
            System.exit(0);
        }
        
    }
    
}
