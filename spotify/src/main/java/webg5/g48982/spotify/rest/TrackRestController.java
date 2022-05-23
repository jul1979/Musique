package webg5.g48982.spotify.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webg5.g48982.spotify.business.ArtistService;
import webg5.g48982.spotify.dto.TrackDto;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TrackRestController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/tracks/{stream}")
    public ResponseEntity<List<TrackDto>> allStudents (@PathVariable(name="stream") Integer stream) {
        return new ResponseEntity<>(artistService.popularTracks(stream), HttpStatus.OK);
    }




}
