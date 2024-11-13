package people.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PromocionId;

    private String marca; //invento

    private double porc;

    private LocalDateTime fechaHasta;

    @ElementCollection
    @CollectionTable(
            name = "promocion_emails",
            joinColumns = @JoinColumn(name = "promocion_id")
    )
    private Set<String> emails = new HashSet<>();


}
