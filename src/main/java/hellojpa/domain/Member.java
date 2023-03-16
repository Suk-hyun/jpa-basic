package hellojpa.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member") // 예제라서 이것 만든 거고, 사실 설계상 member 에 order 가 있을 이유가 딱히 없고
    // 이렇게 설계 한 것은 관심사를 적절히 끊어내지 못하고 잘 못 설계 한 것.
    private List<Order> orders = new ArrayList<>(); // 관례상 nullPointException 도 방지 하기 위해서 new ArrayList() 로 초기화.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

//    @Id
//    private Long id;
//
//    @Column(name = "name") // name = 필드와 매핑할 컬럼 명.
//    // nullable = false -> ddl 생성시 not null 제약조건 달아줌.
//    private String username;
//
//    private Integer age;
//
//    @Enumerated(EnumType.STRING) // default 가 ORDINAL 인데 절대 쓰면 안됨. 무조건 STRING 으로 써라.
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP) // db 에는 time, date, time&date == TIMESTAMP 나눠져 있어서 이렇게 지정을 해줘야 함.
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    // 위의 @Temporal 은 과거 버전 쓸 때만 쓰는 거고, 최신 버전 쓰면 밑에 LocalDate, LocalDateTime 쓰면 됨.
//    // 밑에 애들은 ddl 생성 위한 어노태이션 필요 없음.
//    private LocalDate testLocalDate; // 연월
//    private LocalDateTime testLocalDateTime; //연월일
//
//    @Transient // db 와 관계없이 메모리에서만 쓰고 싶은 필드는 이거 붙이면 됨. ddl-auto create 으로 해도 table 에 포함되지 않음.
//    private int tmp;
//
//    @Lob
//    private String description;

