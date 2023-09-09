package dev.regis.rest.models.production.dtos;

import java.io.Serializable;
import java.util.List;

import dev.regis.rest.models.production.Batch;
import lombok.Data;

@Data
public class GeneticMaterialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private SpecieDTO specie;

    private List<Batch> listBatchs;

}
