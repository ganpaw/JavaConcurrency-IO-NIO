package threaded.blocking.server;

import java.io.IOException;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {
    Socket[] sockets = new Socket[100000];
    for (int i=0; i<sockets.length; i++){
      try {
        System.out.println(i);
        sockets[i] = new Socket("localhost", 8080);
      } catch (IOException e) {
         System.err.println(e);
      } 
    }
    try {
      Thread.sleep(2000000000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
 
}
