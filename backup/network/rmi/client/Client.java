package network.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

import network.rmi.server.MyWorldClock;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        MyWorldClock myWorldClock = (MyWorldClock) registry.lookup(MyWorldClock.class.getSimpleName());
        LocalDateTime now = myWorldClock.getLocalDateTime("Asia/Shanghai");
        System.out.println(now);
    }
}
