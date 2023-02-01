package dbFilm;

import dbConn.ConnectionMaker;
import dbConn.MySqlConnectionMaker;
import dbFilm.viewer.CustomerViewer;
import dbFilm.viewer.FilmViewer;
import dbFilm.viewer.StaffViewer;

import java.sql.Connection;
import java.util.Scanner;

public class dbFilmMain {


    public static void main(String[] args) {

        Scanner SCANNER = new Scanner(System.in);
        Connection connection = null;

        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        CustomerViewer customerViewer = new CustomerViewer(connectionMaker);
        StaffViewer staffViewer = new StaffViewer(SCANNER,connection);
        FilmViewer filmViewer = new FilmViewer(SCANNER, connection);
        customerViewer.showIndex();

    }

}
