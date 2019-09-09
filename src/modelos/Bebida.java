package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// Classe para controle das bebidas
public class Bebida {

    private int id;
    private String nome;
    private double preco;

    public Bebida() {

    }

    public Bebida(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Método para cadastrar uma nova bebida
    public static boolean cadastrar(Bebida nova) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO bebida (nome,preco,excluido) VALUES (?,?,?)";

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, nova.getNome());
            pst.setDouble(2, nova.getPreco());
            pst.setBoolean(3, false);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para remover uma bebida
    public static boolean remover(Bebida bebida) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "UPDATE bebida set excluido = true where id = " + bebida.getId();

        try {
            pst = conn.prepareStatement(stm);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para buscar todas bebidas ativas no banco de dados
    public static ArrayList<Bebida> buscaBebidas() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Bebida bebida = new Bebida();
        ArrayList<Bebida> lista = new ArrayList<Bebida>();
        String stm = "select * from bebida where excluido = false";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            bebida = new Bebida();
            bebida.setId(Integer.parseInt(rs.getString("id")));
            bebida.setNome(rs.getString("nome"));
            bebida.setPreco(rs.getDouble("preco"));
            lista.add(bebida);
        }

        return lista;
    }

    // Método que busca apenas uma bebida por id do pedido
    public static String buscaBebida(Pedido pedido) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();

        String aux = "";
        String stm = "SELECT * from bebida where id = " + pedido.getId_bebida();
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            aux = rs.getString("nome");
        }

        return aux;
    }

    public Bebida(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
