package com.dataprovider.datajob.repository;

import com.dataprovider.datajob.model.SensitiveDataUpdateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensitiveDataRepository extends JpaRepository<SensitiveDataUpdateEntity, Integer> {

  Optional<SensitiveDataUpdateEntity> findByCpf(String cpf);
}
