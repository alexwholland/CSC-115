public class ShapeList{

    private static final int INIT_SZ = 2;

    Shape[] elements;
    int count;

    public ShapeList() {
        this.elements = new Shape[INIT_SZ];
        this.count = 0;

    }

    /*
     * Purpose: returns the number of elements in list
     * Parameters: none
     * Returns: int - the number of elements
     */
    public int size() {
        // ToDo
        int listSize = 0;

        for (Shape element : elements) {
            if (element != null) {
                listSize++;
            }
        }
        return listSize;
    }

    /*
     * Purpose: adds Shape s to back of this list
     * Parameters: Shape - s
     * Returns: nothing
     */
    public void add(Shape s) {
        // ToDo
        if (this.size() == elements.length){
            Shape[] newElements = new Shape[this.size() + 1];
           /* for (int i = 0; i < elements.length; i++){
                newElements[i] = elements[i];
            }*/
            //This ^^ can be replaced with this vv
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            newElements[elements.length] = s;
            elements = newElements;
        }
        else{
            for (int i = 0; i < elements.length; i++){
                if (elements[i] == null){
                    elements[i] = s;
                    return;
                }
            }
        }
    }

    /*
     * Purpose: returns a String reprensentation of the elements
     *      in this list separated by newlines
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        // ToDo
        String string = "";

        for (Shape element : elements) {
            if (element != null) {
                string += element.toString() + "\n";
            }
        }
        return string;
    }

    /*
     * Purpose: removes the first element in this list
     * Parameters: none
     * Returns: nothing
     */
    public void removeFront() {
        // ToDo
      if (elements.length == 0){
          return;
      }
      Shape[] newList = new Shape[this.size() - 1];
     /* for (int i = 0; i < newList.length; i++){
          newList[i] = elements[i + 1];
      }*/
        //This ^^  can be replaced with this vv
        if (newList.length >= 0) {
            System.arraycopy(elements, 1, newList, 0, newList.length);
        }
      elements = newList;
    }

}