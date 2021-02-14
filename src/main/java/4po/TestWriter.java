package objectivetester;

/**
 *
 * @author Steve
 */
class TestWriter extends DefaultWriter {

    TestWriter(UserInterface ui) {
        this.n = 0;
        this.ui = ui;
    }

    @Override
    void writeHeader() {

        ui.addCode("import static io.restassured.RestAssured.given;\n"
                + "import static org.hamcrest.Matchers.equalTo;\n"
                + "import org.junit.After;\n"
                + "import org.junit.AfterClass;\n"
                + "import org.junit.Before;\n"
                + "import org.junit.BeforeClass;\n"
                + "import org.junit.Test;\n"
                + "import static org.junit.Assert.*;\n"
                + ""
                + "\n"
                + "public class RecordedTest {\n"
                + "\n"
                + "    public RecordedTest() {\n"
                + "    }\n"
                + "\n"
                + "    @BeforeClass\n"
                + "    public static void setUpClass() {\n"
                + "    }\n"
                + "\n"
                + "    @AfterClass\n"
                + "    public static void tearDownClass() {\n"
                + "    }\n"
                + "\n"
                + "    @Before\n"
                + "    public void setUp() {\n"
                + "    }\n"
                + "\n"
                + "    @After\n"
                + "    public void tearDown() {\n"
                + "    }\n"
                + "\n}");
        footer = 2; //lines from the insert point to the bottom
    }
}
