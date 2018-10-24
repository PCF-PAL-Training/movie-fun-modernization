package org.superbiz.moviefun.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumsRepository albumsRepository;


    public AlbumsController(AlbumsRepository albumsBean) {
        this.albumsRepository = albumsBean;

    }

    @GetMapping
    public List<Album> getAlbums() {
        return albumsRepository.getAlbums();
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<Album> details(@PathVariable long albumId) {
        Album album = albumsRepository.find(albumId);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
    }


}
