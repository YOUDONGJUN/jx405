package day1027;

import dbConn.ConnectionMaker;
import dbConn.MySqlConnectionMaker;
import dbViewer.UserViewer;

public class BoardMVC {
    public static void main(String[] args) {
        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        UserViewer userViewer = new UserViewer(connectionMaker);
        userViewer.showIndex();
    }
}
