package proj.hammr.hammr.Auction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public List<AuctionEntity> getAllAuctionEntitys() {
        return auctionRepository.findAll();
    }
    
    public void save(AuctionEntity auction) {
        auctionRepository.save(auction);
    }
    
    public AuctionEntity getByAuctionId(UUID id) {
        Optional<AuctionEntity> auctionById = auctionRepository.findById(id);
        AuctionEntity auction = null;

        if(auctionById.isPresent())
            auction = auctionById.get();
        else
            throw new RuntimeException(
                "No Auction with this id. Id = " + id + ". Check AuctionService");
    
        return auction;
    }

    

}
