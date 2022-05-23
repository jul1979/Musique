package webg5.g48982.spotify.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webg5.g48982.spotify.dto.ArtistDto;
import webg5.g48982.spotify.dto.TrackDto;
import webg5.g48982.spotify.repository.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<ArtistDto> artistsInfo(){
        return artistRepository.artistsInfo();
    }

     public  List<TrackDto> popularTracks(Integer stream){
         return artistRepository.popularTracks(stream);

     }


}
