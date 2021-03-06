package com.letscode.banco811.specification;

import com.letscode.banco811.criteria.SearchCriteria;
import com.letscode.banco811.model.Usuario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioSpecificationBuilder {

    private List<SearchCriteria> params;

    public UsuarioSpecificationBuilder with(String key, String operation, Object value) {
        params.add( new SearchCriteria(key, operation, value) );
        return this;
    }

    public UsuarioSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public Specification<Usuario> build() {
        if(params.size() == 0) return null;

        var specs = params.stream().map(UsuarioSpecification::new).collect(Collectors.toList());

        Specification result = specs.stream().findFirst().get();

        for (int i=1; i<params.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }

        return result;
    }
}
