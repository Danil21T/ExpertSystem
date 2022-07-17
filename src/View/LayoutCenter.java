package View;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;


class LayoutCenter extends GraphicsConfiguration implements LayoutManager
{
    private Dimension size = new Dimension();

    private Dimension param = new Dimension();

    public LayoutCenter(int a, int b){
        param.height = b;
        param.width = a;
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    public void layoutContainer(Container container)
    {
        Component list[] = container.getComponents();
        calculateBestSize(container);
        int currentY = container.getSize().height/3;
        for (int i = 0; i < list.length; i++) {
            list[i].setBounds(container.getSize().width/2-(size.width/2), currentY, size.width, size.height);
            currentY += 5;
            currentY += size.height;
        }
    }

    private Dimension calculateBestSize(Container c)
    {

        size.height = c.getSize().height / param.height;
        size.width = c.getSize().width / param.width;

        return size;
    }

    @Override
    public GraphicsDevice getDevice() {
        return null;
    }

    @Override
    public ColorModel getColorModel() {
        return null;
    }

    @Override
    public ColorModel getColorModel(int transparency) {
        return null;
    }

    @Override
    public AffineTransform getDefaultTransform() {
        return null;
    }

    @Override
    public AffineTransform getNormalizingTransform() {
        return null;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
