//////////////////////////////////////////////////////////////////////////
// Copyright (c) 2001-2018 Aspose Pty Ltd. All Rights Reserved.
//
// This file is part of Aspose.Words. The source code in this file
// is only intended as a supplement to the documentation, and is provided
// "as is", without warranty of any kind, either expressed or implied.
//////////////////////////////////////////////////////////////////////////

import org.testng.annotations.Test;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.HtmlFixedSaveOptions;
import com.aspose.words.HtmlFixedPageHorizontalAlignment;
import org.testng.Assert;
import com.aspose.words.ExportFontFormat;
import com.aspose.words.IResourceSavingCallback;
import com.aspose.words.ResourceSavingArgs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.Charset;

public class ExHtmlFixedSaveOptions extends ApiExampleBase
{
    @Test
    public void useEncoding() throws Exception
    {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.Encoding
        //ExSummary:Shows how to set encoding for exporting to HTML.
        Document doc = new Document();

        DocumentBuilder builder = new DocumentBuilder(doc);
        builder.writeln("Hello World!");

        // Encoding the document
        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setEncoding(Charset.forName("US-ASCII"));

        doc.save(getArtifactsDir() + "UseEncoding.html", htmlFixedSaveOptions);
        //ExEnd
    }

    //Note: Test doesn't contain validation result, because it's may take a lot of time for assert result
    //For validation result, you can save the document to HTML file and check out with notepad++, that file encoding will be correctly displayed (Encoding tab in Notepad++)
    @Test
    public void exportEmbeddedObjects() throws Exception
    {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedCss
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedFonts
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedImages
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedSvg
        //ExSummary:Shows how to export embedded objects into HTML file.
        Document doc = DocumentHelper.createDocumentFillWithDummyText();

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setEncoding(Charset.forName("US-ASCII"));
        htmlFixedSaveOptions.setExportEmbeddedCss(true);
        htmlFixedSaveOptions.setExportEmbeddedFonts(true);
        htmlFixedSaveOptions.setExportEmbeddedImages(true);
        htmlFixedSaveOptions.setExportEmbeddedSvg(true);

        doc.save(getArtifactsDir() + "ExportEmbeddedObjects.html", htmlFixedSaveOptions);
        //ExEnd
    }

    //Note: Test doesn't contain validation result, because it's may take a lot of time for assert result
    //For validation result, you can save the document to HTML file and check out with notepad++, that file encoding will be correctly displayed (Encoding tab in Notepad++)
    @Test
    public void encodingUsingNewEncoding() throws Exception
    {
        Document doc = DocumentHelper.createDocumentFillWithDummyText();

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setEncoding(Charset.forName("UTF-32"));

        doc.save(getArtifactsDir() + "EncodingUsingNewEncoding.html", htmlFixedSaveOptions);
    }

    //Note: Test doesn't contain validation result, because it's may take a lot of time for assert result
    //For validation result, you can save the document to HTML file and check out with notepad++, that file encoding will be correctly displayed (Encoding tab in Notepad++)
    @Test
    public void encodingUsingGetEncoding() throws Exception
    {
        Document doc = DocumentHelper.createDocumentFillWithDummyText();

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setEncoding(Charset.forName("UTF-16"));

        doc.save(getArtifactsDir() + "EncodingUsingGetEncoding.html", htmlFixedSaveOptions);
    }

    @Test
    public void exportFormFields() throws Exception
    {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.ExportFormFields
        //ExSummary:Show how to exporting form fields from a document into HTML file.
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        builder.insertCheckBox("CheckBox", false, 15);

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setExportFormFields(true);
        
        doc.save(getArtifactsDir() + "ExportFormFiels.html", htmlFixedSaveOptions);
        //ExEnd
    }

    @Test
    public void cssPrefix() throws Exception
        {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.CssClassNamesPrefix
        //ExSummary:Shows how to add prefix to all class names in css file.
        Document doc = new Document(getMyDir() + "Bookmark.doc");

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setCssClassNamesPrefix("test");

        doc.save(getArtifactsDir() + "cssPrefix_Out.html", htmlFixedSaveOptions);
        //ExEnd

        DocumentHelper.findTextInFile(getArtifactsDir() + "cssPrefix_Out" + File.separator +"styles.css", "test");
    }

    @Test
    public void horizontalAlignment() throws Exception
    {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.PageHorizontalAlignment
        //ExFor:HtmlFixedPageHorizontalAlignment
        //ExSummary:Shows how to set the horizontal alignment of pages in HTML file.
        Document doc = new Document(getMyDir() + "Bookmark.doc");

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setPageHorizontalAlignment(HtmlFixedPageHorizontalAlignment.LEFT);

        doc.save(getArtifactsDir() + "HtmlFixedPageHorizontalAlignment.html", htmlFixedSaveOptions);
        //ExEnd
    }

    @Test
    public void pageMarginsException() throws Exception
    {
        Document doc = new Document(getMyDir() + "Bookmark.doc");

        HtmlFixedSaveOptions saveOptions = new HtmlFixedSaveOptions();
        try
        {
            saveOptions.setPageMargins(-1);
        } catch (Exception e)
        {
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }

        doc.save(getArtifactsDir() + "HtmlFixedPageMargins.html", saveOptions);
        }

    @Test
    public void pageMargins() throws Exception
    {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.PageMargins
        //ExSummary:Shows how to set the margins around pages in HTML file.
        Document doc = new Document(getMyDir() + "Bookmark.doc");

        HtmlFixedSaveOptions saveOptions = new HtmlFixedSaveOptions();
        saveOptions.setPageMargins(10.0);

        doc.save(getArtifactsDir() + "HtmlFixedPageMargins.html", saveOptions);
        //ExEnd
    }

    @Test
    public void usingMachineFonts() throws Exception
    {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.UseTargetMachineFonts
        //ExSummary: Shows how used target machine fonts to display the document
        Document doc = new Document(getMyDir() + "Font.DisappearingBulletPoints.doc");

        HtmlFixedSaveOptions saveOptions = new HtmlFixedSaveOptions();
        saveOptions.setUseTargetMachineFonts(true);
        saveOptions.setFontFormat(ExportFontFormat.TTF);
        saveOptions.setExportEmbeddedFonts(false);
        saveOptions.setResourceSavingCallback(new ResourceSavingCallback());

        doc.save(getArtifactsDir() + "UseMachineFonts Out.html", saveOptions);
    }

    private static class ResourceSavingCallback implements IResourceSavingCallback
    {
        /**
         *  Called when Aspose.Words saves an external resource to fixed page HTML or SVG.
         */
        public void resourceSaving(ResourceSavingArgs args) throws Exception
        {
            args.setResourceStream(new ByteArrayOutputStream());
            args.setKeepResourceStreamOpen(true);

            String fileName = args.getResourceFileName();
            String extension =  fileName.substring(fileName.lastIndexOf("."));
            switch (extension)
            {
                case ".ttf":
                case ".woff":
                {
                    Assert.fail("'ResourceSavingCallback' is not fired for fonts when 'UseTargetMachineFonts' is true");
                    break;
                }
            }
        }
    }

    //ExEnd
}
