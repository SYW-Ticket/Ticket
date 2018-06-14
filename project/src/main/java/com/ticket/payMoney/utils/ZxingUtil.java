package com.ticket.payMoney.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shinelon on 2018/6/12.
 */
public class ZxingUtil {

    public static Boolean encode(String contents, String format, int width, int
            height, String saveImgFilePath) {
        Boolean bool = false;
        BufferedImage image = createImage(contents,width,height);
        if (image != null) {
            bool = writeToFile(image, format, saveImgFilePath);
        }
        return bool;
    }




    public static void encode(String contents, int width, int height) {
            createImage(contents, width, height);
        }



    public static BufferedImage createImage(String contents ,int width, int
            height) {
        BufferedImage bufImg=null;
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // ೰ਧᔿᲙᒵᕆ
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN, 10);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            // contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.QR_CODE, width, height, hints);

            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001,0xFFFFFFFF);
            bufImg = MatrixToImageWriter.toBufferedImage(bitMatrix, config);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufImg;
    }

    @SuppressWarnings("finally")
    public static Boolean writeToFile(BufferedImage bufImg, String format, String
            saveImgFilePath) {
        Boolean bool = false;
        try {
            bool = ImageIO.write(bufImg, format, new File(saveImgFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return bool;
        }
    }
}
