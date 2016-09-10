@Grab('org.eclipse.jetty.aggregate:jetty-all:9.2.6.v20141205')
@Grab('com.sun.jersey:jersey-server:1.18.3')
@Grab('com.sun.jersey:jersey-servlet:1.18.3')
@Grab('com.sun.jersey:jersey-core:1.18.3')
@Grab('com.sun.jersey:jersey-json:1.18.3')

import com.sun.jersey.spi.container.servlet.ServletContainer

import org.eclipse.jetty.server.handler.ContextHandler
import org.eclipse.jetty.server.handler.HandlerList
import org.eclipse.jetty.server.handler.ResourceHandler
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.eclipse.jetty.server.Server


/** */
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

//TODO����s�v�ł́H��
import HelloResultDto

@Path("/")
class HelloResource {

    @GET
    @Path("/hello")
    String getHello() {
        return "hello!"
    }

    @GET
    @Path("/helloJson")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloResultDto helloJson() {
        HelloResultDto dto = new HelloResultDto()
        dto.name1 = "AAA"
        dto.name2 = "BBB"
        dto.name3 = "CCC"
        dto.name4 = "DDD"
        return dto
    }

    @GET
    @Path("/helloJson2")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloResultDto helloJson2() {
        return new HelloResultDto("AAA", "BBB", "CCC", "DDD")
    }

    // JSON�̃��X�g��Ԃ�
    @GET
    @Path("/helloJsonList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HelloResultDto> helloJsonList() {
        def jsonList = new ArrayList()
        jsonList.add( new HelloResultDto("AAA", "BBB", "CCC", "DDD") )
        jsonList.add( new HelloResultDto("EEE", "FFF", "GGG", "HHH") )
        return jsonList
    }

    @GET
    @Path("/error")
    String getError() {
        throw new HelloException()
    }

    @GET
    @Path("/error2")
    String getError2() {
        throw new HelloException("P", "O", "I", "!")
    }
}

/** */
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class HelloResultDto {
    String name1
    String name2
    String name3
    String name4

    //�����Ȃ��ł�new�ł���悤�ɂ���
    HelloResultDto() {
    }

    HelloResultDto(name1, name2, name3, name4) {
        this.name1 = name1
        this.name2 = name2
        this.name3 = name3
        this.name4 = name4
    }
}

/** */
import javax.ws.rs.core.Response
import javax.ws.rs.core.Response.ResponseBuilder
import javax.ws.rs.core.Response.Status
import javax.ws.rs.WebApplicationException

class HelloException extends WebApplicationException {
    HelloException() {
        //�X�e�[�^�X404������
        super(Response
            .status(Status.NOT_FOUND)
            .build()
        )
    }

    HelloException(name1, name2, name3, name4) {
        super(Response
            //�X�e�[�^�X400������
            .status(Status.BAD_REQUEST)
            .entity(new HelloResultDto(name1, name2, name3, name4))
            //JSON�Ƃ��ĕԂ�
            .type("application/json")
            .build()
        )
    }
}


/*----- jersey -----*/
//JAX-RS��resource�Aprovider�Ɋ܂߂�N���X���w��
def ResourceClass = [
    HelloResource.class,
]
def servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
def servletHolder = new ServletHolder(ServletContainer.class);

//�T�[�u���b�g�Ƃ��ē��삳����N���X�����w��i"HogeClass;FugaClass;�c"�̌`�j
servletHolder.setInitParameters([
    "com.sun.jersey.config.property.resourceConfigClass": "com.sun.jersey.api.core.ClassNamesResourceConfig",
    "com.sun.jersey.config.property.classnames": ResourceClass.collect{it.getName()}.join(";"),
    "com.sun.jersey.api.json.POJOMappingFeature": "true"
])
servletContext.setContextPath("/api")        //URL�ݒ�
servletContext.addServlet(servletHolder, "/*")

/*----- �T�[�o�N�� -----*/
def server = new Server(18888);               //�|�[�g�ݒ�
//�R���e�L�X�g��`���T�[�o�Ƀn���h��
def handlerList = new HandlerList()
handlerList.setHandlers(servletContext)
server.setHandler(handlerList)

println "API�T�[�o�[���N�����܂�"
server.start()                               //�T�[�o�N��

/*----- �I���� -----*/
addShutdownHook {
  println "API�T�[�o�[���~���܂�"
  server.stop()
}