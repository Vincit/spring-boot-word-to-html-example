package fi.vincit.springboot.wordtohtml;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

/**
 *  This is a non instantiable constant class. This class declares the
 *  constants that are used to write both unit and integration tests
 *  to Spring MVC controllers.
 */
final class WebTestConstants {

    static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );

    static String REQUEST_PARAM_NAME_FILE = "file";

    private WebTestConstants() {}
}
