/*
 *  Copyright (C) 2010-2014 JPEXS
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jpexs.decompiler.flash.exporters.shape;

import com.jpexs.decompiler.flash.SWF;
import com.jpexs.decompiler.flash.exporters.commonshape.Matrix;
import com.jpexs.decompiler.flash.exporters.commonshape.Point;
import com.jpexs.decompiler.flash.tags.Tag;
import com.jpexs.decompiler.flash.tags.base.ImageTag;
import com.jpexs.decompiler.flash.types.ColorTransform;
import com.jpexs.decompiler.flash.types.FILLSTYLE;
import com.jpexs.decompiler.flash.types.GRADIENT;
import com.jpexs.decompiler.flash.types.GRADRECORD;
import com.jpexs.decompiler.flash.types.LINESTYLE2;
import com.jpexs.decompiler.flash.types.RECT;
import com.jpexs.decompiler.flash.types.RGB;
import com.jpexs.decompiler.flash.types.RGBA;
import com.jpexs.decompiler.flash.types.SHAPE;
import com.jpexs.helpers.Helper;
import com.jpexs.helpers.SerializableImage;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author JPEXS
 */
public class CanvasShapeExporter extends ShapeExporterBase {

    protected String pathData = "";
    protected String shapeData = "";
    protected String html = "";
    protected String strokeData = "";
    protected String fillData = "";
    protected double deltaX = 0;
    protected double deltaY = 0;
    protected Matrix fillMatrix = null;
    protected String lastRadColor = null;
    protected SWF swf;
    protected int repeatCnt = 0;
    protected double unitDivisor;
    protected RGB basicFill;

    
    public static String getJsPrefix(){
         return "var c=document.getElementById(\"myCanvas\");\r\n"
                + "var ctx=c.getContext(\"2d\");\r\n";
    }
    
    public static String getHtmlPrefix(int width,int height) {
        return "<!DOCTYPE html>\r\n"
                + "<html>\r\n"
                + "<body>\r\n"
                + "\r\n"
                + "<canvas id=\"myCanvas\" width=\"" + width + "\" height=\"" + height + "\" style=\"border:1px solid #c3c3c3;\">\r\n"
                + "Your browser does not support the HTML5 canvas tag.\r\n"
                + "</canvas>\r\n"
                + "\r\n"
                + "<script>\r\n";                
               
    }
    
    public static String getHtmlSuffix(){
        return  "\r\n"
                + "</script>\r\n"
                + "</body>\r\n"
                + "</html>";
    }
    public String getHtml() {
        RECT r = shape.getBounds();
        int width = (int) (r.getWidth() / unitDivisor);
        int height = (int) (r.getHeight() / unitDivisor);
        
        return getHtmlPrefix(width, height)+getJsPrefix()+shapeData+getHtmlSuffix();
    }

    public String getShapeData() {
        return shapeData;
    }
    
    

    public CanvasShapeExporter(RGB basicFill,double unitDivisor,SWF swf, SHAPE shape, ColorTransform colorTransform, int deltaX, int deltaY) {
        super(shape, colorTransform);        
        this.swf = swf;
        this.unitDivisor = unitDivisor;
        this.basicFill = basicFill;
    }

    @Override
    public void beginShape() {
        shapeData = "";
    }

    @Override
    public void endShape() {
    }

    @Override
    public void beginFills() {
    }

    @Override
    public void endFills() {
    }

    @Override
    public void beginLines() {
    }

    @Override
    public void endLines() {
        finalizePath();
    }

    @Override
    public void beginFill(RGB color) {
        finalizePath();
        if(color == null){
            color  = basicFill;
        }
        fillData += "ctx.fillStyle=\"" + color(color) + "\";\r\n";        
    }

    @Override
    public void beginGradientFill(int type, GRADRECORD[] gradientRecords, Matrix matrix, int spreadMethod, int interpolationMethod, float focalPointRatio) {
        finalizePath();

        //TODO: How many repeats is ideal?        
        final int REPEAT_CNT = 5;

        repeatCnt = spreadMethod == GRADIENT.SPREAD_PAD_MODE ? 0 : REPEAT_CNT;

        if (type == FILLSTYLE.LINEAR_GRADIENT) {
            Point start = matrix.transform(new Point(-16384 - 32768 * repeatCnt, 0));
            Point end = matrix.transform(new Point(16384 + 32768 * repeatCnt, 0));
            start.x += deltaX;
            start.y += deltaY;
            end.x += deltaX;
            end.y += deltaY;
            fillData += "var grd=ctx.createLinearGradient(" + Double.toString(start.x / unitDivisor) + "," + Double.toString(start.y / unitDivisor) + "," + Double.toString(end.x / unitDivisor) + "," + Double.toString(end.y / unitDivisor) + ");\r\n";
        } else {
            matrix.translateX /= unitDivisor;
            matrix.translateY /= unitDivisor;
            matrix.scaleX /= unitDivisor;
            matrix.scaleY /= unitDivisor;
            matrix.rotateSkew0 /= unitDivisor;
            matrix.rotateSkew1 /= unitDivisor;
            fillMatrix = matrix;

            matrix.translateX += deltaX / unitDivisor;
            matrix.translateY += deltaY / unitDivisor;

            //TODO: Focal point
            
            fillData += "var grd=ctx.createRadialGradient(0,0,0,0,0," + (16384 + 32768 * repeatCnt) + ");\r\n";
        }
        int repeatTotal = repeatCnt * 2 + 1;
        double oneHeight = 1.0 / repeatTotal;
        double pos = 0;
        boolean revert = false;
        if (type != FILLSTYLE.LINEAR_GRADIENT && spreadMethod == GRADIENT.SPREAD_REFLECT_MODE) {
            revert = true;
        }
        for (int i = 0; i < repeatTotal; i++) {
            if (spreadMethod == GRADIENT.SPREAD_REFLECT_MODE) {
                revert = !revert;
            }
            for (GRADRECORD r : gradientRecords) {
                fillData += "grd.addColorStop(" + Double.toString(pos + (oneHeight * (revert ? 255 - r.ratio : r.ratio) / 255.0)) + ",\"" + color(r.color) + "\");\r\n";
                lastRadColor = color(r.color);
            }
            pos += oneHeight;
        }
        fillData += "ctx.fillStyle = grd;\r\n";
    }

    public static String color(Color color) {
        return color(new RGBA(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha()));
    }
    
    public static String color(RGB rgb) {
        if ((rgb instanceof RGBA)&&(((RGBA) rgb).alpha<255)) {
            RGBA rgba = (RGBA) rgb;
            return "rgba(" + rgba.red + "," + rgba.green + "," + rgba.blue + "," + rgba.getAlphaFloat() + ")";
        } else {
            return rgb.toHexRGB();
        }

    }

    @Override
    public void beginBitmapFill(int bitmapId, Matrix matrix, boolean repeat, boolean smooth, ColorTransform colorTransform) {
        finalizePath();
        ImageTag image = null;
        for (Tag t : swf.tags) {
            if (t instanceof ImageTag) {
                ImageTag i = (ImageTag) t;
                if (i.getCharacterId() == bitmapId) {
                    image = i;
                    break;
                }
            }
        }
        if (image != null) {
            SerializableImage img = image.getImage();
            if (img != null) {
                colorTransform.apply(img);
                String format = image.getImageFormat();
                InputStream imageStream = image.getImageData();
                byte[] imageData;
                if (imageStream != null) {
                    imageData = Helper.readStream(image.getImageData());
                } else {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    try {
                        ImageIO.write(img.getBufferedImage(), format.toUpperCase(Locale.ENGLISH), baos);
                    } catch (IOException ex) {
                    }
                    imageData = baos.toByteArray();
                }
                String base64ImgData = DatatypeConverter.printBase64Binary(imageData);
                if (matrix != null) {
                    matrix.translateX /= unitDivisor;
                    matrix.translateY /= unitDivisor;
                    matrix.scaleX /= unitDivisor;
                    matrix.scaleY /= unitDivisor;
                    matrix.rotateSkew0 /= unitDivisor;
                    matrix.rotateSkew1 /= unitDivisor;
                    fillMatrix = matrix;

                }

                fillData += "var img = document.createElement(\"img\"); img.src=\"data:image/" + format + ";base64," + base64ImgData + "\";\r\n";
                fillData += "var pat=ctx.createPattern(img,\"repeat\");\r\n";
                fillData += "ctx.fillStyle = pat;\r\n";
            }
        }
    }

    @Override
    public void endFill() {
        finalizePath();
    }

    @Override
    public void lineStyle(double thickness, RGB color, boolean pixelHinting, String scaleMode, int startCaps, int endCaps, int joints, int miterLimit) {
        finalizePath();
        thickness /= unitDivisor;

        strokeData += "ctx.strokeStyle=\"" + color(color) + "\";\r\n";
        strokeData += "ctx.lineWidth=" + Double.toString(thickness == 0 ? 1 : thickness) + ";\r\n";
        switch (startCaps) {
            case LINESTYLE2.NO_CAP:
                strokeData += "ctx.lineCap=\"butt\";\r\n";
                break;
            case LINESTYLE2.SQUARE_CAP:
                strokeData += "ctx.lineCap=\"square\";\r\n";
                break;
            default:
                strokeData += "ctx.lineCap=\"round\";\r\n";
                break;
        }
        switch (joints) {
            case LINESTYLE2.BEVEL_JOIN:
                strokeData += "ctx.lineJoin=\"bevel\";\r\n";
                break;
            case LINESTYLE2.ROUND_JOIN:
                strokeData += "ctx.lineJoin=\"round\";\r\n";
                break;
            default:
                strokeData += "ctx.lineJoin=\"miter\";\r\n";
                strokeData += "ctx.miterLimit=" + Integer.toString(miterLimit) + ";\r\n";
                break;
        }
    }

    @Override
    public void lineGradientStyle(int type, GRADRECORD[] gradientRecords, Matrix matrix, int spreadMethod, int interpolationMethod, float focalPointRatio) {
        //TODO
    }

    @Override
    public void moveTo(double x, double y) {
        x += deltaX;
        y += deltaY;
        pathData += "ctx.moveTo("
                + (x / unitDivisor) + ","
                + (y / unitDivisor) + ");\r\n";
    }

    @Override
    public void lineTo(double x, double y) {
        x += deltaX;
        y += deltaY;
        pathData += "ctx.lineTo(" + (x / unitDivisor) + ","
                + (y / unitDivisor) + ");\r\n";
    }

    @Override
    public void curveTo(double controlX, double controlY, double anchorX, double anchorY) {
        controlX += deltaX;
        anchorX += deltaX;
        controlY += deltaY;
        anchorY += deltaY;
        pathData += "ctx.quadraticCurveTo(" + (controlX / unitDivisor) + ","
                + (controlY / unitDivisor) + ","
                + (anchorX / unitDivisor) + ","
                + (anchorY / unitDivisor) + ");\r\n";
    }

    protected void finalizePath() {
        if (!"".equals(pathData)) {
            pathData = "ctx.beginPath();\r\n" + pathData + "ctx.closePath();\r\n" + strokeData;
            
            if (fillMatrix != null) {
                if (lastRadColor != null) {
                    pathData += "ctx.fillStyle=\"" + lastRadColor + "\";\r\n ctx.fill(\"evenodd\");\r\n";
                }
                pathData += "ctx.save();\r\n";
                pathData += "ctx.clip();\r\n";
                pathData += "ctx.transform(" + fillMatrix.scaleX + "," + fillMatrix.rotateSkew0 + "," + fillMatrix.rotateSkew1 + "," + fillMatrix.scaleY + "," + fillMatrix.translateX + "," + fillMatrix.translateY + ");\r\n";
                pathData += fillData;
                pathData += "ctx.fillRect(" + (-16384 - 32768 * repeatCnt) + "," + (-16384 - 32768 * repeatCnt) + "," + (2 * 16384 + 32768 * 2 * repeatCnt) + "," + (2 * 16384 + 32768 * 2 * repeatCnt) + ");\r\n";
                pathData += "ctx.restore();\r\n";
                shapeData += pathData;
            } else {
                if (!"".equals(fillData)) {
                    pathData += "ctx.fill(\"evenodd\");\r\n";
                }
                shapeData += fillData + pathData;
            }
            if (!"".equals(strokeData)) {
                shapeData += "ctx.stroke();\r\n";
            }
        }

        repeatCnt = 0;
        pathData = "";
        fillData = "";
        strokeData = "";
        fillMatrix = null;
        lastRadColor = null;
    }
}