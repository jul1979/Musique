package webg5.g48982.spotify.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webg5.g48982.spotify.dto.ArtistDto;
import webg5.g48982.spotify.dto.TrackDto;
import webg5.g48982.spotify.dto.TrackInfoDto;
import webg5.g48982.spotify.model.Artist;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,String> {

   /* @Query("select distinct NEW webg5.g48982.spotify.dto.ArtistDto (a.name,a.tracks.size) from Artist a left join a.tracks s")
    List<ArtistDto> artistsInfo();*/

    @Query("select  NEW webg5.g48982.spotify.dto.ArtistDto (a.login,a.name,count (s.id)) from Artist a left join a.tracks s group by a.name")
    List<ArtistDto> artistsInfo();

    @Query("select NEW webg5.g48982.spotify.dto.TrackDto (s.id,s.title,s.stream,s.artist.name) from Artist a  join a.tracks s where s.stream>?1")
    List<TrackDto> popularTracks(Integer stream);


    @Query("select  NEW webg5.g48982.spotify.dto.TrackInfoDto(s.id,s.title,s.stream) from Artist a join a.tracks s where a.login=?1")
    List<TrackInfoDto> tracksInfos(String login);
}
