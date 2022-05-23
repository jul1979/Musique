package webg5.g48982.spotify.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webg5.g48982.spotify.model.Track;

@Repository
public interface TrackRepository extends CrudRepository<Track,Integer> {
}
