package webg5.g48982.spotify.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webg5.g48982.spotify.dto.ArtistDto;
import webg5.g48982.spotify.dto.TrackDto;
import webg5.g48982.spotify.dto.TrackInfoDto;
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


    public List<TrackInfoDto> tracksInfos(String login) {
        return artistRepository.tracksInfos(login);
    }

    public String artistLogin(String login) {
        return artistRepository.findById(login).get().getLogin();
    }
}
