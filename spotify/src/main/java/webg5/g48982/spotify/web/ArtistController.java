package webg5.g48982.spotify.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webg5.g48982.spotify.business.ArtistService;
import webg5.g48982.spotify.business.TrackService;
import webg5.g48982.spotify.model.Track;

import javax.validation.Valid;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private TrackService trackService;

    @GetMapping("/artists")
    public String repos(Model model){
        model.addAttribute("artists",artistService.artistsInfo());

        return "artistView";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name ="login") String login, Model model){
        model.addAttribute("artists",artistService.tracksInfos(login));
        model.addAttribute("login",artistService.artistLogin(login));
        model.addAttribute("track",new Track());
        return "detailView";
    }

    @PostMapping("/updateSong")
    public String update(@RequestParam(name ="id") String id,
                         @RequestParam(name ="login") String login,
                         @RequestParam(name ="title") String title,
                         @Valid @ModelAttribute (name = "track")Track track,
                         Errors errors,
                         Model model){
        int idAsInt = Integer.parseInt(id);
        track.setTitle(title);
        //trackService.findStreamById(idAsInt)
        //track.setStream(trackService.findStreamById(idAsInt));
        if(errors.hasErrors()){
           // model.addAttribute("artists",artistService.tracksInfos(id));
            //model.addAttribute("login",artistService.artistLogin(id));
            return "detail";
        }
        trackService.upDateTrack(idAsInt,track.getStream());
        return  detail(login,model);

    }



}
