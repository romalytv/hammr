package proj.hammr.hammr.Auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    @Autowired
    AuctionRepository auctionRepository;

    
}
