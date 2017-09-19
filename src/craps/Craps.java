package craps;

import java.util.Random;

public class Craps {
    
    // Variável de classe para geração de números randômicos
    private static final Random NUMERO_RANDOMICO = new Random ();
    
    // Enumeração com os estados do jogo
    private enum Estado {CONTINUA, GANHOU, PERDEU};
    
    // Constantes com os nomes das jogadas conforme o valor dos dados
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    
    // Joga uma partida de craps
    public void joga () {
        
        int meusPontos = 0; // Acumulador para valores dos dados
        Estado estadoJogo; // CONTINUA, GANHOU ou PERDEU
        
        int somaDosDados = rolaDados (); // Primeira jogada
        
        // Estado do jogo conforme primeira jogada
        switch (somaDosDados) {
            
            case SEVEN : // Ganha com 7 na primeira jogada
            case YO_LEVEN : // Ganha com 11 na primeira jogada
                estadoJogo = Estado.GANHOU;
                break;
                
            case SNAKE_EYES : // Perde com 2 na primeira jogada
            case TREY : // Perde com 3 na primeira jogada
            case BOX_CARS : // Perde com 12 na primeira jogada
                estadoJogo = Estado.PERDEU;
                break;
                
            default : // Nem ganhou, nem perdeu na primeira jogada
                estadoJogo = Estado.CONTINUA; // Continua o jogo
                meusPontos = somaDosDados; // Guarda o valor dos dados
                
                System.out.println ("Meus pontos: " + String.valueOf(meusPontos));
                break;
                
        } // switch (somaDosDados)
        
        // Enquanto o jogo não terminar
        while (estadoJogo == Estado.CONTINUA) {
            
            somaDosDados = rolaDados (); // Rola os dados novamente
            
            if (somaDosDados == meusPontos) { // Se o lançamento é igual ao meu primeiro lançamento
                
                estadoJogo = Estado.GANHOU; // Ganhou o jogo
                
            } else if (somaDosDados == SEVEN) { // Se o lançamento é igual a 7
                
                estadoJogo = Estado.PERDEU; // Perdeu o jogo

            } // if (somaDosDados == SEVEN)
            
        } // while (estadoJogo = Estado.CONTINUA)
        
        if (estadoJogo == Estado.GANHOU) {
            
            System.out.println ("Ganhou o jogo!!!"); // Venceu!
            
        } else {
            
            System.out.println ("Perdeu o jogo!!!"); // Venceu!
            
        } // if (estadoJogo == Estado.GANHOU)
            
        
    } // public void play ()
    
    private int rolaDados () {
        
        // Seleciona os valores aleatórios para cada um dos dados
        int dado1 = 1 + NUMERO_RANDOMICO.nextInt(6);
        int dado2 = 1 + NUMERO_RANDOMICO.nextInt(6);
        
        int somaDados = dado1 + dado2; // Soma dos valores dos dados
        
        System.out.println ("Dado 1: " + String.valueOf(dado1) + "\tDado 2: " + String.valueOf(dado2));
        
        return somaDados;
    }

    public static void main(String[] args) {
        
        Craps jogo = new Craps (); // Instancia e cria um objeto da classe Craps
        
        jogo.joga(); // Joga uma partida de Craps
        
    }
    
}
