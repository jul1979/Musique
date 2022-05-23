package webg5.g48982.spotify.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webg5.g48982.spotify.model.Track;
import webg5.g48982.spotify.repository.TrackRepository;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public void upDateTrack(int idAsInt,int add) {
         Track track = trackRepository.findById(idAsInt).get();
         int total = track.getStream() + add;
        track.setStream(total);
        trackRepository.save(track);
    }
    public Integer findStreamById(Integer id) {
       return trackRepository.findById(id).get().getStream();
    }
}
