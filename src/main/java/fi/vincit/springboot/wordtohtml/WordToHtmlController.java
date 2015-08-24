package fi.vincit.springboot.wordtohtml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *  This controller provides the public API that is used to transform Word documents
 *  into HTML documents.
 *
 *  @author Petri Kainulainen
 */
@RestController
final class WordToHtmlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordToHtmlController.class);

    private final WordToHtmlConverter converter;

    @Autowired
    public WordToHtmlController(WordToHtmlConverter converter) {
        this.converter = converter;
    }

    /**
     * Transforms the Word document into HTML document and returns the transformed document.
     *
     * @return  The content of the uploaded document as HTML.
     */
    @RequestMapping(value = "/api/word-to-html", method = RequestMethod.POST)
    public ConvertedDocumentDTO convertWordDocumentIntoHtmlDocument(@RequestParam(value = "file", required = true) MultipartFile wordDocument) {
        LOGGER.info("Converting word document into HTML document");

        ConvertedDocumentDTO htmlDocument = converter.convertWordDocumentIntoHtml(wordDocument);

        LOGGER.info("Converted word document into HTML document.");
        LOGGER.trace("The created HTML markup looks as follows: {}", htmlDocument);

        return htmlDocument;
    }
}
