package com.mmtrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmtrip.model.Cliente;
import com.mmtrip.repositories.ClienteRepository;
import com.mmtrip.services.ClienteService;

@Service
public class ClienteImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente getClienteById(Long idCliente) {
		return clienteRepository.findById(idCliente).orElse(null);
	}

	@Override
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Long idCliente, Cliente clienteAtualizado) {
		Cliente clienteExistente = clienteRepository.findById(idCliente).orElse(null);
		if (clienteExistente != null) {
			clienteExistente.setNome(clienteAtualizado.getNome());
			clienteExistente.setSobrenome(clienteAtualizado.getSobrenome());
			clienteExistente.setDtNasc(clienteAtualizado.getDtNasc());
			clienteExistente.setSexo(clienteAtualizado.getSexo());
			clienteExistente.setEmail(clienteAtualizado.getEmail());
			clienteExistente.setUf(clienteAtualizado.getUf());
			clienteExistente.setCidade(clienteAtualizado.getCidade());
			clienteExistente.setEndereco(clienteAtualizado.getEndereco());
			clienteExistente.setSenha(clienteAtualizado.getSenha());

			return clienteRepository.save(clienteExistente);
		} else {
			throw new RuntimeException("Categoria com o ID" + idCliente + "não encontrada.");
		}

	}

	@Override
	public void deleteCliente(Long idCliente) {
		clienteRepository.deleteById(idCliente);

	}

}
