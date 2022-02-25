package com.romario.aulao.service;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romario.aulao.domain.ItemPedido;
import com.romario.aulao.domain.PagamentoComBoleto;
import com.romario.aulao.domain.Pedido;
import com.romario.aulao.domain.enums.EstadoPagamento;
import com.romario.aulao.repositories.ItemPedidoRepository;
import com.romario.aulao.repositories.PagamentoRepository;
import com.romario.aulao.repositories.PedidoReposirory;
import com.romario.aulao.repositories.ProdutoRepository;
import com.romario.aulao.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoReposirory repo;
	@Autowired
	private BoletoService boletoService;
	@Autowired 
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ProdutoRepository produtoReposirory;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ClienteService clienteService;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Pedido.class.getName() ));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());

		return obj;
	}
	
}
