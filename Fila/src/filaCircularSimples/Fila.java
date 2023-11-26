package filaCircularSimples;

import filaCircularDupla.FilaDupla;

public class Fila
{
	/* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected int[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */
	
	public Fila(int tam)
	{
		tamanho = tam;
		vetor = new int[tamanho];
		ini = 0;
		n = 0;
	}
	
	public boolean vazia()
	{
		return (n == 0);
	}
	
	public boolean cheia()
	{
		return (n == tamanho);
	}
	
	//Retiramos o elemento do início da fila
	public int remove()
	{
		int elemento = Integer.MIN_VALUE;
		
		if (!this.vazia())
		{
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(int elemento)
	{
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = elemento;
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}
	
	public void imprime()
	{
		int i, j;
		
		if (vazia())
			System.out.println("Fila est� vazia.");
		else
			for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
				System.out.println(j + " " + vetor[i]);
	}
	
	public void combinaFilas(Fila f1, Fila f2) {
		while((!f1.vazia() || !f2.vazia()) && !this.cheia()) {
			if(!f1.vazia()) {
				this.insere(f1.remove());
			}
			if(!f2.vazia()) {
				this.insere(f2.remove());
			}
		}
	}
	
	public static FilaDupla implementaFilaDupla(Fila fila) {
		Fila filaSimples = (Fila) fila;
		FilaDupla filaDupla = new FilaDupla(filaSimples.getTamanho());
		while(!filaSimples.vazia()) {
			filaDupla.insere(filaSimples.remove());
		}
		
		return filaDupla;
		
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
}