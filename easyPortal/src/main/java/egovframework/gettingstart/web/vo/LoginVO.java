package egovframework.gettingstart.web.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginVO implements Serializable {
    /** 사용자 ID */
    private String userId;
    /** 사용자 이름 */
    private String name;
   
    /**
     * userId attribute를 리턴한다.
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * uniqId attribute 값을 설정한다.
     * @param uniqId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * name attribute를 리턴한다.
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * name attribute 값을 설정한다.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}