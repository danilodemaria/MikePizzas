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

         while(rs.next()){
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

         while(rs.next()){
            pedido = new Pedido();
            pedido.setId(rs.getInt("id")); 
            pedido.setNome_cliente(rs.getString("nome"));
            pedido.setValor(rs.getDouble("valor"));            
            lista.add(pedido);                           
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the juridico
     */
    public boolean isJuridico() {
        return juridico;
    }

    /**
     * @param juridico the juridico to set
     */
    public void setJuridico(boolean juridico) {
        this.juridico = juridico;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

}
