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
    private boolean juridico;
    private double valor;
    private String nome_cliente;

    public Pedido() {

    }

    public Pedido(int id, int id_cliente, boolean juridico, double valor, String nome_cliente) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.juridico = juridico;
        this.valor = valor;
    }

    public int buscaIdPedido() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        String stm = "select id from pedido order by id desc limit 1";
        int aux = 0;
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            aux = rs.getInt("id");
        }

        aux = aux + 1;
        return aux;
    }

    public static ArrayList<Pedido> buscaFisico() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Pedido pedido = new Pedido();
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        String stm = "select  a.id, b.nome, a.valor from pedido a, pessoa_fisica b where (a.id_cliente = b.id) and juridico = false";
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setNome_cliente(rs.getString("nome"));
            pedido.setValor(rs.getDouble("valor"));
            lista.add(pedido);
        }

        return lista;
    }

    public static ArrayList<Pedido> buscaJuridico() throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Pedido pedido = new Pedido();
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        String stm = "select  a.id, b.nome, a.valor from pedido a, pessoa_juridica b where (a.id_cliente = b.id) and juridico = true";
        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setNome_cliente(rs.getString("nome"));
            pedido.setValor(rs.getDouble("valor"));
            lista.add(pedido);
        }

        return lista;
    }

    public static ArrayList<Pizza> buscaItensTam(int idPedido) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Pizza pizza = new Pizza();
        ArrayList<Pizza> lista = new ArrayList<Pizza>();
        String stm = "SELECT C .tamanho, C.preco FROM pedido A INNER JOIN pedido_pizza b ON ( b.id_pedido = A.ID ) INNER JOIN pizza C ON ( C.ID = b.id_pizza ) WHERE A.ID = " + idPedido + " \n"
                + " AND A.juridico = FALSE GROUP BY C.ID, A.juridico";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            pizza = new Pizza();
            pizza.setTamanho(rs.getString("tamanho"));
            pizza.setPreco(rs.getDouble("preco"));
            lista.add(pizza);
        }

        return lista;
    }

    public static ArrayList<Sabor> buscaItensSabor(int idPedido) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Sabor sabor = new Sabor();
        ArrayList<Sabor> lista = new ArrayList<Sabor>();
        String stm = "SELECT C.nome FROM pedido A INNER JOIN pedido_sabor b ON ( b.id_pedido = A.ID ) INNER JOIN sabor C ON ( C.ID = b.id_sabor ) WHERE A.ID = " + idPedido + " \n"
                + " AND A.juridico = FALSE GROUP BY C.ID, A.juridico";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            sabor = new Sabor();
            sabor.setNome(rs.getString("nome"));
            lista.add(sabor);
        }

        return lista;
    }

    public static ArrayList<Bebida> buscaItensBebida(int idPedido) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        Bebida bebida = new Bebida();
        ArrayList<Bebida> lista = new ArrayList<Bebida>();
        String stm = "SELECT C.nome, C.preco FROM pedido A INNER JOIN pedido_bebida b ON ( b.id_pedido = A.ID ) INNER JOIN bebida C ON ( C.ID = b.id_bebida ) WHERE A.ID = "+idPedido+" \n" +
" AND A.juridico = FALSE GROUP BY C.ID, A.juridico";

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            bebida = new Bebida();
            bebida.setNome(rs.getString("nome"));
            bebida.setPreco(rs.getDouble("preco"));
            lista.add(bebida);
        }

        return lista;
    }

    public boolean inserePedido(ArrayList<Integer> idBebida, ArrayList<Integer> idSabores, ArrayList<Integer> idTamanho, Pedido pedido, int numPedidoAtual) {
        PreparedStatement pst;
        Connection conn = Conexao.Connect();
        boolean valida = false;

        // Inserindo pedido
        String stm = "INSERT INTO pedido (id_cliente,valor,juridico) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(stm);
            pst.setInt(1, pedido.getId_cliente());
            pst.setDouble(2, pedido.getValor());
            pst.setBoolean(3, pedido.isJuridico());
            pst.execute();
            valida = true;
            System.out.println("cheguei aqui");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            valida = false;
        }
        System.out.println("pedido atual: " + numPedidoAtual);
        // Inserindo bebidas do pedido
        stm = "INSERT INTO pedido_bebida (id_pedido,id_bebida) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(stm);
            for (int i = 0; i < idBebida.size(); i++) {
                pst.setInt(1, numPedidoAtual);
                pst.setInt(2, idBebida.get(i));
                pst.execute();
            }
            valida = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            valida = false;
        }

        // Inserindo pizzas do pedido
        stm = "INSERT INTO pedido_pizza (id_pedido,id_pizza) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(stm);
            for (int i = 0; i < idTamanho.size(); i++) {
                pst.setInt(1, numPedidoAtual);
                pst.setInt(2, idTamanho.get(i));
                pst.execute();
            }
            valida = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            valida = false;
        }

        // Inserindo sabores do pedido
        stm = "INSERT INTO pedido_sabor (id_pedido,id_sabor) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(stm);
            for (int i = 0; i < idSabores.size(); i++) {
                pst.setInt(1, numPedidoAtual);
                pst.setInt(2, idSabores.get(i));
                pst.execute();
            }
            valida = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            valida = false;
        }

        return valida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isJuridico() {
        return juridico;
    }

    public void setJuridico(boolean juridico) {
        this.juridico = juridico;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

}
