package week8;

public class Kindle {

    private int totalPages; //first declare private data encapsulation
    private int currentPage;

    public Kindle(int numberOfPages){

        totalPages = numberOfPages;
        currentPage = 1;

    } // end of the constructor

    public String toString(){
        return "Page " + currentPage + " of " + totalPages;
    } // end of the toString method

    public void turnPages(){
        turnPages(1);
    } // end of turnPages method
    // no argument is sent so just increment by 1

    public void turnPages(int pagesToTurn){
        int nextPage = currentPage + pagesToTurn; // initialize nextPage variable, the next page is the current page plus however many pages you turn
        if (nextPage > totalPages) {
            System.out.println("Turning " + pagesToTurn + " pages would take you past the last page.");
            System.out.println("You are now on: " + "Page " + totalPages + " of " + totalPages);
            currentPage = totalPages;
        } else {
            currentPage = nextPage;
        } // if the next page is more than how many pages the book has, it is too much
        // if the next page is within the book, the current page is the next pages (current page plus pages turned)

    }// end of turnPages method

} // end of the Kindle class
