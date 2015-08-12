package fi.vincit.springboot.wordtohtml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  This controller provides the public API that is used to transform Word documents
 *  into HTML documents.
 */
@RestController
public class WordToHtmlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordToHtmlController.class);

    @RequestMapping(value = "/api/word-to-html", method = RequestMethod.POST)
    public String convertWordDocumentIntoHtmlDocument() {
        LOGGER.info("Converting word document into html document");
        return "<html><body>Hello World!</body></html>";
    }
}
