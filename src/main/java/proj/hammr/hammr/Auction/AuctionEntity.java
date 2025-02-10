package proj.hammr.hammr.Auction;

import java.awt.image.BufferedImage;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuctionEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private String lotName;
    private BufferedImage lotImage;
    private long lotPrice;

    public UUID getId() {
        return id;
    }

    public String getLotName() {
        return lotName;
    }

    public BufferedImage getLotImage() {
        return lotImage;
    }

    public long getLotPrice() {
        return lotPrice;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public void setLotImage(BufferedImage lotImage) {
        this.lotImage = lotImage;
    }

    public void setLotPrice(long lotPrice){
        this.lotPrice = lotPrice;
    }
}
