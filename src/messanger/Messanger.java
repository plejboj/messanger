/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messanger;

import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author Wojciech Pokora
 * @author Jakub Pawlak
 * @author Patryk Szewczyk
 * @author Katarzyna Wiater
 * @author Agnieszka Musiał
 * @author Michał Darkowski
 * 
 */
public class Messanger {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
                EchoWorker worker = new EchoWorker();
                new Thread(worker).start();
                new Thread(new NioServer(null, 9090, worker)).start();
        } catch (IOException e) {
                e.printStackTrace();
        }



        try {
                NioClient client = new NioClient(InetAddress.getByName("www.google.com"), 80);
                Thread t = new Thread(client);
                t.setDaemon(true);
                t.start();
                RspHandler handler = new RspHandler();
                client.send("GET / HTTP/1.0\r\n\r\n".getBytes(), handler);
                handler.waitForResponse();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    
    
    
}
