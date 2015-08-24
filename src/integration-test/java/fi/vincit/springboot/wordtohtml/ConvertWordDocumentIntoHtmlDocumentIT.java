package fi.vincit.springboot.wordtohtml;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WordToHtmlApplication.class)
@WebAppConfiguration
public class ConvertWordDocumentIntoHtmlDocumentIT {

    private static final String FILENAME_HELLO_WORLD = "helloworld.docx";
    private static final String FILE_PATH_HELLO_WORLD = "/fi/vincit/springboot/wordtohtml/helloworld.docx";

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void convertWordDocumentIntoHtmlDocument_ShouldReturnResponseStatusOk() throws Exception {
        MockMultipartFile wordDocument = createMultipartFile(FILENAME_HELLO_WORLD, FILE_PATH_HELLO_WORLD);
        mockMvc.perform(fileUpload("/api/word-to-html")
                .file(wordDocument)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void convertWordDocumentIntoHtmlDocument_HelloWorldDocument_ShouldReturnJsonDocument() throws Exception {
        MockMultipartFile wordDocument = createMultipartFile(FILENAME_HELLO_WORLD, FILE_PATH_HELLO_WORLD);
        mockMvc.perform(fileUpload("/api/word-to-html")
                        .file(wordDocument)
        )
                .andExpect(content().contentType(WebTestConstants.APPLICATION_JSON_UTF8));
    }

    @Test
    public void convertWordDocumentIntoHtmlDocument_HelloWorldDocument_ShouldReturnFilenameOfUploadedWordDocument() throws Exception {
        MockMultipartFile wordDocument = createMultipartFile(FILENAME_HELLO_WORLD, FILE_PATH_HELLO_WORLD);
        mockMvc.perform(fileUpload("/api/word-to-html")
                        .file(wordDocument)
        )
                .andExpect(jsonPath("$.filename", is(FILENAME_HELLO_WORLD)));
    }

    private MockMultipartFile createMultipartFile(String fileName, String filePath) throws IOException {
        InputStream in = this.getClass().getResourceAsStream(filePath);
        return new MockMultipartFile(WebTestConstants.REQUEST_PARAM_NAME_FILE,
                fileName,
                "",
                in
        );
    }
}
