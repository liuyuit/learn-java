package network.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        System.out.println("create World clock remote service...");
        MyWorldClock myWorldClock = new MyWorldClockService();
        MyWorldClock skeleton = (MyWorldClock) UnicastRemoteObject.exportObject(myWorldClock, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind(MyWorldClock.class.getSimpleName(), skeleton);
    }
}
