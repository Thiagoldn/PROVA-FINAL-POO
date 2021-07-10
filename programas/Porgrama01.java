package programas;
import java.util.Scanner;
import classes.Produtos;
import classes.Venda;
import static java.util.Comparator.comparing;
import java.util.ArrayList;
import java.util.List;


public class Porgrama01 {
  public static void main(String[] args)   {
    Scanner in = new Scanner(System.in);
    int opcao;
    List<Produtos> listaprodutos = new ArrayList<>();
    List<Venda> listavendas = new ArrayList<>();
    double soma = 0;
    double somarVend = 0, mediaVend = 0;
   

    do {
      System.out.println("\n");
      System.out.println("****************************************************************************");
      System.out.println("******************************MENU PRINCINPAL*******************************");
      System.out.println("****************************************************************************");
      System.out.println();
      System.out.println("1 - Incluir produto");
      System.out.println("2 - Consultar Produto");
      System.out.println("3 - Listagem de Produtos");
      System.out.println("4 - Realizar venda ");
      System.out.println("5 - Relatorio de Vendas - detalhado");
      

      System.out.println("0 - Sair");
      System.out.print("Opção: ");
      opcao = in.nextInt();
      in.nextLine(); // Tira o ENTER
    
      switch (opcao) {
        case 1:

        //Cadastro de produto
        Produtos produ = new Produtos();

        System.out.println("****************************************************************************");
        System.out.println("****************************CADASTRO DE PRODUTOS****************************");
        System.out.println("****************************************************************************");

        System.out.print("Digite o codigo do produto: ");
        produ.setCodigoProduto(in.nextLine());

        System.out.print("Digite o nome do produto: ");
        produ.setNomeProduto(in.nextLine());

        System.out.print("Digite a quantidade: ");
        produ.setEstoqueProduto(in.nextInt());

        System.out.print("Digite o valor do produto: ");
        produ.setValorProduto(in.nextDouble());
        
        
        listaprodutos.add(produ);
       
      
        System.out.println("****************************************************************************");
        System.out.println("*********************PRDODUTO CADASTRADO COM SUCESSO************************");
        System.out.println("****************************************************************************");

        break;


          case 2:

        System.out.println("****************************************************************************");
        System.out.println("*****************************CONSULTAR PRODUTOS*****************************");
        System.out.println("****************************************************************************");
          
          System.out.print("Digite o nome do produto: ");
          String nome =  (in.nextLine());

          System.out.println();
          System.out.println("**********************************************************************");
          System.out.println("**************************CONSULTAR PRODUTOS**************************");
          System.out.println("**********************************************************************");
          System.out.println();
          System.out.println("Codigo     "  +   "    Nome "      +  "              Valor   "     + "       Quantidade "   );
          System.out.println("----------------------------------------------------------------------");

    
          boolean produtoencontrado = false;
          for(int i = 0; i < listaprodutos.size(); i ++) {
            Produtos produtos = listaprodutos.get(i);  
            
            if(nome.equals(produtos.getNomeProduto())){
           
            System.out.println(produtos.getCodigoProduto() + "            " + produtos.getNomeProduto() + "             " + produtos.getValorProduto() + "           " + produtos.getEstoqueProduto());
            System.out.println("----------------------------------------------------------------------");
            produtoencontrado = true;
            break;
            }
            
            
        
          }    
    


            if(produtoencontrado == false   ){
             
              System.out.println("Produto não encontrado.");
            }
        // voltarMenu(sc);
        break;

          case 3:
          if (listaprodutos.isEmpty()) {
            System.out.println("Produto não Encontrado.");
            continue;
            //voltarMenu(sc);
          }
           
              System.out.println();
              System.out.println("**********************************************************************");
              System.out.println("*************************LISTAGEM DE PRODUTOS*************************");
              System.out.println("**********************************************************************");
              System.out.println();
              System.out.println("Codigo     "  +   "       Nome "      +  "              Valor   "     + "       Quantidade "   );
              System.out.println("----------------------------------------------------------------------");
            for (Produtos produtos :listaprodutos ) {           
              
              System.out.println(produtos.getCodigoProduto() +"               " +  produtos.getNomeProduto() +"            " + "R$" + produtos.getValorProduto() +"              " +  produtos.getEstoqueProduto());
              System.out.println("----------------------------------------------------------------------");
               
              soma = soma + produtos.getValorProduto() ;
            }  
            
            double maiorValor = listaprodutos.stream()
            .max(comparing(Produtos::getValorProduto))
            .get()
            .getValorProduto();            
              
             double menorValor = listaprodutos.stream()
             .min(comparing(Produtos::getValorProduto))
             .get()
             .getValorProduto();
        
              double media = soma / listaprodutos.stream().count();
           
              System.out.println("Valor Maximo: " + "R$ "+ maiorValor  +     "     Média " + "R$ "+media  + "    Valor Minimo  " + "R$ " + menorValor);
        
          break;
          
        case 4:// :new Relatorio(vend).run(); break;
        System.out.println("****************************************************************************");
        System.out.println("*******************************REALIZAR VENDA*******************************");
        System.out.println("****************************************************************************");
        
        Venda vend = new Venda();
        
        System.out.print("Digite o nome do produto: ");
        String codigoitem = in.nextLine();
     ;

        boolean produtoencontradovenda = false;
          for(int i = 0; i < listaprodutos.size(); i ++) {
            Produtos produtos = listaprodutos.get(i);  
            
            if(codigoitem.equals(produtos.getNomeProduto())){
              vend.setProduto(produtos.getNomeProduto());
          
             
            System.out.println();
            produtoencontradovenda = true;
                   

            System.out.print("Digite a Data da venda: " );
            vend.setDataVenda(in.nextLine());

           System.out.print("Digite a quantidade do produto: ");
           vend.setProdutoEstoque(in.nextInt());
          
           double calculo = (vend.getProdutoEstoque() * produtos.getValorProduto());
           int calculoestoque = ( produtos.getEstoqueProduto() - vend.getProdutoEstoque());  
          
           vend.setValorVenda(calculo);
           produtos.setEstoqueProduto(calculoestoque);
           
           listavendas.add(vend);

        System.out.println("Venda realizada com sucesso.");

      }
    }

         
    if(produtoencontradovenda == false   ){
             
      System.out.println("Produto não encontrado.");
    }
    
    break;
        
         case 5:

         System.out.print("Digite a data inicial no formato  dd/mm/aaaa:  ");
         String dataI =  (in.nextLine());

         System.out.print("Digite a data final no formato  dd/mm/aaaa:  ");
         String dataF =  (in.nextLine());
    
         boolean vendaencontrada = false;
        
         System.out.println("****************************************************************************************************");
         System.out.println("****************************************RELATÓRIO DE VENDAS - DETALHADO*****************************");
         System.out.println("****************************************************************************************************");
         System.out.println("Período de emissão: " + dataI +  " a " + dataF + ".");
         System.out.println("Data     "  +   "       Produto "   + "      Quantidade"  +    "           Valor(R$)   "     + "       ValorTotal "   );
              System.out.println("-----------------------------------------------------------------------------------------------");
         for(int i = 0; i < listavendas.size(); i ++) {
           Venda vendas = listavendas.get(i);  
            
            
             

           if((dataI.equals(vendas.getDataVenda()) || ( dataI.equals(vendas.getDataVenda()))) ||  (dataF.equals(vendas.getDataVenda()) || ( dataF.equals(vendas.getDataVenda())))){
            
            double valorUnitario = vendas.getValorVenda() / vendas.getProdutoEstoque();
            
                        
            System.out.println( vendas.getDataVenda()+"         " +    vendas.getProduto()+"        " +                   vendas.getProdutoEstoque() +"                   " + "R$"+ valorUnitario + "              " +  "R$" + vendas.getValorVenda());
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println();          
           
            somarVend = somarVend + vendas.getValorVenda();
            mediaVend = somarVend / listavendas.stream().count();
           
           
           
           vendaencontrada = true;
          
           }           
          
          
           if(vendaencontrada == false   ){
             
            System.out.println("Produto não encontrado.");
          }
         }
            System.out.println("Valor médio das vendas no período: " + "R$" + mediaVend);

        
        case 0:
          System.out.println("Fim do programa.");
          break;
        default:
          System.out.println("opção inválida!");
          break;
      }
    } while (opcao != -1);

    in.close();

    
}
}