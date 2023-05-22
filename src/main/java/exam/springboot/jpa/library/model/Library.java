package exam.springboot.jpa.library.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="LIBRARY")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lbno;
    private String lbname;
    private String sido;
    private String gugun;
    private String lbtype;
    private String clsday;
    private String addr;
    private String phone;
    private String homepage;
    private Double lat;
    private Double lot;
    @CreatedDate
    @Column(insertable = false, updatable = false)
    private LocalDateTime regdate;

}
