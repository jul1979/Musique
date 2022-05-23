package webg5.g48982.spotify.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webg5.g48982.spotify.business.ArtistService;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/artists")
    public String repos(Model model){
        model.addAttribute("artists",artistService.artistsInfo());
        return "artistView";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name ="login") String login, Model model){
        model.addAttribute("artists",artistService.tracksInfos(login));
        model.addAttribute("login",artistService.artistLogin(login));
        return "detailView";
    }


}
