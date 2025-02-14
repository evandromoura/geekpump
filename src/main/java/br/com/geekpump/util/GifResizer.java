package br.com.geekpump.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.madgag.gif.fmsware.GifDecoder;

public class GifResizer {

    public static void main(String[] args) throws Exception {
    	String uid = "ef5393d4-7ab7-4dcd-a630-f50b1985d192";
        String inputGif = "/home/trixti/git/geekpump-img/images/"+uid+".gif";
        String outputGif = "/home/trixti/git/geekpump-img/images/"+uid+"_thumb.gif"; 
        int targetWidth = 200;
        int targetHeight = 200;
        
        resizeGif(inputGif, outputGif, targetWidth, targetHeight);
        System.out.println("GIF redimensionado com sucesso!");
    }

    public synchronized static void resizeGif(String inputPath, String outputPath, int targetWidth, int targetHeight) throws Exception {
        GifDecoder decoder = new GifDecoder();
        int status = decoder.read(new FileInputStream(inputPath));
        if (status != GifDecoder.STATUS_OK) {
            throw new IOException("Erro ao ler o GIF!");
        }

        List<BufferedImage> frames = new ArrayList<>();
        List<Integer> delays = new ArrayList<>();

        for (int i = 0; i < decoder.getFrameCount(); i++) {
            BufferedImage frame = decoder.getFrame(i);
            int delay = decoder.getDelay(i);

            BufferedImage resizedFrame = resizeImage(frame, targetWidth, targetHeight);
            frames.add(resizedFrame);
            delays.add(delay);
        }

        writeGif(frames, delays, outputPath);
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    private static void writeGif(List<BufferedImage> frames, List<Integer> delays, String outputPath) throws Exception {
        ImageOutputStream output = ImageIO.createImageOutputStream(new File(outputPath));
        GifSequenceWriter writer = new GifSequenceWriter(output, BufferedImage.TYPE_INT_ARGB, delays.get(0), true);

        for (int i = 0; i < frames.size(); i++) {
            writer.writeToSequence(frames.get(i), delays.get(i));
        }

//        writer.close();
//        output.close();
    }
}