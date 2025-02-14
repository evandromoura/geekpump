package br.com.geekpump.util;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

public class GifSequenceWriter {
    private ImageWriter writer;
    private ImageOutputStream outputStream;
    private IIOMetadata metadata;

    public GifSequenceWriter(ImageOutputStream out, int imageType, int delay, boolean loop) throws IOException {
        writer = ImageIO.getImageWritersBySuffix("gif").next();
        outputStream = out;
        writer.setOutput(outputStream);
        writer.prepareWriteSequence(null);

        metadata = writer.getDefaultImageMetadata(new ImageTypeSpecifier(new BufferedImage(1, 1, imageType)), null);
        configureRootMetadata(delay, loop);
    }

    private void configureRootMetadata(int delay, boolean loop) throws IOException {
        String metaFormatName = metadata.getNativeMetadataFormatName();
        IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(metaFormatName);
        IIOMetadataNode graphicsControlExtensionNode = getNode(root, "GraphicControlExtension");

        graphicsControlExtensionNode.setAttribute("disposalMethod", "none");
        graphicsControlExtensionNode.setAttribute("userInputFlag", "FALSE");
        graphicsControlExtensionNode.setAttribute("transparentColorFlag", "FALSE");
        graphicsControlExtensionNode.setAttribute("delayTime", Integer.toString(delay / 10));
        graphicsControlExtensionNode.setAttribute("transparentColorIndex", "0");

        if (loop) {
            IIOMetadataNode appExtensionsNode = getNode(root, "ApplicationExtensions");
            IIOMetadataNode child = new IIOMetadataNode("ApplicationExtension");
            child.setAttribute("applicationID", "NETSCAPE");
            child.setAttribute("authenticationCode", "2.0");
            child.setUserObject(new byte[]{0x1, 0x0, 0x0});
            appExtensionsNode.appendChild(child);
        }

        metadata.setFromTree(metaFormatName, root);
    }

    private IIOMetadataNode getNode(IIOMetadataNode rootNode, String nodeName) {
        for (int i = 0; i < rootNode.getLength(); i++) {
            if (rootNode.item(i).getNodeName().equalsIgnoreCase(nodeName)) {
                return (IIOMetadataNode) rootNode.item(i);
            }
        }
        IIOMetadataNode node = new IIOMetadataNode(nodeName);
        rootNode.appendChild(node);
        return node;
    }

    public void writeToSequence(BufferedImage img, int delay) throws IOException {
        configureRootMetadata(delay, true);
        writer.writeToSequence(new javax.imageio.IIOImage(img, null, metadata), null);
    }

    public void close() throws IOException {
        writer.endWriteSequence();
        outputStream.close();
    }
}
