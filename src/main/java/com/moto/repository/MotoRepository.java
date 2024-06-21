package com.moto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moto.models.Motocicleta;

@Repository
public interface MotoRepository extends JpaRepository<Motocicleta, Integer> {

   List<Motocicleta> findByUsuarioId(int id);
}
