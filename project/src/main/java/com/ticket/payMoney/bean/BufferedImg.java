package com.ticket.payMoney.bean;


import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by Shinelon on 2018/6/13.
 */
public class BufferedImg extends BufferedImage implements Serializable{

    public BufferedImg(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    public BufferedImg(int width, int height, int imageType, IndexColorModel cm) {
        super(width, height, imageType, cm);
    }

    public BufferedImg(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
        super(cm, raster, isRasterPremultiplied, properties);
    }
}
