package modelos;

public class Pedido {
    
    private int id;
    private int id_pizza;
    private int id_cliente;
    private int id_bebida;
    private int quantidade;
    private double valor;

    public Pedido(){
        
    }
    
    public Pedido(int id, int id_pizza, int id_cliente, int id_bebida,int quantidade,double valor){
        this.id = id;
        this.id_pizza = id_pizza;
        this.id_cliente = id_cliente;
        this.id_bebida = id_bebida;
        this.quantidade = quantidade;
        this.valor = valor;
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
     * @return the id_pizza
     */
    public int getId_pizza() {
        return id_pizza;
    }

    /**
     * @param id_pizza the id_pizza to set
     */
    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
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
     * @return the id_bebida
     */
    public int getId_bebida() {
        return id_bebida;
    }

    /**
     * @param id_bebida the id_bebida to set
     */
    public void setId_bebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    
}
