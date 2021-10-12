package com.dataprovider.datajob.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class SensitiveDataEntity {

  @Id
  private Integer id;

  private String cpf;
  private LocalDateTime updateAt;
}
