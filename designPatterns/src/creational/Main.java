package creational;

// Product
abstract class Document {
    public abstract void open();
}

// Concrete Products
class WordDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening a Word document.");
    }
}

class PdfDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}

class ExcelDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening an Excel document.");
    }
}

// Creator
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete Creators
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        DocumentFactory factory = new WordDocumentFactory();
        Document doc = factory.createDocument();
        doc.open();  // Output: Opening a Word document.
    }
}
