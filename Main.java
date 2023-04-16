import java.util.Scanner;
import java.math.*;
import java.time.LocalDate;

class Main {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    String nome, dataAdmissao, cargo;
    int mesReferencia;
    BigDecimal salarioBruto, salarioHora, adicionalPericulosidade;
    
    //nome completo
    System.out.println("Insira seu nome: ");
    nome = console.next();
    
    //data de admissao
    System.out.println("Insira a data de admissão (DD/MM/AAAA): ");
    dataAdmissao = console.next();
    
    //mês de referencia
    System.out.println("Insira mês de referencia: \n 1: Janeiro \n 2: Fevereiro \n 3: Março \n 4: Abril \n 5: Maio \n 6: Junho \n 7: Julho \n 8: Agosto \n 9: Setembro \n 10: Outubro \n 11: Novembro \n 12: Dezembro ");
    mesReferencia = console.nextInt();

    //cargo
    System.out.println("Insira seu Cargo: ");
    cargo = console.next();

    //salário bruto
    System.out.println("Insira o Salario Bruto (00.00): ");
    salarioBruto = console.nextBigDecimal();
    
    salarioHora = calcularSalarioHora(salarioBruto, console);
    adicionalPericulosidade = calcularPericulosidade(salarioBruto);
    
    //criar relatorio
    System.out.println("\n\n\n\n\n*****Folha de Pagamento******");
    System.out.println("*****Nome Completo: " + nome);
    System.out.println("*****Data de Admissão: " + dataAdmissao);
    System.out.println("*****Mês Referência: " + mesReferencia);
    System.out.println("*****Cargo do colaborador: " + cargo);
    System.out.println("*****Salário do colaborador: ");
    System.out.println("*****Proventos*****");
    System.out.println("*****Periculosidade: " + adicionalPericulosidade);
    System.out.println("*****Insalubridade: ");
    System.out.println("*****Descontos*****: ");
    System.out.println("*****INSS: ");
    System.out.println("*****IRRF: ");
    System.out.println("*****FGTS: ");
    System.out.println("*****Vale Transporte: ");
    System.out.println("*****Vale Refeição: ");
    System.out.println("*****Valor do Salario Bruto: " + salarioBruto);
    System.out.println("*****Valor do Salario Hora: " + salarioHora);
  }

  private static BigDecimal calcularSalarioHora(BigDecimal salarioBruto, Scanner console) {
    int horasTrabalhadas, diasTrabalhados, jornadaSemanal, jornadaMensal, semanas = 5;
        
    System.out.println("Informe as horas trabalhadas por dia:");
    horasTrabalhadas = console.nextInt();

    System.out.println("Informe a quantidade de dias trabalhados semanais:");
    diasTrabalhados = console.nextInt();

    jornadaSemanal = horasTrabalhadas * diasTrabalhados;
    jornadaMensal = jornadaSemanal * semanas;
    
    return salarioBruto.divide(new BigDecimal(jornadaMensal)).setScale(2, RoundingMode.HALF_EVEN);
  }

  private static BigDecimal calcularPericulosidade(BigDecimal salarioBruto) {
    double adicionalPericulosidade = 0.3;
    
    return salarioBruto.multiply(new BigDecimal(adicionalPericulosidade)).setScale(2, RoundingMode.HALF_EVEN);
  }

  
}