import edu.duke.*;
import java.io.File;
import java.text.DecimalFormat;

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
        int newPoint = 1;

        // Iterar para contar la cantidad de puntos
        for (Point point : s.getPoints()) {
            // Cada ves que itera suma un punto
            numPoints = numPoints + newPoint;
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
        DecimalFormat df = new DecimalFormat("#.##");
        //Inicializar la variable largestSide en 0
        double largestSide = 0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            System.out.println(df.format(currDist));
            //Compara la anterior distancia con la actual
            if (largestSide < currDist) {
                //Si la actual es mayor a la anterior toma su lugar como el lado más largo
                largestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }        
        //Retorna el lado con la longitud mas grande
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
            if (largestX < currX) {
                //toma su lugar como el mayor X
                largestX =  currX;
            }
        }
        //Retorna la coordenanada en X más grande
        return largestX;
    }

    public void testPerimeter () {
        DecimalFormat df = new DecimalFormat("#.##");
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + df.format(length));
        int numPoints = getNumPoints(s);
        System.out.println("numPoints = " + numPoints);
        double averageLength = getAverageLength(s);
        System.out.println("averageLength = " + df.format(averageLength));
        double largestSide = getLargestSide(s);
        System.out.println("largestSide = " + df.format(largestSide));
        double largestX = getLargestX(s);
        System.out.println("largestX = " + largestX);
    }

    public double getLargestPerimeterMultipleFiles() {
        //Crea un recurso de directorio (para que pueda seleccionar varios archivos) 
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        //Para cada archivo f, 
        for(File f : dr.selectedFiles()){
            //convierte el archivo en un FileResource 
            FileResource fr = new FileResource(f);
            //Luego crea una Forma a partir de FileResource 
            Shape s = new Shape(fr);
            //Calcula el perímetro de las formas
            double currPerimeter = getPerimeter(s);
            //System.out.println(currPerimeter);
            //Compara el perimetro más largo anterior con el perímetro actualmente calculado
            if (largestPerimeter < currPerimeter) {
                largestPerimeter = currPerimeter;
            }
        }
        return largestPerimeter;
    }

    public void testPerimeterMultipleFiles() {
        //printFileNames();
        DecimalFormat df = new DecimalFormat("#.##");
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largestPerimeter = " + df.format(largestPerimeter));
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        File temp = null;

        for (File f : dr.selectedFiles()) {
            //convierte el archivo en un FileResource 
            FileResource fr = new FileResource(f);
            //Luego crea una Forma a partir de FileResource 
            Shape s = new Shape(fr);
            //Calcula el perímetro de las formas
            double currPerimeter = getPerimeter(s);
            if (largestPerimeter < currPerimeter) {
                largestPerimeter = currPerimeter;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("fileWithLargestPerimeter = " + getFileWithLargestPerimeter());
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
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f.getName());
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
    }
}
