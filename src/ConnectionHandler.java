import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
  private final Socket client;
  private final Server server;
  private BufferedReader in; // holds what client sends
  private PrintWriter out; // holds what we sent to client
  private String username;

  public ConnectionHandler(Socket client, Server server) {
    this.client = client;
    this.server = server;
  }

  @Override
  public void run() {
    try {
      out = new PrintWriter(client.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out.println("Please enter a username: ");
      this.username = in.readLine();
      if (this.username.equals("")) {
        throw new NullPointerException("Username cannot be nothing");
      }
      System.out.println(this.username + " has connected to the chat!");
      this.server.broadcast(username + " joined the chat!");
      String message;
      while (!(message = in.readLine()).equals("")) {
        if (message.startsWith("/nick ")) {
          String[] messageSplit = message.split(" ", 2);
          if (messageSplit.length == 2) {
            this.server.broadcast(this.username + " renamed to " + messageSplit[1]);
            System.out.println(this.username + " renamed to " + messageSplit[1]);
            this.username = messageSplit[1];
            out.println("changed name to " + this.username);
          } else {
            out.println("No username provided");
          }
        } else if (message.startsWith("/quit")) {
          // TODO: quit
          this.server.broadcast(this.username + " left the chat. :(");
          shutdown();
        } else {
          this.server.broadcast(username + ": " + message);
        }
      }
    } catch (IOException e1) {
      try {
        shutdown();
      } catch (IOException e2) {
        // ignore
      }
    }
  }

  public void sendMessage(String message) {
    this.out.println(message);
  }

  public void shutdown() throws IOException {
    in.close();
    out.close();
    if (!this.client.isClosed()) {
      client.close();
    }
  }
}

/*



 */
