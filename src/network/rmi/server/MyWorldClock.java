package network.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface MyWorldClock extends Remote {

    LocalDateTime getLocalDateTime(String zoneId) throws RemoteException;

}
