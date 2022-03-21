package kr.co.gongguiljeong.config.auth.dto;

import kr.co.gongguiljeong.domain.user.Role;
import kr.co.gongguiljeong.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userName;
    private String userEmail;
    private String userProfileImage;
    private String userNotification;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String userName, String userEmail, String userProfileImage, String userNotification) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userProfileImage = userProfileImage;
        this.userNotification = userNotification;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }

        if("kakao".equals(registrationId)){
            return ofKakao("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .userName((String) attributes.get("name"))
                .userEmail((String) attributes.get("email"))
                .userProfileImage((String) attributes.get(""))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .userName((String) response.get("name"))
                .userEmail((String) response.get("email"))
                .userProfileImage((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        // kakao는 kakao_account에 유저정보가 있다. (email)
        Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        // kakao_account안에 또 profile이라는 JSON객체가 있다. (nickname, profile_image)
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        return OAuthAttributes.builder()
                .userName((String) kakaoProfile.get("nickname"))
                .userEmail((String) kakaoAccount.get("email"))
                .userProfileImage((String) kakaoProfile.get("profile_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userProfileImage(userProfileImage)
                .userNotification(userNotification)
                .userRole(Role.USER)
                .build();
    }
}