package objetos;

import java.util.*;
import java.util.UUID;

public class SistemaZoo {
    Random random = new Random();
    Scanner SC = new Scanner(System.in);

    protected HashMap<Integer, Funcionario> funcionarios = new HashMap<>();

    public HashMap<Integer, Funcionario>  getFuncionarios(){
        return funcionarios;  // retorna o hast map de funcrionario
    }

    public void iniciarSistema(){
        //carregarAquivo

        if(funcionarios.isEmpty()){
            crieUser();
        }else{
            login();
        }
    }

    public void criarUsuario(Funcionario funcionario){
        Integer usuario = random.nextInt(90000) + 10000;  // Criando User Aleatorio com 5 numeros entre 10000 - 99999
        // verifica se ja existi, so sai do while, quando for exclusivo
        while (funcionarios.containsKey(usuario)){
            usuario = random.nextInt(90000) + 10000;
        }
        funcionario.setUsuario(usuario);
    }

    public void criarSenha(Funcionario funcionario){
        String primeiraSenha = UUID.randomUUID().toString().substring(0,8); // cria senha aleatoria, o plano é que depois do primeiro acesso, o user a troque
        funcionario.setSenha(primeiraSenha);
    }

    public void crieUser(){
        int escolha;
        if(funcionarios.isEmpty()){
            System.out.println("Crie o Admistrador do Sistema!");
            escolha = 0;
        } else{
            System.out.print("\nEscolha o Cargo: ");
            System.out.println(" Indice | Cargo | Função Relacionada. ");
            System.out.println(" 0 | Admistrador do Sistema | Gerenciamento Sistema. ");
            System.out.println(" 1 | Gerente | Gerenciamento Finaceiro. ");
            System.out.println(" 2 | Tratador de Animais | Cuidados Basicos aos Animais.");
            System.out.println(" 3 | Zootecnista | Cuidados Tecnicos aos Animais.");
            System.out.println(" 4 | Medico Veterinario | Cuidados Clinicos aos Animais.");
            System.out.println(" 5 | Biologo | Cuidados relacionados ao Ecossistema. ");
            System.out.println(" 6 | Auxiliar de Manutenção | Manuntenção do Zoologico. ");
            System.out.println(" 7 | Profissionais de Limpeza | Limpeza do Zoologico");
            System.out.println();

            System.out.println("Selecione qual o indice: ");
            escolha = SC.nextInt();
        }

        System.out.print("Nome: ");
        String nome = SC.next();
        System.out.print("\nIdade: ");
        int idade = SC.nextInt();
        System.out.print("\nFormação: ");
        String formacao = SC.next();
        System.out.print("\nTelefone: ");
        String telefone = SC.next();
        System.out.print("\nSalario: ");
        double salario = SC.nextDouble();

        instaciarFuncionario(nome, idade, formacao, telefone, salario, escolha);
    }

    public void instaciarFuncionario(String nome, int idade, String formacao, String telefone, double salario, int escolha){
        if(salario > 0 && idade >= 18) {
             if (escolha == 0) {
                Funcionario Adm0 = new AdmistradorDoSistema(nome, idade, formacao, telefone, salario);
                criarUsuario(Adm0);
                criarSenha(Adm0);
                funcionarios.put(Adm0.getUsuario(), Adm0);
                System.out.println("Administrador do Sistema criado com sucesso!");

            } else if (escolha == 1) {
                Gerente Gerente = new Gerente(nome, idade, formacao, telefone, salario);
                criarUsuario(Gerente);
                criarSenha(Gerente);
                funcionarios.put(Gerente.getUsuario(), Gerente);
                System.out.println("Gerente Criado!");
            }
        }  else {
            System.out.println("Tente Novamente!");
            crieUser();
        }
    }

    public void informarDemanda() throws Vazio {
        System.out.println();
        System.out.print("Demanda: ");
        String demanda = SC.nextLine();
        SC.nextLine();

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
        Demanda demandaInformada = new Demanda(demanda, tipoFuncionario);
        enviarDemanda(demandaInformada);
    }

    public ArrayList<Funcionario> buscarFuncionariosPorCargo(int tipoFuncionario){
        ArrayList<Funcionario> lista = new ArrayList<>();

        for(Funcionario funcionario : funcionarios.values()){
            if(tipoFuncionario == 0 && funcionario instanceof AdmistradorDoSistema){
                lista.add(funcionario);
            } else if (tipoFuncionario == 1 && funcionario instanceof Gerente) {
                lista.add(funcionario);
            }
        }
        return lista;
    }

    public void enviarDemanda(Demanda demanda) throws Vazio {
        ArrayList<Funcionario> lista = buscarFuncionariosPorCargo(demanda.getTipoFuncionario());

        if(lista.isEmpty()){
            throw new Vazio("Não existe funcionário desse cargo.");
        }

        int escolha = random.nextInt(lista.size());
        Funcionario escolhido = lista.get(escolha);
        escolhido.receberDemandas(demanda.getProblema());
    }

    public void login(){

        System.out.println("Usuario: ");
        Integer user = SC.nextInt();
        SC.nextLine();

        Funcionario acesso = funcionarios.get(user);

        if(acesso == null){
            System.out.println("Usuário Inexistente!");
            return;
        }

        int tentativas = 0;
        String senha;

        while (tentativas < 5) {
            System.out.print("Senha: ");
            senha = SC.nextLine();

            if (Objects.equals(acesso.getSenha(), senha)) {
                System.out.println("Login realizado");
                menu(acesso.getUsuario());

                return;
            }
            tentativas++;
            System.out.println("Senha Incorreta, tente novamente: ");

        }
        System.out.println("Você atingiu o limite de tentaivas. ");
    }

    public void redefinirSenha(int user){
        Funcionario funcionario = funcionarios.get(user);

        System.out.print("Informe sua senha atual: ");
        String senhaAtual = SC.nextLine();

        if (!funcionario.getSenha().equals(senhaAtual)) {
            System.out.println("Senha atual incorreta.");
            return;
        }

        while (true) {

            System.out.print("Informe a nova senha: ");
            String novaSenha = SC.nextLine();

            if (novaSenha.length() < 8) {
                System.out.println("A senha deve possuir no mínimo 8 caracteres.");
                continue;
            }

            System.out.print("Confirme a nova senha: ");
            String confirmacao = SC.nextLine();

            if (!novaSenha.equals(confirmacao)) {
                System.out.println("As senhas não coincidem.");
                continue;
            }

            funcionario.setSenha(novaSenha);

            System.out.println("Senha alterada com sucesso!");
            break;
        }
    }

    public void editarFuncionario(int user){
        System.out.println("Para Editar digite o indice do que deseja: ");
        System.out.println(" 1 - Nome      ");
        System.out.println(" 2 - Idade     ");
        System.out.println(" 3 - Formação  ");
        System.out.println(" 4 - Telefone  ");
        System.out.println(" 5 - Salario   ");

        System.out.print("Opção: ");
        int opcao = SC.nextInt();
        SC.nextLine();

        switch (opcao){
            case 1:
                System.out.print("Modifição: ");
                String nome = SC.nextLine();
                funcionarios.get(user).setNome(nome);
                break;
            case 2:
                System.out.print("Nova idade: ");
                int idade = SC.nextInt();
                funcionarios.get(user).setIdade(idade);
                break;

            case 3:
                SC.nextLine();
                System.out.print("Nova formação: ");
                String formacao = SC.nextLine();
                funcionarios.get(user).setFormacao(formacao);
                break;

            case 4:
                System.out.print("Novo telefone: ");
                String telefone = SC.nextLine();
                funcionarios.get(user).setTelefone(telefone);
                break;

            case 5:
                System.out.print("Novo salário: ");
                double salario = SC.nextDouble();
                funcionarios.get(user).setSalario(salario);
                break;

            default:
                System.out.println("Opção inválida.");
        }

        System.out.println("Funcionário atualizado com sucesso!");

    }

    public void removerFuncionario(int user){
        funcionarios.remove(user);
    }

    public void pausar(){
        System.out.println("\nPressione ENTER para contininuar...");
        SC.nextLine();
    }

    public void menu(int user){
        boolean executando = true;
        int indice;

        Funcionario funcionario = funcionarios.get(user);

        while (executando){
            System.out.println("Bem vindo de volta " + funcionarios.get(user).getNome());
            System.out.println();

            System.out.println("---------  Menu Principal ---------");
            System.out.println(" 0 - Sair do Menu.              ");
            System.out.println(" 1 - Exebir Minhas Informações.    ");
            System.out.println(" 2 - Ver Minhas Demandas.          ");
            System.out.println(" 3 - Informar Demanda.             ");
            System.out.println(" 4 - Informar Conclusão da Demanda.");
            System.out.println(" 5 - Alterar Senha.                ");

            if(funcionarios.get(user) instanceof AdmistradorDoSistema){
                System.out.println(" 6 - Cadastrar Funcionario.     ");
                System.out.println(" 7 - Editar Funcionario.        ");
                System.out.println(" 8 - Remover Funcionario        ");
            }

            System.out.println();

            System.out.print("Opção: ");
            int opcao = SC.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println();
                    funcionario.exibirInformacoes();
                    pausar();
                    break;

                case 2:
                    System.out.println();
                    try {
                        funcionario.exibirDemandas();
                    } catch (Vazio e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    pausar();
                    break;

                case 3:

                    try {
                        informarDemanda();
                    } catch (Vazio e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    pausar();
                    break;

                case 4:
                    System.out.print("\nInforme o indice da demanda que deseja apagar: ");
                    indice = SC.nextInt();

                    try {
                        funcionarios.get(user).removerDemanda(indice);
                    } catch (Vazio e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    pausar();
                    break;

                case 5:
                    System.out.println("Defina sua nova senha");
                    redefinirSenha(user);
                    pausar();
                    break;

                case 6:
                    if(funcionario instanceof AdmistradorDoSistema) {
                        System.out.println("Cadraste o Usuario: ");
                        crieUser();
                    } else{
                        System.out.println("Opção Invalida");
                    }
                    pausar();
                    break;

                case 7:
                    if(funcionario instanceof AdmistradorDoSistema) {
                        System.out.println("Faça as modificações: ");
                        editarFuncionario(user);
                    }else{
                        System.out.println("Opção Invalida");
                    }
                    pausar();
                    break;

                case 8:
                    if(funcionario instanceof AdmistradorDoSistema) {
                        System.out.print("Informe o usuario do funcionario a removido: ");
                        Integer usuario = SC.nextInt();
                        removerFuncionario(usuario);
                        System.out.println("Usuario foi apagado!");
                    } else{
                        System.out.println("Opção Invalida");
                    }
                    pausar();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Valor fora dos limites!");
            }
        }
    }
}
