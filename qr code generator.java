import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGenerator {
    public static void main(String[] args) {
        // The data to be encoded as a QR code
        String data = "Hello, this is a QR code example!";

        // Path where the QR code image will be saved
        String filePath = "qrcode.png";

        // Encoding charset
        String charset = "UTF-8";

        // Create a QR code writer
        QRCodeWriter writer = new QRCodeWriter();

        // Set QR code parameters
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        try {
            // Generate a QR code
            BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 200, 200, hintMap);

            // Save the QR code as an image
            MatrixToImageWriter.writeToFile(bitMatrix, "PNG", new File(filePath));

            System.out.println("QR Code generated and saved as " + filePath);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
