package com.edugobeti.serralheria.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugobeti.serralheria.domain.Cliente;
import com.edugobeti.serralheria.domain.Pagamento;
import com.edugobeti.serralheria.domain.Pedido;
import com.edugobeti.serralheria.domain.dto.PedidoDTO;
import com.edugobeti.serralheria.domain.enuns.EstadoPagamento;
import com.edugobeti.serralheria.domain.enuns.FormaPagamento;
import com.edugobeti.serralheria.repository.ClienteRepository;
import com.edugobeti.serralheria.repository.PagamentoRepository;
import com.edugobeti.serralheria.repository.PedidoRepository;
import com.edugobeti.serralheria.service.exception.DataIntegrityException;
import com.edugobeti.serralheria.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Transactional(readOnly = true)
	public PedidoDTO buscar(Integer id) {
		Optional<Pedido> pedido = repo.findById(id);
		return new PedidoDTO(pedido.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado")));
	}
	
	@Transactional(readOnly = true)
	public List<PedidoDTO> listar(){
		List<Pedido> list = repo.findAll();
		return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public void salvar(PedidoDTO dto) {
		Pedido pedido = deDto(dto);
		pagamentoRepository.save(pedido.getPagamento());
		repo.save(pedido);	
	}
	
	public void deletar(Integer id) {
		buscar(id);
		try{
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cliente com pedidos associados não pode ser excluído");
		}
	}
	
	public Pedido deDto(PedidoDTO dto) {
		Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(() -> new ObjectNotFoundException("Cliente não cadastrado"));
		Pagamento pagto = new Pagamento();
		Pedido pedido = new Pedido();
		
		pedido.setId(dto.getId());
		pedido.setDataVenda(dto.getDataVenda());
		pedido.setDataInstalacao(dto.getDataInstalacao());
		pedido.setDesconto(dto.getDesconto());
		pedido.setQuantidade(dto.getQuantidade());
		pedido.setTotal(dto.getTotal());
		pedido.setEnderecoEntrega(dto.getEnderecoEntrega());
		pedido.setPortoes(dto.getPortoes());
		pedido.setCliente(cliente);
		pedido.setPagamento(pagto);
		pagto.setEstado(EstadoPagamento.paraEnum(dto.getEstadoPagamento()));
		pagto.setForma(FormaPagamento.paraEnum(dto.getFormaPagamento()));
		pagto.setPedido(pedido);
		return pedido;
	}
}
