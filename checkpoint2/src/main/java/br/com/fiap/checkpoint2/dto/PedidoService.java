package br.com.fiap.checkpoint2.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void delete(Long id) {
			pedidoRepository.deleteById(id);
	}
	
	public Pedido add(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido edit(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public PedidoGetDto get() {
		return new PedidoGetDto(pedidoRepository.findAll());
	}
}
