import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
	/**
	 * @param args
	 * @throws ParametrosIvalidosException 
	 */
	public static void main(String[] args) throws ParametrosIvalidosException {
	
		processar_entrada();
		System.out.println("FIM da execução! - [Main]");
	}

	static void contar(int parametroUm, int parametroDois ) throws ParametrosIvalidosException  {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if ( parametroUm >= parametroDois ){
            //System.err.println("O primeiro parametro precisar ser menor que o segundo");
			throw new ParametrosIvalidosException ();
		}
		
		int contagem = parametroDois - parametroUm;
		//realizar o for para imprimir os números com base na variável contagem
		for (int i = 1; i <= contagem;i++){
			
			System.out.println("Imprima o numero " + i);
		}
	}

	static void processar_entrada () throws ParametrosIvalidosException{
		
		Scanner terminal = new Scanner(System.in);
		try {
			System.out.println("Digite o primeiro parâmetro");
			int parametroUm = terminal.nextInt();
			System.out.println("Digite o segundo parâmetro");
			int parametroDois = terminal.nextInt();
			System.out.println();

			terminal.close();
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
			
		}
		catch ( ParametrosIvalidosException e ) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
			System.err.println(e);
		}
		catch ( InputMismatchException e ){ // tentativa de recuperar a aplicação sem finally
			System.out.println("Por favor digite um número válido.");
			processar_entrada(); // chama metodo processar entrada novamente caso um dos valores seja invalidos
			System.out.println("FIM da execução! - [InputMismatchException]");
		}
		
	}
}