package webg5.g48982.spotify.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artist {



    @Id
    private String login;
    @NotBlank(message ="le nom ne peut être vide")
    private String name;


    @OneToMany(mappedBy="artist",fetch = FetchType.EAGER, cascade={CascadeType.PERSIST,
            CascadeType.REMOVE})
    @ToString.Exclude
    @JsonManagedReference
    private List<Track> tracks;
}
