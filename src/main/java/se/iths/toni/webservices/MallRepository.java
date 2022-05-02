package se.iths.toni.webservices;

import io.micronaut.core.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface MallRepository {
    
    @NonNull
    List<Mall> getList();
    
    void save(@NonNull @NotNull @Valid Mall mall);
}
