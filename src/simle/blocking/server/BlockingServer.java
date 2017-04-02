package simle.blocking.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Single Threaded
 * @author dealscandy
 *
 */
public class BlockingServer {
  public static void main(String[] args){
    try( ServerSocket ss = new ServerSocket(8080); ){      
    while(true){
      System.out.println("Waiting for connection...");
      Socket s = ss.accept();// blocking but non null
      System.out.println("Connected");
      handle(s);
      System.out.println("Done.!");
    }
    }catch (IOException ex){
      ex.printStackTrace();
    }
  }
  private static void handle(Socket s){
    try(
    InputStream in = s.getInputStream();
    OutputStream out = s.getOutputStream();
    ){
      int data;
      while ((data=in.read()) != -1){
       data = transmongrify(data);
       out.write(data);
      }
    }catch (IOException ex){
      throw new UncheckedIOException(ex);
    }
  }
  
  private static int transmongrify(int data){
    return Character.isLetter(data) ? data ^ ' ' : data;
  }
}
