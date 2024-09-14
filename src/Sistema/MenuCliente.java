package Sistema;

import java.util.Scanner;

public class MenuCliente {
    Scanner input = new Scanner(System.in);
    
    public void controleMenuCliente(char opcao){
        switch(opcao){
            case '1':
                comprarIngresso();
                break;
            case '2':
                listarEventos();
                break;
            case '3':
                cancelarCompra();
                break;
            case '4':
                minhasInfo();
            case '5':
                MenuPrincipal menu = new MenuPrincipal();
                menu.menuPrincipal();
                break;
            default:
                System.out.println("\nEscolha uma opcao valida!");
                menuCliente();
        }
    }
    
    public void menuCliente(){
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        
        for (int i = 0; i < menuFuncionario.eventos.size(); i++) {
            if(menuFuncionario.ingressos.get(i).getQuantidade() < 1){
                menuFuncionario.ingressos.get(i).setStatus("Inativo");
            }
        }
        char opcao;
        
        System.out.println("---------------------------");
        System.out.println("----- Menu do Cliente -----");
        System.out.println("---------------------------\n");
        
        System.out.println("[1]. Comprar Ingresso");
        System.out.println("[2]. Listar Eventos");
        System.out.println("[3]. Cancelar compra");
        System.out.println("[4]. Minhas info");
        System.out.println("[5]. Menu Principal");
        System.out.print("|Escolha uma opcao [1-4]: ");
        opcao = input.next().charAt(0);
        
        controleMenuCliente(opcao);
    }
    
    public void comprarIngresso(){
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        input.nextLine();
        
        boolean encontrado = false;
        
        System.out.print("\nInforme o nome do evento: ");
        String nomeEvento = input.nextLine();
        
        for (int i = 0; i < menuFuncionario.eventos.size(); i++) {
            if(menuFuncionario.eventos.get(i).getStatus() == "Inativo" || menuFuncionario.ingressos.get(i).getStatus() == "Inativo"){
                System.out.println("Poxa, esse evento esta inativo ou os ingresos esgotaram! :(\n");
                menuCliente();
            }
            
            if(nomeEvento.equalsIgnoreCase(menuFuncionario.eventos.get(i).getNome())){
                encontrado = true;
                System.out.println("\nEvento encontrado!");
                
                System.out.print("Quantos ingressos deseja comprar?: ");
                int numeroIngressos = input.nextInt();
                
                if(numeroIngressos > menuFuncionario.ingressos.get(i).getQuantidade()){
                    System.out.println("Voce nao pode comprar essa quantidade de ingressos!");
                    comprarIngresso();
                }else if(numeroIngressos < 1 ){
                    System.out.println("A quantidade precisa ser maior que 0!");
                    comprarIngresso();
                }else{
                    //Diminui o numero de ingressos total pelo numero de ingressos que comprei
                    int quantidade = menuFuncionario.ingressos.get(i).getQuantidade();
                    menuFuncionario.ingressos.get(i).setQuantidade(quantidade -= numeroIngressos);
                    
                    //Armazena o numero de ingressos que comprei
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    int ingressosComprados = menuPrincipal.usuarios.get(i).getIngressosComprados();
                    menuPrincipal.usuarios.get(i).setIngressosComprados(ingressosComprados += numeroIngressos);
                    
                    System.out.println("Voce acaba de comprar " + numeroIngressos + " ingressos!");
                    menuCliente();
                }
            }
        }
        if(!encontrado){
            System.out.println("Evento nao encontrado!");
            menuCliente();
        }
    }
    
    public void listarEventos(){
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        
        if(menuFuncionario.eventos.isEmpty()){
            System.out.println("\nNao existem eventos cadastrados!");
        }else{
            for (int i = 0; i < menuFuncionario.eventos.size(); i++) {
                System.out.printf("\nEvento %d\n", i+1);
                System.out.println("Nome: " + menuFuncionario.eventos.get(i).getNome());
                System.out.println("Descricao: " + menuFuncionario.eventos.get(i).getDescricao());
                System.out.println("Data: " + menuFuncionario.eventos.get(i).getData());
                System.out.println("Status do evento: " + menuFuncionario.eventos.get(i).getStatus());
                
                System.out.println("\n------------------------");
                
                System.out.println("\nIngressos ");
                for (int j = 0; j < menuFuncionario.ingressos.size(); j++) {
                    System.out.println("Id: " + menuFuncionario.ingressos.get(j).getId());
                    System.out.println("Valor: " + menuFuncionario.ingressos.get(j).getValor());
                    System.out.println("Status: " + menuFuncionario.ingressos.get(j).getStatus());
                    System.out.println("Quantidade: " + menuFuncionario.ingressos.get(j).getQuantidade());
                }
            }
        }
        menuCliente();
    } 
    
    public void cancelarCompra(){
        input.nextLine();
          
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        boolean encontrado = false;
        
        System.out.print("\nDe qual evento deseja cancelar a compra?: ");
        String nomeEvento = input.nextLine();
        
        for (int i = 0; i < menuFuncionario.eventos.size(); i++) {
            if(nomeEvento.equals(menuFuncionario.eventos.get(i).getNome())){
                encontrado = true;
                
                if(menuPrincipal.usuarios.get(i).getIngressosComprados() == 0){
                    System.out.println("Voce nao comprou nenhum ingresso!");
                }else{
                    System.out.println("Evento encontrado!");
                    System.out.println("Total de ingressos comprados: " + menuPrincipal.usuarios.get(i).getIngressosComprados());

                    System.out.println("\nQuantos ingressos deseja cancelar a compra?: ");
                    int quantidadeCancelada = input.nextInt();

                    if(quantidadeCancelada > menuPrincipal.usuarios.get(i).getIngressosComprados()){
                        System.out.println("Voce nao pode cancelar essa quantidade!");
                    }else{
                        int quantidadeComprada =  menuPrincipal.usuarios.get(i).getIngressosComprados();
                        menuPrincipal.usuarios.get(i).setIngressosComprados(quantidadeComprada - quantidadeCancelada);
                        
                        int quantidadeAtualIngressos =  menuFuncionario.ingressos.get(i).getQuantidade();
                        
                        menuFuncionario.ingressos.get(i).setQuantidade(quantidadeAtualIngressos += quantidadeCancelada);

                        System.out.println(quantidadeCancelada + " ingresso(s) foram cancelados!");
                    }
                } 
            }
        }
        if(!encontrado){
            System.out.println("\nEvento nao encotnrado!");
        }
        
        menuCliente();
    }
    
    public void minhasInfo(){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        
        for (int i = 0; i < menuPrincipal.usuarios.size() ; i++) {
            System.out.println("\nNome: " + menuPrincipal.usuarios.get(i).getNome());
            System.out.println("CPF: " + menuPrincipal.usuarios.get(i).getCpf());
            System.out.println("Email: " + menuPrincipal.usuarios.get(i).getEmail());
            System.out.println("Ingressos comprados: " + menuPrincipal.usuarios.get(i).getIngressosComprados());
        }
        menuCliente();
    }
}