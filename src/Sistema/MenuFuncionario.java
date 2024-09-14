package Sistema;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class MenuFuncionario {
    Scanner input = new Scanner(System.in);
    static ArrayList<Ingresso> ingressos = new ArrayList<>();
    static ArrayList<Evento> eventos = new ArrayList<>();
    
    public void controleMenuFuncionario(char opcao){
        switch(opcao){
            case '1':
                cadastrarEvento();
                break;
            case '2':
                //modificarEvento();
                break;
            case '3':
                listarEventos();
                break;
            case '4':
                MenuPrincipal menu = new MenuPrincipal();
                menu.menuPrincipal();
                break;
            default:
                System.out.println("\nEscolha uma opcao valida!");
                menuFuncionario();
        }
    }
    
    public void menuFuncionario(){
        char opcao;
        
        System.out.println("---------------------------");
        System.out.println("--- Menu do Funcionario ---");
        System.out.println("---------------------------\n");
        
        System.out.println("[1]. Cadastrar Evento");
        System.out.println("[2]. Modificar Evento");
        System.out.println("[3]. Listar Eventos");
        System.out.println("[4]. Menu Principal");
        System.out.print("|Escolha uma opcao [1-4]: ");
        opcao = input.next().charAt(0);
        
        controleMenuFuncionario(opcao);
    }
    
    public void cadastrarEvento(){
        //Evento
        input.nextLine();
        
        System.out.print("\nInforme o nome do evento: ");
        String nome = input.nextLine();
        
        System.out.print("\nDe uma breve descricao do evento: ");
        String descricao = input.nextLine();
        
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("\nInforme a data do evento (dd/MM/yyyy): ");
        String dataEntrada = input.nextLine();
        
        Date dataInformada = null;
        
        try {
            // Convertendo a string para um objeto Date
            dataInformada = formatoData.parse(dataEntrada);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
        }
        
        String statusEvento = "Ativo";
        
        /*-----------------------------------------------------------------------------*/
        
        //Ingresso
        System.out.print("\nInforme o id do ingresso: ");
        String idIngresso = input.nextLine();
        
        System.out.print("\nInforme o valor do ingresso: ");
        double valorIngresso = input.nextDouble();
        
        System.out.print("\nInforme a quantidade de ingressos: ");
        int quantidadeIngressos = input.nextInt();
        
        String statusIngresso = "Ativo";
        
        Evento evento = new Evento(nome, descricao, dataInformada, statusEvento);
        Ingresso ingresso = new Ingresso(idIngresso, valorIngresso, statusIngresso, quantidadeIngressos);
        
        ingressos.add(ingresso);
        eventos.add(evento);
        
        System.out.println("\nEvento cadastrado com sucesso!");
        menuFuncionario();
    }
    
    public void listarEventos(){
        if(eventos.isEmpty()){
            System.out.println("\nNao existem eventos cadastrados!");
        }else{
            for (int i = 0; i < eventos.size(); i++) {
                System.out.printf("\nEvento %d\n", i+1);
                System.out.println("Nome: " + eventos.get(i).getNome());
                System.out.println("Descricao: " + eventos.get(i).getDescricao());
                System.out.println("Data: " + eventos.get(i).getData());
                System.out.println("Status do evento: " + eventos.get(i).getStatus());
                
                System.out.println("\n------------------------");
                
                System.out.println("\nIngressos ");
                for (int j = 0; j < ingressos.size(); j++) {
                    System.out.println("Id: " + ingressos.get(j).getId());
                    System.out.println("Valor: " + ingressos.get(j).getValor());
                    System.out.println("Status: " + ingressos.get(j).getStatus());
                    System.out.println("Quantidade: " + ingressos.get(j).getQuantidade());
                }
            }
        }
        menuFuncionario();
    } 
}