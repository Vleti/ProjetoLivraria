package livraria;

import java.util.List;
import java.util.Scanner;


public class Livraria {

    public static void main(String[] args) {
        Scanner scanner;
        Book b1 = new Book();
        String title="";
        String author="";
        String publisher="";
        String email="";
        int id=0;
        
        int opcao=0;
        
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Alterar livro");
        System.out.println("3 - Excluir livro");
        System.out.println("4 - Consultar livro pelo titulo");
        System.out.println("5 - Listar todos livros");
        
        scanner = new Scanner(System.in);
        System.out.println("\nEscolha uma opcao:");
        opcao = scanner.nextInt();
        
        if(opcao==1){
        
            try{
                scanner = new Scanner(System.in);
                System.out.println("========ADICIONAR LIVRO=========");
                System.out.println("Titulo do livro: ");
                title=scanner.nextLine();

                System.out.println("Nome do autor: ");
                author=scanner.nextLine();

                System.out.println("Publicadora: ");
                publisher=scanner.nextLine();
                
                System.out.println("Email: ");
                email=scanner.nextLine();

                b1.setTitle(title);
                b1.setAuthor(author);
                b1.setPublisher(publisher);
                b1.setEmail(email);

                DaoBook db=new DaoBook();
                db.insert(b1);

                System.out.println("Livro adicionado com sucesso");
                System.out.println("================================");
                
            }catch(Exception e){
                   e.printStackTrace();
               }
        }
        
        if(opcao==2){
            DaoBook db=new DaoBook();
            List<Book> books=db.listar("");
            
            if(books.isEmpty()){
                System.out.println("Não há livros adicionados");
            }
            else{
                try{
                    scanner = new Scanner(System.in);
                    System.out.println("========ALTERAR LIVRO=========");
                    
                    System.out.println("ID do livro que deseja alterar: ");
                    id=scanner.nextInt();
                    
                    scanner.nextLine();
                    
                    b1.setId(id);
                    
                    id = db.verificaID(b1);
                    
                    if(id==-1){
                        System.out.println("ID não encontrado");
                        System.out.println("================================");
                    }
                    
                    else{
                        System.out.println("Titulo do livro: ");
                        title=scanner.nextLine();

                        System.out.println("Nome do autor: ");
                        author=scanner.nextLine();
                        
                        System.out.println("Publicadora: ");
                        publisher=scanner.nextLine();

                        System.out.println("Email: ");
                        email=scanner.nextLine();
                        
                        b1.setTitle(title);
                        b1.setAuthor(author);
                        b1.setPublisher(publisher);
                        b1.setEmail(email);
                        
                        db.update(b1);

                        System.out.println("Livro alterado com sucesso");
                        System.out.println("================================");
                    }
                }catch(Exception e){
                       e.printStackTrace();
                   }
            }
        }
    
        
        if(opcao==3){
            DaoBook db=new DaoBook();
            List<Book> books=db.listar("");
            
            if(books.isEmpty()){
                System.out.println("Não há livros adicionados");
            }
            
            else{
                try{
                    scanner = new Scanner(System.in);
                    System.out.println("========EXCLUIR LIVRO=========");
                    
                    System.out.println("ID do livro que deseja excluir: ");
                    id=scanner.nextInt();
                    
                    b1.setId(id);
                    
                    id = db.verificaID(b1);
                    
                    if(id==-1){
                        System.out.println("ID não encontrado");
                        System.out.println("================================");
                    }
                    else{
                        db.delete(b1);

                        System.out.println("Livro excluido com sucesso");
                        System.out.println("================================");
                    }
            }catch(Exception e){
                       e.printStackTrace();
                }
            }
        }
        
        if(opcao==4){
            DaoBook db=new DaoBook();
            List<Book> books=db.listar("");
            
            if(books.isEmpty()){
                System.out.println("Não há livros adicionados");
            }
            
            else{
                try{
                    scanner = new Scanner(System.in);
                    System.out.println("========CONSULTAR LIVRO=========");
                    
                    System.out.println("Nome do livro que deseja consultar: ");
                    title=scanner.nextLine();
                    
                    b1.setTitle(title);
                    
                    id = db.consultarPorTitulo(b1);
                    
                    if(id==-1){
                        System.out.println("Livro não encontrado");
                        System.out.println("================================");
                    }
                    else{
                    
                        System.out.println("ID do Livro:"+b1.getId());

                        System.out.println("Livro consultado com sucesso");
                        System.out.println("================================");
                    }
            }catch(Exception e){
                       e.printStackTrace();
                }
            }
        }
        
        if(opcao==5){
            DaoBook db=new DaoBook();
            List<Book> books=db.listar("");
            
            if(books.isEmpty()){
                System.out.println("Não há livros adicionados");
            }
            
            else{
                for(Book b:books){
                    System.out.print("\n");
                    System.out.println("ID:"+b.getId());
                    System.out.println("Titulo:"+b.getTitle());
                    System.out.println("Autor:"+b.getAuthor());
                    System.out.println("Publicadora:"+b.getPublisher());
                    System.out.println("Email:"+b.getEmail());
                }
            }
        }
        
        if(opcao<=0 || opcao>=6){
            System.out.println("Escolha uma opção válida");
        }
    }
}
















































      /* Book b1=new Book();
       b1.setTitle("BroCode");
       
       Author a1=new Author();
       a1.setName("Barney Stinson");
       
       Publisher p1=new Publisher();
       p1.setName("Suit Literature");
       b1.setPublisher(p1);
       
       User user1=new User();
       user1.setName("Ted");
       User edi=new Editorial();
       User cust=new Customer();
       
       Shipper entrega = new Shipper();
       ShippingInfo entregaInfo = new ShippingInfo();
       entregaInfo.setShipper(entrega);
       
       Account user1Acc = new Account();
       user1.setAccount(user1Acc);
       user1Acc.setId(1);
       user1Acc.setPassword("42");
       user1Acc.setEmailAddress("MosblyT@gmail.com");
       
       BillingInfo compraInfo = new BillingInfo();
       compraInfo.setAccount(user1Acc);
       
       Order compra1=new Order();
       compra1.setUser(user1);
       compra1.setBook(b1);
       compra1.setShippingInfo(entregaInfo);
       compra1.setBillingInfo(compraInfo);
       
       if(compra1.isFullFilled()){
           Scanner scanner;
           long id = 0;
           String psw="";
           try{
               scanner= new Scanner(System.in);
               System.out.println("Insira o ID:");
               id=scanner.nextLong();
               
               System.out.println("Insira a password:");
               psw=scanner.next();
           }catch(Exception e){
               e.printStackTrace();
           }
           if(compra1.getBillingInfo().getAccount().validateLogin(id, psw)){
               System.out.println("Compra realizada com sucesso");
               System.out.println("Livro comprado: "+b1.getTitle());
               System.out.println("Autor do livro: "+b1.getAuthor());
               System.out.println("Publicadora do livro: "+b1.getPublisher().getName());
               System.out.println("Nome do usuário: "+user1.getName());
           }
           else{
               System.out.println("Não foi possível realizar a compra");
           }
           
       }
    
        
        Criar um Livro
        Criar um Autor e vincular ao livro
        Criar um Publicador e vincular ao livro
        Criar um Usuário(Editorial/Consumidor) e vincular a ordem de compra
        Criar um Entregador
        Criar InformaçõesDeEntrega e vincular Entregador
        Criar uma conta com validação de senha
        Criar uma classe de Informações de Conta e vincular a Conta
        Criar uma ordem de compra
        Vincular tudo acima = Ter objeto de venda 
        */
