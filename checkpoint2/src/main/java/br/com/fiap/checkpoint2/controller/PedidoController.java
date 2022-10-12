package br.com.fiap.checkpoint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.dto.PedidoCreationDto;
import br.com.fiap.checkpoint2.dto.PedidoGetDto;
import br.com.fiap.checkpoint2.dto.PedidoIdDto;
import br.com.fiap.checkpoint2.dto.PedidoMapper;
import br.com.fiap.checkpoint2.dto.PedidoService;
import br.com.fiap.checkpoint2.model.Pedido;

@RestController
@RequestMapping("api/orders")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoMapper pedidoMapper;
	
	@DeleteMapping ("/{id}")
	public PedidoIdDto deletePedido(@PathVariable Long id) {
		pedidoService.delete(id);
		
		return new PedidoIdDto(id);
	}
	
	@PutMapping ("/{id}")
	public PedidoIdDto updatePedido(@PathVariable Long id ,@RequestBody PedidoCreationDto pedidoDto) {
		
		Pedido pedido = pedidoMapper.toPedido(pedidoDto);
		
		pedido.setId(id);
		
		Pedido editPedido = pedidoService.edit(pedido);
		
		return new PedidoIdDto(editPedido.getId());
	}
	
	@PostMapping
	public PedidoIdDto createPedido(@RequestBody PedidoCreationDto pedidoDto) {
		
		Pedido pedido = pedidoMapper.toPedido(pedidoDto);
		
		Pedido newPedido = pedidoService.add(pedido);
		
		return new PedidoIdDto(newPedido.getId());
	}
	
	
	@GetMapping
	public PedidoGetDto getPedido() {
		return pedidoService.get();
		
	}	
}
