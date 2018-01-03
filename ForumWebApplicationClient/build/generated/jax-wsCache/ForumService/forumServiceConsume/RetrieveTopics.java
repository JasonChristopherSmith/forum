
package forumServiceConsume;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retrieveTopics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retrieveTopics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="retrieveTopic" type="{http://forumService/}topicModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrieveTopics", propOrder = {
    "retrieveTopic"
})
public class RetrieveTopics {

    protected TopicModel retrieveTopic;

    /**
     * Gets the value of the retrieveTopic property.
     * 
     * @return
     *     possible object is
     *     {@link TopicModel }
     *     
     */
    public TopicModel getRetrieveTopic() {
        return retrieveTopic;
    }

    /**
     * Sets the value of the retrieveTopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopicModel }
     *     
     */
    public void setRetrieveTopic(TopicModel value) {
        this.retrieveTopic = value;
    }

}
