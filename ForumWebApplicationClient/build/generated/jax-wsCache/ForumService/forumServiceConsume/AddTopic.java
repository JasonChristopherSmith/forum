
package forumServiceConsume;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addTopic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addTopic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="topic" type="{http://forumService/}topicModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addTopic", propOrder = {
    "topic"
})
public class AddTopic {

    protected TopicModel topic;

    /**
     * Gets the value of the topic property.
     * 
     * @return
     *     possible object is
     *     {@link TopicModel }
     *     
     */
    public TopicModel getTopic() {
        return topic;
    }

    /**
     * Sets the value of the topic property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopicModel }
     *     
     */
    public void setTopic(TopicModel value) {
        this.topic = value;
    }

}
