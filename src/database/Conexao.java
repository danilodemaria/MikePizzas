package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    public static Connection Connect() {
        String url = "jdbc:postgresql://localhost:5432/db_pizzaria";
        String usuario = "pizza";
        String senha = "1234";

        String driverName = "org.postgresql.Driver";

        Connection conn = null;
        try {
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
