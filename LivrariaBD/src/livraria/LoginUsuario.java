/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Windows 7
 */
public class LoginUsuario {
    public static void main(String[] args) {
        Scanner scanner;
        User u = new User();
        String userName="";
        String userEmail="";
        String password="";
        int id=0;
        int opcao=0;
        
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Login");
        
        scanner = new Scanner(System.in);
        System.out.println("Escolha uma opcao:");
        opcao = scanner.nextInt();
        
        if(opcao==1){
            try{
                scanner = new Scanner(System.in);
                System.out.println("========CADASTRO=========");
                System.out.println("Nome do usuário: ");
                userName=scanner.nextLine();

                System.out.println("Email: ");
                userEmail=scanner.nextLine();

                System.out.println("Senha: ");
                password=scanner.nextLine();

                u.setName(userName);
                u.setEmail(userEmail);
                u.setPassword(password);

                DaoUser db=new DaoUser();
                db.cadastrar(u);

                System.out.println("Usuário cadastrado com sucesso");
                System.out.println("================================");
                
            }catch(Exception e){
                   e.printStackTrace();
               }
        }
        if(opcao==2){
            try{
                scanner = new Scanner(System.in);
                System.out.println("========LOGIN=========");
                System.out.println("Nome do usuário: ");
                userName=scanner.nextLine();
                
                System.out.println("Senha: ");
                password=scanner.nextLine();
                
                u.setName(userName);
                u.setPassword(password);
                
                DaoUser db=new DaoUser();
                
                int verificar = db.logar(u);
                
                if(verificar==-1){
                    System.out.println("Usuário ou senha incorretos");
                    System.out.println("=======================");
                }
                else{
                    System.out.println("Usuário logado com sucesso");
                    System.out.println("===========================");
                    Thread.sleep(1500);
                    for(int i =0;i<10;i++){
                        System.out.println();
                    }
                    menu(u);
                    
                }
                
            }catch(Exception e){
                   e.printStackTrace();
               }
        }
        if(opcao<=0 || opcao>=3){
            System.out.println("Escolha uma opção válida");
        }
    }
    
    public static int menu(User u) throws InterruptedException{
        Scanner scanner;
        Book b = new Book();
        String userName="";
        String userEmail="";
        String password="";
        String title="";
        int id=0;
        int opcao=0;
        opcao = 0;
        
        do{
            System.out.println("1 - Comprar livro");
            System.out.println("2 - Dados conta");
            System.out.println("3 - Alterar conta");
            System.out.println("4 - Excluir conta");
            System.out.println("5 - Sair");

            scanner = new Scanner(System.in);
            System.out.println("Escolha uma opcao:");
            opcao = scanner.nextInt();

            if(opcao==1){
                try{

                    System.out.println("========COMPRAR LIVRO=========");

                    DaoBook db=new DaoBook();
                    DaoOrder dor= new DaoOrder();
                    List<Book> books=db.listar("");
                    System.out.println("Livros disponiveis:");
                    for(Book l:books){
                        System.out.println();
                        System.out.println("Titulo:"+l.getTitle());
                        System.out.println("Autor:"+l.getAuthor());
                        System.out.println("Publicadora:"+l.getPublisher());
                    }

                    scanner = new Scanner(System.in);
                    System.out.println("\nTitulo do livro que deseja comprar: ");
                    title=scanner.nextLine();

                    b.setTitle(title);

                    int tmpid = db.consultarPorTitulo(b);
                    if(tmpid==-1){
                        System.out.println("Livro não encontrado no estoque");
                        System.out.println("================================");
                        
                        Thread.sleep(1500);
                        for(int i =0;i<10;i++){
                            System.out.println();
                        }
                    }
                    else{
                        int idLivro = tmpid;
                        int idUsu = u.getId();
                        dor.insert(idUsu,idLivro);
                        System.out.println("Pedido do livro confirmado!");
                        System.out.println("================================");
                        
                        Thread.sleep(1500);
                        for(int i =0;i<10;i++){
                            System.out.println();
                        }
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(opcao==2){
                DaoUser db=new DaoUser();
                List<User> users=db.dados("",u);
                try{
                    System.out.println("========DADOS CONTA=========");
                    for(User us:users){
                        System.out.println("ID:"+us.getId());
                        System.out.println("Usuário:"+us.getName());
                        System.out.println("Senha:"+us.getPassword());
                        System.out.println("Email:"+us.getEmail());
                        
                        Thread.sleep(1500);
                        for(int i =0;i<10;i++){
                            System.out.println();
                        }
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(opcao==3){
                DaoUser db=new DaoUser();
                try{
                    scanner = new Scanner(System.in);
                    System.out.println("========ALTERAR CONTA=========");

                    System.out.println("Novo Usuário: ");
                    userName=scanner.nextLine();

                    System.out.println("Novo E-mail: ");
                    userEmail=scanner.nextLine();

                    System.out.println("Nova Senha: ");
                    password=scanner.nextLine();

                    u.setName(userName);
                    u.setEmail(userEmail);
                    u.setPassword(password);

                    db.alterar(u);

                    System.out.println("Conta alterada com sucesso");
                    System.out.println("================================");
                    
                    Thread.sleep(1500);
                        for(int i =0;i<10;i++){
                            System.out.println();
                        }

                    }catch(Exception e){
                           e.printStackTrace();
                       }
            }

            if(opcao==4){
                try{
                    scanner = new Scanner(System.in);
                    System.out.println("========EXCLUIR CONTA=========");

                    System.out.println("Informe a senha para exclusão: ");
                    password=scanner.nextLine();

                    u.setPassword(password);
                    DaoUser db=new DaoUser();

                    int verificar = db.logar(u);

                    if(verificar==-1){
                        System.out.println("Senha incorreta. \nNão será possivel excluir a conta");
                        System.out.println("==============================");
                        
                        Thread.sleep(1500);
                        for(int i =0;i<10;i++){
                            System.out.println();
                        }
                    }
                    else{
                        db.excluir(u);
                        System.out.println("Conta excluida com sucesso");
                        System.out.println("Deslogando...");
                        System.out.println("==============================");
                        Thread.sleep(1500);
                        opcao=5;
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(opcao<=0 || opcao>=6){
                System.out.println("Escolha uma opção válida");
                Thread.sleep(1500);
                for(int i =0;i<10;i++){
                    System.out.println();
                }
            }
        }while(opcao!=5);
        
        return 0;
    }
}

