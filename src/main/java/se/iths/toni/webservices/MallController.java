package se.iths.toni.webservices;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/malls")
@ExecuteOn(TaskExecutors.IO)
public class MallController {

    private final MallRepository mallRepository;

    public MallController(MallRepository mallRepository) {
        this.mallRepository = mallRepository;
    }

    @Get
    List<Mall> getList(){
        return mallRepository.getList();
    }

    @Post
    @Status(HttpStatus.CREATED)
    void save(@NonNull @NotNull @Valid Mall mall) {
        mallRepository.save(mall);
    }
}
