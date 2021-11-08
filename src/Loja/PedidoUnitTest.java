//PROGRAMA REFATORADO POR FREDERICO LEITE SAUER EM ATIVIDADE PARA FAETERJ-RIO
package teste.Loja;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import tav.Interfaces.Loja.ICliente;
import tav.Interfaces.Loja.IEntrega;
import tav.Interfaces.Loja.IFrete;
import tav.Model.Loja.Cliente;
import tav.Model.Loja.Entrega;
import tav.Model.Loja.Frete;
import tav.Model.Loja.Pedido;

public class PedidoUnitTest {
	
	@Test
	public void ValidaEntregaIdZerado() {
		// Arrange
		Pedido pedido = new Pedido(1, 12, 0, 15.98);
		boolean esperado = false;
		IEntrega entrega = new Entrega();
		
		IEntrega mockEntrega = mock(IEntrega.class);
		
		
        when(mockEntrega.ValidaEntrega(entrega)).thenReturn(true);

        //ACT
        var resultado = pedido.ValidaEntrega(entrega);

        // Assert
        assertEquals(resultado, esperado);
	}
	
	@Test
	public void CalculaFreteTest1() {
		// Arrange
		ICliente mockCliente = mock(ICliente.class);
		Cliente cliente = new Cliente();
        
		cliente.idCliente = 4;
		cliente.endereco =  "Clarimundo de Melo 857";
		cliente.cep = 20123456;
		cliente.pais = "BR";
		
		int cep = 20123456;
		
		when(mockCliente.getCepById(3)).thenReturn(cliente.cep);
		
		IFrete mockFrete = mock(IFrete.class);
		Frete frete = new Frete ();
		
		frete.idFrete = 25;
		frete.cep = 20123456;
		frete.valorFrete = 7.26;		
		
		when(mockFrete.GetValorFrete(cep)).thenReturn(frete.valorFrete);
		when(mockCliente.getCountryById(3)).thenReturn(cliente.pais);

		
		double esperado = 7.26;
		
		// ACT
		Pedido pedido = new Pedido(1, 3, mockCliente, mockFrete, 5, 25.56);
        double resultado = pedido.CalcularFrete();
        
        // Assert
		assertEquals(resultado, esperado, 0.0);
	}
	
	@Test
	public void CalculaFreteTestCountry() {
		// Arrange
		ICliente mockCliente = mock(ICliente.class);
		Cliente cliente = new Cliente();
        
		cliente.idCliente = 3;
		cliente.endereco =  "New York - NY";
		cliente.cep = 1004;
		cliente.pais = "USA";
		
		int cep = 1004;
		
		when(mockCliente.getCepById(3)).thenReturn(cliente.cep);
		when(mockCliente.getCountryById(3)).thenReturn(cliente.pais);
		
		IFrete mockFrete = mock(IFrete.class);
		Frete frete = new Frete ();
		
		frete.idFrete = 25;
		frete.cep = 10004;
		frete.valorFrete = 7.26;
		
		double esperado = 7.26 * 2;
		
		when(mockFrete.GetValorFrete(cep)).thenReturn(frete.valorFrete);
		
		// ACT
		Pedido pedido = new Pedido(1, 3, mockCliente, mockFrete, 5, 25.56);
        double resultado = pedido.CalcularFrete();
        
        // Assert
		assertEquals(resultado, esperado, 0.0);
	}
	
	@Test
	public void CalculaFreteARG() {
		// Arrange
		ICliente mockCliente = mock(ICliente.class);
		Cliente cliente = new Cliente();
		
		cliente.idCliente = 4;
		cliente.endereco = "Buenos Aires";
		cliente.cep = 0000234;
		cliente.pais = "ARG";
		
		int cep = 0000234;
		
		when(mockCliente.getCepById(4)).thenReturn(cliente.cep);
		when(mockCliente.getCountryById(4)).thenReturn(cliente.pais);
		
		IFrete mockFrete = mock(IFrete.class);
		Frete frete = new Frete();
		
		frete.idFrete = 30;
		frete.cep = cep;
		frete.valorFrete = 8.00;
		
		double esperado = 13.00;
		
		when(mockFrete.GetValorFrete(cep)).thenReturn(frete.valorFrete);
		
		// ACT
		Pedido pedido = new Pedido(4, 4, mockCliente, mockFrete, 30, 13.00);
		
		double resultado = pedido.CalcularFrete();
		
		// Assert
		assertEquals(resultado, esperado, 0.0);
	}
}