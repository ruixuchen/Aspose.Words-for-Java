package com.aspose.words.examples.linq;
import com.aspose.words.*;
import com.aspose.words.examples.Utils;
import  java.util.*;
public class MulticoloredNumberedList {
    /**
     * The main entry point for the application.
     */
    public static void main(String[] args) throws Exception {
        //ExStart:MulticoloredNumberedList
		// The path to the documents directory.
        String dataDir = Utils.getDataDir(MulticoloredNumberedList.class);
        String fileName = "MulticoloredNumberedList.doc";
        // Load the template document.
        Document doc = new Document(dataDir + fileName);

        // Create a Reporting Engine.
        ReportingEngine engine = new ReportingEngine();

        // Execute the build report.
        engine.buildReport(doc, Common.GetClients());

        dataDir = dataDir + Utils.GetOutputFilePath(fileName);

        // Save the finished document to disk.
        doc.save(dataDir);
		//ExEnd:MulticoloredNumberedList

        System.out.println("\nMulticolored numbered list template document is populated with the data about clients.\nFile saved at " + dataDir);
    }
}
