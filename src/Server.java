import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import static java.util.EnumMap.NULL;

// import static java.lang.constant.ConstantDescs.NULL;


public class Server implements Runnable {
  private final List<ConnectionHandler> connections; // list of connected clients
  private ServerSocket server;
  private boolean done;
  private ExecutorService pool;


  public Server() {
    connections = new ArrayList<>();
    done = false;
  }

  public static void main(String[] args) {
    Server server = new Server();
    server.run();
  }

  public void shutdown() throws IOException {
    done = true;
    pool.shutdown();
    if (!server.isClosed()) {
      server.close();
    }
    for (ConnectionHandler ch : connections) {
      ch.shutdown();
    }
  }

  @Override
  public void run() {
    try {
      server = new ServerSocket(9999);
      pool = Executors.newCachedThreadPool();
      while (!done) {
        Socket client = server.accept();
        ConnectionHandler handler = new ConnectionHandler(client, this);
        connections.add(handler);
        pool.execute(handler);
      }
    } catch (IOException e) {
      // e.printStackTrace();
      // shutdown function later
      try {
        shutdown();
      } catch (IOException ex) {
      }
    }


  }

  public void broadcast(String message) {
    for (ConnectionHandler ch : connections) {
      if (ch != null) {
        ch.sendMessage(message);
      }
    }
  }
}
