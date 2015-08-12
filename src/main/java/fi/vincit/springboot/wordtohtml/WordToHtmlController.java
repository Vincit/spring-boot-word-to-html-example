package fi.vincit.springboot.wordtohtml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  This controller provides the public API that is used to transform Word documents
 *  into HTML documents.
 *
 *  @author Petri Kainulainen
 */
@RestController
public class WordToHtmlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordToHtmlController.class);

    /**
     * Transforms the Word document into HTML document and returns the transformed document.
     *
     * @return  The content of the uploaded document as HTML.
     */
    @RequestMapping(value = "/api/word-to-html", method = RequestMethod.POST)
    public String convertWordDocumentIntoHtmlDocument() {
        LOGGER.info("Converting word document into html document");
        return "<html><body>Hello World!</body></html>";
    }
}
