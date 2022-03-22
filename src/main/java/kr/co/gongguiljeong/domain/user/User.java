package kr.co.gongguiljeong.domain.user;

import kr.co.gongguiljeong.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCode;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userEmail;

    @Column
    private String userProfileImage;

    @Column(nullable = false)
    private String userNotification;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role userRole;

    @Builder
    public User(Long userCode, String userName, String userEmail, String userProfileImage, String userNotification, Role userRole) {
        this.userCode = userCode;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userProfileImage = userProfileImage;
        this.userNotification = userNotification;
        this.userRole = userRole;
    }

    public User update(String userName, String userProfileImage) {
        this.userName = userName;
        this.userProfileImage = userProfileImage;

        return this;
    }

    public String getRoleKey() {
        return this.userRole.getKey();
    }
}
