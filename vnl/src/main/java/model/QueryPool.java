package model;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QueryPool {

    private static final Properties queries= new Properties();

    protected static String getQueryString(String queryId){
        if (queries.isEmpty()) {
            try (InputStream inputStream = readResourceFile()) {
                if (inputStream == null) {
                    throw new IllegalArgumentException("xml/query.xml is not found");
                }
                queries.loadFromXML(inputStream);
                if (queries.isEmpty()) {
                    System.out.println("Query non caricate dal file xml");
                } else {
            
                    System.out.println("Query caricate dal file xml");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return queries.getProperty(queryId);

    }

    private static InputStream readResourceFile() {
        String xmlFilePath = "query.xml";
        InputStream inputStream = QueryPool.class.getClassLoader().getResourceAsStream(xmlFilePath);

        if (inputStream == null) {
            System.out.println("File not found in classpath: " + xmlFilePath);
            throw new IllegalArgumentException(xmlFilePath + " is not found");
        }

        System.out.println("File found: " + xmlFilePath);
        return inputStream;
    }


}
