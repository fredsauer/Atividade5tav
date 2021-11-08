//PROGRAMA REFATORADO POR FREDERICO LEITE SAUER EM ATIVIDADE PARA FAETERJ-RIO
package tav.Model.Loja;

import tav.Interfaces.Loja.*;

public class Pedido 
	{
	public int id;
	public int idCliente;
	public int idEntrega;
	public double valorTotal;
	public ICliente Cliente;
	public IFrete Frete;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getIdCliente() 
	{
		return idCliente;
	}
	public void setIdCliente(int idCliente) 
	{
		this.idCliente = idCliente;
	}
	public int getIdEntrega() 
	{
		return idEntrega;
	}
	public void setIdEntrega(int idEntrega) 
	{
		this.idEntrega = idEntrega;
	}
	public double getValorTotal() 
	{
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) 
	{
		this.valorTotal = valorTotal;
	}
	public ICliente getCliente() 
	{
		return Cliente;
	}
	public IFrete getFrete() 
	{
		return Frete;
	}
	
	public Pedido (int _id, int _cliente, int _idEntrega, double _valorTotal) 
	{
		id = _id;
		idCliente = _cliente;
		idEntrega = _idEntrega;
		valorTotal = _valorTotal;
	}
	
	public Pedido (int _id, int _idCliente, ICliente cliente, IFrete frete, int _idEntrega, double _valorTotal) 
	{
	id = _id;
        Cliente = cliente;
        idCliente = _idCliente;
        Frete = frete;
        idEntrega = _idEntrega;
        valorTotal = _valorTotal;
	}
	
	public Boolean ValidaEntrega(IEntrega entrega) 
	{
		if (entrega == null || idEntrega < 1)
        {
            return false;
        }
        return true;
	}
	
	public double CalcularFrete()
    {
		String pais = Cliente.getCountryById(idCliente);
        int cep = Cliente.getCepById(idCliente);
        
        double valorFrete = Frete.GetValorFrete(cep);
			switch (pais) {
				case "USA":
					return valorFrete * 2;
				case "CN":
					return valorFrete * 4;
				case "CL":
					return valorFrete + 3;
				case "ARG":
					return valorFrete + 5;
				default:
					return valorFrete;
			}
    }
}