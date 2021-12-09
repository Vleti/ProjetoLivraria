/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Windows 7
 */
public class Pedidos {
    public static void main(String[] args) {
        Scanner scanner;
        Order o1 = new Order();
        int id=0;
        int opcao=0;
        
        System.out.println("1 - Listar Pedidos");
        System.out.println("2 - Excluir Pedidos");
        
        scanner = new Scanner(System.in);
        System.out.println("Escolha uma opcao:");
        opcao = scanner.nextInt();
        
        if(opcao==1){
            DaoOrder dor=new DaoOrder();
            List<Order> ordem=dor.listarPedido("");
            
            if(ordem.isEmpty()){
                System.out.println("Não há pedidos adicionados");
            }
            
            else{
                for(Order o:ordem){
                    System.out.print("\n");
                    System.out.println("ID do pedido:"+o.getId());
                    System.out.println("ID do usuario:"+o.getIdUsu());
                    System.out.println("ID do livro:"+o.getIdLiv());
                    System.out.println("Data do pedido:"+o.getDate());
                    System.out.println("Hora do pedido:"+o.getTime());
                }
            }
        }
        
        if(opcao==2){
            DaoOrder dor=new DaoOrder();
            List<Order> orders=dor.listarPedido("");
            
            if(orders.isEmpty()){
                System.out.println("Não há pedidos adicionados");
            }
            
            else{
                try{
                    scanner = new Scanner(System.in);
                    System.out.println("========EXCLUIR PEDIDO=========");
                    
                    System.out.println("ID do pedido que deseja excluir: ");
                    id=scanner.nextInt();
                    
                    o1.setId(id);
                    
                    id = dor.verificaIDPedido(o1);
                    
                    if(id==-1){
                        System.out.println("ID do pedido não encontrado");
                        System.out.println("================================");
                    }
                    else{
                        dor.deletaPedido(o1);

                        System.out.println("Pedido excluido com sucesso");
                        System.out.println("================================");
                    }
            }catch(Exception e){
                       e.printStackTrace();
                }
            }
        }
        
        if(opcao<=0 || opcao>=3){
            System.out.println("Escolha uma opção válida");
        }

    }
}
