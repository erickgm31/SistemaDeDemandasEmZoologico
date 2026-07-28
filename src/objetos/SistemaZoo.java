package objetos;

import java.util.*;
import java.util.UUID;

public class SistemaZoo {
    Random random = new Random();
    Scanner SC = new Scanner(System.in);

    AdmistradorDoSistema Adm0;

    protected HashMap<Integer, Funcionario> funcionarios = new HashMap<>();

    public HashMap<Integer, Funcionario>  getFuncionarios(){
        return funcionarios;  // retorna o hast map de funcrionario
    }

    public void iniciarSistema(){
        //carregarAquivo

        if(funcionarios.isEmpty() == true){
            crieAdimDoSistema();
        }else{
            login();
        }
    }

    public void crieAdimDoSistema(){
        System.out.println("Crie o Admistrador do Sistema! ");

        System.out.print("Nome: ");
        String nome = SC.nextLine();
        System.out.print("\nIdade: ");
        int idade = SC.nextInt();
        System.out.print("\nSalario: ");
        double salario = SC.nextDouble();
        System.out.print("\nFormação: ");
        String formacao = SC.nextLine();
        System.out.print("\nOrientação Sexual: ");
        String orientacaoS = SC.nextLine();

        if(salario > 0 && idade >= 18){
            Adm0 = new AdmistradorDoSistema(nome, idade, formacao, orientacaoS, salario);
            System.out.println("Administrador do Sistema criado com sucesso!");
        } else{
            System.out.println("Tente Novamente!");
            crieAdimDoSistema();
        }
    }

    public void criaUser(){

        System.out.print("\nEscolha o Cargo: ");
        System.out.println(" Indice | Cargo | Função Relacionada. ");
        System.out.println(" 1 | Gerente | Gerenciamento Finaceiro. ");
        System.out.println(" 2 | Tratador de Animais | Cuidados Basicos aos Animais.");
        System.out.println(" 3 | Zootecnista | Cuidados Tecnicos aos Animais.");
        System.out.println(" 4 | Medico Veterinario | Cuidados Clinicos aos Animais.");
        System.out.println(" 5 | Biologo | Cuidados relacionados ao Ecossistema. ");
        System.out.println(" 6 | Auxiliar de Manutenção | Manuntenção do Zoologico. ");
        System.out.println(" 7 | Profissionais de Limpeza | Limpeza do Zoologico");
        System.out.println();

        System.out.println("Selecione qual o indice: ");
        int escolha = SC.nextInt();
        if (escolha == 1){

            System.out.println("Crie o Gerente: ");

            System.out.print("Nome: ");
            String nome = SC.next();
            System.out.print("\nIdade: ");
            int idade = SC.nextInt();
            System.out.print("\nSalario: ");
            double salario = SC.nextDouble();
            System.out.print("\nFormação: ");
            String formacao = SC.next();
            System.out.print("\nOrientação Sexual: ");
            String orientacaoS = SC.next();

            Gerente Ad01 = new Gerente(nome,idade, formacao, orientacaoS, salario);
            funcionarios.put(Ad01.getUsuario(), Ad01);

            Integer usuario = random.nextInt(90000) + 10000;  // Criando User Aleatorio com 5 numeros entre 10000 - 99999
            if(funcionarios.containsKey(usuario)){  // verifica se ja existi, so sai do while, quando for exclusivo
                while (funcionarios.containsKey(usuario)){
                    usuario = random.nextInt(90000) + 10000;
                }
            }

            String primeiraSenha = UUID.randomUUID().toString().substring(0,8); // cria senha aleatoria, o plano é que depois do primeiro acesso, o user a troque

            Ad01.setUsuario(usuario);
            Ad01.setSenha(primeiraSenha);
        }
    }

    public void informarDemanda() throws Vazio {
        System.out.println();
        System.out.print("Demanda: ");
        String demanda = SC.nextLine();

        System.out.print("\nCargo responsavel: ");
        System.out.println(" Indice | Cargo | Função Relacionada. ");
        System.out.println(" 1 | Gerente | Gerenciamento Finaceiro. ");
        System.out.println(" 2 | Tratador de Animais | Cuidados Basicos aos Animais.");
        System.out.println(" 3 | Zootecnista | Cuidados Tecnicos aos Animais.");
        System.out.println(" 4 | Medico Veterinario | Cuidados Clinicos aos Animais.");
        System.out.println(" 5 | Biologo | Cuidados relacionados ao Ecossistema. ");
        System.out.println(" 6 | Auxiliar de Manutenção | Manuntenção do Zoologico. ");
        System.out.println(" 7 | Profissionais de Limpeza | Limpeza do Zoologico");
        System.out.println();

        System.out.print("Opção: ");
        int tipoFuncionario = SC.nextInt();
        Demanda X = new Demanda(demanda, tipoFuncionario);
        enviarDemanda(X);
    }

    public void enviarDemanda(Demanda demanda) throws Vazio {
        if (demanda.getTipoFuncionario() == 0) { // forma mais facil de definir qual o funcionario é por numeros
            ArrayList<Funcionario> gerentes = new ArrayList<>();
            for (Funcionario funcionario : getFuncionarios().values()) {
                if (funcionario instanceof Gerente) {
                    gerentes.add(funcionario);
                    }
                }
            if(gerentes.size() == 0){ // tratamento de exceção
                throw new Vazio ("Ainda não existe Admistradores cadrastados!");
            } else {
                int escolha = random.nextInt(gerentes.size());  // delimita uma escolha aleatoria entre a quantidade dos adims
                Funcionario escolhido = gerentes.get(escolha); // escolhe o adim do indice sorteado a cima
                escolhido.receberDemandas(demanda.getProblema()); // envia para o adim escolhido
            }

            // Aqui continua o teste, para envio, exemplo
            // if else(d.getTipoFuncionario() == 1){ faz o arraylist proprio dos tratadores
        }
    }

    public void login(){

        System.out.println("Usuario: ");
        Integer user = SC.nextInt();

        Funcionario Pacesso = funcionarios.get(user);

        if (Pacesso != null) {
            System.out.println("Senha: ");
            String senha = SC.nextLine();
            if(Objects.equals(Pacesso.getSenha(), senha)){ //Começa verificando se a senha não é null, e depois se ta certo
                System.out.println("Login Realizado com Sucesso.");

            } else{
                System.out.println("Senha Incorreta! Tente de novo");
                int cont = 0;

                while (cont < 5 || Objects.equals(Pacesso.getSenha(), senha)){
                    login();
                    cont ++;
                }
            }
        } else{
            System.out.println("Usuario inexistente");
        }
    }

    public void redefinirSenha(int user){
        System.out.print("Informe sua senha antiga: ");
        String senhaAntiga = SC.nextLine();

        System.out.print("Informe sua nova senha: ");
        String novaSenha = SC.nextLine();


        if(Objects.equals(funcionarios.get(user).getSenha(), senhaAntiga)) {
            if (novaSenha.length() == 8) {
                funcionarios.get(user).setSenha(novaSenha);
                System.out.println("Senha aprovada com sucesso");
            } else if (novaSenha.length() > 8) {
                System.out.println("Senha com mais de 8 digitos! Tente de novo");
                redefinirSenha(user);
            } else{
                System.out.println("Senha com menos de 8 digitos! Tente de novo");
                redefinirSenha(user);
            }
        } else{
            System.out.println("Senha Antiga Invalida.");
        }
    }

    public void MenuNormal(int user){
        boolean executando = true;
        int indice;

        while (executando){
            System.out.println("Bem vindo de volta " + funcionarios.get(user).getNome());
            System.out.println();
            System.out.println("---------  Menu Principal ---------");
            System.out.println(" 1 - Exebir Minhas Informações.    ");
            System.out.println(" 2 - Ver Minhas Demandas.          ");
            System.out.println(" 3 - Informar Demanda.             ");
            System.out.println(" 4 - Informar Conclusão da Demanda.");
            System.out.println(" 5 - Alterar Senha.                ");
            System.out.println(" 6 - Sair do sistema.              ");

            System.out.println();

            System.out.print("Opção: ");
            int opcao = SC.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println();
                    funcionarios.get(user).exibirInformacoes();
                    System.out.println("\nPressione Enter para voltar ao menu: ");
                    SC.nextLine();
                    SC.nextLine();
                    break;

                case 2:
                    System.out.println();
                    try {
                        funcionarios.get(user).exibirDemandas();
                    } catch (Vazio e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    System.out.println("\nPressione Enter para voltar ao menu: ");
                    SC.nextLine();
                    SC.nextLine();
                    break;

                case 3:

                    try {
                        informarDemanda();
                    } catch (Vazio e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    System.out.println("\nPressione Enter para voltar ao menu: ");
                    SC.nextLine();
                    SC.nextLine();
                    break;

                case 4:
                    System.out.print("\nInforme o indice da demanda que deseja apagar: ");
                    indice = SC.nextInt();

                    try {
                        funcionarios.get(user).removerDemanda(indice);
                    } catch (Vazio e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    System.out.println("\nPressione Enter para voltar ao menu: ");
                    SC.nextLine();
                    SC.nextLine();
                    break;

                case 5:
                    System.out.println("Defina sua nova senha");
                    redefinirSenha(user);
                    System.out.println("\nPressione Enter para voltar ao menu: ");
                    SC.nextLine();
                    SC.nextLine();
                    break;

                case 6:
                    executando = false;
                    break;
                default:
                    System.out.println("Valor fora dos limites!");
            }
        }
    }



}
