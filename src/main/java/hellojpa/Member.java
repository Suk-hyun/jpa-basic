package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name") // name = 필드와 매핑할 컬럼 명.
    // nullable = false -> ddl 생성시 not null 제약조건 달아줌.
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // default 가 ORDINAL 인데 절대 쓰면 안됨. 무조건 STRING 으로 써라.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // db 에는 time, date, time&date == TIMESTAMP 나눠져 있어서 이렇게 지정을 해줘야 함.
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 위의 @Temporal 은 과거 버전 쓸 때만 쓰는 거고, 최신 버전 쓰면 밑에 LocalDate, LocalDateTime 쓰면 됨.
    // 밑에 애들은 ddl 생성 위한 어노태이션 필요 없음.
    private LocalDate testLocalDate; // 연월
    private LocalDateTime testLocalDateTime; //연월일

    @Transient // db 와 관계없이 메모리에서만 쓰고 싶은 필드는 이거 붙이면 됨. ddl-auto create 으로 해도 table 에 포함되지 않음.
    private int tmp;

    @Lob
    private String description;

}
