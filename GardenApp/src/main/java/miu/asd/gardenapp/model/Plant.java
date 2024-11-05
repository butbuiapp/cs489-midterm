package miu.asd.gardenapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String type;
    private LocalDate plantDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Garden garden;

    @Override
    public String toString() {
        return
                "ID: " + id +
                ", Name: " + name +
                ", Type: " + type +
                ", Plant Date: " + plantDate +
                ", Garden: " + garden.getName();
    }
}
