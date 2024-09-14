package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    Scanner input = new Scanner(System.in);
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public void controleMenuPrincipal(char opcao){
        switch(opcao){
            case '1':
                fazerCadastro();
                break;
            case '2':
                loginCliente();
                break;
            case '3':
                loginFuncionario();
                break;
            case '4':
                System.out.println("\nObrigado por usar meu sistema!");
                System.exit(0);
            default:
                System.out.println("\nEscolha uma opcao valida!");
                menuPrincipal();
        }
    }
    
    public void menuPrincipal(){
        char opcao;
        
        System.out.println("--------------------------");
        System.out.println("----- Menu Principal -----");
        System.out.println("--------------------------\n");
        
        System.out.println("[1]. Fazer cadastro");
        System.out.println("[2]. Login para cliente");
        System.out.println("[3]. Login para funcionario");
        System.out.println("[4]. Sair");
        System.out.print("|Escolha uma opcao [1-4]: ");
        opcao = input.next().charAt(0);
        
        controleMenuPrincipal(opcao);
    }
    
    public void fazerCadastro(){
        input.nextLine();
        
        int id = 0;
        
        System.out.print("\nInforme seu nome: ");
        String nome = input.nextLine();
        
        System.out.print("\nInforme seu CPF: ");
        String cpf = input.nextLine();
        
        System.out.print("\nInforme seu email: ");
        String email = input.nextLine();
        
        System.out.print("\nCrie um login: ");
        String login = input.nextLine();
        
        System.out.print("\nCrie uma senha: ");
        String senha = input.nextLine();
        
        id++;
        
        Usuario usuario = new Usuario(login, senha, nome, cpf, email, id);
        usuarios.add(usuario);
        
        System.out.println("\nUsuario cadastrado com sucesso!");
        menuPrincipal();
    }
    
    public void loginCliente(){
        boolean encontrado = false;
        
        input.nextLine();
        
        System.out.print("\nInforme seu login: ");
        String login = input.nextLine();
        
        System.out.print("\nInforme sua senha: ");
        String senha = input.nextLine();
        
        for (int i = 0; i < usuarios.size(); i++) {
            if(login.equals(usuarios.get(i).getLogin()) && senha.equals(usuarios.get(i).getSenha())){
                encontrado = true;
                
                System.out.println("\nLogin bem sucedido!\n");
                
                MenuCliente menu = new MenuCliente();
                menu.menuCliente();
            }
        }
        
        if(!encontrado){
            System.out.println("\nUsuario ou senha incorretos!\n");
            menuPrincipal();
        }
    }
    
    public void loginFuncionario(){
        input.nextLine();
        
        System.out.print("\nInforme seu login: ");
        String login = input.nextLine();
        
        System.out.print("\nInforme sua senha: ");
        String senha = input.nextLine();
        
        if(login.equals("ADMIN") && senha.equals("123")){
            System.out.println("\nLogin bem sucedido!\n");
            
            MenuFuncionario menu = new MenuFuncionario();
            menu.menuFuncionario();
        }else{
            System.out.println("\nLogin ou senha incorretos!");
            menuPrincipal();
        }
    }
}