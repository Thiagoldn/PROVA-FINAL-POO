package classes;

public class Produtos {
    
    private String codigoProduto;
    private String nomeProduto;
    private int estoqueProduto;
    private double valorProduto;
   
    

    public Produtos(){}

    public Produtos(String codigoProdutos, String nomeProduto , int estoqueProduto, double valorProduto  ){
        this.codigoProduto = codigoProdutos;
        this.nomeProduto = nomeProduto;
        this.estoqueProduto = estoqueProduto;
        this.valorProduto = valorProduto;

    }

    public String getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public double getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    public int getEstoqueProduto() {
        return estoqueProduto;
    }
    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    
   
    
    




    
}
