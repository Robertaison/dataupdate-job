package com.dataprovider.datajob.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class TraceDataEntity {

  @Id
  private Integer id;

  private String cpf;
  private LocalDateTime updateAt;
}
