package cl.luci.poc.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name = "message")
public class ResponseMessage {

    @XmlElement
    private String code;

    @XmlElement
    private String message;

    public ResponseMessage() {

    }

    public ResponseMessage(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
