import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Inicializar con numPoints = 0
        int numPoints = 0;

        // Iterar para contar la cantidad de puntos
        for (Point point : s.getPoints()) {
            // Cada ves que itera suma un punto
            numPoints = numPoints + 1;
        }

        //Retorna el número de puntos totales
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        //Invoca la función que calcula la suma de las lingutudes
        double sumLength = getPerimeter(s);
        //Invoca la función que calcula el número de puntos de la figura
        double numPoints = getNumPoints(s);

        //Calcular el promedio de las longutudes de la figura
        double averageLength = sumLength / numPoints;

        //Retorna el promedio de las longitudes
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        //Inicializar la variable largestSide en 0
        double largestSide = 0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);

            //Compara la anterior distancia con la actual
            if (largestSide < currDist) {
                //Si la actual es mayor a la anterior toma su lugar como el lado más largo
                largestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }        
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        //Inicializo la variable largestX
        double largestX = 0;

        //Para cada X de cada punto
        for (Point currPt : s.getPoints()){
            //
            double currX = currPt.getX();

            //
            if (largestX < currX){
                //toma su lugar como el mayor X
                largestX =  currX;
            }
        }

        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("numPoints = " + numPoints);
        double averageLength = getAverageLength(s);
        System.out.println("averageLength = " + averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("largestSide = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("largestX = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
