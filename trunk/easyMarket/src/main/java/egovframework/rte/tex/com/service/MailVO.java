package egovframework.rte.tex.com.service;

import java.util.ArrayList;
import java.util.List;

public class MailVO {
	 /** 제목 */
    private String sj;
    
    /** 발송결과코드 */
    private boolean sndngResult;
    
    /** 메일내용 */
    private String emailCn;
    
    /** recptnPersons */
    private List<String> recptnPersons;

   /**
     * getSj
     *
     * @return
    */
    public String getSj() {
        return sj;
    }

    /**
     * setSj
     *
     * @param sj
    */
    public void setSj(String sj) {
        this.sj = sj;
    }

    /**
     * getSndngResultCode
     *
     * @return
    */
    public boolean getSndngResult() {
        return sndngResult;
    }

    /**
     * setSndngResultCode
     *
     * @param sndngResultCode
    */
    public void setSndngResult(boolean sndngResult) {
        this.sndngResult = sndngResult;
    }

    /**
     * getEmailCn
     *
     * @return
     * @see egovframework.mgt.cmm.ems.service.SndngMailVO#getEmailCn()
    */
    public String getEmailCn() {
        return emailCn;
    }

    public void setEmailCn(String emailCn) {
        this.emailCn = emailCn;
    }

    public List<String> getRecptnPersons() {
        return recptnPersons;
    }

    public void setRecptnPersons(List<String> recptnPersons) {
        this.recptnPersons = recptnPersons;
    }

    public void setRecptnPerson(String recptnPerson) {
        List<String> person = new ArrayList<String>();
        person.add(recptnPerson);
        setRecptnPersons(person);
    }
    
}
