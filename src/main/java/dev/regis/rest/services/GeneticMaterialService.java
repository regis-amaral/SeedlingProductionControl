package dev.regis.rest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.regis.rest.models.dtos.GeneticMaterialDTO;
import dev.regis.rest.models.entities.GeneticMaterial;
import dev.regis.rest.repositories.GeneticMaterialRepository;

@Service
public class GeneticMaterialService {
    
    @Autowired
	GeneticMaterialRepository geneticMaterialRepository;

	@Autowired
	ModelMapper mapper;

    public List<GeneticMaterialDTO> listAll() {
		// List<GeneticMaterial> lista = geneticMaterialRepository.findAll();
		
		// List<GeneticMaterialDTO> listaDTO = new ArrayList();

		// for (GeneticMaterial geneticMaterial : lista) {
		// 	GeneticMaterialDTO geneticMaterialDTO = mapper.map(geneticMaterial, GeneticMaterialDTO.class);
		// 	listaDTO.add(geneticMaterialDTO);
		// }

		List<GeneticMaterialDTO> geneticMaterialDTO = geneticMaterialRepository
			.findAll()
			.stream()
			.map(geneticMaterial -> mapper.map(geneticMaterial, GeneticMaterialDTO.class))
			.toList();

		return geneticMaterialDTO;
	}

	public GeneticMaterialDTO findById(Long id) {
		Optional<GeneticMaterial> optional = geneticMaterialRepository.findById(id);
		return null;
	}

	public void deleteById(Long id) {
		System.out.println("Deletou o material genético com id = " + id);
	}

	public List<GeneticMaterialDTO> search(String name) {
		System.out.println("Buscando o produto pelo nome");
		return List.of(new GeneticMaterialDTO("eucalyptus terrestrys"), new GeneticMaterialDTO("eucalyptus arboreo"), new GeneticMaterialDTO("pinheirus florensys"));
	}

	public GeneticMaterialDTO findByName(String name){
		return new GeneticMaterialDTO("eucalyptus terrestrys");
	}
}
