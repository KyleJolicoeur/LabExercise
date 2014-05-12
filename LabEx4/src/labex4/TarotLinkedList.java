package labex4;

public class TarotLinkedList 
{
    TarotNode top;
    TarotNode n1;
    TarotNode n2;
    TarotNode n3;
    TarotNode n4;
    TarotNode n5;
    TarotNode n6;
    TarotNode n7;
    TarotNode n8;
    TarotNode n9;
    
    int count = 0;
    public TarotDeck td;
    
    TarotLinkedList()
    {
        top = new TarotNode();
        td=new TarotDeck();
        populateList();
        count = 0;
    }
    
    boolean isEmpty()
    {
        return count == 0;
    }
    int getCount()
    {
        return count;
    }
    void display()
    {
        if (isEmpty())
        {
            System.out.println("Empty List");
        }
        else
        {
            System.out.println("Print List");
            TarotNode curr = top;
            while (curr.getNext() != null)
            {
                curr.getNext().getData();
                curr = curr.getNext();
            }
        }
    }
    
    void addNode(Card c)
    {
        TarotNode NewNode = new TarotNode();
        NewNode.setData(c);
        TarotNode curr = top;
        while (curr.getNext() != null && (!curr.getNext().getData().equals(c)))
            {
                curr = curr.getNext();
            }
        NewNode.setNext(curr.getNext());
        curr.setNext(NewNode);
        count++;
    }
    void addFirst(TarotNode n)
    {
        n.setNext(top);
        top = n;
        count++;
    }
    TarotNode getNode(int i)
    {
        if ( i>= count)
        {
            System.err.println("Error");
        }
        TarotNode ptr = top;
        for( int k=0; k<i; k++)
        {
            ptr = ptr.getNext();
        }
        return ptr;
    }
    void setNode(Card c, int i)
    {
        TarotNode temp = getNode(i);
        temp.setData(c);
    }
    
    void populateList()
    {
        for(int i = 0; i<9; i++);
        {
         top.setData((Card)td.getStack().pop());
         count++;
        }
    }
}
