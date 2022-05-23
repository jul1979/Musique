package webg5.g48982.spotify.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Track {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String title;
    @Positive(message = " Le nombre d’écoutes doit être positif")
    private Integer stream;

    @ManyToOne
    @JsonBackReference
    @ToString.Exclude
    @JoinColumn(name = "AUTHOR_LOGIN")
    private Artist artist;



}
