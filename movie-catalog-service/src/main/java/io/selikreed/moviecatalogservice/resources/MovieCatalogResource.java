package io.selikreed.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import io.selikreed.model.CatalogItem;

@RestController
public class MovieCatalogResource {
    
    public List<CatalogItem> getCatalog(String userId) {
        return Collections.singletonList(
            new CatalogItem("Transformers", "Test", 4)
        );
    }
}
