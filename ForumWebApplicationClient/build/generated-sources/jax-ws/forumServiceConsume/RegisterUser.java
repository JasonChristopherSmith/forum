
package forumServiceConsume;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registerUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registerUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="register" type="{http://forumService/}registrationModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerUser", propOrder = {
    "register"
})
public class RegisterUser {

    protected RegistrationModel register;

    /**
     * Gets the value of the register property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationModel }
     *     
     */
    public RegistrationModel getRegister() {
        return register;
    }

    /**
     * Sets the value of the register property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationModel }
     *     
     */
    public void setRegister(RegistrationModel value) {
        this.register = value;
    }

}
