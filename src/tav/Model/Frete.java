//PROGRAMA REFATORADO POR FREDERICO LEITE SAUER EM ATIVIDADE PARA FAETERJ-RIO
package tav.Model.;

public class Frete 
	{
	public int idFrete;
	public double valorFrete;
	public int cep;

	public int getIdFrete() 
	{
		return idFrete;
	}
	public void setIdFrete(int idFrete) 
	{
		this.idFrete = idFrete;
	}
	public double getValorFrete() 
	{
		return valorFrete;
	}
	public void setValorFrete(double valorFrete) 
	{
		this.valorFrete = valorFrete;
	}
	public int getCep() 
	{
		return cep;
	}
	public void setCep(int cep) 
	{
		this.cep = cep;
	}
}