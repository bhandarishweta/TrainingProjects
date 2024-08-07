package src.main.java.com.factory.shapes;

public class AbstractFactoryPatternDemo {
    public static void main (String[] args){
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

        Shape rect = shapeFactory.getShape("rectangle");
        rect.draw();

        Shape squa = shapeFactory.getShape("square");
        squa.draw();

        AbstractFactory roundedShapeFactory = FactoryProducer.getFactory(true);

        Shape roundedRect = roundedShapeFactory.getShape("rectangle");
        roundedRect.draw();

        Shape roundedSqua = roundedShapeFactory.getShape("square");
        roundedSqua.draw();
    }
}
