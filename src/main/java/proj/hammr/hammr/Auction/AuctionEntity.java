package proj.hammr.hammr.Auction;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import proj.hammr.hammr.User.UserEntity;

@Entity
public class AuctionEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private String lotName;
    private String lotImageUrl;
    private long lotPrice;

    @ManyToMany
    @JoinTable(
        name = "auction_users",
        joinColumns = @JoinColumn(name = "auction_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> usersOnLot;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = true)
    private UserEntity creatorOfLot;

    public UUID getId() {
        return id;
    }

    public String getLotName() {
        return lotName;
    }

    public String getLotImageUrl() {
        return lotImageUrl;
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

    public void setLotImageUrl(String lotImageUrl) {
        this.lotImageUrl = lotImageUrl;
    }

    public void setLotPrice(long lotPrice){
        this.lotPrice = lotPrice;
    }

    public List<UserEntity> getUsersOnLot() {
        return usersOnLot;
    }

    public void setUsersOnLot(List<UserEntity> usersOnLot) {
        this.usersOnLot = usersOnLot;
    }

    public void setCreatorOfLot(UserEntity creatorOfLot) {
        this.creatorOfLot = creatorOfLot;
    }

    public UserEntity getCreatorOfLot() {
        return creatorOfLot;
    }
}
