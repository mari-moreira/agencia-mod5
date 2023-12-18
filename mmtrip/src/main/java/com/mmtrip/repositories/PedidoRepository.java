package com.mmtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmtrip.model.PedidoViagem;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoViagem, Long>{

}
