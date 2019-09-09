package modelos;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pedido {

    private int id;
    private int id_cliente;
    private int id_bebida;
    private int id_pizza;
    private ArrayList<Integer> idSabores = new ArrayList<>();
    private double valor;
    private String nome_cliente;

    public Pedido() {

    }

    public Pedido(int id, int id_cliente, int id_bebida, int id_pizza, ArrayList<Integer> idSabores, double valor, String nome_cliente) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_bebida = id_bebida;
        this.id_pizza = id_pizza;
        this.idSabores = idSabores;
        this.valor = valor;
        this.nome_cliente = nome_cliente;
    }

    // método para inserir pedido de pessoa fisica
    public boolean insereFisico(Pedido pedido) {

        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO pedido_fisico (id_cliente,id_bebida,id_pizza,id_sabores,total, nome_cliente) VALUES (?,?,?,?,?,?)";

        String aux = "";
        aux = aux + String.valueOf(pedido.getIdSabores().get(0));
        for (int i = 1; i < pedido.getIdSabores().size(); i++) {
            aux = aux + "," + String.valueOf(pedido.getIdSabores().get(i));
        }

        try {
            pst = conn.prepareStatement(stm);
            pst.setInt(1, pedido.getId_cliente());
            pst.setInt(2, pedido.getId_bebida());
            pst.setInt(3, pedido.getId_pizza());
            pst.setString(4, aux);
            pst.setDouble(5, pedido.getValor());
            pst.setString(6, pedido.getNome_cliente());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para inserir pedido pessoa juridica
    public boolean insereJuridico(Pedido pedido) {

        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "INSERT INTO pedido_juridico (id_cliente,id_bebida,id_pizza,id_sabores,total, nome_cliente) VALUES (?,?,?,?,?,?)";

        String aux = "";
        aux = aux + String.valueOf(pedido.getIdSabores().get(0));
        for (int i = 1; i < pedido.getIdSabores().size(); i++) {
            aux = aux + "," + String.valueOf(pedido.getIdSabores().get(i));
        }

        try {
            pst = conn.prepareStatement(stm);
            pst.setInt(1, pedido.getId_cliente());
            pst.setInt(2, pedido.getId_bebida());
            pst.setInt(3, pedido.getId_pizza());
            pst.setString(4, aux);
            pst.setDouble(5, pedido.getValor());
            pst.setString(6, pedido.getNome_cliente());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para buscar pedidos de pessoas fisicas
    public ArrayList<Pedido> buscaPedidosFisicos() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Pedido pedido = new Pedido();
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        ArrayList<Integer> sabores = new ArrayList<>();
        String stm = "select * from pedido_fisico";
        String aux;
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            aux = "";
            sabores.clear();
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setId_cliente(rs.getInt("id_cliente"));
            pedido.setId_pizza(rs.getInt("id_pizza"));
            pedido.setId_bebida(rs.getInt("id_bebida"));
            pedido.setValor(rs.getDouble("total"));
            pedido.setNome_cliente(rs.getString("nome_cliente"));
            aux = rs.getString("id_sabores");

            String[] parts = aux.split(",");

            for (int i = 0; i < parts.length; i++) {
                sabores.add(Integer.parseInt(parts[i]));
            }
            pedido.setIdSabores(sabores);

            lista.add(pedido);
        }

        return lista;
    }

    // Método para buscar pedidos de pessoas juridicas
    public ArrayList<Pedido> buscaPedidosJuridicos() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Pedido pedido = new Pedido();
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        ArrayList<Integer> sabores = new ArrayList<>();
        String stm = "select * from pedido_juridico";
        String aux;
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            aux = "";
            sabores.clear();
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setId_cliente(rs.getInt("id_cliente"));
            pedido.setId_pizza(rs.getInt("id_pizza"));
            pedido.setId_bebida(rs.getInt("id_bebida"));
            pedido.setValor(rs.getDouble("total"));
            pedido.setNome_cliente(rs.getString("nome_cliente"));
            aux = rs.getString("id_sabores");

            String[] parts = aux.split(",");

            for (int i = 0; i < parts.length; i++) {
                sabores.add(Integer.parseInt(parts[i]));
            }
            pedido.setIdSabores(sabores);

            lista.add(pedido);
        }

        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    public ArrayList<Integer> getIdSabores() {
        return idSabores;
    }

    public void setIdSabores(ArrayList<Integer> idSabores) {
        this.idSabores = idSabores;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

}
