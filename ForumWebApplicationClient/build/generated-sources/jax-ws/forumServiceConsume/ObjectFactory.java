
package forumServiceConsume;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the forumServiceConsume package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginUserResponse_QNAME = new QName("http://forumService/", "loginUserResponse");
    private final static QName _LoginUser_QNAME = new QName("http://forumService/", "loginUser");
    private final static QName _RegisterUserResponse_QNAME = new QName("http://forumService/", "registerUserResponse");
    private final static QName _AddTopicResponse_QNAME = new QName("http://forumService/", "addTopicResponse");
    private final static QName _AddTopic_QNAME = new QName("http://forumService/", "addTopic");
    private final static QName _Hello_QNAME = new QName("http://forumService/", "hello");
    private final static QName _RetrieveTopics_QNAME = new QName("http://forumService/", "retrieveTopics");
    private final static QName _RegisterUser_QNAME = new QName("http://forumService/", "registerUser");
    private final static QName _HelloResponse_QNAME = new QName("http://forumService/", "helloResponse");
    private final static QName _RetrieveTopicsResponse_QNAME = new QName("http://forumService/", "retrieveTopicsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: forumServiceConsume
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveTopics }
     * 
     */
    public RetrieveTopics createRetrieveTopics() {
        return new RetrieveTopics();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link AddTopic }
     * 
     */
    public AddTopic createAddTopic() {
        return new AddTopic();
    }

    /**
     * Create an instance of {@link AddTopicResponse }
     * 
     */
    public AddTopicResponse createAddTopicResponse() {
        return new AddTopicResponse();
    }

    /**
     * Create an instance of {@link RetrieveTopicsResponse }
     * 
     */
    public RetrieveTopicsResponse createRetrieveTopicsResponse() {
        return new RetrieveTopicsResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link LoginUserResponse }
     * 
     */
    public LoginUserResponse createLoginUserResponse() {
        return new LoginUserResponse();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link LoginUser }
     * 
     */
    public LoginUser createLoginUser() {
        return new LoginUser();
    }

    /**
     * Create an instance of {@link TopicModel }
     * 
     */
    public TopicModel createTopicModel() {
        return new TopicModel();
    }

    /**
     * Create an instance of {@link LoginModel }
     * 
     */
    public LoginModel createLoginModel() {
        return new LoginModel();
    }

    /**
     * Create an instance of {@link RegistrationModel }
     * 
     */
    public RegistrationModel createRegistrationModel() {
        return new RegistrationModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "loginUserResponse")
    public JAXBElement<LoginUserResponse> createLoginUserResponse(LoginUserResponse value) {
        return new JAXBElement<LoginUserResponse>(_LoginUserResponse_QNAME, LoginUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "loginUser")
    public JAXBElement<LoginUser> createLoginUser(LoginUser value) {
        return new JAXBElement<LoginUser>(_LoginUser_QNAME, LoginUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "registerUserResponse")
    public JAXBElement<RegisterUserResponse> createRegisterUserResponse(RegisterUserResponse value) {
        return new JAXBElement<RegisterUserResponse>(_RegisterUserResponse_QNAME, RegisterUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTopicResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "addTopicResponse")
    public JAXBElement<AddTopicResponse> createAddTopicResponse(AddTopicResponse value) {
        return new JAXBElement<AddTopicResponse>(_AddTopicResponse_QNAME, AddTopicResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTopic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "addTopic")
    public JAXBElement<AddTopic> createAddTopic(AddTopic value) {
        return new JAXBElement<AddTopic>(_AddTopic_QNAME, AddTopic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveTopics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "retrieveTopics")
    public JAXBElement<RetrieveTopics> createRetrieveTopics(RetrieveTopics value) {
        return new JAXBElement<RetrieveTopics>(_RetrieveTopics_QNAME, RetrieveTopics.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "registerUser")
    public JAXBElement<RegisterUser> createRegisterUser(RegisterUser value) {
        return new JAXBElement<RegisterUser>(_RegisterUser_QNAME, RegisterUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveTopicsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forumService/", name = "retrieveTopicsResponse")
    public JAXBElement<RetrieveTopicsResponse> createRetrieveTopicsResponse(RetrieveTopicsResponse value) {
        return new JAXBElement<RetrieveTopicsResponse>(_RetrieveTopicsResponse_QNAME, RetrieveTopicsResponse.class, null, value);
    }

}
