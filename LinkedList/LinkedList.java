package LinkedList;

public class LinkedList {

    private Cell firstElement = null;
    private Cell lastElement = null;
    private int totalElements = 0;

    public void addAtStart(Object element){
        Cell newCell = new Cell(element, firstElement);
        firstElement = newCell;

        if(totalElements == 0)
            lastElement = newCell;
        this.totalElements++;
    }

    public void add(Object element){
        if(totalElements == 0){
            addAtStart(element);
        }
        else{
            Cell newCell = new Cell(element, null);

            lastElement.setNext(newCell);
            lastElement = newCell;

            this.totalElements++;
        }
    }

    public void addAt(int index, Object element){
        if(!indexExists(index))
            throw new IllegalArgumentException("Invalid index");

        if(index == 0)
            addAtStart(element);
        else if (index == totalElements)
            add(element);
        else{
            Cell previousCell = getCell(index - 1);
            Cell newCell = new Cell(element, previousCell.getNext());
            previousCell.setNext(newCell);

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
        this.totalElements--;

        if(totalElements == 0)
            this.lastElement = null;
    }

    public void removeFrom(int index){
        if(index == 0){
            removeFromStart();
        }
        else{
            if(this.totalElements == 0)
                throw new IllegalArgumentException("Empty list");
            if(!indexExists(index))
                throw new IllegalArgumentException("Invalid index");

            Cell previousCell = getCell(index - 1);
            Cell currentCell = getCell(index);
            previousCell.setNext(currentCell.getNext());
            if(index == totalElements - 1)
                lastElement = previousCell;

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
}
