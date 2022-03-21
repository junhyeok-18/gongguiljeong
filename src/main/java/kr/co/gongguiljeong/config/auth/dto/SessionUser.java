package kr.co.gongguiljeong.config.auth.dto;

import kr.co.gongguiljeong.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private Long userCode;
    private String userName;
    private String userEmail;
    private String userProfileImage;
    private String userNotification;

    public SessionUser(User user) {
        this.userCode = user.getUserCode();
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
        this.userProfileImage = user.getUserProfileImage();
        this.userNotification = user.getUserNotification();
    }
}
