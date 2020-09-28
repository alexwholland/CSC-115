public class Rectangle implements Shape {
    private int length;         //length of the x-axis
    private int width;          //length of the y-axis
    private Point position;     //position is the (x, y) coordinates from the bottom left corner of the rectangle

    public Rectangle(){
        this.length = 0;
        this.width = 0;
        this.position = new Point();
    }

    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
        this.position = new Point();
    }

    public Rectangle(int length, int width, Point position){
        this.length = length;
        this.width = width;
        this.position = position;
    }

    public double area() {
        return this.length * this.width;
    }

    public double perimeter() {
        return (this.length + this.width) * 2;
    }

    public boolean contains(Point p) {
        int positionX = position.getX();
        int positionY = position.getY();

        int pX = p.getX();
        int pY = p.getY();

        if (positionX <= pX){
            if (pX <= positionX + this.length){
                if (positionY <= pY){
                    return pY <= positionY + width;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString(){
        return "Rectangle of dimensions: " + length + " by " + width + " at Point: " + position;
    }
}
