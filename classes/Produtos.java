package classes;

public class Produtos {
    
    private String codProduto;
    private String nomeProd;
    private int estoqueProd;
    private double valorProd;
   
    

    public Produtos(){}

    public Produtos(String codigoProdutos, String nomeProduto , int estoqueProduto, double valorProduto  ){
        this.codProduto = codigoProdutos;
        this.nomeProd = nomeProduto;
        this.estoqueProd = estoqueProduto;
        this.valorProd = valorProduto;

    }

    public String getCodigoProduto() {
        return codProduto;
    }
    public void setCodigoProduto(String codigoProduto) {
        this.codProduto = codigoProduto;
    }
    public String getNomeProduto() {
        return nomeProd;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProd = nomeProduto;
    }
    public double getValorProduto() {
        return valorProd;
    }
    public void setValorProduto(double valorProduto) {
        this.valorProd = valorProduto;
    }
    public int getEstoqueProduto() {
        return estoqueProd;
    }
    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProd = estoqueProduto;
    }

    
   
    
    




    
}
