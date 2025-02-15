package proj.hammr.hammr.Auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    // @RequestMapping(value = "home", method = RequestMethod.GET)
    // public String homeView(Model model) {
    //     model.addAttribute("allAuctionList", auctionService.getAllAuctionEntitys());
    //     return "home";
    // }

    @RequestMapping(value = "createauction", method = RequestMethod.GET)
    public String createAuction(Model model) {
        AuctionEntity auction = new AuctionEntity();
        model.addAttribute("auction", auction);
        return "createauction";
    }

    @RequestMapping(value = "saveauction", method = RequestMethod.POST)
    public String saveAuction(@ModelAttribute("auction") AuctionEntity auction) {
        auctionService.save(auction);
        return "redirect:/home";
    }
    
    

}
