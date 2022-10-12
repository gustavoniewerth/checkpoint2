package br.com.fiap.checkpoint2.command;

import java.util.List;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;


public class CommandList {
	
	private PedidoRepository repository;
	
	public CommandList(PedidoRepository repository) {
		this.repository = repository;
	}
	
	public List<Pedido> list() {
		return repository.findAll();
		}
	
	public Pedido create(Pedido pedido) {
		try {
			return repository.save(pedido);
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao salvar! Erro: " + e);
			return null;
		}
	}
	
	public String delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(Exception e) {
			return "Id do pedido nulo ou inválido! Erro: " + e;
		}
		
		return "Pedido " + id + " excluído com sucesso!";
	}

	public Pedido update(Long id, Pedido pedidoAlterado) {
		try {
			Pedido novoPedido = repository.getById(id);
			
			if (pedidoAlterado.getCodigoCliente() != null)
				novoPedido.setCodigoCliente(pedidoAlterado.getCodigoCliente());
			
			if (pedidoAlterado.getDataCadastro() != null)
				novoPedido.setDataCadastro(pedidoAlterado.getDataCadastro());
			
			if (pedidoAlterado.getDataPedido() != null)
				novoPedido.setDataPedido(pedidoAlterado.getDataPedido());
			
			if (pedidoAlterado.getValorTotal() != null)
				novoPedido.setValorTotal(pedidoAlterado.getValorTotal());
			
			return repository.save(novoPedido);
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao alterar! Erro: " + e);
			
			return null;
		}
	}
	
	

}
