package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent;

import android.content.Context;

import org.researchstack.backbone.model.ConsentDocument;
import org.researchstack.backbone.model.ConsentSection;
import org.researchstack.backbone.model.ConsentSignature;
import org.researchstack.backbone.utils.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jameskizer on 8/28/17.
 */

public class RSTBConsentDocument extends ConsentDocument implements Serializable {

    private String title;
    private List<ConsentSignature> signatures;
    private String signaturePageTitle;
    private String signaturePageContent;
    private String mobileStyleSheet;
    private String pdfStyleSheet;

    public RSTBConsentDocument(
            String title,
            List<ConsentSection> sections,
            List<ConsentSignature> signatures,
            String mobileStyleSheet,
            String pdfStyleSheet
    ) {
        super();
        this.setTitle(title);
        this.setSections(sections);

        this.signatures = new ArrayList<>();
        for (ConsentSignature signature: signatures) {
            this.addSignature(signature);
        }

        this.mobileStyleSheet = mobileStyleSheet;
        this.pdfStyleSheet = pdfStyleSheet;

    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignaturePageTitleText() {
        return signaturePageTitle;
    }

    public void setSignaturePageTitle(String signaturePageTitle) {
        this.signaturePageTitle = signaturePageTitle;
    }

    public String getSignaturePageContent() {
        return signaturePageContent;
    }

    public String getMobileStyleSheet() {
        return mobileStyleSheet;
    }

    public void setMobileStyleSheet(String mobileStyleSheet) {
        this.mobileStyleSheet = mobileStyleSheet;
    }

    public String getPdfStyleSheet() {
        return pdfStyleSheet;
    }

    public void setPdfStyleSheet(String pdfStyleSheet) {
        this.pdfStyleSheet = pdfStyleSheet;
    }

    @Override
    public void setSignaturePageContent(String signaturePageContent) {
        this.signaturePageContent = signaturePageContent;
    }

    public void addSignature(ConsentSignature signature)
    {
        signatures.add(signature);
    }

    public ConsentSignature getSignature(int location)
    {
        return signatures.get(location);
    }

    public void replaceSignature(ConsentSignature signature) {
        int foundIndex = -1;
        for (int i = 0; i<signatures.size(); i++) {
            ConsentSignature currentSignature = signatures.get(i);
            if (currentSignature.getIdentifier().equals(signature.getIdentifier())) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex >= 0) {
            signatures.set(foundIndex, signature);
        }
    }

    public String getMobileHTML(String title, String detail) {
        return getHTML(true, title, detail);
    }

    public String getHTMLForSection(ConsentSection section) {
        String title = TextUtils.isEmpty(section.getFormalTitle()) ?
                (TextUtils.isEmpty(section.getTitle()) ? "" : section.getTitle()):
                section.getFormalTitle();

        String content = !TextUtils.isEmpty(section.getHtmlContent()) ? section.getHtmlContent() : section.getEscapedContent();
        return String.format("<h4 style=\"text-align: center\">%1$s</h4><p style=\"text-align: center\">%2$s</p>", title, content);
    }

    //TODO: Fill this in!!
    public String getHTMLForSignature(ConsentSignature signature) {


        return "";

    }

    protected String getHTMLBody(boolean forMobile, String title, String detail) {
        StringBuilder docBuilder = new StringBuilder(
                "</br><div style=\"padding: 10px 10px 10px 10px;\" class='header'>");

        if (!TextUtils.isEmpty(title)) {
            docBuilder.append(String.format(
                    "<h1 style=\"text-align: center; font-family:sans-serif-light;\">%1$s</h1>",
                    title));
        }

        if (!TextUtils.isEmpty(detail)) {
            docBuilder.append(String.format("<p style=\"text-align: center\">%1$s</p>", detail));
        }

        docBuilder.append("</div></br>");
        if (!TextUtils.isEmpty(this.getHtmlReviewContent())) {
            docBuilder.append(this.getHtmlReviewContent());
        }
        else {

            docBuilder.append(String.format("<p style=\"text-align: center\">%1$s</p>", (!TextUtils.isEmpty(this.getTitle()) ? this.getTitle() : "")));

            for (ConsentSection section : getSections()) {
                docBuilder.append(this.getHTMLForSection(section));
            }

            if (!forMobile) {

                //page break
                String signaturePageTitle = !TextUtils.isEmpty(this.getSignaturePageTitleText()) ? this.getSignaturePageTitleText() : "";
                docBuilder.append(String.format("<h4 class \"pagebreak\" style=\"text-align: center\">%1$s</h4>", signaturePageTitle));

                String signaturePageContent = !TextUtils.isEmpty(this.getSignaturePageContent()) ? this.getSignaturePageContent() : "";
                docBuilder.append(String.format("<p style=\"text-align: center\">%1$s</p>", signaturePageContent));

                for (ConsentSignature signature : this.signatures) {
                    docBuilder.append(this.getHTMLForSignature(signature));
                }

            }

        }

        return docBuilder.toString();
    }

    public String getHTML(boolean forMobile, String title, String detail) {
        StringBuilder docBuilder = new StringBuilder("<html><head><style>");

        String styleSheet = forMobile ?
                (!TextUtils.isEmpty(this.getMobileStyleSheet()) ? this.getMobileStyleSheet() : "") :
                (!TextUtils.isEmpty(this.getPdfStyleSheet()) ? this.getPdfStyleSheet() : "");

        docBuilder.append(styleSheet);
        docBuilder.append("</style></head><body>");
        docBuilder.append(this.getHTMLBody(forMobile, title, detail));
        docBuilder.append("</body></html>");

        return docBuilder.toString();
    }

}
