//PROGRAMA REFATORADO POR FREDERICO LEITE SAUER EM ATIVIDADE PARA FAETERJ-RIO
package tav.Model.Loja;

public class Cliente 
	{
	public int idCliente;
	public String endereco;
	public String pais;
	public int cep;
	
	public int getIdCliente() 
	{
		return idCliente;
	}
	public void setIdCliente(int idCliente) 
	{
		this.idCliente = idCliente;
	}
	public String getEndereco() 
	{
		return endereco;
	}
	public void setEndereco(String endereco) 
	{
		this.endereco = endereco;
	}
	
	public String getPais() 
	{
		return pais;
	}
	public void setPaisCliente(String pais) 
	{
		this.pais = pais;
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