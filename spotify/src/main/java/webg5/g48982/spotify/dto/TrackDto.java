package webg5.g48982.spotify.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrackDto {

    private Integer id;
    private String title;
    private Integer stream;
    private String name;
}
