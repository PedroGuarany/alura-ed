package DoublyLinkedList;

public class DoublyLinkedList {

    private Cell firstElement = null;
    private Cell lastElement = null;
    private int totalElements = 0;

    public void addAtStart(Object element){
        if(totalElements == 0){
            Cell newCell = new Cell(element, null, null);
            this.firstElement = newCell;
            this.lastElement = newCell;
        }
        else{
            Cell newCell = new Cell(element, null, this.firstElement);
            this.firstElement.setPrevious(newCell);
            this.firstElement = newCell;
        }

        this.totalElements++;
    }

    public void add(Object element){
        if(totalElements == 0){
            addAtStart(element);
        }
        else{
           Cell newCell = new Cell(element, this.lastElement, null);
           this.lastElement.setNext(newCell);
           this.lastElement = newCell;

           this.totalElements++;
        }
    }

    public void addAt(int index, Object element){
        if(!indexExists(index))
            throw new IllegalArgumentException("Invalid index");

        if(index == 0)
            addAtStart(element);
        else if (index == totalElements - 1)
            add(element);
        else{
            Cell previousCell = getCell(index - 1);
            Cell newCell = new Cell(element, previousCell, previousCell.getNext());

            newCell.getPrevious().setNext(newCell);
            newCell.getNext().setPrevious(newCell);
            this.totalElements++;
        }
    }

    private Cell getCell(int index){
        if(!indexExists(index))
            throw new IllegalArgumentException("Invalid index");

        Cell currentCell = firstElement;
        for (int i = 0; i < index; i++) {
            currentCell = currentCell.getNext();
        }
        return currentCell;
    }

    private boolean indexExists(int index){
        return index >= 0 && index < totalElements;
    }
    
    public Object get(int index){
        return getCell(index).getElement();
    }

    public int length(){
        return this.totalElements;
    }

    public void removeFromStart(){
        if(this.totalElements == 0)
            throw new IllegalArgumentException("Empty list");

        this.firstElement = this.firstElement.getNext();
        this.firstElement.setPrevious(null);
        this.totalElements--;

        if(totalElements == 0)
            this.lastElement = null;
    }

    public void removeFromEnd(){
        if(this.totalElements == 1){
            removeFromStart();
        }
        else{
            this.lastElement = this.lastElement.getPrevious();
            this.lastElement.setNext(null);

            this.totalElements--;
        }
    }
    public void removeFrom(int index){
        if(index == 0)
            removeFromStart();
        else if (index == totalElements - 1)
            removeFromEnd();
        else{
            if(!indexExists(index))
                throw new IllegalArgumentException("Invalid index");

            Cell previousCell = getCell(index - 1);
            Cell currentCell = previousCell.getNext();
            Cell nextCell = currentCell.getNext();
            previousCell.setNext(nextCell);
            nextCell.setPrevious(previousCell);

            this.totalElements--;
            if(totalElements == 0){
                this.firstElement = null;
                this.lastElement = null;
            }
        }
    }
    @Override
    public String toString() {
        if (this.totalElements == 0){
            return "[]";
        }

        Cell currentCell = firstElement;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < this.totalElements; i++) {
            builder.append(currentCell.getElement());
            builder.append(", ");
            currentCell = currentCell.getNext();
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    public boolean contains(Object element){
        Cell currentCell = this.firstElement;

        while(currentCell != null){
            if(currentCell.getElement().equals(element))
                return true;

            currentCell = currentCell.getNext();
        }

        return false;
    }
}
