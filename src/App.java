/*

Projet  : Arduino Serial read
Auteur  : Bilel Belhadj
Date    : 11-11-2022
Version : 0.0.1

 */

import com.fazecast.jSerialComm.*;  //import

public class App {

    public static void main(String[] args) throws Exception {
      
        SerialPort comPort = SerialPort.getCommPorts()[0];                  //get the active serial port port
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 0, 0);   
        comPort.openPort();                                                 //open the port
        System.out.println(comPort);                                        //weite the port name

        try {
            while (true)  //if the port is available
            {
                System.out.println("true");
                while (comPort.bytesAvailable() == 0)  //test if theres data to read
                    Thread.sleep(20);
                    System.out.println("true1");
                    
                byte[] readBuffer = new byte[comPort.bytesAvailable()];             //read data i a buffer type yte
                int numRead = comPort.readBytes(readBuffer, readBuffer.length);     //convert buffer
                System.out.println("Read " + numRead + " bytes.");
                
                for (int i = 0; i < readBuffer.length; ++i)                         //display data
                    System.out.print((char)readBuffer[i]);
                System.out.println("\n");


            }

            
        } catch (Exception e) { e.printStackTrace(); }
        comPort.closePort();    //close port

    }   
}
