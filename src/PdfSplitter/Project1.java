package PdfSplitter;
//-- PDF SPLITTER--//
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.*;

public class Project1 {
    public static void main(String[] args) throws IOException {
        File oldFile= new File("C:/JAVA/CodeClause/src/PdfSplitter/sample.pdf");
        PDDocument document= PDdocument.load(oldFile);

        Splitter splitter= new Splitter();

        List<PDDocument> splitPages= splitter.split(document);

        int num=1;
        for(PDDocument mydoc: splitPages){
            mydoc.save("C:\\JAVA\\CodeClause\\src\\PdfSplitter\\Extract\\split_0"+num+".pdf");
            num++;
            mydoc.close();
        }
        System.out.println("Split Done!");

    }
}
